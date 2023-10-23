package ASTNodes;

public class RelationNode extends ExpressionNode {
    private SimpleNode leftOperand;
    private ComparisonOperator operator = null;
    private SimpleNode rightOperand = null;

    public RelationNode(String label, int lineNumber) {
        super(label, lineNumber);
    }

    public RelationNode(SimpleNode leftOperand, int lineNumber) {
        super("RelationNode", lineNumber);
        this.leftOperand = leftOperand;
    }

    public RelationNode(SimpleNode leftOperand, ComparisonOperator operator, SimpleNode rightOperand, int lineNumber) {
        super("RelationNode", lineNumber);
        this.operator = operator;
        this.leftOperand = leftOperand;
        this.rightOperand = rightOperand;
    }

    public ComparisonOperator getOperator() {
        return operator;
    }

    public SimpleNode getLeftOperand() {
        return leftOperand;
    }

    public SimpleNode getRightOperand() {
        return rightOperand;
    }

    @Override
    public void printNode(int depth) {

    }
}
