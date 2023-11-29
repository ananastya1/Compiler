import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CodeGenHelper {

    static StringBuilder mainCode = new StringBuilder();
    static final String mainClassName = "MainClass";

    static Integer mainNumOfLocalVariables = 1;
    static HashMap<String,Integer> mainLocalVariable = new HashMap<>();

    static String scope = null;
    static String recordScope = null;

    static List<String> routines = new ArrayList<>();
    static HashMap<String, RoutineJasminNode> routineNodes = new HashMap<>();

    static List<String> records = new ArrayList<>();
    static HashMap<String, RecordJasminNode> recordNodes = new HashMap<>();

    static List<String> globalVariables = new ArrayList<>();
    static HashMap<String,String> globalVarTypes = new HashMap<>();

    static HashMap<String,ArrayJasminNode> arrays = new HashMap<>();
    static String arrayTemp = null;

    static TypeAnalysis2 typeAnalyse = new TypeAnalysis2();

    static String codeBuilder(){
        StringBuilder resultCode = new StringBuilder();

        resultCode.append(".class public " + mainClassName + "\n");
        resultCode.append(".super java/lang/Object\n\n");

        for (String globalVariable: globalVariables) {
            resultCode.append(globalVariable).append("\n");
        }
        resultCode.append("\n");

        resultCode.append(mainCode);

        // add routines
        resultCode.append("\n");
        for (String routineCode: routines) {
            resultCode.append(routineCode).append("\n");
        }

        return resultCode.toString();
    }
    static String paramType(String type){
        if (type.equals("Z") || type.equals("I") ||type.equals("F")){
            return type;}
        else{
            return (new String("L"+type+";"));
        }
    }
}
