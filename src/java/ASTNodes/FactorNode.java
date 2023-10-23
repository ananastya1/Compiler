package ASTNodes;

import java.util.List;

public class FactorNode extends SimpleNode {
    private SummandNode leftOperand;
    private List<FactorNodeRightSide> rightFactorOperand;

    public FactorNode(String label, int lineNumber) {
        super(label, lineNumber);
    }

    public FactorNode(SummandNode leftOperand, List<FactorNodeRightSide> rightFactorOperand, int lineNumber) {
        super("FactorNode", lineNumber);
        this.leftOperand = leftOperand;
        this.rightFactorOperand = rightFactorOperand;
    }

    public SummandNode getLeftOperand() {
        return leftOperand;
    }

    public List<FactorNodeRightSide> getRightFactorOperand() {
        return rightFactorOperand;
    }

    @Override
    public void printNode(int depth) {

    }
}
