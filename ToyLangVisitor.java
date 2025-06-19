// Generated from ToyLang.g4 by ANTLR 4.13.2
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link ToyLangParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface ToyLangVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link ToyLangParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(ToyLangParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by the {@code VarDecl}
	 * labeled alternative in {@link ToyLangParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarDecl(ToyLangParser.VarDeclContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Assignment}
	 * labeled alternative in {@link ToyLangParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignment(ToyLangParser.AssignmentContext ctx);
	/**
	 * Visit a parse tree produced by the {@code MemberAssignment}
	 * labeled alternative in {@link ToyLangParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMemberAssignment(ToyLangParser.MemberAssignmentContext ctx);
	/**
	 * Visit a parse tree produced by the {@code IfStatement}
	 * labeled alternative in {@link ToyLangParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfStatement(ToyLangParser.IfStatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code WhileStatement}
	 * labeled alternative in {@link ToyLangParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhileStatement(ToyLangParser.WhileStatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code FunctionDecl}
	 * labeled alternative in {@link ToyLangParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionDecl(ToyLangParser.FunctionDeclContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BlockStatement}
	 * labeled alternative in {@link ToyLangParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlockStatement(ToyLangParser.BlockStatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprStatement}
	 * labeled alternative in {@link ToyLangParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprStatement(ToyLangParser.ExprStatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ReturnStatement}
	 * labeled alternative in {@link ToyLangParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnStatement(ToyLangParser.ReturnStatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code FunctionCallExpr}
	 * labeled alternative in {@link ToyLangParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionCallExpr(ToyLangParser.FunctionCallExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code EqualityExpr}
	 * labeled alternative in {@link ToyLangParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEqualityExpr(ToyLangParser.EqualityExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code MulDivExpr}
	 * labeled alternative in {@link ToyLangParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMulDivExpr(ToyLangParser.MulDivExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code CompareExpr}
	 * labeled alternative in {@link ToyLangParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompareExpr(ToyLangParser.CompareExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AtomExpr}
	 * labeled alternative in {@link ToyLangParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAtomExpr(ToyLangParser.AtomExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code MemberAccessExpr}
	 * labeled alternative in {@link ToyLangParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMemberAccessExpr(ToyLangParser.MemberAccessExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AddSubExpr}
	 * labeled alternative in {@link ToyLangParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddSubExpr(ToyLangParser.AddSubExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ParenExpr}
	 * labeled alternative in {@link ToyLangParser#atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParenExpr(ToyLangParser.ParenExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code IdAtom}
	 * labeled alternative in {@link ToyLangParser#atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdAtom(ToyLangParser.IdAtomContext ctx);
	/**
	 * Visit a parse tree produced by the {@code NumberAtom}
	 * labeled alternative in {@link ToyLangParser#atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumberAtom(ToyLangParser.NumberAtomContext ctx);
	/**
	 * Visit a parse tree produced by the {@code StringAtom}
	 * labeled alternative in {@link ToyLangParser#atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringAtom(ToyLangParser.StringAtomContext ctx);
	/**
	 * Visit a parse tree produced by the {@code NullAtom}
	 * labeled alternative in {@link ToyLangParser#atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNullAtom(ToyLangParser.NullAtomContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ObjectAtom}
	 * labeled alternative in {@link ToyLangParser#atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitObjectAtom(ToyLangParser.ObjectAtomContext ctx);
	/**
	 * Visit a parse tree produced by the {@code TrueAtom}
	 * labeled alternative in {@link ToyLangParser#atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTrueAtom(ToyLangParser.TrueAtomContext ctx);
	/**
	 * Visit a parse tree produced by the {@code FalseAtom}
	 * labeled alternative in {@link ToyLangParser#atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFalseAtom(ToyLangParser.FalseAtomContext ctx);
	/**
	 * Visit a parse tree produced by {@link ToyLangParser#pair}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPair(ToyLangParser.PairContext ctx);
	/**
	 * Visit a parse tree produced by {@link ToyLangParser#idList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdList(ToyLangParser.IdListContext ctx);
	/**
	 * Visit a parse tree produced by {@link ToyLangParser#exprList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprList(ToyLangParser.ExprListContext ctx);
}