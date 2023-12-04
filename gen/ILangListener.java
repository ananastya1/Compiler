// Generated from C:/Users/admin/Desktop/Compiler/src/grammar/ILang.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link ILangParser}.
 */
public interface ILangListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link ILangParser#main}.
	 * @param ctx the parse tree
	 */
	void enterMain(ILangParser.MainContext ctx);
	/**
	 * Exit a parse tree produced by {@link ILangParser#main}.
	 * @param ctx the parse tree
	 */
	void exitMain(ILangParser.MainContext ctx);
	/**
	 * Enter a parse tree produced by {@link ILangParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(ILangParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link ILangParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(ILangParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link ILangParser#simpleDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterSimpleDeclaration(ILangParser.SimpleDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link ILangParser#simpleDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitSimpleDeclaration(ILangParser.SimpleDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link ILangParser#variableDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterVariableDeclaration(ILangParser.VariableDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link ILangParser#variableDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitVariableDeclaration(ILangParser.VariableDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link ILangParser#typeDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterTypeDeclaration(ILangParser.TypeDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link ILangParser#typeDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitTypeDeclaration(ILangParser.TypeDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link ILangParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(ILangParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link ILangParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(ILangParser.TypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link ILangParser#primitiveType}.
	 * @param ctx the parse tree
	 */
	void enterPrimitiveType(ILangParser.PrimitiveTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link ILangParser#primitiveType}.
	 * @param ctx the parse tree
	 */
	void exitPrimitiveType(ILangParser.PrimitiveTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link ILangParser#userType}.
	 * @param ctx the parse tree
	 */
	void enterUserType(ILangParser.UserTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link ILangParser#userType}.
	 * @param ctx the parse tree
	 */
	void exitUserType(ILangParser.UserTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link ILangParser#recordType}.
	 * @param ctx the parse tree
	 */
	void enterRecordType(ILangParser.RecordTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link ILangParser#recordType}.
	 * @param ctx the parse tree
	 */
	void exitRecordType(ILangParser.RecordTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link ILangParser#arrayType}.
	 * @param ctx the parse tree
	 */
	void enterArrayType(ILangParser.ArrayTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link ILangParser#arrayType}.
	 * @param ctx the parse tree
	 */
	void exitArrayType(ILangParser.ArrayTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link ILangParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(ILangParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link ILangParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(ILangParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link ILangParser#assignment}.
	 * @param ctx the parse tree
	 */
	void enterAssignment(ILangParser.AssignmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link ILangParser#assignment}.
	 * @param ctx the parse tree
	 */
	void exitAssignment(ILangParser.AssignmentContext ctx);
	/**
	 * Enter a parse tree produced by {@link ILangParser#routineCall}.
	 * @param ctx the parse tree
	 */
	void enterRoutineCall(ILangParser.RoutineCallContext ctx);
	/**
	 * Exit a parse tree produced by {@link ILangParser#routineCall}.
	 * @param ctx the parse tree
	 */
	void exitRoutineCall(ILangParser.RoutineCallContext ctx);
	/**
	 * Enter a parse tree produced by {@link ILangParser#builtInRoutines}.
	 * @param ctx the parse tree
	 */
	void enterBuiltInRoutines(ILangParser.BuiltInRoutinesContext ctx);
	/**
	 * Exit a parse tree produced by {@link ILangParser#builtInRoutines}.
	 * @param ctx the parse tree
	 */
	void exitBuiltInRoutines(ILangParser.BuiltInRoutinesContext ctx);
	/**
	 * Enter a parse tree produced by {@link ILangParser#whileLoop}.
	 * @param ctx the parse tree
	 */
	void enterWhileLoop(ILangParser.WhileLoopContext ctx);
	/**
	 * Exit a parse tree produced by {@link ILangParser#whileLoop}.
	 * @param ctx the parse tree
	 */
	void exitWhileLoop(ILangParser.WhileLoopContext ctx);
	/**
	 * Enter a parse tree produced by {@link ILangParser#forLoop}.
	 * @param ctx the parse tree
	 */
	void enterForLoop(ILangParser.ForLoopContext ctx);
	/**
	 * Exit a parse tree produced by {@link ILangParser#forLoop}.
	 * @param ctx the parse tree
	 */
	void exitForLoop(ILangParser.ForLoopContext ctx);
	/**
	 * Enter a parse tree produced by {@link ILangParser#range}.
	 * @param ctx the parse tree
	 */
	void enterRange(ILangParser.RangeContext ctx);
	/**
	 * Exit a parse tree produced by {@link ILangParser#range}.
	 * @param ctx the parse tree
	 */
	void exitRange(ILangParser.RangeContext ctx);
	/**
	 * Enter a parse tree produced by {@link ILangParser#ifStatement}.
	 * @param ctx the parse tree
	 */
	void enterIfStatement(ILangParser.IfStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link ILangParser#ifStatement}.
	 * @param ctx the parse tree
	 */
	void exitIfStatement(ILangParser.IfStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link ILangParser#routineDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterRoutineDeclaration(ILangParser.RoutineDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link ILangParser#routineDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitRoutineDeclaration(ILangParser.RoutineDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link ILangParser#parameters}.
	 * @param ctx the parse tree
	 */
	void enterParameters(ILangParser.ParametersContext ctx);
	/**
	 * Exit a parse tree produced by {@link ILangParser#parameters}.
	 * @param ctx the parse tree
	 */
	void exitParameters(ILangParser.ParametersContext ctx);
	/**
	 * Enter a parse tree produced by {@link ILangParser#parameterDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterParameterDeclaration(ILangParser.ParameterDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link ILangParser#parameterDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitParameterDeclaration(ILangParser.ParameterDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link ILangParser#body}.
	 * @param ctx the parse tree
	 */
	void enterBody(ILangParser.BodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link ILangParser#body}.
	 * @param ctx the parse tree
	 */
	void exitBody(ILangParser.BodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link ILangParser#returnStatement}.
	 * @param ctx the parse tree
	 */
	void enterReturnStatement(ILangParser.ReturnStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link ILangParser#returnStatement}.
	 * @param ctx the parse tree
	 */
	void exitReturnStatement(ILangParser.ReturnStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link ILangParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(ILangParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ILangParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(ILangParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ILangParser#relation}.
	 * @param ctx the parse tree
	 */
	void enterRelation(ILangParser.RelationContext ctx);
	/**
	 * Exit a parse tree produced by {@link ILangParser#relation}.
	 * @param ctx the parse tree
	 */
	void exitRelation(ILangParser.RelationContext ctx);
	/**
	 * Enter a parse tree produced by {@link ILangParser#simple}.
	 * @param ctx the parse tree
	 */
	void enterSimple(ILangParser.SimpleContext ctx);
	/**
	 * Exit a parse tree produced by {@link ILangParser#simple}.
	 * @param ctx the parse tree
	 */
	void exitSimple(ILangParser.SimpleContext ctx);
	/**
	 * Enter a parse tree produced by {@link ILangParser#summand}.
	 * @param ctx the parse tree
	 */
	void enterSummand(ILangParser.SummandContext ctx);
	/**
	 * Exit a parse tree produced by {@link ILangParser#summand}.
	 * @param ctx the parse tree
	 */
	void exitSummand(ILangParser.SummandContext ctx);
	/**
	 * Enter a parse tree produced by {@link ILangParser#factor}.
	 * @param ctx the parse tree
	 */
	void enterFactor(ILangParser.FactorContext ctx);
	/**
	 * Exit a parse tree produced by {@link ILangParser#factor}.
	 * @param ctx the parse tree
	 */
	void exitFactor(ILangParser.FactorContext ctx);
	/**
	 * Enter a parse tree produced by {@link ILangParser#primary}.
	 * @param ctx the parse tree
	 */
	void enterPrimary(ILangParser.PrimaryContext ctx);
	/**
	 * Exit a parse tree produced by {@link ILangParser#primary}.
	 * @param ctx the parse tree
	 */
	void exitPrimary(ILangParser.PrimaryContext ctx);
	/**
	 * Enter a parse tree produced by {@link ILangParser#sign}.
	 * @param ctx the parse tree
	 */
	void enterSign(ILangParser.SignContext ctx);
	/**
	 * Exit a parse tree produced by {@link ILangParser#sign}.
	 * @param ctx the parse tree
	 */
	void exitSign(ILangParser.SignContext ctx);
	/**
	 * Enter a parse tree produced by {@link ILangParser#modifiablePrimary}.
	 * @param ctx the parse tree
	 */
	void enterModifiablePrimary(ILangParser.ModifiablePrimaryContext ctx);
	/**
	 * Exit a parse tree produced by {@link ILangParser#modifiablePrimary}.
	 * @param ctx the parse tree
	 */
	void exitModifiablePrimary(ILangParser.ModifiablePrimaryContext ctx);
	/**
	 * Enter a parse tree produced by {@link ILangParser#writeStatement}.
	 * @param ctx the parse tree
	 */
	void enterWriteStatement(ILangParser.WriteStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link ILangParser#writeStatement}.
	 * @param ctx the parse tree
	 */
	void exitWriteStatement(ILangParser.WriteStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link ILangParser#inputStatement}.
	 * @param ctx the parse tree
	 */
	void enterInputStatement(ILangParser.InputStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link ILangParser#inputStatement}.
	 * @param ctx the parse tree
	 */
	void exitInputStatement(ILangParser.InputStatementContext ctx);
}