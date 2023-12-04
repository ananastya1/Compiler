import java.util.List;

public class ExpressionNode extends ASTNode {
    private RelationNode left;
    private List<RightSideExpressionNode> rightSide;

    public ExpressionNode(String label, int lineNumber) {
        super(label, lineNumber);
    }
    public ExpressionNode(RelationNode left, List<RightSideExpressionNode> rightSide, int lineNumber) {
        super("Expression", lineNumber);
        this.left = left;
        this.rightSide = rightSide;
    }

    public RelationNode getLeft() {
        return left;
    }

    public List<RightSideExpressionNode> getRightSide() {
        return rightSide;
    }
}
