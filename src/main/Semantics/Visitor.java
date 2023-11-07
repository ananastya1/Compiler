import org.antlr.v4.runtime.tree.ParseTree;

import java.util.*;

public class Visitor extends ILangBaseVisitor<ASTNode> {


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

        TypeClass type = null;
        ExpressionNode initialValue = null;

        if (ctx.type() != null){
            type = new TypeClass(((TypeNode) visit(ctx.type())).type.getType());
        }

        if (ctx.expression() != null){
            initialValue = (ExpressionNode) visit(ctx.expression());
            Type analysisType = HelperStore.typeAnalysis.analyzeExpression(ctx.expression());
            if (type == null){
                type = new TypeClass(analysisType) ;
            } else if (type.getType() != analysisType){
                HelperStore.throwException(ctx.getStart().getLine(),identifier.getIdentifier() + " invalid type of initial value");
            }
        }
        HelperStore.inputType = null;

        String a = ctx.getText();

        if (!HelperStore.isRecordScope){
            if (HelperStore.isLoopVariable(identifier.getIdentifier())){
                HelperStore.throwException(ctx.getStart().getLine()," Variable should not be the same as the loop variable");
            }

            if (HelperStore.scope != null){
                if (HelperStore.isVariableInRoutineScope(identifier.getIdentifier()) ||
                        HelperStore.isVariableInRoutineParameters(identifier.getIdentifier())){

                   HelperStore.throwException(ctx.getStart().getLine(), identifier.getIdentifier() + " already exists");
                }else{
                    RoutineDeclarationNode routine = HelperStore.routines.get(HelperStore.scope);
                    routine.putVariable(identifier.getIdentifier(), type);
                }
            }else{
                if (HelperStore.globalVariables.get(identifier.getIdentifier()) != null){
                    HelperStore.throwException(ctx.getStart().getLine(), identifier.getIdentifier() + " already exists");
                }else{
                    HelperStore.globalVariables.put(identifier.getIdentifier(),type);
                }
            }
        }


