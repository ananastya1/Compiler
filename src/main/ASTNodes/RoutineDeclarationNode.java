import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RoutineDeclarationNode extends ASTNode {
    private IdentifierNode procedureName;
//    private ParametersNode parameters;
    private TypeNode returnType;
    private String routineType;
    private HashMap<String, Type> variables;
    private List<ParameterDeclarationNode> parameters = new ArrayList<>();
    private BodyNode body;

    public RoutineDeclarationNode(IdentifierNode procedureName, List<ParameterDeclarationNode> parameters, TypeNode returnType, BodyNode body, int lineNumber) {
        super("RoutineDeclaration", lineNumber);
        this.procedureName = procedureName;
        this.parameters = parameters;
        this.returnType = returnType;
        this.body = body;
    }

    public IdentifierNode getProcedureName() {
        return procedureName;
    }

    public List<ParameterDeclarationNode> getParameters() {
        return parameters;
    }

    public ASTNode getReturnType() {
        return returnType;
    }

    public BodyNode getBody() {
        return body;
    }

    public String getRoutineType() {
        return routineType;
    }

    public HashMap<String, Type> getVariables() {
        return variables;
    }

    public void putVariable(String name ,Type type){
        this.variables.put(name, type);
    }

    @Override
    public void printNode(int depth) {

    }
}
