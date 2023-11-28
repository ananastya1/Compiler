import java.util.HashMap;
import org.graalvm.polyglot.Context;
import org.graalvm.polyglot.Engine;

public class Listener extends ILangBaseListener{
    static HashMap<String, String> expressions = new HashMap<>();

    Engine engine = Engine.newBuilder()
            .option("engine.WarnInterpreterOnly", "false")
            .build();
    Context evalCtx = Context.newBuilder("js").engine(engine).build();

    @Override
    public void enterExpression(ILangParser.ExpressionContext ctx) {
        super.enterExpression(ctx);
        try{
            String optimized = optimize(ctx.getText());
            System.out.println("optimized " + optimized);

            String splitted = ctx.getText().split(">|<|>=|<=|\\+|-|xor|or|and|\\*|=|/|/=")[0];
            try{
                if ((Float.parseFloat(splitted)) ==
                        (Float.parseFloat(String.valueOf(Integer.parseInt(splitted))))){
                    optimized = String.valueOf((int)(Float.parseFloat(optimized)));
                }
            }
            catch (Exception ignored){
//                System.out.println(ignored);
            }
            if (!ctx.getText().equals(optimized)){
                expressions.put(ctx.getText(), optimized);
            }
            //System.out.println(ctx.getText() + " - " + optimized);
        } catch (Exception ignored){
//            System.out.println("Exception :"+ ignored);
        }
    }



    private String optimize(String expression){
        expression = expression.replaceAll("and", " && ");
        expression = expression.replaceAll("xor", " ^ ");
        expression = expression.replaceAll("or", " || ");
        expression = expression.replaceAll("/=", " != ");

        Object result = evalCtx.eval("js", expression);
        return result.toString();
    }
}
