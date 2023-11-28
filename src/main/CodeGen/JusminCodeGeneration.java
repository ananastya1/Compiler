import org.antlr.v4.runtime.tree.ParseTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class JusminCodeGeneration extends IlangCodeGenerationBaseVisitor<String>{
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitMain(IlangCodeGenerationParser.MainContext ctx) {

        CodeGenHelper.mainCode.append(".method public static main([Ljava/lang/String;)V\n");
        CodeGenHelper.mainCode.append("\t.limit stack 100\n");
        CodeGenHelper.mainCode.append("\t.limit locals 100\n\n");

        CodeGenHelper.mainCode.append("\t.var 0 is args [Ljava/lang/String;\n\n");


        // Генерация кода для обхода дочерних узлов
        for (IlangCodeGenerationParser.ProgramContext programContext : ctx.program()) {
            CodeGenHelper.mainCode.append(visit(programContext));
        }

        // Генерация завершающих инструкций метода main
        CodeGenHelper.mainCode.append("\n\treturn\n");
        CodeGenHelper.mainCode.append(".end method\n");

        return CodeGenHelper.codeBuilder();
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitProgram(IlangCodeGenerationParser.ProgramContext ctx) {

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
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitSimpleDeclaration(IlangCodeGenerationParser.SimpleDeclarationContext ctx) {

        if (ctx.variableDeclaration() != null) {
            return visit(ctx.variableDeclaration());
        }else if (ctx.typeDeclaration() != null){
            return visit(ctx.typeDeclaration());
        }

        return null;
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitVariableDeclaration(IlangCodeGenerationParser.VariableDeclarationContext ctx) {
        String identifier = ctx.Identifier().getText();
        String type=null;
        if (ctx.type()!=null){
            type= visit(ctx.type());
        }
        else{
            switch (CodeGenHelper.typeAnalyse.analyzeExpression(ctx.expression())){
                case BOOLEAN -> type="Z";
                case INT -> type = "I";
                case REAL -> type = "F";
            }
        }

//        if(identifier.equals("i")){
//            System.out.println("123");
//        }
        StringBuilder newVariable = new StringBuilder();

        if (CodeGenHelper.recordScope != null){
            RecordJasminNode recordNode = CodeGenHelper.recordNodes.get(CodeGenHelper.recordScope);

            StringBuilder recordVar = new StringBuilder();

            if (!type.equals("I") && !type.equals("Z") && !type.equals("F")){
                if (CodeGenHelper.arrays.get(type) != null){
                    ArrayJasminNode arr = CodeGenHelper.arrays.get(type);
                    recordVar.append(".field public ").append(identifier).append(" ").append("[".repeat(arr.dimension)).append(arr.type).append("\n");
                }else{
                    recordVar.append(".field public ").append(identifier).append(" L").append(type).append(";\n");
                }


            }else{
                recordVar.append(".field public ").append(identifier).append(" ").append(type).append("\n");
            }


            recordNode.vars.add(identifier);

            if (ctx.expression() != null){
                String expressionCode = visit(ctx.expression());
                recordNode.varsInitialValues.put(identifier, expressionCode);
            }

            if (CodeGenHelper.recordNodes.get(type) != null || CodeGenHelper.arrays.get(type) != null){
                recordNode.varsInitialValues.put(identifier, type);
            }

            recordNode.varsType.put(identifier, type);

            CodeGenHelper.recordNodes.put(CodeGenHelper.recordScope, recordNode);

            return recordVar.toString();
        }


        if (CodeGenHelper.scope == null){
            if (!type.equals("I") && !type.equals("Z") && !type.equals("F")){
                newVariable.append(".field static ").append(identifier).append(" L").append(type).append(";");
            }else{
                newVariable.append(".field static ").append(identifier).append(" ").append(type);
            }


            CodeGenHelper.globalVariables.add(newVariable.toString());

            CodeGenHelper.globalVarTypes.put(identifier, type);

            if (ctx.expression() != null){
                String expressionCode = visit(ctx.expression());
                return "\t" + expressionCode + "\tputstatic "+ CodeGenHelper.mainClassName +"/" + identifier + " " + type + "\n";
            }

            if (!type.equals("I") && !type.equals("Z") && !type.equals("F")){
                if (CodeGenHelper.recordNodes.get(type) != null){
                    return "new " + type + "\n" + "dup\n" + "invokespecial " + type + "/<init>()V\n" + "putstatic " + CodeGenHelper.mainClassName + "/" + identifier + " L" + type + ";\n";
                }

            }


            return "";
        }

        // TODO аналайз
        String localVariable = "";
        RoutineJasminNode routine = CodeGenHelper.routineNodes.get(CodeGenHelper.scope);
        routine.numOfLocalVariables += 1;
        routine.localVariable.put(identifier, routine.numOfLocalVariables);

        routine.varTypes.put(identifier, type);

        localVariable += ".var " + (routine.numOfLocalVariables - 1) + " is "+ identifier + " " + type +"\n";

        if (ctx.expression() != null){
            String expressionCode = visit(ctx.expression());
            localVariable += expressionCode + "\n";
            String typeStore = "";
            if (type.equals("I")){
                typeStore = "i";
            }else if (type.equals("Z")){
                typeStore = "z";
            }else if (type.equals("F")){
                typeStore = "f";
            }
            typeStore += "store ";

            localVariable += typeStore + (routine.numOfLocalVariables - 1);
        }

        return localVariable;
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitTypeDeclaration(IlangCodeGenerationParser.TypeDeclarationContext ctx) {
        StringBuilder typeCode = new StringBuilder();

        if (ctx.type().userType().arrayType() != null){
            ArrayJasminNode ArrNode = new ArrayJasminNode(ctx.Identifier().getText());
            CodeGenHelper.arrayTemp = ctx.Identifier().getText();

            if (CodeGenHelper.scope != null){
                RoutineJasminNode routine = CodeGenHelper.routineNodes.get(CodeGenHelper.scope);
                routine.arrays.put(ctx.Identifier().getText(), ArrNode);

                String visitedType = visit(ctx.type());
                ArrNode = routine.arrays.get(ctx.Identifier().getText());

                routine.numOfLocalVariables += 1;
                routine.localVariable.put(ctx.Identifier().getText(), routine.numOfLocalVariables);

                typeCode.append(".var ").append(routine.numOfLocalVariables - 1).append(" is ").append(ctx.Identifier().getText()).append(" ").append("[".repeat(ArrNode.dimension)).append(ArrNode.type).append("\n");

                typeCode.append(visitedType).append("\n");
                typeCode.append("astore ").append(routine.numOfLocalVariables - 1).append("\n");

            }else{

                CodeGenHelper.arrays.put(ctx.Identifier().getText(), ArrNode);

                String visitedType = visit(ctx.type());
                ArrNode = CodeGenHelper.arrays.get(ctx.Identifier().getText());

                StringBuilder newVariable = new StringBuilder();

                if (CodeGenHelper.recordNodes.get(ArrNode.type) != null){
                    newVariable.append(".field static ").append(ctx.Identifier().getText()).append(" ").append("[".repeat(ArrNode.dimension)).append(ArrNode.type);

                }else{
                    newVariable.append(".field static ").append(ctx.Identifier().getText()).append(" ").append("[".repeat(ArrNode.dimension)).append(ArrNode.type);

                }
                CodeGenHelper.globalVariables.add(newVariable.toString());

                typeCode.append(visitedType).append("\n");
                if (CodeGenHelper.recordNodes.get(ArrNode.type) != null){
                    typeCode.append("\tputstatic " + CodeGenHelper.mainClassName + "/").append(ctx.Identifier().getText()).append(" ").append("[".repeat(ArrNode.dimension)).append(ArrNode.type).append("\n");

                }else{
                    typeCode.append("\tputstatic " + CodeGenHelper.mainClassName + "/").append(ctx.Identifier().getText()).append(" ").append("[".repeat(ArrNode.dimension)).append(ArrNode.type).append("\n");

                }

            }

            CodeGenHelper.arrayTemp = null;
        }
        else if(ctx.type().userType().recordType() != null){
            StringBuilder recordCode = new StringBuilder();
            recordCode.append(".class public ").append(ctx.Identifier().getText()).append("\n");
            recordCode.append(".super java/lang/Object\n\n");

            CodeGenHelper.recordScope = ctx.Identifier().getText();
            RecordJasminNode newRecordNode = new RecordJasminNode(ctx.Identifier().getText());
            CodeGenHelper.recordNodes.put(ctx.Identifier().getText(),newRecordNode);
            recordCode.append(visit(ctx.type())).append("\n");

            RecordJasminNode nodeAfterFilling = CodeGenHelper.recordNodes.get(ctx.Identifier().getText());

            recordCode.append(".method public <init>()V\n");
            recordCode.append(".limit stack 100\n").append(".limit locals 100\n\n");

            recordCode.append("aload_0\n").append("invokespecial java/lang/Object/<init>()V\n");

            for (String var: nodeAfterFilling.vars) {
                if (nodeAfterFilling.varsInitialValues.get(var) != null){
                    String initialValue = nodeAfterFilling.varsInitialValues.get(var);
                        if (CodeGenHelper.recordNodes.get(initialValue) != null){
                            recordCode.append("aload_0\n");
                            recordCode.append("new ").append(initialValue).append("\n").append("dup\n");
                            recordCode.append("invokespecial ").append(initialValue).append("/<init>()V\n");
                            recordCode.append("putfield ").append(ctx.Identifier().getText()).append("/").append(var).append(" L").append(nodeAfterFilling.varsType.get(var)).append(";\n");


                    }else{
                        recordCode.append("aload_0\n");
                        recordCode.append(initialValue);
                        recordCode.append("putfield ").append(ctx.Identifier().getText()).append("/").append(var).append(" ").append(nodeAfterFilling.varsType.get(var)).append("\n");
                    }
                }
            }

            recordCode.append("return\n").append(".end method\n");
            CodeGenHelper.records.add(recordCode.toString());
            CodeGenHelper.recordScope = null;
            return "";
        }

        return typeCode.toString();
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitType(IlangCodeGenerationParser.TypeContext ctx) {
        if (ctx.primitiveType() != null) {
            return visit(ctx.primitiveType());
        } else if (ctx.userType() != null) {
            return visit(ctx.userType());
        } else if (ctx.Identifier() != null) {
            return ctx.Identifier().getText();
        }
        return null;
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitPrimitiveType(IlangCodeGenerationParser.PrimitiveTypeContext ctx) {
        if (ctx.INTEGER_KEYWORD() != null) {
            return "I";
        } else if (ctx.REAL_KEYWORD() != null) {
            return "F";
        } else if (ctx.BOOLEAN_KEYWORD() != null) {
            return "Z";
        }

        return null;
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitUserType(IlangCodeGenerationParser.UserTypeContext ctx) {
        if (ctx.arrayType() != null) {
            return visit(ctx.arrayType());
        }

        return visit(ctx.recordType());

    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitRecordType(IlangCodeGenerationParser.RecordTypeContext ctx) {
        StringBuilder recordCodeType = new StringBuilder();

        for (int i = 0; i <  ctx.variableDeclaration().size() ; i++) {
            recordCodeType.append(visit(ctx.variableDeclaration(i))).append("\n");
        }

        return recordCodeType.toString();
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitArrayType(IlangCodeGenerationParser.ArrayTypeContext ctx) {
        StringBuilder arrayCode = new StringBuilder();
        boolean isRecordArray = false;
        List<Integer> sizes = new ArrayList<>();

        if (ctx.expression() == null){
            return "";
        }

        String arrayType = visit(ctx.type());
        String arrayNewType = "";
        String nodeType = "";
        int dimension = 0;

        if (arrayType.equals("I")){
            dimension = 1;
            arrayNewType = "int";
            nodeType = "I";
        }else if (arrayType.equals("F")){
            dimension = 1;
            arrayNewType = "float";
            nodeType = "F";
        }else if (arrayType.equals("Z")){
            dimension = 1;
            arrayNewType = "boolean";
            nodeType = "Z";

        }else{
            if (CodeGenHelper.scope != null){
                RoutineJasminNode routine = CodeGenHelper.routineNodes.get(CodeGenHelper.scope);

                if (routine.arrays.get(arrayType) != null){
                    ArrayJasminNode arr = routine.arrays.get(arrayType);
                    dimension = arr.dimension + 1;
                    arrayNewType = arr.type;
                    nodeType = arr.type;
                    sizes = arr.sizes;
                }else if (CodeGenHelper.recordNodes.get(arrayType) != null){
                    isRecordArray = true;
                    dimension = 1;
                    arrayNewType = arrayType;
                    nodeType = "L" + arrayType + ";";

                }
            }else{
                if (CodeGenHelper.arrays.get(arrayType) != null){
                    ArrayJasminNode arr = CodeGenHelper.arrays.get(arrayType);
                    dimension = arr.dimension + 1;
                    arrayNewType = arr.type;
                    nodeType = arr.type;
                    sizes = arr.sizes;

                }else if (CodeGenHelper.recordNodes.get(arrayType) != null){
                    isRecordArray = true;
                    dimension = 1;
                    arrayNewType = arrayType;
                    nodeType = "L" + arrayType + ";";
                }
            }
        }

        arrayCode.append(visit(ctx.expression()));
        if (dimension == 1){
            if (isRecordArray){
                arrayCode.append("anewarray ").append(arrayNewType).append("\n");
            }else{
                arrayCode.append("newarray ").append(arrayNewType).append("\n");
            }

        }else{
            for (int i = 0; i < dimension - 1; i++) {
                arrayCode.append("ldc ").append(sizes.get(i)).append("\n");
            }

            arrayCode.append("multianewarray ").append("[".repeat(dimension)).append(arrayNewType).append(" ").append(dimension).append("\n");
        }

        if (CodeGenHelper.scope != null){
            ArrayJasminNode arrayNode = CodeGenHelper.routineNodes.get(CodeGenHelper.scope).arrays.get(CodeGenHelper.arrayTemp);
            arrayNode.dimension = dimension;
            arrayNode.type = nodeType;
            sizes.add(Integer.parseInt(ctx.expression().getText()));
            arrayNode.sizes = sizes;
            CodeGenHelper.arrays.put(CodeGenHelper.arrayTemp, arrayNode);
        }else{
            ArrayJasminNode arrayNode = CodeGenHelper.arrays.get(CodeGenHelper.arrayTemp);
            arrayNode.dimension = dimension;
            arrayNode.type = nodeType;
            sizes.add(0, Integer.parseInt(ctx.expression().getText()));
            arrayNode.sizes = sizes;

            CodeGenHelper.arrays.put(CodeGenHelper.arrayTemp, arrayNode);
        }


        return arrayCode.toString();
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitStatement(IlangCodeGenerationParser.StatementContext ctx) {
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
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitAssignment(IlangCodeGenerationParser.AssignmentContext ctx) {
       StringBuilder assignmentCode = new StringBuilder();

       String[] modifiablePrimary = visit(ctx.modifiablePrimary()).split("!");

       String expression = visit(ctx.expression());

       assignmentCode.append(expression).append("\n");

        if (CodeGenHelper.scope != null && parseInteger(modifiablePrimary[1]) != null){
            assignmentCode.append(modifiablePrimary[0]).append("store ").append(modifiablePrimary[1]).append("\n");
            return assignmentCode.toString();
        }

        assignmentCode.append("putstatic " + CodeGenHelper.mainClassName + "/").append(modifiablePrimary[1]).append(" ").append(modifiablePrimary[0]).append("\n");

       return assignmentCode.toString();
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitRoutineCall(IlangCodeGenerationParser.RoutineCallContext ctx) {
        if (ctx.builtInRoutines() != null) {
            return visit(ctx.builtInRoutines());
        }

        String routineName = ctx.Identifier().getText();
        RoutineJasminNode routineNode = CodeGenHelper.routineNodes.get(routineName);

        // load parameters
        StringBuilder loadParameters = new StringBuilder();
        for (int i = 0; i < ctx.expression().size(); i++){
            loadParameters.append(visit(ctx.expression(i)));
        }

        return loadParameters + "invokestatic " + CodeGenHelper.mainClassName + "/" + routineName + "(" + routineNode.parameters + ")" + routineNode.returnType + "\n";
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitBuiltInRoutines(IlangCodeGenerationParser.BuiltInRoutinesContext ctx) {

        if (ctx.writeStatement() != null) {
            return visit(ctx.writeStatement());
        } else {
            return visit(ctx.inputStatement());
        }

    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitWhileLoop(IlangCodeGenerationParser.WhileLoopContext ctx) {
        StringBuilder whileCode = new StringBuilder();

        whileCode.append("WhileLoopStart").append(ctx.getStart().getStartIndex()).append(":").append("\n");

        String expressionCode = visit(ctx.expression());
        whileCode.append(expressionCode);
        whileCode.append("ifeq ").append("WhileLoopEnd").append(ctx.getStart().getStartIndex()).append("\n");
        whileCode.append(visit(ctx.body()));

        whileCode.append("goto WhileLoopStart").append(ctx.getStart().getStartIndex()).append("\n");
        whileCode.append("WhileLoopEnd").append(ctx.getStart().getStartIndex()).append(":").append("\n");

        return whileCode.toString();
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitForLoop(IlangCodeGenerationParser.ForLoopContext ctx) {
        StringBuilder forLoopCode = new StringBuilder();

        String[] rangeCodeSplitted = visit(ctx.range()).split("\n@@@\n");

        int loopVar = 0;

        if (CodeGenHelper.scope != null) {
            RoutineJasminNode routine = CodeGenHelper.routineNodes.get(CodeGenHelper.scope);

            routine.numOfLocalVariables += 1;
            loopVar = routine.numOfLocalVariables;
            routine.localVariable.put(ctx.Identifier().getText(), routine.numOfLocalVariables);
            forLoopCode.append(".var ").append(routine.numOfLocalVariables - 1).append(" is ").append(ctx.Identifier().getText()).append(" I\n");

            forLoopCode.append(rangeCodeSplitted[ctx.REVERSE() != null ? 1 : 0]).append("\n");

            forLoopCode.append("istore_").append(routine.numOfLocalVariables - 1).append("\n");
        }else{
            CodeGenHelper.mainNumOfLocalVariables += 1;
            loopVar = CodeGenHelper.mainNumOfLocalVariables;
            CodeGenHelper.mainLocalVariable.put(ctx.Identifier().getText(), CodeGenHelper.mainNumOfLocalVariables);
            forLoopCode.append(".var ").append(CodeGenHelper.mainNumOfLocalVariables - 1).append(" is ").append(ctx.Identifier().getText()).append(" I\n");

            forLoopCode.append(rangeCodeSplitted[ctx.REVERSE() != null ? 1 : 0]).append("\n");

            forLoopCode.append("istore_").append(CodeGenHelper.mainNumOfLocalVariables - 1).append("\n");
        }

        forLoopCode.append("ForLoopStart").append(ctx.getStart().getStartIndex()).append(":").append("\n");
        forLoopCode.append("iload_").append(loopVar - 1).append("\n");
        forLoopCode.append(rangeCodeSplitted[ctx.REVERSE() != null ? 0 : 1]).append("\n");

        if (ctx.REVERSE() != null){
            forLoopCode.append("if_icmplt ");
        }else{
            forLoopCode.append("if_icmpgt ");
        }

        forLoopCode.append("ForLoopEnd").append(ctx.getStart().getStartIndex()).append("\n");
        forLoopCode.append(visit(ctx.body()));
        forLoopCode.append("iinc ").append(loopVar - 1).append(ctx.REVERSE() != null ? " -1" : " 1").append("\n");
        forLoopCode.append("goto ").append("ForLoopStart").append(ctx.getStart().getStartIndex()).append("\n");

        forLoopCode.append("ForLoopEnd").append(ctx.getStart().getStartIndex()).append(":").append("\n");

        if (CodeGenHelper.scope != null) {
            CodeGenHelper.routineNodes.get(CodeGenHelper.scope).localVariable.remove(ctx.Identifier().getText());
        }else{
            CodeGenHelper.mainLocalVariable.remove(ctx.Identifier().getText());
        }

        return forLoopCode.toString();
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitRange(IlangCodeGenerationParser.RangeContext ctx) {
        String leftPart = visit(ctx.expression(0));
        String rightPart = visit(ctx.expression(1));

        return leftPart + "\n@@@\n" + rightPart;
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitIfStatement(IlangCodeGenerationParser.IfStatementContext ctx) {
        StringBuilder ifCode = new StringBuilder();
        String expressionCode = visit(ctx.expression());
        ifCode.append(expressionCode);

        String secondBlock = ctx.body().size() == 2 ? "ElseIF" : "EndIF";
        secondBlock += ctx.getStart().getStartIndex();

        ifCode.append("ifeq ").append(secondBlock).append("\n");
        ifCode.append(visit(ctx.body(0))).append("goto EndIF").append(ctx.getStart().getStartIndex()).append("\n");

        if (ctx.body().size() == 2){
            ifCode.append("ElseIF").append(ctx.getStart().getStartIndex()).append(":\n");
            ifCode.append(visit(ctx.body(1)));
        }

        ifCode.append("EndIF").append(ctx.getStart().getStartIndex()).append(":\n");

        return ifCode.toString();

    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitRoutineDeclaration(IlangCodeGenerationParser.RoutineDeclarationContext ctx) {
        StringBuilder rotuineCode = new StringBuilder();

        String routineName = ctx.Identifier().getText();

        HelperStore.scope = routineName;
        CodeGenHelper.scope = routineName;

        rotuineCode.append(".method public static ").append(routineName);
        rotuineCode.append("(");

        List<String> parameters = new ArrayList<>();
        if (ctx.parameters() != null){
            parameters = List.of(visit(ctx.parameters()).split(","));
        }
        StringBuilder parameterTypes = new StringBuilder();
        for (String s : parameters) {
            parameterTypes.append(s.split("@")[1]);
        }
        rotuineCode.append(parameterTypes);
        rotuineCode.append(")");

        // Return type
        String returnType;
        if (ctx.type() != null){
            returnType = visit(ctx.type());
        }else{
            returnType = "V";
        }

        RoutineJasminNode newRoutine = new RoutineJasminNode(parameterTypes.toString(),returnType);

        for (String parameter : parameters) {
            newRoutine.numOfLocalVariables += 1;
            newRoutine.localVariable.put(parameter.split("@")[0], newRoutine.numOfLocalVariables);
            newRoutine.varTypes.put(parameter.split("@")[0],parameter.split("@")[1]);
        }

        CodeGenHelper.routineNodes.put(routineName, newRoutine);

        rotuineCode.append(returnType).append("\n");
        rotuineCode.append("\t.limit stack 100\n");
        rotuineCode.append("\t.limit locals 100\n\n");

        for (int i = 0; i < parameters.size(); i++) {
            rotuineCode.append(".var ").append(i).append(" is ").append(parameters.get(i).split("@")[0]).append(" ").append(parameters.get(i).split("@")[1]).append("\n");
        }

        rotuineCode.append(visit(ctx.body()));

        switch (returnType) {
            case "I" -> rotuineCode.append("i");
            case "F" -> rotuineCode.append("f");
            case "Z" -> rotuineCode.append("z");
        }
        rotuineCode.append("return\n");
        rotuineCode.append("\n.end method");

        CodeGenHelper.routines.add(rotuineCode.toString());

        HelperStore.scope = null;
        CodeGenHelper.scope = null;

        return "";
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitParameters(IlangCodeGenerationParser.ParametersContext ctx) {
        StringBuilder parameters = new StringBuilder();
        for (IlangCodeGenerationParser.ParameterDeclarationContext paramCtx : ctx.parameterDeclaration()) {
            parameters.append(visit(paramCtx)).append(",");
        }
        parameters.deleteCharAt(parameters.lastIndexOf(","));
        return parameters.toString();
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitParameterDeclaration(IlangCodeGenerationParser.ParameterDeclarationContext ctx) {
        return ctx.Identifier().getText() + "@" + visit(ctx.type());
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitBody(IlangCodeGenerationParser.BodyContext ctx) {
        StringBuilder bodyCode = new StringBuilder();
        for (ParseTree child : ctx.children) {
            bodyCode.append("\t").append(visit(child)).append("\n");
        }

        return bodyCode.toString();
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitReturnStatement(IlangCodeGenerationParser.ReturnStatementContext ctx) {
        RoutineJasminNode routine = CodeGenHelper.routineNodes.get(CodeGenHelper.scope);
        StringBuilder returnCode = new StringBuilder();

        if (ctx.expression() != null){
            returnCode.append(visit(ctx.expression()));
        }

        switch (routine.returnType) {
            case "I" -> returnCode.append("i");
            case "F" -> returnCode.append("f");
            case "Z" -> returnCode.append("z");
        }
        returnCode.append("return\n");

        return returnCode.toString();
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitExpression(IlangCodeGenerationParser.ExpressionContext ctx) {
        StringBuilder ExpressionCode = new StringBuilder();

        String firstRelation = visit(ctx.relation(0));

        ExpressionCode.append(firstRelation);

        for (int i = 1; i < ctx.relation().size(); i++) {
            LogicalOperator operator = determineLogicalOperator(ctx, i - 1);
            String nextRelation = visit(ctx.relation(i));
            ExpressionCode.append(nextRelation);

            switch (operator){

                case AND -> {
                    ExpressionCode.append("iand\n");
                }
                case OR -> {
                    ExpressionCode.append("ior\n");
                }
                case XOR -> {
                    ExpressionCode.append("ixor\n");
                }
            }
        }

        return ExpressionCode.toString();

    }

    private LogicalOperator determineLogicalOperator(IlangCodeGenerationParser.ExpressionContext ctx, int operatorIndex) {
        if (ctx.AND(operatorIndex) != null) {
            return LogicalOperator.AND;
        } else if (ctx.OR(operatorIndex) != null) {
            return LogicalOperator.OR;
        } else{
            return LogicalOperator.XOR;
        }
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitRelation(IlangCodeGenerationParser.RelationContext ctx) {
        StringBuilder RelationCode = new StringBuilder();

        String firstSimple = visit(ctx.simple(0));
        RelationCode.append(firstSimple);

        if (ctx.simple(1) != null){
            ComparisonOperator operator = determineComparisonOperator(ctx);
            String nextSimple = visit(ctx.simple(1));
            RelationCode.append(nextSimple);
            switch (operator){

                case LT -> {
                    RelationCode.append("if_icmpge ").append("TrueBranch").append(ctx.getStart().getStartIndex()).append("\n");
                }
                case LEQ -> {
                    RelationCode.append("if_icmpgt ").append("TrueBranch").append(ctx.getStart().getStartIndex()).append("\n");
                }
                case GT -> {
                    RelationCode.append("if_icmple ").append("TrueBranch").append(ctx.getStart().getStartIndex()).append("\n");
                }
                case GEQ -> {
                    RelationCode.append("if_icmplt ").append("TrueBranch").append(ctx.getStart().getStartIndex()).append("\n");
                }
                case EQ -> {
                    RelationCode.append("if_icmpne ").append("TrueBranch").append(ctx.getStart().getStartIndex()).append("\n");
                }
                case NEQ -> {
                    RelationCode.append("if_icmpeq ").append("TrueBranch").append(ctx.getStart().getStartIndex()).append("\n");
                }
            }
            String falseBranch = "ldc 1\ngoto EndComparison"+ctx.getStart().getStartIndex()+"\n";

            String trueBranch = "TrueBranch"+ctx.getStart().getStartIndex()+":\n ldc 0\n";
            String endComparison = "EndComparison"+ctx.getStart().getStartIndex()+":\n";
            RelationCode.append(falseBranch).append(trueBranch).append(endComparison);
        }

        return RelationCode.toString();
    }

    private ComparisonOperator determineComparisonOperator(IlangCodeGenerationParser.RelationContext ctx) {
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
        } else {
            return ComparisonOperator.NEQ;
        }

    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitSimple(IlangCodeGenerationParser.SimpleContext ctx) {
        StringBuilder FactorCode = new StringBuilder();

        String firstSummand = visit(ctx.summand(0));
        FactorCode.append(firstSummand);
        Type firstSummandType = CodeGenHelper.typeAnalyse.analyzeSummand(ctx.summand(0));

        for (int i = 1; i < ctx.summand().size(); i++) {
            SummandOperator operator = ctx.PLUS(i - 1) != null ? SummandOperator.PLUS : SummandOperator.MINUS;
            String summandI = visit(ctx.summand(i));
            Type summandIType = CodeGenHelper.typeAnalyse.analyzeSummand(ctx.summand(i));
            FactorCode.append(summandI);

            String instructionType = "i";
            switch (CodeGenHelper.typeAnalyse.getPrimitiveType(firstSummandType, summandIType)){

                case BOOLEAN, INT -> {
                    instructionType = "i";
                }
                case REAL -> {
                    instructionType = "f";
                }
            }

            switch (operator){
                case PLUS -> {
                    FactorCode.append(instructionType).append("add").append("\n");
                }
                case MINUS -> {
                    FactorCode.append(instructionType).append("sub").append("\n");
                }
            }
        }

        return FactorCode.toString();
    }


    @Override
    public String visitSummand(IlangCodeGenerationParser.SummandContext ctx) {
        StringBuilder SimpleCode = new StringBuilder();

        String firstFactor = visit(ctx.factor(0));
        SimpleCode.append(firstFactor);
        Type firstFactorType = CodeGenHelper.typeAnalyse.analyzeFactor(ctx.factor(0));

        for (int i = 1; i < ctx.factor().size(); i++) {
            FactorOperator operator = ctx.MUL(i - 1) != null ? FactorOperator.MUL :
                    ctx.DIV(i - 1) != null ? FactorOperator.DIV : FactorOperator.MOD;

            String factorI = visit(ctx.factor(i));
            Type factorIType = CodeGenHelper.typeAnalyse.analyzeFactor(ctx.factor(i));
            SimpleCode.append(factorI);

            String instructionType = "i";
            switch (CodeGenHelper.typeAnalyse.getPrimitiveType(firstFactorType, factorIType)){

                case BOOLEAN, INT -> {
                    instructionType = "i";
                }
                case REAL -> {
                    instructionType = "f";
                }
            }

            switch (operator){

                case MUL -> {
                    SimpleCode.append(instructionType).append("mul").append("\n");
                }
                case DIV -> {
                    SimpleCode.append(instructionType).append("div").append("\n");
                }
                case MOD -> {
                    SimpleCode.append(instructionType).append("rem").append("\n");
                }
            }

        }

        return SimpleCode.toString();
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitFactor(IlangCodeGenerationParser.FactorContext ctx) {
        if (ctx.primary() != null){
            return visit(ctx.primary());
        }else{
            return visit(ctx.expression());
        }
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitPrimary(IlangCodeGenerationParser.PrimaryContext ctx) {
        String primaryCode = "";

        if (ctx.IntegerLiteral() != null){
            primaryCode += "ldc " + ctx.IntegerLiteral().getText() + "\n";
            if (ctx.sign() != null && Objects.equals(ctx.sign().getText(), "-")){
                primaryCode += "ineg\n";
            }

            return primaryCode;
        }else if (ctx.RealLiteral() != null){
            primaryCode += "ldc " + ctx.RealLiteral().getText() + "\n";
            if (ctx.sign() != null && Objects.equals(ctx.sign().getText(), "-")){
                primaryCode += "ineg\n";
            }
            return primaryCode;
        }else if (ctx.TRUE() != null){
            primaryCode += "ldc 1\n";
            return primaryCode;
        }else if (ctx.FALSE() != null){
            primaryCode += "ldc 0\n";
            return primaryCode;
        }else if (ctx.modifiablePrimary() != null){
            String[] modifiablePrimarySplitted = visit(ctx.modifiablePrimary()).split("!");

            if (CodeGenHelper.scope != null && parseInteger(modifiablePrimarySplitted[1]) != null){
                primaryCode += modifiablePrimarySplitted[0] + "load " + modifiablePrimarySplitted[1] + "\n";
                return primaryCode;
            }

            if (parseInteger(modifiablePrimarySplitted[1]) != null){
                primaryCode += modifiablePrimarySplitted[0] + "load " + modifiablePrimarySplitted[1] + "\n";
                return primaryCode;
            }

            primaryCode += "getstatic " + CodeGenHelper.mainClassName + "/" + modifiablePrimarySplitted[1] + " " + modifiablePrimarySplitted[0] + "\n";
            return primaryCode;

        }else if(ctx.routineCall() != null){
            return visit(ctx.routineCall());
        }

        return null;
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitModifiablePrimary(IlangCodeGenerationParser.ModifiablePrimaryContext ctx) {
        StringBuilder modifiablePrimaryCode = new StringBuilder();

        if (ctx.getChildCount() == 1){
            if (CodeGenHelper.scope != null) {
                RoutineJasminNode routine = CodeGenHelper.routineNodes.get(CodeGenHelper.scope);
                if (routine.localVariable.get(ctx.Identifier(0).getText()) != null){
                    String loadType = switch (routine.varTypes.get(ctx.Identifier(0).getText())) {
                        case "I" -> "i";
                        case "F" -> "f";
                        case "Z" -> "z";
                        default -> "";
                    };

                    modifiablePrimaryCode.append(loadType).append("!").append(routine.localVariable.get(ctx.Identifier(0).getText()) - 1);
                    return modifiablePrimaryCode.toString();
                }

            }

            if (CodeGenHelper.mainLocalVariable.get(ctx.Identifier(0).getText()) != null){
                modifiablePrimaryCode.append("i").append("!").append(CodeGenHelper.mainLocalVariable.get(ctx.Identifier(0).getText()) - 1);
                return modifiablePrimaryCode.toString();
            }

            modifiablePrimaryCode.append(CodeGenHelper.globalVarTypes.get(ctx.Identifier(0).getText())).append("!").append(ctx.Identifier(0).getText());

            return modifiablePrimaryCode.toString();

        }

        return super.visitModifiablePrimary(ctx);
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitWriteStatement(IlangCodeGenerationParser.WriteStatementContext ctx) {
        StringBuilder writeCode = new StringBuilder();
        String expressionCode = visit(ctx.expression());
        String expressionType = "I";

        writeCode.append(expressionCode);

        switch (CodeGenHelper.typeAnalyse.analyzeExpression(ctx.expression())){

            case BOOLEAN -> {
                expressionType = "Z";
            }

            case REAL -> {
                expressionType = "F";
            }

        }

        if (ctx.WRITE() != null) {
            writeCode.append("getstatic java/lang/System/out Ljava/io/PrintStream;\n");
            writeCode.append("swap\n");
            writeCode.append("invokevirtual java/io/PrintStream/print(").append(expressionType).append(")V\n");
        } else if (ctx.WRITES() != null) {
            writeCode.append("getstatic java/lang/System/out Ljava/io/PrintStream;\n");
            writeCode.append("swap\n");
            writeCode.append("invokevirtual java/io/PrintStream/print(").append(expressionType).append(")V\n");

            writeCode.append("ldc \" \"\n");
            writeCode.append("getstatic java/lang/System/out Ljava/io/PrintStream;\n");
            writeCode.append("swap\n");
            writeCode.append("invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V\n");
        } else {
            writeCode.append("getstatic java/lang/System/out Ljava/io/PrintStream;\n");
            writeCode.append("swap\n");
            writeCode.append("invokevirtual java/io/PrintStream/println(").append(expressionType).append(")V\n");
        }

        return writeCode.toString();
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitInputStatement(IlangCodeGenerationParser.InputStatementContext ctx) {
        StringBuilder inputCode = new StringBuilder();
        // new Scanner
        inputCode.append("new java/util/Scanner\n").append("dup\n");
        inputCode.append("getstatic java/lang/System/in Ljava/io/InputStream;\n");
        inputCode.append("invokespecial java/util/Scanner/<init>(Ljava/io/InputStream;)V\n");

        inputCode.append("dup\n");
        String type = visit(ctx.type());

        if (type.equals("I")){
            inputCode.append("invokevirtual java/util/Scanner/nextInt()I\n");
        }else if (type.equals("Z")){
            inputCode.append("invokevirtual java/util/Scanner/nextBoolean()Z\n");
        }else if (type.equals("F")){
            inputCode.append("invokevirtual java/util/Scanner/nextFloat()F\n");
        }

        return inputCode.toString();
    }


    public static Integer parseInteger(String str) {
        try {
            return Integer.valueOf(str);
        } catch (NumberFormatException e) {
            return null;
        }
    }
}
