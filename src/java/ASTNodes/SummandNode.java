package ASTNodes;

public class SummandNode extends FactorNode {
    private ExpressionNode expression;

    public SummandNode(String label, int lineNumber) {
        super(label, lineNumber);
    }

    public SummandNode(ExpressionNode expression, int lineNumber) {
        super("Summand", lineNumber);
        this.expression = expression;
    }

    public ExpressionNode getExpression() {
        return expression;
    }

    @Override
    public void printNode(int depth) {

    }
}
