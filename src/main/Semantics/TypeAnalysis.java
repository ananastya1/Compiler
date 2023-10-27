import java.util.List;

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
//                String operator = ctx.getChild(1).getText();
//                String leftType = analyzeSimple(ctx.simple(0));
//                String rightType = analyzeSimple(ctx.simple(1));
//
//                // Дополните эту часть кода для анализа типов операторов (AND, OR, XOR и сравнения).
//                // В зависимости от оператора, верните тип результата или генерируйте ошибку, если типы несовместимы.
//
//                return "unknown"; // Замените "unknown" на фактический результат анализа типа.

        }
        return null;

    }

    private Type analyzeSimple(ILangParser.SimpleContext ctx) {
        if (ctx.factor() != null){
            if (ctx.factor().size() == 1) {
                return analyzeFactor(ctx.factor(0));
            } else {
//                String operator = ctx.getChild(1).getText();
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
            String routineName = ctx.routineCall().Identifier().getText();

            RoutineDeclarationNode routine = HelperStore.routines.get(routineName);
            if (routine != null){
                return Type.valueOf(routine.getRoutineType());
            }
            return null;
            // Обработка вызовов рутины
            // Верните тип результата, если он известен.
        }

        return null; // Замените "unknown" на фактический результат анализа типа.
    }

    private Type analyzeModifiablePrimary(ILangParser.ModifiablePrimaryContext ctx) {
        if (ctx.Identifier() != null) {
            String modifiablePrimaryName = ctx.Identifier().toString(); //???????
            if (ctx.getChildCount() > 1) {
                Type CurrenTtype = HelperStore.globalVariables.get(modifiablePrimaryName);

                String nextType;

                if (ctx.getChild(1).getText().equals(".")){
                    nextType = "record";
                }else{
                    nextType = "array";
                }

//                a[1].a.c[5]
//
//                a, arr record
//                        d record null
//                    c arr int
//
//                var arr[10] : integer
//                        a.a   arr[2].a

                for (int i = 2; i < ctx.getChildCount(); i++) {

                    if (nextType.equals("array")){
//                            if (HelperStore.scope != null){
//
//                            }
//                            Type arrayType = HelperStore.globalVariables.get(Identifier);
//                            if (arrayType.equals(Type.ARRAY) || arrayType.equals(Type.RECORD)){
//
//                            }else{
//
//                                return arrayType;
//                            }
                    }else{
                        String Identifier = ctx.getChild(i).getText();

                    }
                }


//                ILangParser.ModifiablePrimaryContext child = (ILangParser.ModifiablePrimaryContext) ctx.getChild(0)
//                for (int i = 1; i < ctx.getChildCount(); i++) {
//                    if (HelperStore.scope != null){
//                        Routine
//                    }
//                    else if (HelperStore.globalVariables.get(ctx.getChild(i).getText()) == Type.ARRAY ||
//                            HelperStore.globalVariables.get(ctx.getChild(i).getText()) == Type.RECORD) {
//                        return analyzePrimary((ILangParser.PrimaryContext) ctx.getChild(i).getChild(0));
//
//                    } else if (HelperStore.globalVariables.get(ctx.getChild(i).getText()) == Type.ARRAY) {
////
////
////                    if (ctx.getChild(i) instanceof ILangParser.ExpressionContext){
////                        return analyzeExpression((ILangParser.ExpressionContext) ctx.getChild(i));
////                    }else{
////                        ModifiablePrimaryRightPartNode element = new ModifiablePrimaryRightPartNode(new IdentifierNode(ctx.getChild(i).getText(),ctx.getStart().getLine()), ctx.getStart().getLine());
////                        right.add(element);
////                    }
//                    }
            } else {
                if (HelperStore.scope != null) {
                    RoutineDeclarationNode routine = HelperStore.routines.get(HelperStore.scope);
                    Type type = routine.getVariables().get(modifiablePrimaryName);
                    if (type != null) {
                        return type;
                    }
                }
                return HelperStore.globalVariables.get(modifiablePrimaryName);
            }
        }
        return null;
    }
//    private Type analyzeUserType()




    private Type getPrimitiveType(Type leftType, Type rightType) {
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
