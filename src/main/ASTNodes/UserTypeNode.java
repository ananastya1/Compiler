public class UserTypeNode extends TypeNode {

    public UserTypeNode(String label, int lineNumber, Type type) {
        super(label, lineNumber, new TypeClass(type));
    }
}