        if (ctx.type() != null && type != null && type.getType() == Type.RECORD){
            type.setName(ctx.type().getText());
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
        ASTNode visitedType =  visit(ctx.type());
        TypeClass type = new TypeClass(((TypeNode) visitedType).type.getType());
        if (HelperStore.isLoopVariable(identifier.getIdentifier())){
            HelperStore.throwException(ctx.getStart().getLine()," Variable should not be the same as the loop variable");
        }

        if (HelperStore.scope != null){
            if (HelperStore.isVariableInRoutineScope(identifier.getIdentifier()) ||
                    HelperStore.isVariableInRoutineParameters(identifier.getIdentifier())){

                HelperStore.throwException(ctx.getStart().getLine(), identifier.getIdentifier() + " already exists");
            }else{
                RoutineDeclarationNode routine = HelperStore.routines.get(HelperStore.scope);
                routine.putVariable(identifier.getIdentifier(), type);
            }
        }else{
            if (HelperStore.globalVariables.get(identifier.getIdentifier()) != null){
                HelperStore.throwException(ctx.getStart().getLine(), identifier.getIdentifier() + " already exists");
            }else{
                HelperStore.globalVariables.put(identifier.getIdentifier(),type);
            }
        }

        if (type.getType() == Type.RECORD){
            List<VariableDeclarationNode> variables = ( (RecordTypeNode) visitedType ).getVariableDeclarations();
            RecordType newRecord = new RecordType(identifier.getIdentifier(),variables);
            System.out.println("Hello world");
            HelperStore.records.put(identifier.getIdentifier(), newRecord);
        }else if (type.getType() == Type.ARRAY){
            TypeClass arrayType = new TypeClass (( (ArrayTypeNode) visitedType ).getElementType().type.getType());
            arrayType.setName(( (ArrayTypeNode) visitedType ).getElementType().getLabel());

            ArrayType newArray = new ArrayType(identifier.getIdentifier(), arrayType, ( (ArrayTypeNode) visitedType ).getArraySizeInt());
            HelperStore.arrays.put(newArray.arrayName, newArray);
        }

        return new TypeDeclarationNode(identifier, type, ctx.getStart().getLine());
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

            if (HelperStore.scope != null){
                RoutineDeclarationNode routine = HelperStore.routines.get(HelperStore.scope);
                if (routine == null){
                    HelperStore.throwException(ctx.getStart().getLine(), HelperStore.scope + " routine doesn't exist");
                }else{
                    if (routine.getVariables().get(ctx.Identifier().getText()) != null){
                        return new TypeNode(ctx.Identifier().getText(), ctx.getStart().getLine(),routine.getVariables().get(ctx.Identifier().getText()) );
                    }
                }
            }

            if (HelperStore.globalVariables.get(ctx.Identifier().getText()) == null){
                HelperStore.throwException(ctx.getStart().getLine(), ctx.Identifier().getText() + " doesn't exist");
            }else{
                return new TypeNode(ctx.Identifier().getText(), ctx.getStart().getLine(), HelperStore.globalVariables.get(ctx.Identifier().getText()));
            }

        }
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
            return new TypeNode("Primitive type", ctx.getStart().getLine(), new TypeClass(Type.INT));
        } else if (ctx.REAL_KEYWORD() != null) {
            return new TypeNode("Primitive type", ctx.getStart().getLine(), new TypeClass(Type.REAL));
        } else if (ctx.BOOLEAN_KEYWORD() != null) {
            return new TypeNode("Primitive type", ctx.getStart().getLine(), new TypeClass(Type.BOOLEAN));
        }

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
        HelperStore.isRecordScope = true;
        List<VariableDeclarationNode> variables = new ArrayList<>();

        for (int i = 0; i <  ctx.variableDeclaration().size() ; i++) {
            VariableDeclarationNode variable =  (VariableDeclarationNode) visit( ctx.variableDeclaration(i));
            for (VariableDeclarationNode variableDeclarationNode : variables) {
                if (Objects.equals(variableDeclarationNode.getVariableName().getIdentifier(), variable.getVariableName().getIdentifier())) {
                    HelperStore.throwException(ctx.getStart().getLine(), " variable " + variable.getVariableName().getIdentifier() + " already exists");
                    return null;
                }
            }
            variables.add(variable);
        }
        HelperStore.isRecordScope = false;
        RecordTypeNode newRecord = new RecordTypeNode(variables, ctx.getStart().getLine());
        return newRecord;
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
        if (HelperStore.isParameterScope && ctx.expression() != null){
            HelperStore.throwException(ctx.getStart().getLine(), "Array size should not be mentioned in routine parameter's declaration");
        }else if (!HelperStore.isParameterScope && ctx.expression() == null){
            HelperStore.throwException(ctx.getStart().getLine(), "Array size is not defined");
        }

        ExpressionNode arraySize = null;
        int arraySizeInt = 0;
        Type type = null;
        if (ctx.expression() != null){
            arraySize = (ExpressionNode) visit(ctx.expression());
            try {
                arraySizeInt = Integer.parseInt(ctx.expression().getText());
            } catch ( NumberFormatException e){
                HelperStore.throwException(ctx.getStart().getLine(), "Array size is not INTEGER literal");
            }

        }
        if (ctx.expression() != null){
            type = HelperStore.typeAnalysis.analyzeExpression(ctx.expression());
            if (!type.equals(Type.INT)){
                HelperStore.throwException(ctx.getStart().getLine(), "Array size is not of type INT");
            }
        }

        return new ArrayTypeNode(arrayType, arraySize, arraySizeInt, ctx.getStart().getLine());
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
        Type leftSideType = null;

        if (HelperStore.loopVaribles.contains(leftSide.getIdentifier().getIdentifier())){
            HelperStore.throwException(ctx.getStart().getLine(), "Loop variable should be read-only");
        }
        if (HelperStore.scope!=null) {
            if (HelperStore.routines.get(HelperStore.scope) != null) {
                HashMap<String, TypeClass> vars = HelperStore.routines.get(HelperStore.scope).getVariables();
                if (vars.get(leftSide.getIdentifier().getIdentifier()) == null && HelperStore.globalVariables.get(leftSide.getIdentifier().getIdentifier()) == null) {
                    HelperStore.throwException(ctx.getStart().getLine(), "Variable " + leftSide.getIdentifier().getIdentifier() + " does not exist");
                } else if (vars.get(leftSide.getIdentifier().getIdentifier()) != null){
                    leftSideType = vars.get(leftSide.getIdentifier().getIdentifier()).getType();
                } else if (HelperStore.globalVariables.get(leftSide.getIdentifier().getIdentifier()) == null){
                    leftSideType = HelperStore.globalVariables.get(leftSide.getIdentifier().getIdentifier()).getType();
                }
            } else {
                HelperStore.throwException(ctx.getStart().getLine(), "Routine " + HelperStore.scope + "does not exist");
            }
        }else {
            if (HelperStore.globalVariables.get(leftSide.getIdentifier().getIdentifier()) == null){
                HelperStore.throwException(ctx.getStart().getLine(), "Variable " + leftSide.getIdentifier().getIdentifier() + " does not exist");
            }else{
                leftSideType = HelperStore.globalVariables.get(leftSide.getIdentifier().getIdentifier()).getType();
            }
        }
        ExpressionNode rightSide = (ExpressionNode) visit(ctx.expression());
        Type rightSideType = HelperStore.typeAnalysis.analyzeExpression(ctx.expression());
        HelperStore.inputType = null;
        // возиожно временная заглушка



        if (leftSideType.equals(Type.INT) || leftSideType.equals(Type.BOOLEAN) || leftSideType.equals(Type.REAL)){
            Type analizedCast = HelperStore.typeAnalysis.getPrimitiveType(leftSideType, rightSideType);
            if (analizedCast==null){
                HelperStore.throwException(ctx.getStart().getLine(), "Expression cannot be evaluated (invalid type conversion)");
            }
            if (!analizedCast.equals(leftSideType)){
                HelperStore.throwException(ctx.getStart().getLine(), "Right side ("+rightSideType.toString()+") cannot be casted to left side("+leftSideType.toString()+")");
            }
        }else{
            Type leftSideTypeAnalized = HelperStore.typeAnalysis.analyzeModifiablePrimary(ctx.modifiablePrimary());
            Type analizedCast = HelperStore.typeAnalysis.getPrimitiveType(leftSideTypeAnalized, rightSideType);
            if (analizedCast==null){
                HelperStore.throwException(ctx.getStart().getLine(), "Expression cannot be evaluated (invalid type conversion)");
            }
            if (!analizedCast.equals(leftSideTypeAnalized)){
                HelperStore.throwException(ctx.getStart().getLine(), "Right side ("+leftSideTypeAnalized.toString()+") cannot be casted to left side("+leftSideType.toString()+")");
            }
        }

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

        if (HelperStore.routines.get(ctx.Identifier().getText()) == null){
            HelperStore.throwException(ctx.getStart().getLine(), "Routine "+ctx.Identifier().getText()+"does not exist");
//            return null;
        }else{
            IdentifierNode functionName = new IdentifierNode(ctx.Identifier().getText(), ctx.getStart().getLine());

            List<ExpressionNode> arguments = new ArrayList<>();
            List<ParameterDeclarationNode> routineParameters = HelperStore.routines.get(ctx.Identifier().getText()).getParameters();

            if (ctx.expression().size() != routineParameters.size()){
                HelperStore.throwException(ctx.getStart().getLine(), "Number of arguments does not correspond to number of routine's parameters");
            }else{
                for (int i = 0; i < ctx.expression().size(); i++) {
                    Type argumentType = HelperStore.typeAnalysis.analyzeExpression(ctx.expression(i));
                    if (!routineParameters.get(i).getType().type.getType().equals(argumentType)){
                        HelperStore.throwException(ctx.getStart().getLine(), "Type of argument does not correspond to type of routine's parameter");
                    }
                    arguments.add((ExpressionNode) visit(ctx.expression(i)));
                }
            }

            return new RoutineCallNode(functionName, arguments, ctx.getStart().getLine());
        }
        return null;



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
            ASTNode input = visit(ctx.inputStatement());
            return input;

        }

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
        if (!HelperStore.typeAnalysis.analyzeExpression(ctx.expression()).equals(Type.BOOLEAN)){
            HelperStore.throwException(ctx.getStart().getLine(), "Type of condition should be boolean");
        }
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

        if (HelperStore.isLoopVariable(loopVariable.getIdentifier())){
            HelperStore.throwException(ctx.getStart().getLine(),loopVariable.getIdentifier()+" already exists");
        }

        if (HelperStore.globalVariables.get(loopVariable.getIdentifier()) != null){
            HelperStore.throwException(ctx.getStart().getLine(), "Variable "+loopVariable.getIdentifier()+" is already initialized");
        }

        if (HelperStore.isVariableInRoutineParameters(loopVariable.getIdentifier()) || HelperStore.isVariableInRoutineScope(loopVariable.getIdentifier())){
            HelperStore.throwException(ctx.getStart().getLine(), "Variable "+loopVariable.getIdentifier()+" is already initialized");
        }

        RangeNode range = (RangeNode) visit(ctx.range());
        HelperStore.loopVaribles.add(loopVariable.getIdentifier());
        if (HelperStore.scope != null){
            HelperStore.routines.get(HelperStore.scope).putVariable(loopVariable.getIdentifier(), new TypeClass(Type.INT));
        }else{
            HelperStore.globalVariables.put(loopVariable.getIdentifier(), new TypeClass(Type.INT));
        }
        BodyNode loopBody = (BodyNode) visit(ctx.body());
        HelperStore.loopVaribles.remove(HelperStore.loopVaribles.size() - 1);
        if (HelperStore.scope != null){
            HelperStore.routines.get(HelperStore.scope).removeVariable(loopVariable.getIdentifier());
        }else{
            HelperStore.globalVariables.remove(loopVariable.getIdentifier());
        }

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

        if (!(HelperStore.typeAnalysis.analyzeExpression(ctx.expression(0)).equals(Type.INT) && HelperStore.typeAnalysis.analyzeExpression(ctx.expression(1)).equals(Type.INT))){
            HelperStore.throwException(ctx.getStart().getLine(), "Range should consist of two integer numbers");
        }

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
        if (!HelperStore.typeAnalysis.analyzeExpression(ctx.expression()).equals(Type.BOOLEAN)){
            HelperStore.throwException(ctx.getStart().getLine(), "Type of condition should be boolean");
        }

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
        if ( HelperStore.routines.get(ctx.Identifier().getText()) != null){
            HelperStore.throwException(ctx.getStart().getLine(), "Routine "+ctx.Identifier().getText()+" exists");
            return null;
        }

        IdentifierNode routineName = new IdentifierNode(ctx.Identifier().getText(), ctx.getStart().getLine());
        List<ParameterDeclarationNode> parameters = new ArrayList<>();
        TypeNode returnType = null;

        if (ctx.parameters() != null) {
            parameters = ((ParametersNode) visit(ctx.parameters())).getParameterDeclarations();
        }

        if (ctx.type() != null) {
            returnType = (TypeNode) visit(ctx.type());
        }

        RoutineDeclarationNode routineBeforeBody = new RoutineDeclarationNode(routineName,parameters,returnType,null,ctx.getStart().getLine());

        for (ParameterDeclarationNode parameter : parameters) {
            routineBeforeBody.putVariable(parameter.getParameterName().getIdentifier(), parameter.getType().type);
        }

        HelperStore.routines.put(routineName.getIdentifier(),routineBeforeBody);

        HelperStore.scope = routineName.getIdentifier();
        BodyNode routineBody = (BodyNode) visit(ctx.body());
        HelperStore.scope = null;

        RoutineDeclarationNode routine = new RoutineDeclarationNode(routineName,parameters,returnType,routineBody,ctx.getStart().getLine());

        HelperStore.routines.put(routineName.getIdentifier(),routine);
        return routine;
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

            for (ParameterDeclarationNode parameterDeclarationNode : parameterList) {
                if (parameterDeclarationNode.getParameterName().getIdentifier().equals(parameter.getParameterName().getIdentifier())) {
                    HelperStore.throwException(ctx.getStart().getLine(), "Parameters' names should be different");
                }
            }

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

        HelperStore.isParameterScope = true;
        TypeNode parameterType = (TypeNode) visit(ctx.type());
        HelperStore.isParameterScope = false;

        if (parameterType.type.getType() == Type.RECORD){
            parameterType.type.setName(ctx.type().getText());
        }

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
                    ASTNode visited = visit(child);
                if ( visited instanceof AssignmentNode ){
                    OneLineBodyNode line = new OneLineBodyNode(
                            (AssignmentNode) visited,
                            ctx.getStart().getLine());

                    lines.add(line);
                } else if ( visited instanceof RoutineCallNode ){
                    OneLineBodyNode line = new OneLineBodyNode(
                            (RoutineCallNode) visited,
                            ctx.getStart().getLine());

                    lines.add(line);
                } else if ( visited instanceof WhileLoopNode ){
                    OneLineBodyNode line = new OneLineBodyNode(
                            (WhileLoopNode) visited,
                            ctx.getStart().getLine());

                    lines.add(line);
                } else if ( visited instanceof ForLoopNode ){
                    OneLineBodyNode line = new OneLineBodyNode(
                            (ForLoopNode) visited,
                            ctx.getStart().getLine());

                    lines.add(line);
                } else if ( visited instanceof IfStatementNode ){
                    OneLineBodyNode line = new OneLineBodyNode(
                            (IfStatementNode) visited,
                            ctx.getStart().getLine());

                    lines.add(line);
                }



            } else if (child instanceof ILangParser.ReturnStatementContext) {
                OneLineBodyNode line = new OneLineBodyNode(
                        (ReturnStatementNode) visit(child),
                        ctx.getStart().getLine());
                lines.add(line);
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
        if (HelperStore.scope == null){
            HelperStore.throwException(ctx.getStart().getLine(), "Unnecessary return statement");
        }

        if (ctx.expression() != null){
            expression = (ExpressionNode) visit(ctx.expression());
            Type typeExpression = HelperStore.typeAnalysis.analyzeExpression(ctx.expression());
            if (HelperStore.scope != null){
                if (HelperStore.routines.get(HelperStore.scope).getReturnType().type.getType() != typeExpression){
                    HelperStore.throwException(ctx.getStart().getLine(), "RETURN TYPE does not match with the expression type");
                }
            }
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
            Type expressionType = HelperStore.typeAnalysis.analyzeExpression(ctx.expression());
            if (expressionType == Type.ARRAY || expressionType == Type.RECORD){
                HelperStore.throwException(ctx.getStart().getLine(), "Only PRIMITIVE TYPE can be printed using WRITE routine");
            }
        }


        if (ctx.WRITE() != null) {
            return new WriteStatementNode(WriteType.WRITE, expression, ctx.getStart().getLine());
        } else if (ctx.WRITES() != null) {
            return new WriteStatementNode(WriteType.WRITE, expression, ctx.getStart().getLine());
        } else if (ctx.WRITELN() != null) {
            return new WriteStatementNode(WriteType.WRITE, expression, ctx.getStart().getLine());
        }

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
        if (type.type.getType() == Type.ARRAY || type.type.getType() == Type.RECORD){
            HelperStore.throwException(ctx.getStart().getLine(), "Only PRIMITIVE TYPE can be treated as an INPUT");
        }

        HelperStore.inputType = type.type;
        return new InputStatementNode(type, ctx.getStart().getLine());

    }

}
