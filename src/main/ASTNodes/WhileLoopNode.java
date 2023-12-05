public class WhileLoopNode extends ASTNode implements StatementNode {
    private final ExpressionNode expression;
    private final BodyNode body;

    public WhileLoopNode(ExpressionNode expression, BodyNode body, int lineNumber) {
        super("WhileLoop", lineNumber);
        this.expression = expression;
        this.body = body;
    }

    public ExpressionNode getExpression() {
        return expression;
    }

    public BodyNode getBody() {
        return body;
    }
}
