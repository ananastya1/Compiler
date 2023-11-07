import java.util.List;

public class ArrayType {
    String arrayName = "";
    TypeClass type = null;
    int arraySize = 0;

    public ArrayType(String arrayName, TypeClass type, int arraySize) {
        this.arrayName = arrayName;
        this.type = type;
        this.arraySize = arraySize;
    }

    public Type getVariableType(List<String> variables){
        if (variables.get(0).equals("size")){
            return Type.INT;
        }else if(!variables.get(0).equals("0")){
            return null;
        }
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
