public class IdentifierNode extends ASTNode{ //extends TypeNode implements Node {
    private String identifier;

    public IdentifierNode(String identifier, int lineNumber) {
        super("IdentifierType", lineNumber);
        this.identifier = identifier;
    }

    public String getIdentifier() {
        return identifier;
    }

}
