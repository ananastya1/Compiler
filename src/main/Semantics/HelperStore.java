import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class HelperStore {
    static String scope = null; // Null - global; "someText" routine someText()...
    static boolean isRecordScope = false;
    static boolean isParameterScope = false;

    static List<String> loopVaribles = new ArrayList<>();
    static TypeAnalysis typeAnalysis = new TypeAnalysis();

    static HashMap<String,TypeClass> globalVariables = new HashMap<>(); // variables in global scope

    static HashMap<String, RoutineDeclarationNode> routines = new HashMap<>();
    static HashMap<String, RecordType> records = new HashMap<>();
    static HashMap<String, ArrayType> arrays = new HashMap<>();

    static TypeClass inputType = null;

    static boolean isLoopVariable(String variableName){
        return loopVaribles.contains(variableName);
    }

    static boolean isVariableInRoutineScope(String variableName){
        if (scope == null){
            return false;
        }

        RoutineDeclarationNode routine = routines.get(scope);

        return routine.getVariables().get(variableName) != null;

    }

    static boolean isVariableInRoutineParameters(String variableName){
        if (scope == null){
            return false;
        }
        RoutineDeclarationNode routine = routines.get(scope);

        for (int i = 0; i < routine.getParameters().size(); i++) {
            if (routine.getParameters().get(i).getParameterName().getIdentifier().equals(variableName)){
                return true;
            }
        }
        return false;
    }

    static public void throwException(Integer line, String exception) {
        try {
            throw new Exception("Line-[" + line + "] " + exception);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.exit(1);
    }
}
