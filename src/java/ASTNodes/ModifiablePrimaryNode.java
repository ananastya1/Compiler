package ASTNodes;

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

    @Override
    public void printNode(int depth) {
//        String indent = "  ".repeat(depth);
//        System.out.println(value);
//        System.out.print(indent + "|__");
    }
}
