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

    @Override
    public void printNode(int depth) {
        String indent = "  ".repeat(depth);
        System.out.println("Expression");
        System.out.print(indent + "|__");
        left.printNode(depth + 1);
        if (rightSide != null){
            System.out.print(indent + "|__");
            for (int i = 0; i < rightSide.size() - 1; i++) {
                rightSide.get(i).printNode(depth + 1);
                System.out.print(indent + "|__");
            }
            if (rightSide.size() - 1 > 0){
                rightSide.get(rightSide.size() - 1).printNode(depth + 1);
            }

        }

    }
}
