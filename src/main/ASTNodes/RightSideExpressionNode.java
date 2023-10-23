public class RightSideExpressionNode extends ASTNode {
    private LogicalOperator logicalOperator = null;
    private RelationNode relation = null;

    public RightSideExpressionNode(LogicalOperator logicalOperator, RelationNode relation, int lineNumber) {
        super("RightSideExpressionNode", lineNumber);
        this.logicalOperator = logicalOperator;
        this.relation = relation;
    }

    public LogicalOperator getLogicalOperator() {
        return logicalOperator;
    }

    public RelationNode getRelation() {
        return relation;
    }

    @Override
    public void printNode(int depth) {

    }
}
