public class UserTypeNode extends TypeNode {

    public UserTypeNode(int lineNumber, Type type) {
        super("UserType", lineNumber, new TypeClass(type));
    }

    public UserTypeNode(String label, int lineNumber, Type type) {
        super(label, lineNumber, new TypeClass(type));
    }
}
