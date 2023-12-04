public class FactorNode extends SummandNode {
    private ExpressionNode expression;

    public FactorNode(String label, int lineNumber) {
        super(label, lineNumber);
    }

    public FactorNode(ExpressionNode expression, int lineNumber) {
        super("Factor", lineNumber);
        this.expression = expression;
    }

    public ExpressionNode getExpression() {
        return expression;
    }
}
