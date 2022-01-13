// Generated from /Users/zymac/Documents/buaa/大三上/软院大三上学习资料/编译原理/Lab/Lab/src/ANTLR/miniSysY.g4 by ANTLR 4.8
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class miniSysYLexer extends Lexer {
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
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "LParen", "RParen", "LBrace", "RBrace", 
			"Semicolon", "Plus", "Minus", "Star", "Div", "Mod", "Int", "RET", "FuncType", 
			"Btype", "Ident", "Letter", "LetterOrDigit", "Decimal_const", "Octal_const", 
			"Hexadecimal_const", "LVal", "Digits", "Whitespace", "BlockComment", 
			"LineComment"
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


	public miniSysYLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "miniSysY.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\37\u00d7\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\3\2\3\2\3\2\3"+
		"\3\3\3\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t"+
		"\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r\3\16\3\16\3\17\3\17\3\20\3\20\3\20"+
		"\3\20\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\22\3\22\3\23\3\23\3\24\3\24"+
		"\7\24p\n\24\f\24\16\24s\13\24\3\25\3\25\3\25\3\25\5\25y\n\25\3\26\3\26"+
		"\5\26}\n\26\3\27\3\27\3\27\5\27\u0082\n\27\3\27\6\27\u0085\n\27\r\27\16"+
		"\27\u0086\3\27\5\27\u008a\n\27\5\27\u008c\n\27\3\27\5\27\u008f\n\27\3"+
		"\30\3\30\7\30\u0093\n\30\f\30\16\30\u0096\13\30\3\30\3\30\7\30\u009a\n"+
		"\30\f\30\16\30\u009d\13\30\3\30\5\30\u00a0\n\30\3\30\5\30\u00a3\n\30\3"+
		"\31\3\31\3\31\3\31\7\31\u00a9\n\31\f\31\16\31\u00ac\13\31\3\31\5\31\u00af"+
		"\n\31\3\31\5\31\u00b2\n\31\3\32\3\32\3\33\3\33\3\34\6\34\u00b9\n\34\r"+
		"\34\16\34\u00ba\3\34\3\34\3\35\3\35\3\35\3\35\7\35\u00c3\n\35\f\35\16"+
		"\35\u00c6\13\35\3\35\3\35\3\35\3\35\3\35\3\36\3\36\3\36\3\36\7\36\u00d1"+
		"\n\36\f\36\16\36\u00d4\13\36\3\36\3\36\3\u00c4\2\37\3\3\5\4\7\5\t\6\13"+
		"\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'"+
		"\25)\26+\27-\30/\31\61\32\63\33\65\34\67\359\36;\37\3\2\20\6\2&&C\\aa"+
		"c|\4\2\2\u0081\ud802\udc01\3\2\ud802\udc01\3\2\udc02\ue001\3\2\62;\3\2"+
		"\63;\4\2NNnn\3\2\629\4\2\629aa\4\2ZZzz\5\2\62;CHch\6\2\62;CHaach\5\2\13"+
		"\f\16\17\"\"\4\2\f\f\17\17\2\u00e9\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2"+
		"\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3"+
		"\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2"+
		"\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2"+
		"\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2"+
		"\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\3=\3\2\2\2\5@\3\2\2\2\7B\3\2\2"+
		"\2\tD\3\2\2\2\13J\3\2\2\2\rL\3\2\2\2\17N\3\2\2\2\21P\3\2\2\2\23R\3\2\2"+
		"\2\25T\3\2\2\2\27V\3\2\2\2\31X\3\2\2\2\33Z\3\2\2\2\35\\\3\2\2\2\37^\3"+
		"\2\2\2!b\3\2\2\2#i\3\2\2\2%k\3\2\2\2\'m\3\2\2\2)x\3\2\2\2+|\3\2\2\2-\u008b"+
		"\3\2\2\2/\u0090\3\2\2\2\61\u00a4\3\2\2\2\63\u00b3\3\2\2\2\65\u00b5\3\2"+
		"\2\2\67\u00b8\3\2\2\29\u00be\3\2\2\2;\u00cc\3\2\2\2=>\7*\2\2>?\7+\2\2"+
		"?\4\3\2\2\2@A\7?\2\2A\6\3\2\2\2BC\7.\2\2C\b\3\2\2\2DE\7e\2\2EF\7q\2\2"+
		"FG\7p\2\2GH\7u\2\2HI\7v\2\2I\n\3\2\2\2JK\7*\2\2K\f\3\2\2\2LM\7+\2\2M\16"+
		"\3\2\2\2NO\7}\2\2O\20\3\2\2\2PQ\7\177\2\2Q\22\3\2\2\2RS\7=\2\2S\24\3\2"+
		"\2\2TU\7-\2\2U\26\3\2\2\2VW\7/\2\2W\30\3\2\2\2XY\7,\2\2Y\32\3\2\2\2Z["+
		"\7\61\2\2[\34\3\2\2\2\\]\7\'\2\2]\36\3\2\2\2^_\7k\2\2_`\7p\2\2`a\7v\2"+
		"\2a \3\2\2\2bc\7t\2\2cd\7g\2\2de\7v\2\2ef\7w\2\2fg\7t\2\2gh\7p\2\2h\""+
		"\3\2\2\2ij\5\37\20\2j$\3\2\2\2kl\5\37\20\2l&\3\2\2\2mq\5)\25\2np\5+\26"+
		"\2on\3\2\2\2ps\3\2\2\2qo\3\2\2\2qr\3\2\2\2r(\3\2\2\2sq\3\2\2\2ty\t\2\2"+
		"\2uy\n\3\2\2vw\t\4\2\2wy\t\5\2\2xt\3\2\2\2xu\3\2\2\2xv\3\2\2\2y*\3\2\2"+
		"\2z}\5)\25\2{}\t\6\2\2|z\3\2\2\2|{\3\2\2\2},\3\2\2\2~\u008c\7\62\2\2\177"+
		"\u0089\t\7\2\2\u0080\u0082\5\65\33\2\u0081\u0080\3\2\2\2\u0081\u0082\3"+
		"\2\2\2\u0082\u008a\3\2\2\2\u0083\u0085\7a\2\2\u0084\u0083\3\2\2\2\u0085"+
		"\u0086\3\2\2\2\u0086\u0084\3\2\2\2\u0086\u0087\3\2\2\2\u0087\u0088\3\2"+
		"\2\2\u0088\u008a\5\65\33\2\u0089\u0081\3\2\2\2\u0089\u0084\3\2\2\2\u008a"+
		"\u008c\3\2\2\2\u008b~\3\2\2\2\u008b\177\3\2\2\2\u008c\u008e\3\2\2\2\u008d"+
		"\u008f\t\b\2\2\u008e\u008d\3\2\2\2\u008e\u008f\3\2\2\2\u008f.\3\2\2\2"+
		"\u0090\u0094\7\62\2\2\u0091\u0093\7a\2\2\u0092\u0091\3\2\2\2\u0093\u0096"+
		"\3\2\2\2\u0094\u0092\3\2\2\2\u0094\u0095\3\2\2\2\u0095\u0097\3\2\2\2\u0096"+
		"\u0094\3\2\2\2\u0097\u009f\t\t\2\2\u0098\u009a\t\n\2\2\u0099\u0098\3\2"+
		"\2\2\u009a\u009d\3\2\2\2\u009b\u0099\3\2\2\2\u009b\u009c\3\2\2\2\u009c"+
		"\u009e\3\2\2\2\u009d\u009b\3\2\2\2\u009e\u00a0\t\t\2\2\u009f\u009b\3\2"+
		"\2\2\u009f\u00a0\3\2\2\2\u00a0\u00a2\3\2\2\2\u00a1\u00a3\t\b\2\2\u00a2"+
		"\u00a1\3\2\2\2\u00a2\u00a3\3\2\2\2\u00a3\60\3\2\2\2\u00a4\u00a5\7\62\2"+
		"\2\u00a5\u00a6\t\13\2\2\u00a6\u00ae\t\f\2\2\u00a7\u00a9\t\r\2\2\u00a8"+
		"\u00a7\3\2\2\2\u00a9\u00ac\3\2\2\2\u00aa\u00a8\3\2\2\2\u00aa\u00ab\3\2"+
		"\2\2\u00ab\u00ad\3\2\2\2\u00ac\u00aa\3\2\2\2\u00ad\u00af\t\f\2\2\u00ae"+
		"\u00aa\3\2\2\2\u00ae\u00af\3\2\2\2\u00af\u00b1\3\2\2\2\u00b0\u00b2\t\b"+
		"\2\2\u00b1\u00b0\3\2\2\2\u00b1\u00b2\3\2\2\2\u00b2\62\3\2\2\2\u00b3\u00b4"+
		"\5\'\24\2\u00b4\64\3\2\2\2\u00b5\u00b6\t\6\2\2\u00b6\66\3\2\2\2\u00b7"+
		"\u00b9\t\16\2\2\u00b8\u00b7\3\2\2\2\u00b9\u00ba\3\2\2\2\u00ba\u00b8\3"+
		"\2\2\2\u00ba\u00bb\3\2\2\2\u00bb\u00bc\3\2\2\2\u00bc\u00bd\b\34\2\2\u00bd"+
		"8\3\2\2\2\u00be\u00bf\7\61\2\2\u00bf\u00c0\7,\2\2\u00c0\u00c4\3\2\2\2"+
		"\u00c1\u00c3\13\2\2\2\u00c2\u00c1\3\2\2\2\u00c3\u00c6\3\2\2\2\u00c4\u00c5"+
		"\3\2\2\2\u00c4\u00c2\3\2\2\2\u00c5\u00c7\3\2\2\2\u00c6\u00c4\3\2\2\2\u00c7"+
		"\u00c8\7,\2\2\u00c8\u00c9\7\61\2\2\u00c9\u00ca\3\2\2\2\u00ca\u00cb\b\35"+
		"\2\2\u00cb:\3\2\2\2\u00cc\u00cd\7\61\2\2\u00cd\u00ce\7\61\2\2\u00ce\u00d2"+
		"\3\2\2\2\u00cf\u00d1\n\17\2\2\u00d0\u00cf\3\2\2\2\u00d1\u00d4\3\2\2\2"+
		"\u00d2\u00d0\3\2\2\2\u00d2\u00d3\3\2\2\2\u00d3\u00d5\3\2\2\2\u00d4\u00d2"+
		"\3\2\2\2\u00d5\u00d6\b\36\2\2\u00d6<\3\2\2\2\25\2qx|\u0081\u0086\u0089"+
		"\u008b\u008e\u0094\u009b\u009f\u00a2\u00aa\u00ae\u00b1\u00ba\u00c4\u00d2"+
		"\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}