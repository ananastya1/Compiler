import java.util.ArrayList;
import java.util.List;

public class TypeAnalysis {


    public Type analyzeExpression(ILangParser.ExpressionContext ctx) {
        if (ctx.relation() != null) {
            if (ctx.relation().size() == 1) {
                return analyzeRelation(ctx.relation(0));
            }
            return Type.BOOLEAN;
        }
        return null;
    }

    private Type analyzeRelation(ILangParser.RelationContext ctx) {
        if (ctx.simple() != null) {
            if (ctx.simple().size() == 1) {
                return analyzeSimple(ctx.simple(0));
            }
            return Type.BOOLEAN;
        }
        return null;
    }

    // (MUL, DIV, MOD, PLUS, MINUS)
    private Type analyzeSimple(ILangParser.SimpleContext ctx) {
        if (ctx.factor() == null) {
            return null;
        }

        if (ctx.factor().size() == 1) {
            return analyzeFactor(ctx.factor(0));
        }

        Type leftType = analyzeFactor(ctx.factor(0));
        Type rightType = analyzeFactor(ctx.factor(1));
        return getPrimitiveType(leftType, rightType);

    }


    // (PLUS, MINUS)
    private Type analyzeFactor(ILangParser.FactorContext ctx) {
        if (ctx.summand() == null) {
            return null;
        }
        if (ctx.summand().size() == 1) {
            return analyzeSummand(ctx.summand(0));
        }

        Type leftType = analyzeSummand(ctx.summand(0));
        Type rightType = analyzeSummand(ctx.summand(1));

        return getPrimitiveType(leftType, rightType);
    }

    // (MUL, DIV, MOD)
    private Type analyzeSummand(ILangParser.SummandContext ctx) {

        if (ctx.primary() != null) {
            return analyzePrimary(ctx.primary());

        } else if (ctx.expression() != null) {
            return analyzeExpression(ctx.expression());
        }

        return null;

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

        } else if (ctx.routineCall() != null) {

            if (HelperStore.inputType != null) {
                Type type = HelperStore.inputType.getType();
                HelperStore.inputType = null;
                return type;
            }

            String routineName = ctx.routineCall().Identifier().getText();
            RoutineDeclarationNode routine = HelperStore.routines.get(routineName);

            if (routine == null) {
                return null;
            }

            if (routine.getReturnType() != null) {
                return routine.getReturnType().type.getType();
            }

            return null;

        }

        return null;
    }

    public Type analyzeModifiablePrimary(ILangParser.ModifiablePrimaryContext ctx) {
        if (ctx.Identifier() == null) {
            return null;
        }

        if (ctx.getChildCount() > 1) {
            return analyzeRecordOrArray(ctx);
        }

        return analyzeSimpleVariable(ctx);
    }

    private Type analyzeRecordOrArray(ILangParser.ModifiablePrimaryContext ctx){

        List<String> identifiers = new ArrayList<>();

        // filling identifiers
        for (int i = 0; i < ctx.getChildCount(); i++) {
            String childString = ctx.getChild(i).getText();

            if (childString.equals(".") || childString.equals("]") || childString.equals("[")) {
                continue;
            }

            if (ctx.getChild(i) instanceof ILangParser.ExpressionContext) {
                if (analyzeExpression((ILangParser.ExpressionContext) ctx.getChild(i)) != Type.INT) {
                    HelperStore.throwException(ctx.getStart().getLine(), "Index of ARRAY TYPE must be of INT TYPE");
                }
                identifiers.add("0");
            } else {
                identifiers.add(childString);
            }
        }

        TypeClass variableType = null;
        if (HelperStore.scope != null) {
            RoutineDeclarationNode routine = HelperStore.routines.get(HelperStore.scope);
            variableType = routine.getVariables().get(identifiers.get(0));
        }

        if (variableType == null) {
            variableType = HelperStore.globalVariables.get(identifiers.get(0));
        }

        if (variableType == null) {
            HelperStore.throwException(ctx.getStart().getLine(), "Variable " + identifiers.get(0) + " does not declared");
            return null;
        }

        ArrayType array = null;
        RecordType record = null;
        Type finishedType = null;
        if (variableType.getType() == Type.ARRAY) {
            array = HelperStore.arrays.get(identifiers.get(0));

        } else if (variableType.getType() == Type.RECORD) {
            record = HelperStore.records.get(variableType.getName());
        }

        identifiers.remove(0);
        if (record != null) {
            finishedType = record.getVariableType(identifiers);

        } else if (array != null) {
            finishedType = array.getVariableType(identifiers);

        } else {
            HelperStore.throwException(ctx.getStart().getLine(), "Unknown type is caught :)");
        }

        if (finishedType == null) {
            for (String identifier : identifiers) {
                if (identifier.equals("0")) {
                    HelperStore.throwException(ctx.getStart().getLine(), "Attempt to access an array element from non ARRAY TYPE");
                }
            }
            String str = String.join(", ", identifiers);
            HelperStore.throwException(ctx.getStart().getLine(), "Record field(s) '" + str + "' do(es) not exist");
        }

        return finishedType;
    }

    private Type analyzeSimpleVariable(ILangParser.ModifiablePrimaryContext ctx){
        String modifiablePrimaryName = ctx.Identifier(0).getText();

        if (HelperStore.isVariableInRoutineScope(modifiablePrimaryName)){
            RoutineDeclarationNode routine = HelperStore.routines.get(HelperStore.scope);

            Type type = routine.getVariables().get(modifiablePrimaryName).getType();

            if (type != null) {
                return type;
            }
        }

        if (HelperStore.globalVariables.get(modifiablePrimaryName) != null) {
            return HelperStore.globalVariables.get(modifiablePrimaryName).getType();
        }

        return null;
    }

    public Type getPrimitiveType(Type leftType, Type rightType) {
        if (leftType == Type.INT && rightType == Type.INT) {
            return Type.INT;
        } else if (leftType == Type.INT && rightType == Type.REAL) {
            return Type.INT;
        } else if (leftType == Type.INT && rightType == Type.BOOLEAN) {
            return Type.INT;
        } else if (leftType == Type.REAL && rightType == Type.REAL) {
            return Type.REAL;
        } else if (leftType == Type.REAL && rightType == Type.INT) {
            return Type.REAL;
        } else if (leftType == Type.REAL && rightType == Type.BOOLEAN) {
            return Type.REAL;
        } else if (leftType == Type.BOOLEAN && rightType == Type.BOOLEAN) {
            return Type.BOOLEAN;
        } else if (leftType == Type.BOOLEAN && rightType == Type.INT) {
            return Type.INT;
        } else if (leftType == Type.BOOLEAN && rightType == Type.REAL) {
            return null;
        }
        return null;
    }

}
