public class FactorNodeRightSide extends ASTNode {

    private SummandOperator operator = null;
    private SummandNode rightOperand = null;

    public FactorNodeRightSide(SummandOperator operator, SummandNode rightOperand, int lineNumber) {
        super("FactorNodeRightSide", lineNumber);
        this.operator = operator;
        this.rightOperand = rightOperand;
    }

    public SummandOperator getOperator() {
        return operator;
    }

    public SummandNode getRightOperand() {
        return rightOperand;
    }

    @Override
    public void printNode(int depth) {

    }
}
