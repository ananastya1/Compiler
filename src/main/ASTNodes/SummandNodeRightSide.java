public class SummandNodeRightSide extends ASTNode {
    private FactorOperator operator = null;
    private SummandNode rightOperand = null;

    public SummandNodeRightSide(FactorOperator operator, SummandNode rightOperand, int lineNumber) {
        super("SummandNodeRightSide", lineNumber);
        this.operator = operator;
        this.rightOperand = rightOperand;
    }

    public FactorOperator getOperator() {
        return operator;
    }

    public SummandNode getRightOperand() {
        return rightOperand;
    }

}
