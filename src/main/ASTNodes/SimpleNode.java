import java.util.List;

public class SimpleNode extends RelationNode {
    private SummandNode leftOperand;
    private List<SimpleNodeRightSide> rightSimpleOperand;

    public SimpleNode(String label, int lineNumber) {
        super(label, lineNumber);
    }

    public SimpleNode(SummandNode leftOperand, List<SimpleNodeRightSide> rightSimpleOperand, int lineNumber) {
        super("SimpleNode", lineNumber);
        this.leftOperand = leftOperand;
        this.rightSimpleOperand = rightSimpleOperand;
    }

    public SummandNode getLeftOperand() {
        return leftOperand;
    }

    public List<SimpleNodeRightSide> getRightSimpleOperand() {
        return rightSimpleOperand;
    }
}
