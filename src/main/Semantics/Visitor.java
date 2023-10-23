import org.antlr.v4.runtime.tree.ParseTree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Visitor extends ILangBaseVisitor<ASTNode> {

    List<String> routinesNames = new ArrayList<>();

    private void throwException(String exception) {
        try {
            throw new Exception(exception);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Visit a parse tree produced by {@link ILangParser#main}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public ASTNode visitMain(ILangParser.MainContext ctx) {
        ProgramNode result = new ProgramNode();

        for (ILangParser.ProgramContext programContext : ctx.program()) {
            result.addProgramNode( visit(programContext) );
        }
        return result;
    }

    /**
     * Visit a parse tree produced by {@link ILangParser#program}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public ASTNode visitProgram(ILangParser.ProgramContext ctx) {

        if (ctx.simpleDeclaration() != null) { // simpleDeclaration
            return visit(ctx.simpleDeclaration());

        } else if (ctx.routineDeclaration() != null) { // routineDeclaration
            return visit(ctx.routineDeclaration());

        } else if (ctx.statement() != null) { // statement
            return visit(ctx.statement());
        }
        throwException("SYNTAX ERROR: 'simpleDeclaration/routineDeclaration/statement' expected");
        return null;
    }

    /**
     * Visit a parse tree produced by {@link ILangParser#simpleDeclaration}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public ASTNode visitSimpleDeclaration(ILangParser.SimpleDeclarationContext ctx) {

        if (ctx.variableDeclaration() != null) {
            return visit(ctx.variableDeclaration());
        }else if (ctx.typeDeclaration() != null){
            return visit(ctx.typeDeclaration());
        }

        throwException("SYNTAX ERROR: 'variableDeclaration/typeDeclaration' expected");
        return null;
    }

    /**
     * Visit a parse tree produced by {@link ILangParser#variableDeclaration}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public ASTNode visitVariableDeclaration(ILangParser.VariableDeclarationContext ctx) {
        IdentifierNode identifier = new IdentifierNode(ctx.Identifier().getText(), ctx.getStart().getLine());

        TypeNode type = null;
        ExpressionNode initialValue = null;

        if (ctx.type() == null && ctx.expression() == null){
            throwException("SYNTAX ERROR: 'type or/and expression' expected");
            return null;

        }

        if (ctx.type() != null){
            type = (TypeNode) visit(ctx.type());
        }
        if (ctx.expression() != null){
            initialValue = (ExpressionNode) visit(ctx.expression());
        }

        return new VariableDeclarationNode(
                identifier,
                type,
                initialValue,
                ctx.getStart().getLine()
        );

    }

    /**
     * Visit a parse tree produced by {@link ILangParser#typeDeclaration}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public ASTNode visitTypeDeclaration(ILangParser.TypeDeclarationContext ctx) {

        IdentifierNode identifier = new IdentifierNode(ctx.Identifier().getText(), ctx.getStart().getLine());
        TypeNode typeNode = (TypeNode) visit(ctx.type());
        return new TypeDeclarationNode(identifier, typeNode, ctx.getStart().getLine());
    }

    /**
     * Visit a parse tree produced by {@link ILangParser#type}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public ASTNode visitType(ILangParser.TypeContext ctx) {

        if (ctx.primitiveType() != null) {
            return visit(ctx.primitiveType());
        } else if (ctx.userType() != null) {
            return visit(ctx.userType());
        } else if (ctx.Identifier() != null) {
            return new TypeNode(ctx.Identifier().getText(), ctx.getStart().getLine());
        }
        throwException("SYNTAX ERROR: 'primitiveType/userType/Identifier' expected");
        return null;
    }

    /**
     * Visit a parse tree produced by {@link ILangParser#primitiveType}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public ASTNode visitPrimitiveType(ILangParser.PrimitiveTypeContext ctx) {
        if (ctx.INTEGER_KEYWORD() != null) {
            return new PrimitiveTypeNode(PrimitiveTypes.INTEGER, ctx.getStart().getLine());
        } else if (ctx.REAL_KEYWORD() != null) {
            return new PrimitiveTypeNode(PrimitiveTypes.REAL, ctx.getStart().getLine());
        } else if (ctx.BOOLEAN_KEYWORD() != null) {
            return new PrimitiveTypeNode(PrimitiveTypes.BOOLEAN, ctx.getStart().getLine());
        }
        throwException("SYNTAX ERROR: 'INTEGER/REAL/BOOLEAN' expected");
        return null;
    }

    /**
     * Visit a parse tree produced by {@link ILangParser#userType}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public ASTNode visitUserType(ILangParser.UserTypeContext ctx) {
        if (ctx.arrayType() != null) {
            return visit(ctx.arrayType());

        } else if (ctx.recordType() != null) {
            return visit(ctx.recordType());
        }

        throwException("SYNTAX ERROR: 'arrayType/recordType/' expected");
        return null;
    }

    /**
     * Visit a parse tree produced by {@link ILangParser#recordType}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public ASTNode visitRecordType(ILangParser.RecordTypeContext ctx) {

        List<VariableDeclarationNode> variables = new ArrayList<>();

        for (int i = 0; i <  ctx.variableDeclaration().size() ; i++) {
            variables.add((VariableDeclarationNode) visit( ctx.variableDeclaration(i)));
        }

        return new RecordTypeNode(variables, ctx.getStart().getLine());
    }

    /**
     * Visit a parse tree produced by {@link ILangParser#arrayType}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public ASTNode visitArrayType(ILangParser.ArrayTypeContext ctx) {

        TypeNode arrayType = (TypeNode) visit(ctx.type());
        ExpressionNode arraySize = (ExpressionNode) visit(ctx.expression());
        return new ArrayTypeNode(arrayType, arraySize, ctx.getStart().getLine());
    }

    /**
     * Visit a parse tree produced by {@link ILangParser#statement}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public ASTNode visitStatement(ILangParser.StatementContext ctx) {

        if (ctx.assignment() != null) {
            return visit(ctx.assignment());

        } else if (ctx.routineCall() != null) {
            return  visit(ctx.routineCall());

        } else if (ctx.whileLoop() != null){
            return  visit(ctx.whileLoop());

        }else if (ctx.forLoop() != null){
            return  visit(ctx.forLoop());

        }else if (ctx.ifStatement() != null){
            return  visit(ctx.ifStatement());
        }

        throwException("SYNTAX ERROR: 'assignment/routineCall/whileLoop/forLoop/ifStatement/inputStatement' expected");
        return null;
    }

    /**
     * Visit a parse tree produced by {@link ILangParser#assignment}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public ASTNode visitAssignment(ILangParser.AssignmentContext ctx) {
        ModifiablePrimaryNode leftSide = (ModifiablePrimaryNode) visit(ctx.modifiablePrimary());

        ExpressionNode rightSide = (ExpressionNode) visit(ctx.expression());

        return new AssignmentNode(leftSide,rightSide, ctx.getStart().getLine());
    }

    /**
     * Visit a parse tree produced by {@link ILangParser#routineCall}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public ASTNode visitRoutineCall(ILangParser.RoutineCallContext ctx) {
        if (ctx.builtInRoutines() != null) {
            return visit(ctx.builtInRoutines());
        }

        if (!routinesNames.contains(ctx.Identifier().getText())){
            // ERROR функция не существует
            return null;
        }

        IdentifierNode functionName = new IdentifierNode(ctx.Identifier().getText(), ctx.getStart().getLine());
        List<ExpressionNode> arguments = new ArrayList<>();

        for (int i = 0; i < ctx.expression().size(); i++) {
            arguments.add((ExpressionNode) visit(ctx.expression(i)));
        }

        return new RoutineCallNode(functionName, arguments, ctx.getStart().getLine());

    }

    /**
     * Visit a parse tree produced by {@link ILangParser#builtInRoutines}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public ASTNode visitBuiltInRoutines(ILangParser.BuiltInRoutinesContext ctx) {
        if (ctx.writeStatement() != null) {
            return visit(ctx.writeStatement());
        } else if (ctx.inputStatement() != null) {
            return visit(ctx.inputStatement());
        }

        throwException("SYNTAX ERROR: 'writeStatement/inputStatement' expected");

        return null;
    }

    /**
     * Visit a parse tree produced by {@link ILangParser#whileLoop}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public ASTNode visitWhileLoop(ILangParser.WhileLoopContext ctx) {
        ExpressionNode condition = (ExpressionNode) visit(ctx.expression());
        BodyNode loopBody = (BodyNode) visit(ctx.body());

        return new WhileLoopNode(condition, loopBody, ctx.getStart().getLine());
    }

    /**
     * Visit a parse tree produced by {@link ILangParser#forLoop}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public ASTNode visitForLoop(ILangParser.ForLoopContext ctx) {
        IdentifierNode loopVariable = new IdentifierNode(ctx.Identifier().getText(), ctx.getStart().getLine());
        boolean isReverse = ctx.REVERSE() != null;

        RangeNode range = (RangeNode) visit(ctx.range());
        BodyNode loopBody = (BodyNode) visit(ctx.body());

        return new ForLoopNode(loopVariable, isReverse, range, loopBody, ctx.getStart().getLine());

    }

    /**
     * Visit a parse tree produced by {@link ILangParser#range}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public ASTNode visitRange(ILangParser.RangeContext ctx) {
        ExpressionNode startValue = (ExpressionNode) visit(ctx.expression(0));
        ExpressionNode endValue = (ExpressionNode) visit(ctx.expression(1));

        return new RangeNode(startValue, endValue, ctx.getStart().getLine());
    }

    /**
     * Visit a parse tree produced by {@link ILangParser#ifStatement}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public ASTNode visitIfStatement(ILangParser.IfStatementContext ctx) {
        ExpressionNode condition = (ExpressionNode) visit(ctx.expression());
        BodyNode ifBody = (BodyNode) visit(ctx.body(0));
        BodyNode elseBody = null;
        if (ctx.body(1) != null) {
            elseBody = (BodyNode) visit(ctx.body(1));

        }

        return new IfStatementNode(condition,ifBody,elseBody,ctx.getStart().getLine() );
    }

    /**
     * Visit a parse tree produced by {@link ILangParser#routineDeclaration}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public ASTNode visitRoutineDeclaration(ILangParser.RoutineDeclarationContext ctx) {
        if (routinesNames.contains(ctx.Identifier().getText())){
            // ERROR функция существует
            return null;
        }
        IdentifierNode routineName = new IdentifierNode(ctx.Identifier().getText(), ctx.getStart().getLine());
        ParametersNode parameters = null;
        TypeNode returnType = null;

        if (ctx.parameters() != null) {
            parameters = (ParametersNode) visit(ctx.parameters());
        }

        if (ctx.type() != null) {
            returnType = (TypeNode) visit(ctx.type());
        }

        BodyNode routineBody = (BodyNode) visit(ctx.body());
        routinesNames.add(routineName.getIdentifier());
        return new RoutineDeclarationNode(routineName,parameters,returnType,routineBody,ctx.getStart().getLine());
    }

    /**
     * Visit a parse tree produced by {@link ILangParser#parameters}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public ASTNode visitParameters(ILangParser.ParametersContext ctx) {

        List<ParameterDeclarationNode> parameterList = new ArrayList<>();

        for (ILangParser.ParameterDeclarationContext paramCtx : ctx.parameterDeclaration()) {
            ParameterDeclarationNode parameter = (ParameterDeclarationNode) visit(paramCtx);
            parameterList.add(parameter);
        }

        return new ParametersNode(parameterList, ctx.getStart().getLine());
    }

    /**
     * Visit a parse tree produced by {@link ILangParser#parameterDeclaration}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public ASTNode visitParameterDeclaration(ILangParser.ParameterDeclarationContext ctx) {
        IdentifierNode parameterName = new IdentifierNode(ctx.Identifier().getText(), ctx.getStart().getLine());
        TypeNode parameterType = (TypeNode) visit(ctx.type());

        return new ParameterDeclarationNode(parameterName, parameterType, ctx.getStart().getLine());
    }

    /**
     * Visit a parse tree produced by {@link ILangParser#body}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public ASTNode visitBody(ILangParser.BodyContext ctx) {
        List<OneLineBodyNode> lines = new ArrayList<>();

        for (ParseTree child : ctx.children) {
            if (child instanceof ILangParser.SimpleDeclarationContext) {
                OneLineBodyNode line = new OneLineBodyNode(
                        (SimpleDeclarationNode) visit(child),
                        ctx.getStart().getLine());
                lines.add(line);
            } else if (child instanceof ILangParser.StatementContext) {

                if ( visit(child) instanceof AssignmentNode ){
                    OneLineBodyNode line = new OneLineBodyNode(
                            (AssignmentNode) visit(child),
                            ctx.getStart().getLine());

                    lines.add(line);
                } else if ( visit(child) instanceof RoutineCallNode ){
                    OneLineBodyNode line = new OneLineBodyNode(
                            (RoutineCallNode) visit(child),
                            ctx.getStart().getLine());

                    lines.add(line);
                } else if ( visit(child) instanceof WhileLoopNode ){
                    OneLineBodyNode line = new OneLineBodyNode(
                            (WhileLoopNode) visit(child),
                            ctx.getStart().getLine());

                    lines.add(line);
                } else if ( visit(child) instanceof ForLoopNode ){
                    OneLineBodyNode line = new OneLineBodyNode(
                            (ForLoopNode) visit(child),
                            ctx.getStart().getLine());

                    lines.add(line);
                } else if ( visit(child) instanceof IfStatementNode ){
                    OneLineBodyNode line = new OneLineBodyNode(
                            (IfStatementNode) visit(child),
                            ctx.getStart().getLine());

                    lines.add(line);
                }else {
                    throwException("SYNTAX ERROR: assignment/routineCall/whileLoop/forLoop/IfStatement expected");
                }



            } else if (child instanceof ILangParser.ReturnStatementContext) {
                OneLineBodyNode line = new OneLineBodyNode(
                        (ReturnStatementNode) visit(child),
                        ctx.getStart().getLine());
                lines.add(line);
            }else{
                throwException("SYNTAX ERROR: SimpleDeclarationNode/ReturnStatementNode/StatementNode");
            }

        }

        return new BodyNode(lines, ctx.getStart().getLine());

    }

    /**
     * Visit a parse tree produced by {@link ILangParser#returnStatement}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public ASTNode visitReturnStatement(ILangParser.ReturnStatementContext ctx) {
        ExpressionNode expression = null;
        if (ctx.expression() != null){
            expression = (ExpressionNode) visit(ctx.expression());
        }

        return new ReturnStatementNode(expression,ctx.getStart().getLine());
    }

    /**
     * Visit a parse tree produced by {@link ILangParser#expression}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public ASTNode visitExpression(ILangParser.ExpressionContext ctx) {

        RelationNode leftSide = (RelationNode) visit(ctx.relation(0) );

        List<RightSideExpressionNode> rightSide = new ArrayList<>();

        for (int i = 1; i < ctx.relation().size(); i++) {
            LogicalOperator operator = determineLogicalOperator(ctx, i - 1);
            RelationNode nextRelation = (RelationNode) visit(ctx.relation(i));
            RightSideExpressionNode element = new RightSideExpressionNode(operator,nextRelation, ctx.getStart().getLine());
            rightSide.add(element);
        }

        return new ExpressionNode(leftSide, rightSide, ctx.getStart().getLine());

    }

    private LogicalOperator determineLogicalOperator(ILangParser.ExpressionContext ctx, int operatorIndex) {
        if (ctx.AND(operatorIndex) != null) {
            return LogicalOperator.AND;
        } else if (ctx.OR(operatorIndex) != null) {
            return LogicalOperator.OR;
        } else if (ctx.XOR(operatorIndex) != null) {
            return LogicalOperator.XOR;
        }

        return null;
    }

    /**
     * Visit a parse tree produced by {@link ILangParser#relation}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public ASTNode visitRelation(ILangParser.RelationContext ctx) {
        SimpleNode first = (SimpleNode) visit(ctx.simple(0));

        if (ctx.simple(1) != null){
            ComparisonOperator operator = determineComparisonOperator(ctx);
            SimpleNode nextSimple = (SimpleNode) visit(ctx.simple(1));
            return new RelationNode(first,operator,nextSimple, ctx.getStart().getLine());
        }
        return new RelationNode(first, ctx.getStart().getLine());

    }

    private ComparisonOperator determineComparisonOperator(ILangParser.RelationContext ctx) {
        if (ctx.LT() != null) {
            return ComparisonOperator.LT;
        } else if (ctx.LEQ() != null) {
            return ComparisonOperator.LEQ;
        } else if (ctx.GT() != null) {
            return ComparisonOperator.GT;
        } else if (ctx.GEQ() != null) {
            return ComparisonOperator.GEQ;
        } else if (ctx.EQ() != null) {
            return ComparisonOperator.EQ;
        } else if (ctx.NEQ() != null) {
            return ComparisonOperator.NEQ;
        }
        throwException("SYNTAX ERROR: LT/LEQ/GT/GEQ/EQ/NEQ expected");
        return null;

    }

    /**
     * Visit a parse tree produced by {@link ILangParser#simple}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public ASTNode visitSimple(ILangParser.SimpleContext ctx) {
        FactorNode leftSide = (FactorNode) visit(ctx.factor(0));

        List<SimpleNodeRightSide> rightSide = new ArrayList<>();

        for (int i = 1; i < ctx.factor().size(); i++) {
            FactorOperator operator = ctx.MUL(i - 1) != null ? FactorOperator.MUL :
                    ctx.DIV(i - 1) != null ? FactorOperator.DIV :
                            ctx.MOD(i - 1) != null ? FactorOperator.MOD : null;

            FactorNode nextFactor = (FactorNode) visit(ctx.factor(i));
            rightSide.add(new SimpleNodeRightSide(operator, nextFactor, ctx.getStart().getLine()));
        }

        return new SimpleNode(leftSide, rightSide, ctx.getStart().getLine() );
    }

    /**
     * Visit a parse tree produced by {@link ILangParser#factor}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public ASTNode visitFactor(ILangParser.FactorContext ctx) {
        SummandNode leftSide = (SummandNode) visit(ctx.summand(0));
        List<FactorNodeRightSide> rightSide = new ArrayList<>();

        for (int i = 1; i < ctx.summand().size(); i++) {
            SummandOperator operator = ctx.PLUS(i - 1) != null ? SummandOperator.PLUS : SummandOperator.MINUS;
            SummandNode nextSummand = (SummandNode) visit(ctx.summand(i));
            rightSide.add(new FactorNodeRightSide(operator,nextSummand, ctx.getStart().getLine()));
        }

        return new FactorNode(leftSide, rightSide, ctx.getStart().getLine());

    }

    /**
     * Visit a parse tree produced by {@link ILangParser#summand}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public ASTNode visitSummand(ILangParser.SummandContext ctx) {

        if (ctx.primary() != null){
            return visit(ctx.primary());
        }else{
            return new SummandNode((ExpressionNode) visit(ctx.expression()), ctx.getStart().getLine());
        }
    }

    /**
     * Visit a parse tree produced by {@link ILangParser#primary}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public ASTNode visitPrimary(ILangParser.PrimaryContext ctx) {

        if (ctx.IntegerLiteral() != null){
            String intString = "";
            if (ctx.sign() != null){
                intString += ctx.sign().getText();
            }
            intString += ctx.IntegerLiteral().toString();

            int integerLiteral = Integer.parseInt(intString);

            return new IntegerLiteralNode(integerLiteral, ctx.getStart().getLine());

        } else if (ctx.RealLiteral() != null){
            String doubleString = "";
            if (ctx.sign() != null){
                doubleString += ctx.sign().getText();
            }
            doubleString += ctx.RealLiteral().toString();
            double doubleLiteral = Double.parseDouble(doubleString);

            return new RealLiteralNode(doubleLiteral, ctx.getStart().getLine());

        } else if (ctx.TRUE() != null){
            return new BoolLiteral(true, ctx.getStart().getLine());

        }else if (ctx.FALSE() != null){
            return new BoolLiteral(false, ctx.getStart().getLine());

        }else if (ctx.modifiablePrimary() != null){
            return visit(ctx.modifiablePrimary());

        }else if (ctx.routineCall() != null){
            return visit(ctx.routineCall());
        }

        throwException("SYNTAX ERROR: IntegerLiteral/RealLiteral/BoolLiteral/modifiablePrimary/routineCall exprected");
        return null;
    }

    /**
     * Visit a parse tree produced by {@link ILangParser#sign}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public ASTNode visitSign(ILangParser.SignContext ctx) {
        return null;

    }

    /**
     * Visit a parse tree produced by {@link ILangParser#modifiablePrimary}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public ASTNode visitModifiablePrimary(ILangParser.ModifiablePrimaryContext ctx) {
        IdentifierNode identifier = new IdentifierNode(ctx.Identifier(0).getText(), ctx.getStart().getLine());

        List<ModifiablePrimaryRightPartNode> right = new ArrayList<>();

        for (int i = 1; i < ctx.getChildCount(); i++) {

            if (ctx.getChild(i).getText().equals(".") || ctx.getChild(i).getText().equals("]") ||ctx.getChild(i).getText().equals("[") ){
                continue;
            }

            if (ctx.getChild(i) instanceof ILangParser.ExpressionContext){
                ModifiablePrimaryRightPartNode element = new ModifiablePrimaryRightPartNode((ExpressionNode) visit(ctx.getChild(i)), ctx.getStart().getLine());
                right.add(element);
            }else{
                ModifiablePrimaryRightPartNode element = new ModifiablePrimaryRightPartNode(new IdentifierNode(ctx.getChild(i).getText(),ctx.getStart().getLine()), ctx.getStart().getLine());
                right.add(element);
            }
        }

        return new ModifiablePrimaryNode(identifier,right,ctx.getStart().getLine());

    }

    /**
     * Visit a parse tree produced by {@link ILangParser#writeStatement}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public ASTNode visitWriteStatement(ILangParser.WriteStatementContext ctx) {

        ExpressionNode expression = null;

        if (ctx.expression() != null){
            expression = (ExpressionNode) visit(ctx.expression());
        }

        if (ctx.WRITE() != null) {
            return new WriteStatementNode(WriteType.WRITE, expression, ctx.getStart().getLine());
        } else if (ctx.WRITES() != null) {
            return new WriteStatementNode(WriteType.WRITE, expression, ctx.getStart().getLine());
        } else if (ctx.WRITELN() != null) {
            return new WriteStatementNode(WriteType.WRITE, expression, ctx.getStart().getLine());
        }

        throwException("SYNTAX ERROR: WRITE/WRITES/WRITELN expected");
        return null;
    }

    /**
     * Visit a parse tree produced by {@link ILangParser#inputStatement}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public ASTNode visitInputStatement(ILangParser.InputStatementContext ctx) {
        TypeNode type = (TypeNode) visit(ctx.type());
        return new InputStatementNode(type, ctx.getStart().getLine());

    }

}
