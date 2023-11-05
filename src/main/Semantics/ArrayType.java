import java.util.List;

public class ArrayType {
    String arrayName = "";
    TypeClass type = null;

    public ArrayType(String arrayName, TypeClass type) {
        this.arrayName = arrayName;
        this.type = type;
    }

    public Type getVariableType(List<String> variables){
        variables.remove(0);
        if (variables.size() == 0){
            return type.getType();
        }
        if (type.getType() == Type.ARRAY){
            return HelperStore.arrays.get(type.getName()).getVariableType(variables);
        }else if (type.getType() == Type.RECORD){
            return HelperStore.records.get(type.getName()).getVariableType(variables);
        }else{
            return type.getType();
        }
    }
}
