package ASTNodes;

public class IntegerLiteralNode extends PrimaryNode {
    private int value;

    public IntegerLiteralNode(int value, int lineNumber) {
        super(lineNumber);
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
