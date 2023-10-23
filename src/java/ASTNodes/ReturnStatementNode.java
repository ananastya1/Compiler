package ASTNodes;

public class ReturnStatementNode extends ASTNode {
    private ExpressionNode expression;

    public ReturnStatementNode(ExpressionNode expression, int lineNumber) {
        super("ReturnStatement", lineNumber);
        this.expression = expression;
    }

    public ExpressionNode getExpression() {
        return expression;
    }

    @Override
    public void printNode(int depth) {

    }
}
