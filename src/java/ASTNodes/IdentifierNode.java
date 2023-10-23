package ASTNodes;

public class IdentifierNode extends TypeNode implements Node {
    private String identifier;

    public IdentifierNode(String identifier, int lineNumber) {
        super("IdentifierType", lineNumber);
        this.identifier = identifier;
    }

    public String getIdentifier() {
        return identifier;
    }

    @Override
    public void printNode(int depth) {
        String indent = "  ".repeat(depth);
        System.out.println(identifier);
    }
}
