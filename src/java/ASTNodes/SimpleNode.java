package ASTNodes;

import java.util.List;

public class SimpleNode extends RelationNode {
    private FactorNode leftOperand;
    private List<SimpleNodeRightSide> rightSide;

    public SimpleNode(String label, int lineNumber) {
        super(label, lineNumber);
    }

    public SimpleNode(FactorNode leftOperand, List<SimpleNodeRightSide> rightSide , int lineNumber) {
        super("SimpleNode", lineNumber);
        this.leftOperand = leftOperand;
        this.rightSide = rightSide;
    }

    public FactorNode getLeftOperand() {
        return leftOperand;
    }


    @Override
    public void printNode(int depth) {

    }
}
