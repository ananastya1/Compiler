package ASTNodes;

public class VariableDeclarationNode extends SimpleDeclarationNode {
    private IdentifierNode variableName;
    private TypeNode type;
    private ExpressionNode initialValue;

    public VariableDeclarationNode(IdentifierNode variableName, TypeNode type, ExpressionNode initialValue, int lineNumber) {
        super("VariableDeclaration", lineNumber);
        this.variableName = variableName;
        this.type = type;
        this.initialValue = initialValue;
    }

    public IdentifierNode getVariableName() {
        return variableName;
    }

    public TypeNode getType() {
        return type;
    }

    public ExpressionNode getInitialValue() {
        return initialValue;
    }

    @Override
    public void printNode(int depth) {
        String indent = "  ".repeat(depth);
        System.out.println(this.label);
        System.out.print(indent + "|__");
        variableName.printNode(depth + 1);
        System.out.print(indent + "|__");
        type.printNode(depth + 1);
        System.out.print(indent + "|__");
        initialValue.printNode(depth + 1);
    }
}
