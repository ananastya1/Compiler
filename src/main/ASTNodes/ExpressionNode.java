public class ExpressionNode extends ASTNode {

    public ExpressionNode(String label, int lineNumber) {
        super(label, lineNumber);
    }
    public ExpressionNode(int lineNumber) {
        super("Expression", lineNumber);
    }

}
