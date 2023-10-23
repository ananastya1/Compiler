package ASTNodes;

public class BoolLiteral extends PrimaryNode {
    private boolean value;

    public BoolLiteral(boolean value, int lineNumber) {
        super(lineNumber);
        this.value = value;
    }

    public boolean getValue() {
        return value;
    }

    @Override
    public void printNode(int depth) {
        String indent = "  ".repeat(depth);
        System.out.println(value);
    }
}
