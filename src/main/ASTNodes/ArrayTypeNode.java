public class ArrayTypeNode extends UserTypeNode implements Node {
    private TypeNode elementType;
    private ExpressionNode arraySize;
    private int arraySizeInt = 0;

    public ArrayTypeNode(TypeNode elementType, ExpressionNode arraySize,int arraySizeInt, int lineNumber) {
        super("ArrayTypeNode", lineNumber, Type.ARRAY);
        this.elementType = elementType;
        this.arraySize = arraySize;
        this.arraySizeInt = arraySizeInt;
    }

    public TypeNode getElementType() {
        return elementType;
    }

    public ExpressionNode getArraySize() {
        return arraySize;
    }

    public int getArraySizeInt() {
        return arraySizeInt;
    }
}
