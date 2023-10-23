package ASTNodes;

public class SimpleNodeRightSide extends ASTNode {
    private FactorOperator operator = null;
    private FactorNode rightOperand = null;

    public SimpleNodeRightSide(FactorOperator operator, FactorNode rightOperand, int lineNumber) {
        super("SimpleNodeRightSide", lineNumber);
        this.operator = operator;
        this.rightOperand = rightOperand;
    }

    public FactorOperator getOperator() {
        return operator;
    }

    public FactorNode getRightOperand() {
        return rightOperand;
    }

    @Override
    public void printNode(int depth) {

    }
}
