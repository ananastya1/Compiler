public class SimpleNode extends RelationNode {

    public SimpleNode(String label, int lineNumber) {
        super(label, lineNumber);
    }

    public SimpleNode(int lineNumber) {
        super("SimpleNode", lineNumber);
    }
}
