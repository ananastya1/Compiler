public class IfStatementNode extends ASTNode implements StatementNode {
    private ExpressionNode condition;
    private BodyNode trueBranch;
    private BodyNode falseBranch;

    public IfStatementNode(ExpressionNode condition, BodyNode trueBranch, BodyNode falseBranch, int lineNumber) {
        super("IfStatement", lineNumber);
        this.condition = condition;
        this.trueBranch = trueBranch;
        this.falseBranch = falseBranch;
    }

    public ExpressionNode getCondition() {
        return condition;
    }

    public BodyNode getTrueBranch() {
        return trueBranch;
    }

    public BodyNode getFalseBranch() {
        return falseBranch;
    }
}
