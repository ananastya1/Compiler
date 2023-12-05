public class RightSideExpressionNode extends ASTNode {
    private final RelationNode relation;

    public RightSideExpressionNode(RelationNode relation, int lineNumber) {
        super("RightSideExpressionNode", lineNumber);
        this.relation = relation;
    }

    public RelationNode getRelation() {
        return relation;
    }
}
