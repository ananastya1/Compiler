package ASTNodes;

public class ModifiablePrimaryRightPartNode extends ASTNode {
    private IdentifierNode identifier;
    private ExpressionNode expressionNode;

    public ModifiablePrimaryRightPartNode(IdentifierNode identifier, int lineNumber) {
        super("ModifiablePrimaryRightPartNode", lineNumber);
        this.identifier = identifier;
    }

    public ModifiablePrimaryRightPartNode(ExpressionNode expressionNode, int lineNumber) {
        super("ModifiablePrimaryRightPartNode", lineNumber);
        this.expressionNode = expressionNode;
    }

    @Override
    public void printNode(int depth) {

    }
}
