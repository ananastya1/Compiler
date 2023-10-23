package ASTNodes;

public class PrimaryNode extends SummandNode {

    public PrimaryNode(int lineNumber) {
        super("Primary", lineNumber);
    }

    public PrimaryNode(String label, int lineNumber) {
        super(label, lineNumber);
    }

    @Override
    public void printNode(int depth) {

    }
}
