package ASTNodes;

public class RangeNode extends ASTNode {
    private ExpressionNode startExpression;
    private ExpressionNode endExpression;

    public RangeNode(ExpressionNode startExpression, ExpressionNode endExpression, int lineNumber) {
        super("Range", lineNumber);
        this.startExpression = startExpression;
        this.endExpression = endExpression;
    }

    public ExpressionNode getStartExpression() {
        return startExpression;
    }

    public ExpressionNode getEndExpression() {
        return endExpression;
    }

    @Override
    public void printNode(int depth) {

    }
}
