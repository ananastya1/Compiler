public class RoutineDeclarationNode extends ASTNode {
    private IdentifierNode procedureName;
    private ParametersNode parameters;
    private TypeNode returnType;
    private BodyNode body;

    public RoutineDeclarationNode(IdentifierNode procedureName, ParametersNode parameters, TypeNode returnType, BodyNode body, int lineNumber) {
        super("RoutineDeclaration", lineNumber);
        this.procedureName = procedureName;
        this.parameters = parameters;
        this.returnType = returnType;
        this.body = body;
    }

    public IdentifierNode getProcedureName() {
        return procedureName;
    }

    public ParametersNode getParameters() {
        return parameters;
    }

    public ASTNode getReturnType() {
        return returnType;
    }

    public BodyNode getBody() {
        return body;
    }

    @Override
    public void printNode(int depth) {

    }
}
