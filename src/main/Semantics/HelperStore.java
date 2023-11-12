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
            String ANSI_RESET = "\u001B[0m";
            String ANSI_RED = "\u001B[31m";

            throw new Exception(ANSI_RED + "Line-[" + line + "] " + exception + ANSI_RESET);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.exit(1);
    }

    static void clearVariables() {
        scope = null;
        isRecordScope = false;
        isParameterScope = false;
        loopVaribles.clear();
        typeAnalysis = new TypeAnalysis();
        globalVariables.clear();
        routines.clear();
        records.clear();
        arrays.clear();
        inputType = null;
    }
}
