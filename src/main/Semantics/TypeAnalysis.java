public class TypeAnalysis {

    enum primitiveType{
        BOOLEAN("boolean"),
        INT("integer"),
        REAL("real"),

        ;
        private String stringRepresentation;

        primitiveType(String stringRepresentation) {
            this.stringRepresentation = stringRepresentation;
        }

        public String getString() {
            return stringRepresentation;
        }
    }


    private primitiveType analyzeExpression(ILangParser.ExpressionContext ctx) {
        if (ctx.relation() != null) {
            if (ctx.relation().size() == 1){
                return analyzeRelation(ctx.relation(0));
            }
            return primitiveType.BOOLEAN;
        }
        return null; // Если что-то пошло не так или тип не может быть определен
    }

    private primitiveType analyzeRelation(ILangParser.RelationContext ctx) {
        if (ctx.simple() != null){
            if (ctx.simple().size() == 1) {
                return analyzeSimple(ctx.simple(0));
            }
            return primitiveType.BOOLEAN;
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

    private primitiveType analyzeSimple(ILangParser.SimpleContext ctx) {
        if (ctx.factor() != null){
            if (ctx.factor().size() == 1) {
                return analyzeFactor(ctx.factor(0));
            } else {
//                String operator = ctx.getChild(1).getText();
                primitiveType leftType = analyzeFactor(ctx.factor(0));
                primitiveType rightType = analyzeFactor(ctx.factor(1));
                return getPrimitiveType(leftType, rightType);

                // Дополните эту часть кода для анализа типов операторов (MUL, DIV, MOD, PLUS, MINUS).
                // В зависимости от оператора, верните тип результата или генерируйте ошибку, если типы несовместимы.
            }
        }
        return null;

    }


    private primitiveType analyzeFactor(ILangParser.FactorContext ctx) {
        if (ctx.summand() != null){
            if (ctx.summand().size() == 1) {
                return analyzeSummand(ctx.summand(0));
            } else {
                primitiveType leftType = analyzeSummand(ctx.summand(0));
                primitiveType rightType = analyzeSummand(ctx.summand(1));

                return getPrimitiveType(leftType, rightType);
                // Дополните эту часть кода для анализа типов операторов (PLUS, MINUS).
                // В зависимости от оператора, верните тип результата или генерируйте ошибку, если типы несовместимы.
            }
        }

        return null;

    }

    private primitiveType analyzeSummand(ILangParser.SummandContext ctx) {
        if (ctx.primary() != null) {
            return analyzePrimary(ctx.primary());
        } else if (ctx.expression() != null) {
            return analyzeExpression(ctx.expression());
        }
            // Дополните эту часть кода для анализа типов операторов (MUL, DIV, MOD).
            // В зависимости от оператора, верните тип результата или генерируйте ошибку, если типы несовместимы.

        return null; // Замените "unknown" на фактический результат анализа типа.

    }

    private primitiveType analyzePrimary(ILangParser.PrimaryContext ctx) {
        if (ctx.IntegerLiteral() != null) {
            return primitiveType.INT;
        } else if (ctx.RealLiteral() != null) {
            return primitiveType.REAL;
        } else if (ctx.TRUE() != null || ctx.FALSE() != null) {
            return primitiveType.BOOLEAN;
        } else if (ctx.modifiablePrimary() != null) {
            // Обработка modifiablePrimary
            // Верните соответствующий тип, если он известен.
        } else if (ctx.routineCall() != null) {
            ctx.routineCall().Identifier().getText();
            // Обработка вызовов рутины
            // Верните тип результата, если он известен.
        }

        return null; // Замените "unknown" на фактический результат анализа типа.
    }


    private primitiveType getPrimitiveType(primitiveType leftType, primitiveType rightType) {
        if (leftType == primitiveType.INT && rightType == primitiveType.INT){
            return primitiveType.INT;
        } else if (leftType == primitiveType.INT && rightType == primitiveType.REAL){
            return primitiveType.REAL;
        } else if (leftType == primitiveType.INT && rightType == primitiveType.BOOLEAN){
            return primitiveType.INT;
        }else if (leftType == primitiveType.REAL && rightType == primitiveType.REAL){
            return primitiveType.REAL;
        } else if (leftType == primitiveType.REAL && rightType == primitiveType.INT){
            return primitiveType.REAL;
        } else if (leftType == primitiveType.REAL && rightType == primitiveType.BOOLEAN){
            return primitiveType.REAL;
        } else if (leftType == primitiveType.BOOLEAN && rightType == primitiveType.BOOLEAN){
            return primitiveType.INT;
        } else if (leftType == primitiveType.BOOLEAN && rightType == primitiveType.INT){
            return primitiveType.INT;
        } else if (leftType == primitiveType.BOOLEAN && rightType == primitiveType.REAL){
            return null;
        }
        return null;
    }

}
