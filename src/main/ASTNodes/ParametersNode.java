import java.util.List;

public class ParametersNode extends ASTNode {
    private final List<ParameterDeclarationNode> parameterDeclarations;

    public ParametersNode(List<ParameterDeclarationNode> parameterDeclarations, int lineNumber) {
        super("ParametersNode", lineNumber);
        this.parameterDeclarations = parameterDeclarations;
    }

    public List<ParameterDeclarationNode> getParameterDeclarations() {
        return parameterDeclarations;
    }

}