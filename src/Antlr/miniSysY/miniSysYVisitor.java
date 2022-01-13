// Generated from miniSysY.g4 by ANTLR 4.9.2
package Antlr.miniSysY;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link miniSysYParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface miniSysYVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link miniSysYParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(miniSysYParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link miniSysYParser#compUnit}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompUnit(miniSysYParser.CompUnitContext ctx);
	/**
	 * Visit a parse tree produced by {@link miniSysYParser#decl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDecl(miniSysYParser.DeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link miniSysYParser#constDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstDecl(miniSysYParser.ConstDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link miniSysYParser#bType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBType(miniSysYParser.BTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link miniSysYParser#constDef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstDef(miniSysYParser.ConstDefContext ctx);
	/**
	 * Visit a parse tree produced by {@link miniSysYParser#constInitVal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstInitVal(miniSysYParser.ConstInitValContext ctx);
	/**
	 * Visit a parse tree produced by {@link miniSysYParser#constExp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstExp(miniSysYParser.ConstExpContext ctx);
	/**
	 * Visit a parse tree produced by {@link miniSysYParser#varDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarDecl(miniSysYParser.VarDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link miniSysYParser#varDef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarDef(miniSysYParser.VarDefContext ctx);
	/**
	 * Visit a parse tree produced by {@link miniSysYParser#initVal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInitVal(miniSysYParser.InitValContext ctx);
	/**
	 * Visit a parse tree produced by {@link miniSysYParser#funcDef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncDef(miniSysYParser.FuncDefContext ctx);
	/**
	 * Visit a parse tree produced by {@link miniSysYParser#funcType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncType(miniSysYParser.FuncTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link miniSysYParser#funcFParams}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncFParams(miniSysYParser.FuncFParamsContext ctx);
	/**
	 * Visit a parse tree produced by {@link miniSysYParser#funcFParam}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncFParam(miniSysYParser.FuncFParamContext ctx);
	/**
	 * Visit a parse tree produced by {@link miniSysYParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(miniSysYParser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link miniSysYParser#blockItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlockItem(miniSysYParser.BlockItemContext ctx);
	/**
	 * Visit a parse tree produced by {@link miniSysYParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStmt(miniSysYParser.StmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link miniSysYParser#assign_stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssign_stmt(miniSysYParser.Assign_stmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link miniSysYParser#exp_stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExp_stmt(miniSysYParser.Exp_stmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link miniSysYParser#if_stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIf_stmt(miniSysYParser.If_stmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link miniSysYParser#while_stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhile_stmt(miniSysYParser.While_stmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link miniSysYParser#break_stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBreak_stmt(miniSysYParser.Break_stmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link miniSysYParser#continue_stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitContinue_stmt(miniSysYParser.Continue_stmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link miniSysYParser#return_stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturn_stmt(miniSysYParser.Return_stmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link miniSysYParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExp(miniSysYParser.ExpContext ctx);
	/**
	 * Visit a parse tree produced by {@link miniSysYParser#cond}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCond(miniSysYParser.CondContext ctx);
	/**
	 * Visit a parse tree produced by {@link miniSysYParser#lVal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLVal(miniSysYParser.LValContext ctx);
	/**
	 * Visit a parse tree produced by {@link miniSysYParser#primaryExp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimaryExp(miniSysYParser.PrimaryExpContext ctx);
	/**
	 * Visit a parse tree produced by {@link miniSysYParser#number}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumber(miniSysYParser.NumberContext ctx);
	/**
	 * Visit a parse tree produced by {@link miniSysYParser#unaryExp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnaryExp(miniSysYParser.UnaryExpContext ctx);
	/**
	 * Visit a parse tree produced by {@link miniSysYParser#callee}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCallee(miniSysYParser.CalleeContext ctx);
	/**
	 * Visit a parse tree produced by {@link miniSysYParser#unaryOp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnaryOp(miniSysYParser.UnaryOpContext ctx);
	/**
	 * Visit a parse tree produced by {@link miniSysYParser#funcRParams}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncRParams(miniSysYParser.FuncRParamsContext ctx);
	/**
	 * Visit a parse tree produced by {@link miniSysYParser#mulExp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMulExp(miniSysYParser.MulExpContext ctx);
	/**
	 * Visit a parse tree produced by {@link miniSysYParser#addExp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddExp(miniSysYParser.AddExpContext ctx);
	/**
	 * Visit a parse tree produced by {@link miniSysYParser#relExp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRelExp(miniSysYParser.RelExpContext ctx);
	/**
	 * Visit a parse tree produced by {@link miniSysYParser#eqExp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEqExp(miniSysYParser.EqExpContext ctx);
	/**
	 * Visit a parse tree produced by {@link miniSysYParser#lAndExp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLAndExp(miniSysYParser.LAndExpContext ctx);
	/**
	 * Visit a parse tree produced by {@link miniSysYParser#lOrExp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLOrExp(miniSysYParser.LOrExpContext ctx);
}