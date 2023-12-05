import java.util.HashMap;
import java.util.List;

public class RoutineDeclarationNode extends ASTNode {
    private final TypeNode returnType;
    public HashMap<String, TypeClass> variables = new HashMap<>();
    private final List<ParameterDeclarationNode> parameters;
    private final BodyNode body;

    public RoutineDeclarationNode(List<ParameterDeclarationNode> parameters, TypeNode returnType, BodyNode body, int lineNumber) {
        super("RoutineDeclaration", lineNumber);
        this.parameters = parameters;
        this.returnType = returnType;
        this.body = body;
    }

    public List<ParameterDeclarationNode> getParameters() {
        return parameters;
    }

    public TypeNode getReturnType() {
        return returnType;
    }

    public BodyNode getBody() {
        return body;
    }

    public HashMap<String, TypeClass> getVariables() {
        return variables;
    }

    public void putVariable(String name, TypeClass type){
        this.variables.put(name, type);
    }
    public void removeVariable(String name){
        this.variables.remove(name);
    }
}
