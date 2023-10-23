// Generated from /Users/shredding/ALL MY/Inno/Year 3/CompilerGit/src/grammar/ILang.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link ILangParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface ILangVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link ILangParser#main}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMain(ILangParser.MainContext ctx);
	/**
	 * Visit a parse tree produced by {@link ILangParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(ILangParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link ILangParser#simpleDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSimpleDeclaration(ILangParser.SimpleDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link ILangParser#variableDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableDeclaration(ILangParser.VariableDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link ILangParser#typeDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeDeclaration(ILangParser.TypeDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link ILangParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType(ILangParser.TypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link ILangParser#primitiveType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimitiveType(ILangParser.PrimitiveTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link ILangParser#userType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUserType(ILangParser.UserTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link ILangParser#recordType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRecordType(ILangParser.RecordTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link ILangParser#arrayType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayType(ILangParser.ArrayTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link ILangParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(ILangParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link ILangParser#assignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignment(ILangParser.AssignmentContext ctx);
	/**
	 * Visit a parse tree produced by {@link ILangParser#routineCall}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRoutineCall(ILangParser.RoutineCallContext ctx);
	/**
	 * Visit a parse tree produced by {@link ILangParser#builtInRoutines}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBuiltInRoutines(ILangParser.BuiltInRoutinesContext ctx);
	/**
	 * Visit a parse tree produced by {@link ILangParser#whileLoop}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhileLoop(ILangParser.WhileLoopContext ctx);
	/**
	 * Visit a parse tree produced by {@link ILangParser#forLoop}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForLoop(ILangParser.ForLoopContext ctx);
	/**
	 * Visit a parse tree produced by {@link ILangParser#range}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRange(ILangParser.RangeContext ctx);
	/**
	 * Visit a parse tree produced by {@link ILangParser#ifStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfStatement(ILangParser.IfStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link ILangParser#routineDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRoutineDeclaration(ILangParser.RoutineDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link ILangParser#parameters}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameters(ILangParser.ParametersContext ctx);
	/**
	 * Visit a parse tree produced by {@link ILangParser#parameterDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameterDeclaration(ILangParser.ParameterDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link ILangParser#body}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBody(ILangParser.BodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link ILangParser#returnStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnStatement(ILangParser.ReturnStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link ILangParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(ILangParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link ILangParser#relation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRelation(ILangParser.RelationContext ctx);
	/**
	 * Visit a parse tree produced by {@link ILangParser#simple}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSimple(ILangParser.SimpleContext ctx);
	/**
	 * Visit a parse tree produced by {@link ILangParser#factor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFactor(ILangParser.FactorContext ctx);
	/**
	 * Visit a parse tree produced by {@link ILangParser#summand}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSummand(ILangParser.SummandContext ctx);
	/**
	 * Visit a parse tree produced by {@link ILangParser#primary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimary(ILangParser.PrimaryContext ctx);
	/**
	 * Visit a parse tree produced by {@link ILangParser#sign}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSign(ILangParser.SignContext ctx);
	/**
	 * Visit a parse tree produced by {@link ILangParser#modifiablePrimary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitModifiablePrimary(ILangParser.ModifiablePrimaryContext ctx);
	/**
	 * Visit a parse tree produced by {@link ILangParser#writeStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWriteStatement(ILangParser.WriteStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link ILangParser#inputStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInputStatement(ILangParser.InputStatementContext ctx);
}