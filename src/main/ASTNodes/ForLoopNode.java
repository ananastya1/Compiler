public class ForLoopNode extends ASTNode implements StatementNode {
    private final RangeNode range;
    private final BodyNode body;

    public ForLoopNode(RangeNode range, BodyNode body, int lineNumber) {
        super("ForLoop", lineNumber);
        this.range = range;
        this.body = body;
    }

    public RangeNode getRange() {
        return range;
    }

    public BodyNode getBody() {
        return body;
    }

}
