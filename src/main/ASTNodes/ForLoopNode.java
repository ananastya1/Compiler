public class ForLoopNode extends ASTNode implements StatementNode {
    private IdentifierNode loopVariable;
    private boolean isReversed;
    private RangeNode range;
    private BodyNode body;

    public ForLoopNode(IdentifierNode loopVariable, boolean isReversed, RangeNode range, BodyNode body, int lineNumber) {
        super("ForLoop", lineNumber);
        this.loopVariable = loopVariable;
        this.isReversed = isReversed;
        this.range = range;
        this.body = body;
    }

    public IdentifierNode getLoopVariable() {
        return loopVariable;
    }

    public boolean isReversed() {
        return isReversed;
    }

    public RangeNode getRange() {
        return range;
    }

    public BodyNode getBody() {
        return body;
    }

    @Override
    public void printNode(int depth) {

    }
}
