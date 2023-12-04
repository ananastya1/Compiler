import java.util.List;

public class ModifiablePrimaryNode extends PrimaryNode {
    private IdentifierNode identifier;
    private List<ModifiablePrimaryRightPartNode> accessorList;

    public ModifiablePrimaryNode(IdentifierNode identifier, List<ModifiablePrimaryRightPartNode> accessorList, int lineNumber) {
        super(lineNumber);
        this.identifier = identifier;
        this.accessorList = accessorList;

    }

    public IdentifierNode getIdentifier() {
        return identifier;
    }

    public List<ModifiablePrimaryRightPartNode> getAccessorList() {
        return accessorList;
    }


}
