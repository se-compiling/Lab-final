// Generated from /Users/zymac/Documents/buaa/大三上/软院大三上学习资料/编译原理/Lab/Lab/src/ANTLR/miniSysY.g4 by ANTLR 4.8
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class miniSysYParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.8", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, LParen=5, RParen=6, LBrace=7, RBrace=8, 
		Semicolon=9, Plus=10, Minus=11, Star=12, Div=13, Mod=14, Int=15, RET=16, 
		FuncType=17, Btype=18, Ident=19, Letter=20, LetterOrDigit=21, Decimal_const=22, 
		Octal_const=23, Hexadecimal_const=24, LVal=25, Digits=26, Whitespace=27, 
		BlockComment=28, LineComment=29;
	public static final int
		RULE_compUnit = 0, RULE_funcDef = 1, RULE_block = 2, RULE_stmt = 3, RULE_number = 4, 
		RULE_initVal = 5, RULE_exp = 6, RULE_addExp = 7, RULE_mulExp = 8, RULE_unaryExp = 9, 
		RULE_primaryExp = 10, RULE_unaryOp = 11, RULE_funcRParams = 12, RULE_decl = 13, 
		RULE_constDecl = 14, RULE_constDef = 15, RULE_constInitVal = 16, RULE_constExp = 17, 
		RULE_varDecl = 18, RULE_varDef = 19, RULE_blockItem = 20;
	private static String[] makeRuleNames() {
		return new String[] {
			"compUnit", "funcDef", "block", "stmt", "number", "initVal", "exp", "addExp", 
			"mulExp", "unaryExp", "primaryExp", "unaryOp", "funcRParams", "decl", 
			"constDecl", "constDef", "constInitVal", "constExp", "varDecl", "varDef", 
			"blockItem"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'()'", "'='", "','", "'const'", "'('", "')'", "'{'", "'}'", "';'", 
			"'+'", "'-'", "'*'", "'/'", "'%'", "'int'", "'return'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, "LParen", "RParen", "LBrace", "RBrace", 
			"Semicolon", "Plus", "Minus", "Star", "Div", "Mod", "Int", "RET", "FuncType", 
			"Btype", "Ident", "Letter", "LetterOrDigit", "Decimal_const", "Octal_const", 
			"Hexadecimal_const", "LVal", "Digits", "Whitespace", "BlockComment", 
			"LineComment"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "miniSysY.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public miniSysYParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class CompUnitContext extends ParserRuleContext {
		public FuncDefContext funcDef() {
			return getRuleContext(FuncDefContext.class,0);
		}
		public TerminalNode EOF() { return getToken(miniSysYParser.EOF, 0); }
		public CompUnitContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_compUnit; }
	}

	public final CompUnitContext compUnit() throws RecognitionException {
		CompUnitContext _localctx = new CompUnitContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_compUnit);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(42);
			funcDef();
			setState(43);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FuncDefContext extends ParserRuleContext {
		public TerminalNode FuncType() { return getToken(miniSysYParser.FuncType, 0); }
		public TerminalNode Ident() { return getToken(miniSysYParser.Ident, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public FuncDefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funcDef; }
	}

	public final FuncDefContext funcDef() throws RecognitionException {
		FuncDefContext _localctx = new FuncDefContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_funcDef);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(45);
			match(FuncType);
			setState(46);
			match(Ident);
			setState(47);
			match(T__0);
			setState(48);
			block();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BlockContext extends ParserRuleContext {
		public TerminalNode LBrace() { return getToken(miniSysYParser.LBrace, 0); }
		public TerminalNode RBrace() { return getToken(miniSysYParser.RBrace, 0); }
		public List<BlockItemContext> blockItem() {
			return getRuleContexts(BlockItemContext.class);
		}
		public BlockItemContext blockItem(int i) {
			return getRuleContext(BlockItemContext.class,i);
		}
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(50);
			match(LBrace);
			setState(54);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__3) | (1L << LParen) | (1L << Semicolon) | (1L << Plus) | (1L << Minus) | (1L << RET) | (1L << Btype) | (1L << Ident) | (1L << Decimal_const) | (1L << Octal_const) | (1L << Hexadecimal_const) | (1L << LVal))) != 0)) {
				{
				{
				setState(51);
				blockItem();
				}
				}
				setState(56);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(57);
			match(RBrace);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StmtContext extends ParserRuleContext {
		public StmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stmt; }
	 
		public StmtContext() { }
		public void copyFrom(StmtContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class Stmt_retContext extends StmtContext {
		public TerminalNode RET() { return getToken(miniSysYParser.RET, 0); }
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public TerminalNode Semicolon() { return getToken(miniSysYParser.Semicolon, 0); }
		public Stmt_retContext(StmtContext ctx) { copyFrom(ctx); }
	}
	public static class Stmt_assignmentContext extends StmtContext {
		public TerminalNode LVal() { return getToken(miniSysYParser.LVal, 0); }
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public TerminalNode Semicolon() { return getToken(miniSysYParser.Semicolon, 0); }
		public Stmt_assignmentContext(StmtContext ctx) { copyFrom(ctx); }
	}
	public static class Stmt_expContext extends StmtContext {
		public TerminalNode Semicolon() { return getToken(miniSysYParser.Semicolon, 0); }
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public Stmt_expContext(StmtContext ctx) { copyFrom(ctx); }
	}

	public final StmtContext stmt() throws RecognitionException {
		StmtContext _localctx = new StmtContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_stmt);
		int _la;
		try {
			setState(72);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				_localctx = new Stmt_assignmentContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(59);
				match(LVal);
				setState(60);
				match(T__1);
				setState(61);
				exp();
				setState(62);
				match(Semicolon);
				}
				break;
			case 2:
				_localctx = new Stmt_expContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(65);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LParen) | (1L << Plus) | (1L << Minus) | (1L << Ident) | (1L << Decimal_const) | (1L << Octal_const) | (1L << Hexadecimal_const) | (1L << LVal))) != 0)) {
					{
					setState(64);
					exp();
					}
				}

				setState(67);
				match(Semicolon);
				}
				break;
			case 3:
				_localctx = new Stmt_retContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(68);
				match(RET);
				setState(69);
				exp();
				setState(70);
				match(Semicolon);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NumberContext extends ParserRuleContext {
		public TerminalNode Decimal_const() { return getToken(miniSysYParser.Decimal_const, 0); }
		public TerminalNode Octal_const() { return getToken(miniSysYParser.Octal_const, 0); }
		public TerminalNode Hexadecimal_const() { return getToken(miniSysYParser.Hexadecimal_const, 0); }
		public NumberContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_number; }
	}

	public final NumberContext number() throws RecognitionException {
		NumberContext _localctx = new NumberContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_number);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(74);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Decimal_const) | (1L << Octal_const) | (1L << Hexadecimal_const))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class InitValContext extends ParserRuleContext {
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public InitValContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_initVal; }
	}

	public final InitValContext initVal() throws RecognitionException {
		InitValContext _localctx = new InitValContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_initVal);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(76);
			exp();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpContext extends ParserRuleContext {
		public AddExpContext addExp() {
			return getRuleContext(AddExpContext.class,0);
		}
		public ExpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exp; }
	}

	public final ExpContext exp() throws RecognitionException {
		ExpContext _localctx = new ExpContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_exp);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(78);
			addExp(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AddExpContext extends ParserRuleContext {
		public Token op;
		public MulExpContext mulExp() {
			return getRuleContext(MulExpContext.class,0);
		}
		public AddExpContext addExp() {
			return getRuleContext(AddExpContext.class,0);
		}
		public TerminalNode Plus() { return getToken(miniSysYParser.Plus, 0); }
		public TerminalNode Minus() { return getToken(miniSysYParser.Minus, 0); }
		public AddExpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_addExp; }
	}

	public final AddExpContext addExp() throws RecognitionException {
		return addExp(0);
	}

	private AddExpContext addExp(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		AddExpContext _localctx = new AddExpContext(_ctx, _parentState);
		AddExpContext _prevctx = _localctx;
		int _startState = 14;
		enterRecursionRule(_localctx, 14, RULE_addExp, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(81);
			mulExp(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(88);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new AddExpContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_addExp);
					setState(83);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(84);
					((AddExpContext)_localctx).op = _input.LT(1);
					_la = _input.LA(1);
					if ( !(_la==Plus || _la==Minus) ) {
						((AddExpContext)_localctx).op = (Token)_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(85);
					mulExp(0);
					}
					} 
				}
				setState(90);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class MulExpContext extends ParserRuleContext {
		public Token op;
		public UnaryExpContext unaryExp() {
			return getRuleContext(UnaryExpContext.class,0);
		}
		public MulExpContext mulExp() {
			return getRuleContext(MulExpContext.class,0);
		}
		public TerminalNode Star() { return getToken(miniSysYParser.Star, 0); }
		public TerminalNode Div() { return getToken(miniSysYParser.Div, 0); }
		public TerminalNode Mod() { return getToken(miniSysYParser.Mod, 0); }
		public MulExpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mulExp; }
	}

	public final MulExpContext mulExp() throws RecognitionException {
		return mulExp(0);
	}

	private MulExpContext mulExp(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		MulExpContext _localctx = new MulExpContext(_ctx, _parentState);
		MulExpContext _prevctx = _localctx;
		int _startState = 16;
		enterRecursionRule(_localctx, 16, RULE_mulExp, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(92);
			unaryExp();
			}
			_ctx.stop = _input.LT(-1);
			setState(99);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new MulExpContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_mulExp);
					setState(94);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(95);
					((MulExpContext)_localctx).op = _input.LT(1);
					_la = _input.LA(1);
					if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Star) | (1L << Div) | (1L << Mod))) != 0)) ) {
						((MulExpContext)_localctx).op = (Token)_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(96);
					unaryExp();
					}
					} 
				}
				setState(101);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class UnaryExpContext extends ParserRuleContext {
		public UnaryExpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unaryExp; }
	 
		public UnaryExpContext() { }
		public void copyFrom(UnaryExpContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class PriExpContext extends UnaryExpContext {
		public PrimaryExpContext primaryExp() {
			return getRuleContext(PrimaryExpContext.class,0);
		}
		public PriExpContext(UnaryExpContext ctx) { copyFrom(ctx); }
	}
	public static class FuncExpContext extends UnaryExpContext {
		public TerminalNode Ident() { return getToken(miniSysYParser.Ident, 0); }
		public TerminalNode LParen() { return getToken(miniSysYParser.LParen, 0); }
		public TerminalNode RParen() { return getToken(miniSysYParser.RParen, 0); }
		public FuncRParamsContext funcRParams() {
			return getRuleContext(FuncRParamsContext.class,0);
		}
		public FuncExpContext(UnaryExpContext ctx) { copyFrom(ctx); }
	}
	public static class OpExpContext extends UnaryExpContext {
		public UnaryOpContext unaryOp() {
			return getRuleContext(UnaryOpContext.class,0);
		}
		public UnaryExpContext unaryExp() {
			return getRuleContext(UnaryExpContext.class,0);
		}
		public OpExpContext(UnaryExpContext ctx) { copyFrom(ctx); }
	}

	public final UnaryExpContext unaryExp() throws RecognitionException {
		UnaryExpContext _localctx = new UnaryExpContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_unaryExp);
		int _la;
		try {
			setState(112);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LParen:
			case Decimal_const:
			case Octal_const:
			case Hexadecimal_const:
			case LVal:
				_localctx = new PriExpContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(102);
				primaryExp();
				}
				break;
			case Plus:
			case Minus:
				_localctx = new OpExpContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(103);
				unaryOp();
				setState(104);
				unaryExp();
				}
				break;
			case Ident:
				_localctx = new FuncExpContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(106);
				match(Ident);
				setState(107);
				match(LParen);
				setState(109);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LParen) | (1L << Plus) | (1L << Minus) | (1L << Ident) | (1L << Decimal_const) | (1L << Octal_const) | (1L << Hexadecimal_const) | (1L << LVal))) != 0)) {
					{
					setState(108);
					funcRParams();
					}
				}

				setState(111);
				match(RParen);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PrimaryExpContext extends ParserRuleContext {
		public TerminalNode LParen() { return getToken(miniSysYParser.LParen, 0); }
		public AddExpContext addExp() {
			return getRuleContext(AddExpContext.class,0);
		}
		public TerminalNode RParen() { return getToken(miniSysYParser.RParen, 0); }
		public NumberContext number() {
			return getRuleContext(NumberContext.class,0);
		}
		public TerminalNode LVal() { return getToken(miniSysYParser.LVal, 0); }
		public PrimaryExpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primaryExp; }
	}

	public final PrimaryExpContext primaryExp() throws RecognitionException {
		PrimaryExpContext _localctx = new PrimaryExpContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_primaryExp);
		try {
			setState(120);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LParen:
				enterOuterAlt(_localctx, 1);
				{
				setState(114);
				match(LParen);
				setState(115);
				addExp(0);
				setState(116);
				match(RParen);
				}
				break;
			case Decimal_const:
			case Octal_const:
			case Hexadecimal_const:
				enterOuterAlt(_localctx, 2);
				{
				setState(118);
				number();
				}
				break;
			case LVal:
				enterOuterAlt(_localctx, 3);
				{
				setState(119);
				match(LVal);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class UnaryOpContext extends ParserRuleContext {
		public UnaryOpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unaryOp; }
	 
		public UnaryOpContext() { }
		public void copyFrom(UnaryOpContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class AddContext extends UnaryOpContext {
		public TerminalNode Plus() { return getToken(miniSysYParser.Plus, 0); }
		public AddContext(UnaryOpContext ctx) { copyFrom(ctx); }
	}
	public static class SubContext extends UnaryOpContext {
		public TerminalNode Minus() { return getToken(miniSysYParser.Minus, 0); }
		public SubContext(UnaryOpContext ctx) { copyFrom(ctx); }
	}

	public final UnaryOpContext unaryOp() throws RecognitionException {
		UnaryOpContext _localctx = new UnaryOpContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_unaryOp);
		try {
			setState(124);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Plus:
				_localctx = new AddContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(122);
				match(Plus);
				}
				break;
			case Minus:
				_localctx = new SubContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(123);
				match(Minus);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FuncRParamsContext extends ParserRuleContext {
		public List<ExpContext> exp() {
			return getRuleContexts(ExpContext.class);
		}
		public ExpContext exp(int i) {
			return getRuleContext(ExpContext.class,i);
		}
		public FuncRParamsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funcRParams; }
	}

	public final FuncRParamsContext funcRParams() throws RecognitionException {
		FuncRParamsContext _localctx = new FuncRParamsContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_funcRParams);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(126);
			exp();
			setState(131);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__2) {
				{
				{
				setState(127);
				match(T__2);
				setState(128);
				exp();
				}
				}
				setState(133);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DeclContext extends ParserRuleContext {
		public ConstDeclContext constDecl() {
			return getRuleContext(ConstDeclContext.class,0);
		}
		public VarDeclContext varDecl() {
			return getRuleContext(VarDeclContext.class,0);
		}
		public DeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_decl; }
	}

	public final DeclContext decl() throws RecognitionException {
		DeclContext _localctx = new DeclContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_decl);
		try {
			setState(136);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__3:
				enterOuterAlt(_localctx, 1);
				{
				setState(134);
				constDecl();
				}
				break;
			case Btype:
				enterOuterAlt(_localctx, 2);
				{
				setState(135);
				varDecl();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ConstDeclContext extends ParserRuleContext {
		public TerminalNode Btype() { return getToken(miniSysYParser.Btype, 0); }
		public List<ConstDefContext> constDef() {
			return getRuleContexts(ConstDefContext.class);
		}
		public ConstDefContext constDef(int i) {
			return getRuleContext(ConstDefContext.class,i);
		}
		public TerminalNode Semicolon() { return getToken(miniSysYParser.Semicolon, 0); }
		public ConstDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constDecl; }
	}

	public final ConstDeclContext constDecl() throws RecognitionException {
		ConstDeclContext _localctx = new ConstDeclContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_constDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(138);
			match(T__3);
			setState(139);
			match(Btype);
			setState(140);
			constDef();
			setState(145);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__2) {
				{
				{
				setState(141);
				match(T__2);
				setState(142);
				constDef();
				}
				}
				setState(147);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(148);
			match(Semicolon);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ConstDefContext extends ParserRuleContext {
		public TerminalNode Ident() { return getToken(miniSysYParser.Ident, 0); }
		public ConstInitValContext constInitVal() {
			return getRuleContext(ConstInitValContext.class,0);
		}
		public ConstDefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constDef; }
	}

	public final ConstDefContext constDef() throws RecognitionException {
		ConstDefContext _localctx = new ConstDefContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_constDef);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(150);
			match(Ident);
			setState(151);
			match(T__1);
			setState(152);
			constInitVal();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ConstInitValContext extends ParserRuleContext {
		public ConstExpContext constExp() {
			return getRuleContext(ConstExpContext.class,0);
		}
		public ConstInitValContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constInitVal; }
	}

	public final ConstInitValContext constInitVal() throws RecognitionException {
		ConstInitValContext _localctx = new ConstInitValContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_constInitVal);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(154);
			constExp();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ConstExpContext extends ParserRuleContext {
		public AddExpContext addExp() {
			return getRuleContext(AddExpContext.class,0);
		}
		public ConstExpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constExp; }
	}

	public final ConstExpContext constExp() throws RecognitionException {
		ConstExpContext _localctx = new ConstExpContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_constExp);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(156);
			addExp(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VarDeclContext extends ParserRuleContext {
		public TerminalNode Btype() { return getToken(miniSysYParser.Btype, 0); }
		public List<VarDefContext> varDef() {
			return getRuleContexts(VarDefContext.class);
		}
		public VarDefContext varDef(int i) {
			return getRuleContext(VarDefContext.class,i);
		}
		public TerminalNode Semicolon() { return getToken(miniSysYParser.Semicolon, 0); }
		public VarDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varDecl; }
	}

	public final VarDeclContext varDecl() throws RecognitionException {
		VarDeclContext _localctx = new VarDeclContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_varDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(158);
			match(Btype);
			setState(159);
			varDef();
			setState(164);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__2) {
				{
				{
				setState(160);
				match(T__2);
				setState(161);
				varDef();
				}
				}
				setState(166);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(167);
			match(Semicolon);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VarDefContext extends ParserRuleContext {
		public TerminalNode Ident() { return getToken(miniSysYParser.Ident, 0); }
		public InitValContext initVal() {
			return getRuleContext(InitValContext.class,0);
		}
		public VarDefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varDef; }
	}

	public final VarDefContext varDef() throws RecognitionException {
		VarDefContext _localctx = new VarDefContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_varDef);
		try {
			setState(173);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(169);
				match(Ident);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(170);
				match(Ident);
				setState(171);
				match(T__1);
				setState(172);
				initVal();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BlockItemContext extends ParserRuleContext {
		public DeclContext decl() {
			return getRuleContext(DeclContext.class,0);
		}
		public StmtContext stmt() {
			return getRuleContext(StmtContext.class,0);
		}
		public BlockItemContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_blockItem; }
	}

	public final BlockItemContext blockItem() throws RecognitionException {
		BlockItemContext _localctx = new BlockItemContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_blockItem);
		try {
			setState(177);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__3:
			case Btype:
				enterOuterAlt(_localctx, 1);
				{
				setState(175);
				decl();
				}
				break;
			case LParen:
			case Semicolon:
			case Plus:
			case Minus:
			case RET:
			case Ident:
			case Decimal_const:
			case Octal_const:
			case Hexadecimal_const:
			case LVal:
				enterOuterAlt(_localctx, 2);
				{
				setState(176);
				stmt();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 7:
			return addExp_sempred((AddExpContext)_localctx, predIndex);
		case 8:
			return mulExp_sempred((MulExpContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean addExp_sempred(AddExpContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean mulExp_sempred(MulExpContext _localctx, int predIndex) {
		switch (predIndex) {
		case 1:
			return precpred(_ctx, 1);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\37\u00b6\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3"+
		"\3\3\4\3\4\7\4\67\n\4\f\4\16\4:\13\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\5"+
		"\5D\n\5\3\5\3\5\3\5\3\5\3\5\5\5K\n\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3"+
		"\t\3\t\3\t\3\t\7\tY\n\t\f\t\16\t\\\13\t\3\n\3\n\3\n\3\n\3\n\3\n\7\nd\n"+
		"\n\f\n\16\ng\13\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\5\13p\n\13\3\13\5"+
		"\13s\n\13\3\f\3\f\3\f\3\f\3\f\3\f\5\f{\n\f\3\r\3\r\5\r\177\n\r\3\16\3"+
		"\16\3\16\7\16\u0084\n\16\f\16\16\16\u0087\13\16\3\17\3\17\5\17\u008b\n"+
		"\17\3\20\3\20\3\20\3\20\3\20\7\20\u0092\n\20\f\20\16\20\u0095\13\20\3"+
		"\20\3\20\3\21\3\21\3\21\3\21\3\22\3\22\3\23\3\23\3\24\3\24\3\24\3\24\7"+
		"\24\u00a5\n\24\f\24\16\24\u00a8\13\24\3\24\3\24\3\25\3\25\3\25\3\25\5"+
		"\25\u00b0\n\25\3\26\3\26\5\26\u00b4\n\26\3\26\2\4\20\22\27\2\4\6\b\n\f"+
		"\16\20\22\24\26\30\32\34\36 \"$&(*\2\5\3\2\30\32\3\2\f\r\3\2\16\20\2\u00b2"+
		"\2,\3\2\2\2\4/\3\2\2\2\6\64\3\2\2\2\bJ\3\2\2\2\nL\3\2\2\2\fN\3\2\2\2\16"+
		"P\3\2\2\2\20R\3\2\2\2\22]\3\2\2\2\24r\3\2\2\2\26z\3\2\2\2\30~\3\2\2\2"+
		"\32\u0080\3\2\2\2\34\u008a\3\2\2\2\36\u008c\3\2\2\2 \u0098\3\2\2\2\"\u009c"+
		"\3\2\2\2$\u009e\3\2\2\2&\u00a0\3\2\2\2(\u00af\3\2\2\2*\u00b3\3\2\2\2,"+
		"-\5\4\3\2-.\7\2\2\3.\3\3\2\2\2/\60\7\23\2\2\60\61\7\25\2\2\61\62\7\3\2"+
		"\2\62\63\5\6\4\2\63\5\3\2\2\2\648\7\t\2\2\65\67\5*\26\2\66\65\3\2\2\2"+
		"\67:\3\2\2\28\66\3\2\2\289\3\2\2\29;\3\2\2\2:8\3\2\2\2;<\7\n\2\2<\7\3"+
		"\2\2\2=>\7\33\2\2>?\7\4\2\2?@\5\16\b\2@A\7\13\2\2AK\3\2\2\2BD\5\16\b\2"+
		"CB\3\2\2\2CD\3\2\2\2DE\3\2\2\2EK\7\13\2\2FG\7\22\2\2GH\5\16\b\2HI\7\13"+
		"\2\2IK\3\2\2\2J=\3\2\2\2JC\3\2\2\2JF\3\2\2\2K\t\3\2\2\2LM\t\2\2\2M\13"+
		"\3\2\2\2NO\5\16\b\2O\r\3\2\2\2PQ\5\20\t\2Q\17\3\2\2\2RS\b\t\1\2ST\5\22"+
		"\n\2TZ\3\2\2\2UV\f\3\2\2VW\t\3\2\2WY\5\22\n\2XU\3\2\2\2Y\\\3\2\2\2ZX\3"+
		"\2\2\2Z[\3\2\2\2[\21\3\2\2\2\\Z\3\2\2\2]^\b\n\1\2^_\5\24\13\2_e\3\2\2"+
		"\2`a\f\3\2\2ab\t\4\2\2bd\5\24\13\2c`\3\2\2\2dg\3\2\2\2ec\3\2\2\2ef\3\2"+
		"\2\2f\23\3\2\2\2ge\3\2\2\2hs\5\26\f\2ij\5\30\r\2jk\5\24\13\2ks\3\2\2\2"+
		"lm\7\25\2\2mo\7\7\2\2np\5\32\16\2on\3\2\2\2op\3\2\2\2pq\3\2\2\2qs\7\b"+
		"\2\2rh\3\2\2\2ri\3\2\2\2rl\3\2\2\2s\25\3\2\2\2tu\7\7\2\2uv\5\20\t\2vw"+
		"\7\b\2\2w{\3\2\2\2x{\5\n\6\2y{\7\33\2\2zt\3\2\2\2zx\3\2\2\2zy\3\2\2\2"+
		"{\27\3\2\2\2|\177\7\f\2\2}\177\7\r\2\2~|\3\2\2\2~}\3\2\2\2\177\31\3\2"+
		"\2\2\u0080\u0085\5\16\b\2\u0081\u0082\7\5\2\2\u0082\u0084\5\16\b\2\u0083"+
		"\u0081\3\2\2\2\u0084\u0087\3\2\2\2\u0085\u0083\3\2\2\2\u0085\u0086\3\2"+
		"\2\2\u0086\33\3\2\2\2\u0087\u0085\3\2\2\2\u0088\u008b\5\36\20\2\u0089"+
		"\u008b\5&\24\2\u008a\u0088\3\2\2\2\u008a\u0089\3\2\2\2\u008b\35\3\2\2"+
		"\2\u008c\u008d\7\6\2\2\u008d\u008e\7\24\2\2\u008e\u0093\5 \21\2\u008f"+
		"\u0090\7\5\2\2\u0090\u0092\5 \21\2\u0091\u008f\3\2\2\2\u0092\u0095\3\2"+
		"\2\2\u0093\u0091\3\2\2\2\u0093\u0094\3\2\2\2\u0094\u0096\3\2\2\2\u0095"+
		"\u0093\3\2\2\2\u0096\u0097\7\13\2\2\u0097\37\3\2\2\2\u0098\u0099\7\25"+
		"\2\2\u0099\u009a\7\4\2\2\u009a\u009b\5\"\22\2\u009b!\3\2\2\2\u009c\u009d"+
		"\5$\23\2\u009d#\3\2\2\2\u009e\u009f\5\20\t\2\u009f%\3\2\2\2\u00a0\u00a1"+
		"\7\24\2\2\u00a1\u00a6\5(\25\2\u00a2\u00a3\7\5\2\2\u00a3\u00a5\5(\25\2"+
		"\u00a4\u00a2\3\2\2\2\u00a5\u00a8\3\2\2\2\u00a6\u00a4\3\2\2\2\u00a6\u00a7"+
		"\3\2\2\2\u00a7\u00a9\3\2\2\2\u00a8\u00a6\3\2\2\2\u00a9\u00aa\7\13\2\2"+
		"\u00aa\'\3\2\2\2\u00ab\u00b0\7\25\2\2\u00ac\u00ad\7\25\2\2\u00ad\u00ae"+
		"\7\4\2\2\u00ae\u00b0\5\f\7\2\u00af\u00ab\3\2\2\2\u00af\u00ac\3\2\2\2\u00b0"+
		")\3\2\2\2\u00b1\u00b4\5\34\17\2\u00b2\u00b4\5\b\5\2\u00b3\u00b1\3\2\2"+
		"\2\u00b3\u00b2\3\2\2\2\u00b4+\3\2\2\2\218CJZeorz~\u0085\u008a\u0093\u00a6"+
		"\u00af\u00b3";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}