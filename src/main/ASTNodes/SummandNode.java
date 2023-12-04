import java.util.List;

public class SummandNode extends SimpleNode {
    private FactorNode leftOperand;
    private List<SummandNodeRightSide> rightSide;

    public SummandNode(String label, int lineNumber) {
        super(label, lineNumber);
    }

    public SummandNode(FactorNode leftOperand, List<SummandNodeRightSide> rightSide , int lineNumber) {
        super("SummandNode", lineNumber);
        this.leftOperand = leftOperand;
        this.rightSide = rightSide;
    }

    public FactorNode getLeftOperand() {
        return leftOperand;
    }
}
