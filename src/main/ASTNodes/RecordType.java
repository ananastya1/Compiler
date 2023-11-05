import java.util.ArrayList;
import java.util.List;

public class RecordType {
    String recordName = "";
    List<VariableDeclarationNode> variables = new ArrayList<>();

    public RecordType(String recordName, List<VariableDeclarationNode> variables) {
        this.recordName = recordName;
        this.variables = variables;
    }

    public List<VariableDeclarationNode> getVariables() {
        return variables;
    }

    public Type getVariableType(List<String> variables){
        for (VariableDeclarationNode variable : this.variables) {
            if (variables.size() == 0) {
                return Type.RECORD;
            }

            if (variable.getVariableName().getIdentifier().equals(variables.get(0))) {
                variables.remove(0);
                if (variable.getType().getType() == Type.RECORD) {
                    return HelperStore.records.get(variable.getType().getName()).getVariableType(variables);
                }else if (variable.getType().getType() == Type.ARRAY){
                    return HelperStore.arrays.get(variable.getType().getName()).getVariableType(variables);
                }else{
                    return variable.getType().getType();
                }
            }
        }
        return null;
    }
}
