public class ReturnStatementNode extends ASTNode {
    private final ExpressionNode expression;

    public ReturnStatementNode(ExpressionNode expression, int lineNumber) {
        super("ReturnStatement", lineNumber);
        this.expression = expression;
    }

    public ExpressionNode getExpression() {
        return expression;
    }
}
