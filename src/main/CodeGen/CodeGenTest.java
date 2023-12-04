import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CodeGenTest {
    public static void main(String[] args) throws Exception{

        String content = readFile("src/sample.script");

        ParseTree tree = treeCreate(content);

//        System.out.println(tree.toStringTree());

        Visitor visitor = new Visitor();

        ASTNode node = visitor.visit(tree);

        HelperStore.clearVariables();

        Listener listener = new Listener();

        String optimizedContent = content;
        ParseTreeWalker walker = new ParseTreeWalker();
        walker.walk(listener, tree);

        Set<String> keys = Listener.expressions.keySet();


        for (String key:keys) {

            String output = key.replaceAll("([\\\\+\\\\*])", " \\\\$1 ");
            output = output.replaceAll("([-/%])", " $1 ");
            output = output.replaceAll("(and|or|xor|&&)", " $1 ");
            String [] outarr = output.split("\\s");
            StringBuilder newString = new StringBuilder();
            for (String i : outarr){
                newString.append("\\s*").append(i);
            }
            newString.append("\\s*");
            String s ="("+newString+")";
            //System.out.println(s);
            String sWithEndLine = "("+newString+"\n)";
            Pattern pattern = Pattern.compile(sWithEndLine);
            Matcher matcher = pattern.matcher(optimizedContent);
            if (matcher.find()){
                optimizedContent =  matcher.replaceAll(" " + Listener.expressions.get(key)+"\n");}
            else{
                Pattern pattern2 = Pattern.compile(s);
                Matcher matcher2 = pattern2.matcher(optimizedContent);
                optimizedContent = matcher2.replaceAll(" " + Listener.expressions.get(key)+ " ");}
        }



        ParseTree treeOptimized = treeCreate(optimizedContent);
//        System.out.println(treeOptimized.toStringTree());

//        System.out.println(optimizedContent);

        Visitor visitorOptimized = new Visitor();

        ASTNode nodeOptimized = visitorOptimized.visit(treeOptimized);
//        System.out.println("AST created");

        // TODO не забыть вернуть optimized
        ParseTree treeForJusmin = treeCreateCodeGeneration(optimizedContent);
        JusminCodeGeneration jusminVisitor = new JusminCodeGeneration();
        String jusminContent = jusminVisitor.visit(treeForJusmin);

//        System.out.println(jusminContent);

        for (int i = 0; i < CodeGenHelper.records.size(); i++) {
            String filePath = "src/JasminFiles/" + i + ".j";

            try (FileWriter writer = new FileWriter(filePath)) {
                // Записываем текст в файл
                writer.write(CodeGenHelper.records.get(i));

//                System.out.println("Запись в файл успешно выполнена.");
            } catch (IOException e) {
//                System.err.println("Ошибка при записи в файл: " + e.getMessage());
            }
        }


        String filePath = "src/JasminFiles/Main.j";

        try (FileWriter writer = new FileWriter(filePath)) {
            // Записываем текст в файл
            writer.write(jusminContent);

//            System.out.println("Запись в файл успешно выполнена.");
        } catch (IOException e) {
//            System.err.println("Ошибка при записи в файл: " + e.getMessage());
        }

    }

    private static String readFile(String path) throws IOException {
        byte[] encoded = Files.readAllBytes(Paths.get(path));
        return new String(encoded);
    }

    private static ParseTree treeCreate(String content) throws IOException {
        CharStream input = CharStreams.fromString(content);
        ILangLexer lexer = new ILangLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        ILangParser parser = new ILangParser(tokens);
        parser.removeErrorListeners();
        parser.addErrorListener(new ErrorListener());
        ParseTree tree = parser.main();
        return tree;
    }

    private static ParseTree treeCreateCodeGeneration(String content) throws IOException {
        CharStream input = CharStreams.fromString(content);
        ILangLexer lexer = new ILangLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        ILangParser parser = new ILangParser(tokens);
        parser.removeErrorListeners();
        parser.addErrorListener(new ErrorListener());
        ParseTree tree = parser.main();
        return tree;
    }
}
