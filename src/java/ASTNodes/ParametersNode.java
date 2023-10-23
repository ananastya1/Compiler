package ASTNodes;

import java.util.List;

public class ParametersNode extends ASTNode {
    private List<ParameterDeclarationNode> parameterDeclarations;

    public ParametersNode(List<ParameterDeclarationNode> parameterDeclarations, int lineNumber) {
        super("ParametersNode", lineNumber);
        this.parameterDeclarations = parameterDeclarations;
    }

    public void addParameterDeclaration(ParameterDeclarationNode parameterDeclaration) {
        parameterDeclarations.add(parameterDeclaration);
    }

    public List<ParameterDeclarationNode> getParameterDeclarations() {
        return parameterDeclarations;
    }

    @Override
    public void printNode(int depth) {

    }
}