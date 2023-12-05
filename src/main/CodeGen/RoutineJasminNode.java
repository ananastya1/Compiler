import java.util.HashMap;

public class RoutineJasminNode {
    String parameters;
    String returnType;
    Integer numOfLocalVariables = 0;
    HashMap<String,Integer> localVariable = new HashMap<>();
    HashMap<String, String> varTypes = new HashMap<>();

    HashMap<String,ArrayJasminNode> arrays = new HashMap<>();
    HashMap<String, RecordJasminNode> recordNodes = new HashMap<>();
    public RoutineJasminNode(String parameters, String returnType) {
        this.parameters = parameters;
        this.returnType = returnType;
    }
}
