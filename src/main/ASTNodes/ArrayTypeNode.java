public class ArrayTypeNode extends UserTypeNode implements Node {
    private TypeNode elementType;
    private ExpressionNode arraySize;

    public ArrayTypeNode(TypeNode elementType, ExpressionNode arraySize, int lineNumber) {
        super("ArrayTypeNode", lineNumber);
        this.elementType = elementType;
        this.arraySize = arraySize;
    }

    public TypeNode getElementType() {
        return elementType;
    }

    public ExpressionNode getArraySize() {
        return arraySize;
    }

    @Override
    public void printNode(int depth) {
        String indent = "  ".repeat(depth);
        System.out.println(indent + this.label);
        elementType.printNode(depth + 1);
        arraySize.printNode(depth + 1);
    }
}
