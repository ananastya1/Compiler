public class RelationNode extends ExpressionNode {

    public RelationNode(String label, int lineNumber) {
        super(label, lineNumber);
    }

    public RelationNode( int lineNumber) {
        super("RelationNode", lineNumber);
    }
}
