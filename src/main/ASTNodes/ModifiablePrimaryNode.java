import java.util.List;

public class ModifiablePrimaryNode extends PrimaryNode {
    private final IdentifierNode identifier;

    public ModifiablePrimaryNode(IdentifierNode identifier, int lineNumber) {
        super(lineNumber);
        this.identifier = identifier;

    }

    public IdentifierNode getIdentifier() {
        return identifier;
    }

}
