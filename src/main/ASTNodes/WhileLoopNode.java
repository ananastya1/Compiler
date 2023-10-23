public class WhileLoopNode extends ASTNode implements StatementNode {
    private ExpressionNode expression;
    private BodyNode body;

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

    @Override
    public void printNode(int depth) {

    }
}
