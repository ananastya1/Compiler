public class SimpleNodeRightSide extends ASTNode {

    private SummandOperator operator = null;
    private SummandNode rightOperand = null;

    public SimpleNodeRightSide(SummandOperator operator, SummandNode rightOperand, int lineNumber) {
        super("SimpleNodeRightSide", lineNumber);
        this.operator = operator;
        this.rightOperand = rightOperand;
    }

    public SummandOperator getOperator() {
        return operator;
    }

    public SummandNode getRightOperand() {
        return rightOperand;
    }
}
