public class IdentifierNode extends ASTNode{
    private final String identifier;

    public IdentifierNode(String identifier, int lineNumber) {
        super("IdentifierType", lineNumber);
        this.identifier = identifier;
    }

    public String getIdentifier() {
        return identifier;
    }

}
