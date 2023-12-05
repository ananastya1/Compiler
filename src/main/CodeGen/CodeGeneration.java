import org.antlr.v4.runtime.tree.ParseTree;

public class CodeGeneration {
    public static void main(String[] args) throws Exception{

        String contentAfterSemantic = Semantic.main();
        ParseTree treeForJasmin = GeneralHelper.createTree(contentAfterSemantic);

        JusminCodeGeneration jasminVisitor = new JusminCodeGeneration();
        String jasminContent = jasminVisitor.visit(treeForJasmin);

        for (int i = 0; i < CodeGenHelper.records.size(); i++) {
            GeneralHelper.fileWriter("src/JasminFiles/" + i + ".j", CodeGenHelper.records.get(i));
        }

        GeneralHelper.fileWriter("src/JasminFiles/Main.j", jasminContent);
    }
}
