import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class TypeAnalysis {


    public Type analyzeExpression(ILangParser.ExpressionContext ctx) {
        if (ctx.relation() != null) {
            if (ctx.relation().size() == 1){
                return analyzeRelation(ctx.relation(0));
            }
            return Type.BOOLEAN;
        }
        return null; // Если что-то пошло не так или тип не может быть определен
    }

    private Type analyzeRelation(ILangParser.RelationContext ctx) {
        if (ctx.simple() != null){
            if (ctx.simple().size() == 1) {
                return analyzeSimple(ctx.simple(0));
            }
            return Type.BOOLEAN;
        }
        return null;
    }

    private Type analyzeSimple(ILangParser.SimpleContext ctx) {
        if (ctx.factor() != null){
            if (ctx.factor().size() == 1) {
                return analyzeFactor(ctx.factor(0));
            } else {
                Type leftType = analyzeFactor(ctx.factor(0));
                Type rightType = analyzeFactor(ctx.factor(1));
                return getPrimitiveType(leftType, rightType);

                // Дополните эту часть кода для анализа типов операторов (MUL, DIV, MOD, PLUS, MINUS).
                // В зависимости от оператора, верните тип результата или генерируйте ошибку, если типы несовместимы.
            }
        }
        return null;

    }


    private Type analyzeFactor(ILangParser.FactorContext ctx) {
        if (ctx.summand() != null){
            if (ctx.summand().size() == 1) {
                return analyzeSummand(ctx.summand(0));
            } else {
                Type leftType = analyzeSummand(ctx.summand(0));
                Type rightType = analyzeSummand(ctx.summand(1));

                return getPrimitiveType(leftType, rightType);
                // Дополните эту часть кода для анализа типов операторов (PLUS, MINUS).
                // В зависимости от оператора, верните тип результата или генерируйте ошибку, если типы несовместимы.
            }
        }

        return null;

    }

    private Type analyzeSummand(ILangParser.SummandContext ctx) {
        if (ctx.primary() != null) {
            return analyzePrimary(ctx.primary());
        } else if (ctx.expression() != null) {
            return analyzeExpression(ctx.expression());
        }
            // Дополните эту часть кода для анализа типов операторов (MUL, DIV, MOD).
            // В зависимости от оператора, верните тип результата или генерируйте ошибку, если типы несовместимы.

        return null; // Замените "unknown" на фактический результат анализа типа.

    }

    private Type analyzePrimary(ILangParser.PrimaryContext ctx) {
        if (ctx.IntegerLiteral() != null) {
            return Type.INT;
        } else if (ctx.RealLiteral() != null) {
            return Type.REAL;
        } else if (ctx.TRUE() != null || ctx.FALSE() != null) {
            return Type.BOOLEAN;
        } else if (ctx.modifiablePrimary() != null) {
            return analyzeModifiablePrimary(ctx.modifiablePrimary());
            // Обработка modifiablePrimary
            // Верните соответствующий тип, если он известен.
        } else if (ctx.routineCall() != null) {
            String a = ctx.getText();
            if (HelperStore.inputType != null){
                Type type = HelperStore.inputType.getType();
                HelperStore.inputType = null;
                return type;
            }
            String routineName = ctx.routineCall().Identifier().getText();

            RoutineDeclarationNode routine = HelperStore.routines.get(routineName);
            if (routine != null){
                return routine.getReturnType().type.getType();
            }
            return null;
            // Обработка вызовов рутины
            // Верните тип результата, если он известен.
        }

        return null; // Замените "unknown" на фактический результат анализа типа.
    }

    public Type analyzeModifiablePrimary(ILangParser.ModifiablePrimaryContext ctx) {
        if (ctx.Identifier() != null) {
            String modifiablePrimaryName = ctx.Identifier(0).getText(); //???????
            if (ctx.getChildCount() > 1) {

                List<String> identifiers = new ArrayList<>();

                for (int i = 0; i < ctx.getChildCount(); i++) {
                    if (ctx.getChild(i).getText().equals(".") || ctx.getChild(i).getText().equals("]") ||ctx.getChild(i).getText().equals("[") ){
                        continue;
                    }

                    if (ctx.getChild(i) instanceof ILangParser.ExpressionContext){
                        if (analyzeExpression((ILangParser.ExpressionContext) ctx.getChild(i)) != Type.INT){
                            HelperStore.throwException(ctx.getStart().getLine(), "Size/Index of ARRAY TYPE must be of INT TYPE");
                        }
                        identifiers.add("0");
                    }else{
                        identifiers.add(ctx.getChild(i).getText());
                    }
                }
                TypeClass variableType = null;
                if (HelperStore.scope != null){
                    RoutineDeclarationNode routine = HelperStore.routines.get(HelperStore.scope);
                    variableType = routine.getVariables().get(identifiers.get(0));
                }

                if (variableType == null){
                    variableType = HelperStore.globalVariables.get(identifiers.get(0));
                }

                if (variableType == null){
                    HelperStore.throwException(ctx.getStart().getLine(), "Variable " +  identifiers.get(0)+" does not declared");
                    return null;
                }

                ArrayType array = null;
                RecordType record = null;
                Type finishedType = null;
                if (variableType.getType() == Type.ARRAY){
                    array = HelperStore.arrays.get(identifiers.get(0));

                }else if (variableType.getType() == Type.RECORD){
//                    record = HelperStore.records.get(variableType.getName());
                    record = HelperStore.records.get(variableType.getName());
                }


                identifiers.remove(0);
                if (record != null){
                    finishedType = record.getVariableType(identifiers);
                } else if (array != null){
                    finishedType = array.getVariableType(identifiers);
                }else{
                    HelperStore.throwException(ctx.getStart().getLine(), "Unknown type is caught :)");
                }


                if (finishedType == null){
                    for (int i = 0; i < identifiers.size(); i++) {
                        if (identifiers.get(i).equals("0")){
                            HelperStore.throwException(ctx.getStart().getLine(), "Attempt to access an array element from non ARRAY TYPE");
                        }
                    }
                    String str = String.join(", ", identifiers);
                    HelperStore.throwException(ctx.getStart().getLine(), "Record field(s) '" + str + "' do(es) not exist");
                }

                return finishedType;


            } else {
                if (HelperStore.scope != null) {
                    RoutineDeclarationNode routine = HelperStore.routines.get(HelperStore.scope);
                    Type type = routine.getVariables().get(modifiablePrimaryName).getType();
                    if (type != null) {
                        return type;
                    }
                    if (HelperStore.isVariableInRoutineParameters(modifiablePrimaryName)){
                        for (int i = 0; i < routine.getParameters().size(); i++) {
                            if (Objects.equals(routine.getParameters().get(i).getParameterName().getIdentifier(), modifiablePrimaryName)){
                                return routine.getParameters().get(i).getType().type.getType();
                            }
                        }
                    }
                }
                return HelperStore.globalVariables.get(modifiablePrimaryName).getType();
            }
        }
        return null;
    }

    public Type getPrimitiveType(Type leftType, Type rightType) {
        if (leftType == Type.INT && rightType == Type.INT){
            return Type.INT;
        } else if (leftType == Type.INT && rightType == Type.REAL){
            return Type.INT;
        } else if (leftType == Type.INT && rightType == Type.BOOLEAN){
            return Type.INT;
        }else if (leftType == Type.REAL && rightType == Type.REAL){
            return Type.REAL;
        } else if (leftType == Type.REAL && rightType == Type.INT){
            return Type.REAL;
        } else if (leftType == Type.REAL && rightType == Type.BOOLEAN){
            return Type.REAL;
        } else if (leftType == Type.BOOLEAN && rightType == Type.BOOLEAN){
            return Type.INT;
        } else if (leftType == Type.BOOLEAN && rightType == Type.INT){
            return Type.INT;
        } else if (leftType == Type.BOOLEAN && rightType == Type.REAL){
            return null;
        }
        return null;
    }

}
