import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class RecordJasminNode {
    String identifier;
    List<String> vars = new ArrayList<>();
    HashMap<String, String> varsInitialValues = new HashMap<>();

    HashMap<String, String> varsType = new HashMap<>();

    public RecordJasminNode(String identifier){
        this.identifier = identifier;
    }
}
