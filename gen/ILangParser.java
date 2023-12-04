// Generated from C:/Users/admin/Desktop/Compiler/src/grammar/ILang.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class ILangParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		VAR=1, TYPE=2, ROUTINE=3, RETURN=4, RECORD=5, END=6, ARRAY=7, WHILE=8, 
		LOOP=9, FOR=10, IN=11, REVERSE=12, IF=13, THEN=14, ELSE=15, IS=16, COLON=17, 
		COMMA=18, ASSIGN=19, DOT=20, DOTDOT=21, LBRACK=22, RBRACK=23, LPAREN=24, 
		RPAREN=25, NOT=26, AND=27, OR=28, XOR=29, LT=30, LEQ=31, GT=32, GEQ=33, 
		EQ=34, NEQ=35, MUL=36, DIV=37, MOD=38, PLUS=39, MINUS=40, INTEGER_KEYWORD=41, 
		REAL_KEYWORD=42, BOOLEAN_KEYWORD=43, TRUE=44, FALSE=45, WRITE=46, WRITES=47, 
		WRITELN=48, INPUT=49, Identifier=50, IntegerLiteral=51, RealLiteral=52, 
		WS=53, COMMENT=54;
	public static final int
		RULE_main = 0, RULE_program = 1, RULE_simpleDeclaration = 2, RULE_variableDeclaration = 3, 
		RULE_typeDeclaration = 4, RULE_type = 5, RULE_primitiveType = 6, RULE_userType = 7, 
		RULE_recordType = 8, RULE_arrayType = 9, RULE_statement = 10, RULE_assignment = 11, 
		RULE_routineCall = 12, RULE_builtInRoutines = 13, RULE_whileLoop = 14, 
		RULE_forLoop = 15, RULE_range = 16, RULE_ifStatement = 17, RULE_routineDeclaration = 18, 
		RULE_parameters = 19, RULE_parameterDeclaration = 20, RULE_body = 21, 
		RULE_returnStatement = 22, RULE_expression = 23, RULE_relation = 24, RULE_simple = 25, 
		RULE_summand = 26, RULE_factor = 27, RULE_primary = 28, RULE_sign = 29, 
		RULE_modifiablePrimary = 30, RULE_writeStatement = 31, RULE_inputStatement = 32;
	private static String[] makeRuleNames() {
		return new String[] {
			"main", "program", "simpleDeclaration", "variableDeclaration", "typeDeclaration", 
			"type", "primitiveType", "userType", "recordType", "arrayType", "statement", 
			"assignment", "routineCall", "builtInRoutines", "whileLoop", "forLoop", 
			"range", "ifStatement", "routineDeclaration", "parameters", "parameterDeclaration", 
			"body", "returnStatement", "expression", "relation", "simple", "summand", 
			"factor", "primary", "sign", "modifiablePrimary", "writeStatement", "inputStatement"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'var'", "'type'", "'routine'", "'return'", "'record'", "'end'", 
			"'array'", "'while'", "'loop'", "'for'", "'in'", "'reverse'", "'if'", 
			"'then'", "'else'", "'is'", "':'", "','", "':='", "'.'", "'..'", "'['", 
			"']'", "'('", "')'", "'not'", "'and'", "'or'", "'xor'", "'<'", "'<='", 
			"'>'", "'>='", "'='", "'/='", "'*'", "'/'", "'%'", "'+'", "'-'", "'integer'", 
			"'real'", "'boolean'", "'true'", "'false'", "'write'", "'writes'", "'writeln'", 
			"'input'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "VAR", "TYPE", "ROUTINE", "RETURN", "RECORD", "END", "ARRAY", "WHILE", 
			"LOOP", "FOR", "IN", "REVERSE", "IF", "THEN", "ELSE", "IS", "COLON", 
			"COMMA", "ASSIGN", "DOT", "DOTDOT", "LBRACK", "RBRACK", "LPAREN", "RPAREN", 
			"NOT", "AND", "OR", "XOR", "LT", "LEQ", "GT", "GEQ", "EQ", "NEQ", "MUL", 
			"DIV", "MOD", "PLUS", "MINUS", "INTEGER_KEYWORD", "REAL_KEYWORD", "BOOLEAN_KEYWORD", 
			"TRUE", "FALSE", "WRITE", "WRITES", "WRITELN", "INPUT", "Identifier", 
			"IntegerLiteral", "RealLiteral", "WS", "COMMENT"
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
	public String getGrammarFileName() { return "ILang.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public ILangParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class MainContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(ILangParser.EOF, 0); }
		public List<ProgramContext> program() {
			return getRuleContexts(ProgramContext.class);
		}
		public ProgramContext program(int i) {
			return getRuleContext(ProgramContext.class,i);
		}
		public MainContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_main; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ILangListener ) ((ILangListener)listener).enterMain(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ILangListener ) ((ILangListener)listener).exitMain(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ILangVisitor ) return ((ILangVisitor<? extends T>)visitor).visitMain(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MainContext main() throws RecognitionException {
		MainContext _localctx = new MainContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_main);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(69);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 2181431069517070L) != 0)) {
				{
				{
				setState(66);
				program();
				}
				}
				setState(71);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(72);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ProgramContext extends ParserRuleContext {
		public SimpleDeclarationContext simpleDeclaration() {
			return getRuleContext(SimpleDeclarationContext.class,0);
		}
		public RoutineDeclarationContext routineDeclaration() {
			return getRuleContext(RoutineDeclarationContext.class,0);
		}
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ILangListener ) ((ILangListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ILangListener ) ((ILangListener)listener).exitProgram(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ILangVisitor ) return ((ILangVisitor<? extends T>)visitor).visitProgram(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_program);
		try {
			setState(77);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case VAR:
			case TYPE:
				enterOuterAlt(_localctx, 1);
				{
				setState(74);
				simpleDeclaration();
				}
				break;
			case ROUTINE:
				enterOuterAlt(_localctx, 2);
				{
				setState(75);
				routineDeclaration();
				}
				break;
			case WHILE:
			case FOR:
			case IF:
			case WRITE:
			case WRITES:
			case WRITELN:
			case INPUT:
			case Identifier:
				enterOuterAlt(_localctx, 3);
				{
				setState(76);
				statement();
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

	@SuppressWarnings("CheckReturnValue")
	public static class SimpleDeclarationContext extends ParserRuleContext {
		public VariableDeclarationContext variableDeclaration() {
			return getRuleContext(VariableDeclarationContext.class,0);
		}
		public TypeDeclarationContext typeDeclaration() {
			return getRuleContext(TypeDeclarationContext.class,0);
		}
		public SimpleDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_simpleDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ILangListener ) ((ILangListener)listener).enterSimpleDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ILangListener ) ((ILangListener)listener).exitSimpleDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ILangVisitor ) return ((ILangVisitor<? extends T>)visitor).visitSimpleDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SimpleDeclarationContext simpleDeclaration() throws RecognitionException {
		SimpleDeclarationContext _localctx = new SimpleDeclarationContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_simpleDeclaration);
		try {
			setState(81);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case VAR:
				enterOuterAlt(_localctx, 1);
				{
				setState(79);
				variableDeclaration();
				}
				break;
			case TYPE:
				enterOuterAlt(_localctx, 2);
				{
				setState(80);
				typeDeclaration();
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

	@SuppressWarnings("CheckReturnValue")
	public static class VariableDeclarationContext extends ParserRuleContext {
		public TerminalNode VAR() { return getToken(ILangParser.VAR, 0); }
		public TerminalNode Identifier() { return getToken(ILangParser.Identifier, 0); }
		public TerminalNode COLON() { return getToken(ILangParser.COLON, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode IS() { return getToken(ILangParser.IS, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public VariableDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variableDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ILangListener ) ((ILangListener)listener).enterVariableDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ILangListener ) ((ILangListener)listener).exitVariableDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ILangVisitor ) return ((ILangVisitor<? extends T>)visitor).visitVariableDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VariableDeclarationContext variableDeclaration() throws RecognitionException {
		VariableDeclarationContext _localctx = new VariableDeclarationContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_variableDeclaration);
		int _la;
		try {
			setState(95);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(83);
				match(VAR);
				setState(84);
				match(Identifier);
				setState(85);
				match(COLON);
				setState(86);
				type();
				setState(89);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==IS) {
					{
					setState(87);
					match(IS);
					setState(88);
					expression();
					}
				}

				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(91);
				match(VAR);
				setState(92);
				match(Identifier);
				setState(93);
				match(IS);
				setState(94);
				expression();
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

	@SuppressWarnings("CheckReturnValue")
	public static class TypeDeclarationContext extends ParserRuleContext {
		public TerminalNode TYPE() { return getToken(ILangParser.TYPE, 0); }
		public TerminalNode Identifier() { return getToken(ILangParser.Identifier, 0); }
		public TerminalNode IS() { return getToken(ILangParser.IS, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TypeDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ILangListener ) ((ILangListener)listener).enterTypeDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ILangListener ) ((ILangListener)listener).exitTypeDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ILangVisitor ) return ((ILangVisitor<? extends T>)visitor).visitTypeDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeDeclarationContext typeDeclaration() throws RecognitionException {
		TypeDeclarationContext _localctx = new TypeDeclarationContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_typeDeclaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(97);
			match(TYPE);
			setState(98);
			match(Identifier);
			setState(99);
			match(IS);
			setState(100);
			type();
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

	@SuppressWarnings("CheckReturnValue")
	public static class TypeContext extends ParserRuleContext {
		public PrimitiveTypeContext primitiveType() {
			return getRuleContext(PrimitiveTypeContext.class,0);
		}
		public UserTypeContext userType() {
			return getRuleContext(UserTypeContext.class,0);
		}
		public TerminalNode Identifier() { return getToken(ILangParser.Identifier, 0); }
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ILangListener ) ((ILangListener)listener).enterType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ILangListener ) ((ILangListener)listener).exitType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ILangVisitor ) return ((ILangVisitor<? extends T>)visitor).visitType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_type);
		try {
			setState(105);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INTEGER_KEYWORD:
			case REAL_KEYWORD:
			case BOOLEAN_KEYWORD:
				enterOuterAlt(_localctx, 1);
				{
				setState(102);
				primitiveType();
				}
				break;
			case RECORD:
			case ARRAY:
				enterOuterAlt(_localctx, 2);
				{
				setState(103);
				userType();
				}
				break;
			case Identifier:
				enterOuterAlt(_localctx, 3);
				{
				setState(104);
				match(Identifier);
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

	@SuppressWarnings("CheckReturnValue")
	public static class PrimitiveTypeContext extends ParserRuleContext {
		public TerminalNode INTEGER_KEYWORD() { return getToken(ILangParser.INTEGER_KEYWORD, 0); }
		public TerminalNode REAL_KEYWORD() { return getToken(ILangParser.REAL_KEYWORD, 0); }
		public TerminalNode BOOLEAN_KEYWORD() { return getToken(ILangParser.BOOLEAN_KEYWORD, 0); }
		public PrimitiveTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primitiveType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ILangListener ) ((ILangListener)listener).enterPrimitiveType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ILangListener ) ((ILangListener)listener).exitPrimitiveType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ILangVisitor ) return ((ILangVisitor<? extends T>)visitor).visitPrimitiveType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrimitiveTypeContext primitiveType() throws RecognitionException {
		PrimitiveTypeContext _localctx = new PrimitiveTypeContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_primitiveType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(107);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 15393162788864L) != 0)) ) {
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

	@SuppressWarnings("CheckReturnValue")
	public static class UserTypeContext extends ParserRuleContext {
		public ArrayTypeContext arrayType() {
			return getRuleContext(ArrayTypeContext.class,0);
		}
		public RecordTypeContext recordType() {
			return getRuleContext(RecordTypeContext.class,0);
		}
		public UserTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_userType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ILangListener ) ((ILangListener)listener).enterUserType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ILangListener ) ((ILangListener)listener).exitUserType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ILangVisitor ) return ((ILangVisitor<? extends T>)visitor).visitUserType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UserTypeContext userType() throws RecognitionException {
		UserTypeContext _localctx = new UserTypeContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_userType);
		try {
			setState(111);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ARRAY:
				enterOuterAlt(_localctx, 1);
				{
				setState(109);
				arrayType();
				}
				break;
			case RECORD:
				enterOuterAlt(_localctx, 2);
				{
				setState(110);
				recordType();
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

	@SuppressWarnings("CheckReturnValue")
	public static class RecordTypeContext extends ParserRuleContext {
		public TerminalNode RECORD() { return getToken(ILangParser.RECORD, 0); }
		public TerminalNode END() { return getToken(ILangParser.END, 0); }
		public List<VariableDeclarationContext> variableDeclaration() {
			return getRuleContexts(VariableDeclarationContext.class);
		}
		public VariableDeclarationContext variableDeclaration(int i) {
			return getRuleContext(VariableDeclarationContext.class,i);
		}
		public RecordTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_recordType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ILangListener ) ((ILangListener)listener).enterRecordType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ILangListener ) ((ILangListener)listener).exitRecordType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ILangVisitor ) return ((ILangVisitor<? extends T>)visitor).visitRecordType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RecordTypeContext recordType() throws RecognitionException {
		RecordTypeContext _localctx = new RecordTypeContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_recordType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(113);
			match(RECORD);
			setState(117);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==VAR) {
				{
				{
				setState(114);
				variableDeclaration();
				}
				}
				setState(119);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(120);
			match(END);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ArrayTypeContext extends ParserRuleContext {
		public TerminalNode ARRAY() { return getToken(ILangParser.ARRAY, 0); }
		public TerminalNode LBRACK() { return getToken(ILangParser.LBRACK, 0); }
		public TerminalNode RBRACK() { return getToken(ILangParser.RBRACK, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ArrayTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arrayType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ILangListener ) ((ILangListener)listener).enterArrayType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ILangListener ) ((ILangListener)listener).exitArrayType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ILangVisitor ) return ((ILangVisitor<? extends T>)visitor).visitArrayType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArrayTypeContext arrayType() throws RecognitionException {
		ArrayTypeContext _localctx = new ArrayTypeContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_arrayType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(122);
			match(ARRAY);
			setState(123);
			match(LBRACK);
			setState(125);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 8991256352915456L) != 0)) {
				{
				setState(124);
				expression();
				}
			}

			setState(127);
			match(RBRACK);
			setState(128);
			type();
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

	@SuppressWarnings("CheckReturnValue")
	public static class StatementContext extends ParserRuleContext {
		public AssignmentContext assignment() {
			return getRuleContext(AssignmentContext.class,0);
		}
		public RoutineCallContext routineCall() {
			return getRuleContext(RoutineCallContext.class,0);
		}
		public WhileLoopContext whileLoop() {
			return getRuleContext(WhileLoopContext.class,0);
		}
		public ForLoopContext forLoop() {
			return getRuleContext(ForLoopContext.class,0);
		}
		public IfStatementContext ifStatement() {
			return getRuleContext(IfStatementContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ILangListener ) ((ILangListener)listener).enterStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ILangListener ) ((ILangListener)listener).exitStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ILangVisitor ) return ((ILangVisitor<? extends T>)visitor).visitStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_statement);
		try {
			setState(135);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(130);
				assignment();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(131);
				routineCall();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(132);
				whileLoop();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(133);
				forLoop();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(134);
				ifStatement();
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

	@SuppressWarnings("CheckReturnValue")
	public static class AssignmentContext extends ParserRuleContext {
		public ModifiablePrimaryContext modifiablePrimary() {
			return getRuleContext(ModifiablePrimaryContext.class,0);
		}
		public TerminalNode ASSIGN() { return getToken(ILangParser.ASSIGN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public AssignmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignment; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ILangListener ) ((ILangListener)listener).enterAssignment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ILangListener ) ((ILangListener)listener).exitAssignment(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ILangVisitor ) return ((ILangVisitor<? extends T>)visitor).visitAssignment(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssignmentContext assignment() throws RecognitionException {
		AssignmentContext _localctx = new AssignmentContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_assignment);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(137);
			modifiablePrimary();
			setState(138);
			match(ASSIGN);
			setState(139);
			expression();
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

	@SuppressWarnings("CheckReturnValue")
	public static class RoutineCallContext extends ParserRuleContext {
		public BuiltInRoutinesContext builtInRoutines() {
			return getRuleContext(BuiltInRoutinesContext.class,0);
		}
		public TerminalNode Identifier() { return getToken(ILangParser.Identifier, 0); }
		public TerminalNode LPAREN() { return getToken(ILangParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(ILangParser.RPAREN, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(ILangParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(ILangParser.COMMA, i);
		}
		public RoutineCallContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_routineCall; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ILangListener ) ((ILangListener)listener).enterRoutineCall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ILangListener ) ((ILangListener)listener).exitRoutineCall(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ILangVisitor ) return ((ILangVisitor<? extends T>)visitor).visitRoutineCall(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RoutineCallContext routineCall() throws RecognitionException {
		RoutineCallContext _localctx = new RoutineCallContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_routineCall);
		int _la;
		try {
			setState(155);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case WRITE:
			case WRITES:
			case WRITELN:
			case INPUT:
				enterOuterAlt(_localctx, 1);
				{
				setState(141);
				builtInRoutines();
				}
				break;
			case Identifier:
				enterOuterAlt(_localctx, 2);
				{
				setState(142);
				match(Identifier);
				setState(143);
				match(LPAREN);
				setState(152);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 8991256352915456L) != 0)) {
					{
					setState(144);
					expression();
					setState(149);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(145);
						match(COMMA);
						setState(146);
						expression();
						}
						}
						setState(151);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(154);
				match(RPAREN);
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

	@SuppressWarnings("CheckReturnValue")
	public static class BuiltInRoutinesContext extends ParserRuleContext {
		public WriteStatementContext writeStatement() {
			return getRuleContext(WriteStatementContext.class,0);
		}
		public InputStatementContext inputStatement() {
			return getRuleContext(InputStatementContext.class,0);
		}
		public BuiltInRoutinesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_builtInRoutines; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ILangListener ) ((ILangListener)listener).enterBuiltInRoutines(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ILangListener ) ((ILangListener)listener).exitBuiltInRoutines(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ILangVisitor ) return ((ILangVisitor<? extends T>)visitor).visitBuiltInRoutines(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BuiltInRoutinesContext builtInRoutines() throws RecognitionException {
		BuiltInRoutinesContext _localctx = new BuiltInRoutinesContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_builtInRoutines);
		try {
			setState(159);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case WRITE:
			case WRITES:
			case WRITELN:
				enterOuterAlt(_localctx, 1);
				{
				setState(157);
				writeStatement();
				}
				break;
			case INPUT:
				enterOuterAlt(_localctx, 2);
				{
				setState(158);
				inputStatement();
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

	@SuppressWarnings("CheckReturnValue")
	public static class WhileLoopContext extends ParserRuleContext {
		public TerminalNode WHILE() { return getToken(ILangParser.WHILE, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode LOOP() { return getToken(ILangParser.LOOP, 0); }
		public BodyContext body() {
			return getRuleContext(BodyContext.class,0);
		}
		public TerminalNode END() { return getToken(ILangParser.END, 0); }
		public WhileLoopContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_whileLoop; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ILangListener ) ((ILangListener)listener).enterWhileLoop(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ILangListener ) ((ILangListener)listener).exitWhileLoop(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ILangVisitor ) return ((ILangVisitor<? extends T>)visitor).visitWhileLoop(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WhileLoopContext whileLoop() throws RecognitionException {
		WhileLoopContext _localctx = new WhileLoopContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_whileLoop);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(161);
			match(WHILE);
			setState(162);
			expression();
			setState(163);
			match(LOOP);
			setState(164);
			body();
			setState(165);
			match(END);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ForLoopContext extends ParserRuleContext {
		public TerminalNode FOR() { return getToken(ILangParser.FOR, 0); }
		public TerminalNode Identifier() { return getToken(ILangParser.Identifier, 0); }
		public TerminalNode IN() { return getToken(ILangParser.IN, 0); }
		public RangeContext range() {
			return getRuleContext(RangeContext.class,0);
		}
		public TerminalNode LOOP() { return getToken(ILangParser.LOOP, 0); }
		public BodyContext body() {
			return getRuleContext(BodyContext.class,0);
		}
		public TerminalNode END() { return getToken(ILangParser.END, 0); }
		public TerminalNode REVERSE() { return getToken(ILangParser.REVERSE, 0); }
		public ForLoopContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forLoop; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ILangListener ) ((ILangListener)listener).enterForLoop(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ILangListener ) ((ILangListener)listener).exitForLoop(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ILangVisitor ) return ((ILangVisitor<? extends T>)visitor).visitForLoop(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ForLoopContext forLoop() throws RecognitionException {
		ForLoopContext _localctx = new ForLoopContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_forLoop);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(167);
			match(FOR);
			setState(168);
			match(Identifier);
			setState(169);
			match(IN);
			setState(171);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==REVERSE) {
				{
				setState(170);
				match(REVERSE);
				}
			}

			setState(173);
			range();
			setState(174);
			match(LOOP);
			setState(175);
			body();
			setState(176);
			match(END);
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

	@SuppressWarnings("CheckReturnValue")
	public static class RangeContext extends ParserRuleContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode DOTDOT() { return getToken(ILangParser.DOTDOT, 0); }
		public RangeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_range; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ILangListener ) ((ILangListener)listener).enterRange(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ILangListener ) ((ILangListener)listener).exitRange(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ILangVisitor ) return ((ILangVisitor<? extends T>)visitor).visitRange(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RangeContext range() throws RecognitionException {
		RangeContext _localctx = new RangeContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_range);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(178);
			expression();
			setState(179);
			match(DOTDOT);
			setState(180);
			expression();
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

	@SuppressWarnings("CheckReturnValue")
	public static class IfStatementContext extends ParserRuleContext {
		public TerminalNode IF() { return getToken(ILangParser.IF, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode THEN() { return getToken(ILangParser.THEN, 0); }
		public List<BodyContext> body() {
			return getRuleContexts(BodyContext.class);
		}
		public BodyContext body(int i) {
			return getRuleContext(BodyContext.class,i);
		}
		public TerminalNode END() { return getToken(ILangParser.END, 0); }
		public TerminalNode ELSE() { return getToken(ILangParser.ELSE, 0); }
		public IfStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ILangListener ) ((ILangListener)listener).enterIfStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ILangListener ) ((ILangListener)listener).exitIfStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ILangVisitor ) return ((ILangVisitor<? extends T>)visitor).visitIfStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IfStatementContext ifStatement() throws RecognitionException {
		IfStatementContext _localctx = new IfStatementContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_ifStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(182);
			match(IF);
			setState(183);
			expression();
			setState(184);
			match(THEN);
			setState(185);
			body();
			setState(188);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ELSE) {
				{
				setState(186);
				match(ELSE);
				setState(187);
				body();
				}
			}

			setState(190);
			match(END);
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

	@SuppressWarnings("CheckReturnValue")
	public static class RoutineDeclarationContext extends ParserRuleContext {
		public TerminalNode ROUTINE() { return getToken(ILangParser.ROUTINE, 0); }
		public TerminalNode Identifier() { return getToken(ILangParser.Identifier, 0); }
		public TerminalNode LPAREN() { return getToken(ILangParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(ILangParser.RPAREN, 0); }
		public TerminalNode IS() { return getToken(ILangParser.IS, 0); }
		public BodyContext body() {
			return getRuleContext(BodyContext.class,0);
		}
		public TerminalNode END() { return getToken(ILangParser.END, 0); }
		public ParametersContext parameters() {
			return getRuleContext(ParametersContext.class,0);
		}
		public TerminalNode COLON() { return getToken(ILangParser.COLON, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public RoutineDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_routineDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ILangListener ) ((ILangListener)listener).enterRoutineDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ILangListener ) ((ILangListener)listener).exitRoutineDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ILangVisitor ) return ((ILangVisitor<? extends T>)visitor).visitRoutineDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RoutineDeclarationContext routineDeclaration() throws RecognitionException {
		RoutineDeclarationContext _localctx = new RoutineDeclarationContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_routineDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(192);
			match(ROUTINE);
			setState(193);
			match(Identifier);
			setState(194);
			match(LPAREN);
			setState(196);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Identifier) {
				{
				setState(195);
				parameters();
				}
			}

			setState(198);
			match(RPAREN);
			setState(201);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COLON) {
				{
				setState(199);
				match(COLON);
				setState(200);
				type();
				}
			}

			setState(203);
			match(IS);
			setState(204);
			body();
			setState(205);
			match(END);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ParametersContext extends ParserRuleContext {
		public List<ParameterDeclarationContext> parameterDeclaration() {
			return getRuleContexts(ParameterDeclarationContext.class);
		}
		public ParameterDeclarationContext parameterDeclaration(int i) {
			return getRuleContext(ParameterDeclarationContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(ILangParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(ILangParser.COMMA, i);
		}
		public ParametersContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameters; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ILangListener ) ((ILangListener)listener).enterParameters(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ILangListener ) ((ILangListener)listener).exitParameters(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ILangVisitor ) return ((ILangVisitor<? extends T>)visitor).visitParameters(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParametersContext parameters() throws RecognitionException {
		ParametersContext _localctx = new ParametersContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_parameters);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(207);
			parameterDeclaration();
			setState(212);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(208);
				match(COMMA);
				setState(209);
				parameterDeclaration();
				}
				}
				setState(214);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ParameterDeclarationContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(ILangParser.Identifier, 0); }
		public TerminalNode COLON() { return getToken(ILangParser.COLON, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public ParameterDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameterDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ILangListener ) ((ILangListener)listener).enterParameterDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ILangListener ) ((ILangListener)listener).exitParameterDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ILangVisitor ) return ((ILangVisitor<? extends T>)visitor).visitParameterDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParameterDeclarationContext parameterDeclaration() throws RecognitionException {
		ParameterDeclarationContext _localctx = new ParameterDeclarationContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_parameterDeclaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(215);
			match(Identifier);
			setState(216);
			match(COLON);
			setState(217);
			type();
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

	@SuppressWarnings("CheckReturnValue")
	public static class BodyContext extends ParserRuleContext {
		public List<SimpleDeclarationContext> simpleDeclaration() {
			return getRuleContexts(SimpleDeclarationContext.class);
		}
		public SimpleDeclarationContext simpleDeclaration(int i) {
			return getRuleContext(SimpleDeclarationContext.class,i);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public List<ReturnStatementContext> returnStatement() {
			return getRuleContexts(ReturnStatementContext.class);
		}
		public ReturnStatementContext returnStatement(int i) {
			return getRuleContext(ReturnStatementContext.class,i);
		}
		public BodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_body; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ILangListener ) ((ILangListener)listener).enterBody(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ILangListener ) ((ILangListener)listener).exitBody(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ILangVisitor ) return ((ILangVisitor<? extends T>)visitor).visitBody(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BodyContext body() throws RecognitionException {
		BodyContext _localctx = new BodyContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_body);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(224);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 2181431069517078L) != 0)) {
				{
				setState(222);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case VAR:
				case TYPE:
					{
					setState(219);
					simpleDeclaration();
					}
					break;
				case WHILE:
				case FOR:
				case IF:
				case WRITE:
				case WRITES:
				case WRITELN:
				case INPUT:
				case Identifier:
					{
					setState(220);
					statement();
					}
					break;
				case RETURN:
					{
					setState(221);
					returnStatement();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(226);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ReturnStatementContext extends ParserRuleContext {
		public TerminalNode RETURN() { return getToken(ILangParser.RETURN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ReturnStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_returnStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ILangListener ) ((ILangListener)listener).enterReturnStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ILangListener ) ((ILangListener)listener).exitReturnStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ILangVisitor ) return ((ILangVisitor<? extends T>)visitor).visitReturnStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ReturnStatementContext returnStatement() throws RecognitionException {
		ReturnStatementContext _localctx = new ReturnStatementContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_returnStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(227);
			match(RETURN);
			setState(229);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,21,_ctx) ) {
			case 1:
				{
				setState(228);
				expression();
				}
				break;
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

	@SuppressWarnings("CheckReturnValue")
	public static class ExpressionContext extends ParserRuleContext {
		public List<RelationContext> relation() {
			return getRuleContexts(RelationContext.class);
		}
		public RelationContext relation(int i) {
			return getRuleContext(RelationContext.class,i);
		}
		public List<TerminalNode> AND() { return getTokens(ILangParser.AND); }
		public TerminalNode AND(int i) {
			return getToken(ILangParser.AND, i);
		}
		public List<TerminalNode> OR() { return getTokens(ILangParser.OR); }
		public TerminalNode OR(int i) {
			return getToken(ILangParser.OR, i);
		}
		public List<TerminalNode> XOR() { return getTokens(ILangParser.XOR); }
		public TerminalNode XOR(int i) {
			return getToken(ILangParser.XOR, i);
		}
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ILangListener ) ((ILangListener)listener).enterExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ILangListener ) ((ILangListener)listener).exitExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ILangVisitor ) return ((ILangVisitor<? extends T>)visitor).visitExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(231);
			relation();
			setState(236);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 939524096L) != 0)) {
				{
				{
				setState(232);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 939524096L) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(233);
				relation();
				}
				}
				setState(238);
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

	@SuppressWarnings("CheckReturnValue")
	public static class RelationContext extends ParserRuleContext {
		public List<SimpleContext> simple() {
			return getRuleContexts(SimpleContext.class);
		}
		public SimpleContext simple(int i) {
			return getRuleContext(SimpleContext.class,i);
		}
		public TerminalNode LT() { return getToken(ILangParser.LT, 0); }
		public TerminalNode LEQ() { return getToken(ILangParser.LEQ, 0); }
		public TerminalNode GT() { return getToken(ILangParser.GT, 0); }
		public TerminalNode GEQ() { return getToken(ILangParser.GEQ, 0); }
		public TerminalNode EQ() { return getToken(ILangParser.EQ, 0); }
		public TerminalNode NEQ() { return getToken(ILangParser.NEQ, 0); }
		public RelationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_relation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ILangListener ) ((ILangListener)listener).enterRelation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ILangListener ) ((ILangListener)listener).exitRelation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ILangVisitor ) return ((ILangVisitor<? extends T>)visitor).visitRelation(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RelationContext relation() throws RecognitionException {
		RelationContext _localctx = new RelationContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_relation);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(239);
			simple();
			setState(242);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 67645734912L) != 0)) {
				{
				setState(240);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 67645734912L) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(241);
				simple();
				}
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

	@SuppressWarnings("CheckReturnValue")
	public static class SimpleContext extends ParserRuleContext {
		public List<SummandContext> summand() {
			return getRuleContexts(SummandContext.class);
		}
		public SummandContext summand(int i) {
			return getRuleContext(SummandContext.class,i);
		}
		public List<TerminalNode> PLUS() { return getTokens(ILangParser.PLUS); }
		public TerminalNode PLUS(int i) {
			return getToken(ILangParser.PLUS, i);
		}
		public List<TerminalNode> MINUS() { return getTokens(ILangParser.MINUS); }
		public TerminalNode MINUS(int i) {
			return getToken(ILangParser.MINUS, i);
		}
		public SimpleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_simple; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ILangListener ) ((ILangListener)listener).enterSimple(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ILangListener ) ((ILangListener)listener).exitSimple(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ILangVisitor ) return ((ILangVisitor<? extends T>)visitor).visitSimple(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SimpleContext simple() throws RecognitionException {
		SimpleContext _localctx = new SimpleContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_simple);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(244);
			summand();
			setState(249);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==PLUS || _la==MINUS) {
				{
				{
				setState(245);
				_la = _input.LA(1);
				if ( !(_la==PLUS || _la==MINUS) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(246);
				summand();
				}
				}
				setState(251);
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

	@SuppressWarnings("CheckReturnValue")
	public static class SummandContext extends ParserRuleContext {
		public List<FactorContext> factor() {
			return getRuleContexts(FactorContext.class);
		}
		public FactorContext factor(int i) {
			return getRuleContext(FactorContext.class,i);
		}
		public List<TerminalNode> MUL() { return getTokens(ILangParser.MUL); }
		public TerminalNode MUL(int i) {
			return getToken(ILangParser.MUL, i);
		}
		public List<TerminalNode> DIV() { return getTokens(ILangParser.DIV); }
		public TerminalNode DIV(int i) {
			return getToken(ILangParser.DIV, i);
		}
		public List<TerminalNode> MOD() { return getTokens(ILangParser.MOD); }
		public TerminalNode MOD(int i) {
			return getToken(ILangParser.MOD, i);
		}
		public SummandContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_summand; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ILangListener ) ((ILangListener)listener).enterSummand(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ILangListener ) ((ILangListener)listener).exitSummand(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ILangVisitor ) return ((ILangVisitor<? extends T>)visitor).visitSummand(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SummandContext summand() throws RecognitionException {
		SummandContext _localctx = new SummandContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_summand);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(252);
			factor();
			setState(257);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 481036337152L) != 0)) {
				{
				{
				setState(253);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 481036337152L) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(254);
				factor();
				}
				}
				setState(259);
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

	@SuppressWarnings("CheckReturnValue")
	public static class FactorContext extends ParserRuleContext {
		public PrimaryContext primary() {
			return getRuleContext(PrimaryContext.class,0);
		}
		public TerminalNode LPAREN() { return getToken(ILangParser.LPAREN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(ILangParser.RPAREN, 0); }
		public FactorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_factor; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ILangListener ) ((ILangListener)listener).enterFactor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ILangListener ) ((ILangListener)listener).exitFactor(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ILangVisitor ) return ((ILangVisitor<? extends T>)visitor).visitFactor(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FactorContext factor() throws RecognitionException {
		FactorContext _localctx = new FactorContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_factor);
		try {
			setState(265);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case PLUS:
			case MINUS:
			case TRUE:
			case FALSE:
			case WRITE:
			case WRITES:
			case WRITELN:
			case INPUT:
			case Identifier:
			case IntegerLiteral:
			case RealLiteral:
				enterOuterAlt(_localctx, 1);
				{
				setState(260);
				primary();
				}
				break;
			case LPAREN:
				enterOuterAlt(_localctx, 2);
				{
				setState(261);
				match(LPAREN);
				setState(262);
				expression();
				setState(263);
				match(RPAREN);
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

	@SuppressWarnings("CheckReturnValue")
	public static class PrimaryContext extends ParserRuleContext {
		public TerminalNode IntegerLiteral() { return getToken(ILangParser.IntegerLiteral, 0); }
		public SignContext sign() {
			return getRuleContext(SignContext.class,0);
		}
		public TerminalNode RealLiteral() { return getToken(ILangParser.RealLiteral, 0); }
		public TerminalNode TRUE() { return getToken(ILangParser.TRUE, 0); }
		public TerminalNode FALSE() { return getToken(ILangParser.FALSE, 0); }
		public ModifiablePrimaryContext modifiablePrimary() {
			return getRuleContext(ModifiablePrimaryContext.class,0);
		}
		public RoutineCallContext routineCall() {
			return getRuleContext(RoutineCallContext.class,0);
		}
		public PrimaryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primary; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ILangListener ) ((ILangListener)listener).enterPrimary(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ILangListener ) ((ILangListener)listener).exitPrimary(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ILangVisitor ) return ((ILangVisitor<? extends T>)visitor).visitPrimary(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrimaryContext primary() throws RecognitionException {
		PrimaryContext _localctx = new PrimaryContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_primary);
		int _la;
		try {
			setState(279);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,29,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(268);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==PLUS || _la==MINUS) {
					{
					setState(267);
					sign();
					}
				}

				setState(270);
				match(IntegerLiteral);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(272);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==PLUS || _la==MINUS) {
					{
					setState(271);
					sign();
					}
				}

				setState(274);
				match(RealLiteral);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(275);
				match(TRUE);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(276);
				match(FALSE);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(277);
				modifiablePrimary();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(278);
				routineCall();
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

	@SuppressWarnings("CheckReturnValue")
	public static class SignContext extends ParserRuleContext {
		public TerminalNode PLUS() { return getToken(ILangParser.PLUS, 0); }
		public TerminalNode MINUS() { return getToken(ILangParser.MINUS, 0); }
		public SignContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sign; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ILangListener ) ((ILangListener)listener).enterSign(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ILangListener ) ((ILangListener)listener).exitSign(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ILangVisitor ) return ((ILangVisitor<? extends T>)visitor).visitSign(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SignContext sign() throws RecognitionException {
		SignContext _localctx = new SignContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_sign);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(281);
			_la = _input.LA(1);
			if ( !(_la==PLUS || _la==MINUS) ) {
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

	@SuppressWarnings("CheckReturnValue")
	public static class ModifiablePrimaryContext extends ParserRuleContext {
		public List<TerminalNode> Identifier() { return getTokens(ILangParser.Identifier); }
		public TerminalNode Identifier(int i) {
			return getToken(ILangParser.Identifier, i);
		}
		public List<TerminalNode> DOT() { return getTokens(ILangParser.DOT); }
		public TerminalNode DOT(int i) {
			return getToken(ILangParser.DOT, i);
		}
		public List<TerminalNode> LBRACK() { return getTokens(ILangParser.LBRACK); }
		public TerminalNode LBRACK(int i) {
			return getToken(ILangParser.LBRACK, i);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> RBRACK() { return getTokens(ILangParser.RBRACK); }
		public TerminalNode RBRACK(int i) {
			return getToken(ILangParser.RBRACK, i);
		}
		public ModifiablePrimaryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_modifiablePrimary; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ILangListener ) ((ILangListener)listener).enterModifiablePrimary(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ILangListener ) ((ILangListener)listener).exitModifiablePrimary(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ILangVisitor ) return ((ILangVisitor<? extends T>)visitor).visitModifiablePrimary(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ModifiablePrimaryContext modifiablePrimary() throws RecognitionException {
		ModifiablePrimaryContext _localctx = new ModifiablePrimaryContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_modifiablePrimary);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(283);
			match(Identifier);
			setState(292);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==DOT || _la==LBRACK) {
				{
				setState(290);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case DOT:
					{
					setState(284);
					match(DOT);
					setState(285);
					match(Identifier);
					}
					break;
				case LBRACK:
					{
					setState(286);
					match(LBRACK);
					setState(287);
					expression();
					setState(288);
					match(RBRACK);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(294);
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

	@SuppressWarnings("CheckReturnValue")
	public static class WriteStatementContext extends ParserRuleContext {
		public TerminalNode WRITE() { return getToken(ILangParser.WRITE, 0); }
		public TerminalNode LPAREN() { return getToken(ILangParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(ILangParser.RPAREN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode WRITES() { return getToken(ILangParser.WRITES, 0); }
		public TerminalNode WRITELN() { return getToken(ILangParser.WRITELN, 0); }
		public WriteStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_writeStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ILangListener ) ((ILangListener)listener).enterWriteStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ILangListener ) ((ILangListener)listener).exitWriteStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ILangVisitor ) return ((ILangVisitor<? extends T>)visitor).visitWriteStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WriteStatementContext writeStatement() throws RecognitionException {
		WriteStatementContext _localctx = new WriteStatementContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_writeStatement);
		int _la;
		try {
			setState(313);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case WRITE:
				enterOuterAlt(_localctx, 1);
				{
				setState(295);
				match(WRITE);
				setState(296);
				match(LPAREN);
				setState(298);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 8991256352915456L) != 0)) {
					{
					setState(297);
					expression();
					}
				}

				setState(300);
				match(RPAREN);
				}
				break;
			case WRITES:
				enterOuterAlt(_localctx, 2);
				{
				setState(301);
				match(WRITES);
				setState(302);
				match(LPAREN);
				setState(304);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 8991256352915456L) != 0)) {
					{
					setState(303);
					expression();
					}
				}

				setState(306);
				match(RPAREN);
				}
				break;
			case WRITELN:
				enterOuterAlt(_localctx, 3);
				{
				setState(307);
				match(WRITELN);
				setState(308);
				match(LPAREN);
				setState(310);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 8991256352915456L) != 0)) {
					{
					setState(309);
					expression();
					}
				}

				setState(312);
				match(RPAREN);
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

	@SuppressWarnings("CheckReturnValue")
	public static class InputStatementContext extends ParserRuleContext {
		public TerminalNode INPUT() { return getToken(ILangParser.INPUT, 0); }
		public TerminalNode LPAREN() { return getToken(ILangParser.LPAREN, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(ILangParser.RPAREN, 0); }
		public InputStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_inputStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ILangListener ) ((ILangListener)listener).enterInputStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ILangListener ) ((ILangListener)listener).exitInputStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ILangVisitor ) return ((ILangVisitor<? extends T>)visitor).visitInputStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InputStatementContext inputStatement() throws RecognitionException {
		InputStatementContext _localctx = new InputStatementContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_inputStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(315);
			match(INPUT);
			setState(316);
			match(LPAREN);
			setState(317);
			type();
			setState(318);
			match(RPAREN);
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

	public static final String _serializedATN =
		"\u0004\u00016\u0141\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"+
		"\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007\u0015"+
		"\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002\u0018\u0007\u0018"+
		"\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a\u0002\u001b\u0007\u001b"+
		"\u0002\u001c\u0007\u001c\u0002\u001d\u0007\u001d\u0002\u001e\u0007\u001e"+
		"\u0002\u001f\u0007\u001f\u0002 \u0007 \u0001\u0000\u0005\u0000D\b\u0000"+
		"\n\u0000\f\u0000G\t\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0003\u0001N\b\u0001\u0001\u0002\u0001\u0002\u0003\u0002"+
		"R\b\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0003\u0003Z\b\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0003\u0003`\b\u0003\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0003\u0005"+
		"j\b\u0005\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0003\u0007"+
		"p\b\u0007\u0001\b\u0001\b\u0005\bt\b\b\n\b\f\bw\t\b\u0001\b\u0001\b\u0001"+
		"\t\u0001\t\u0001\t\u0003\t~\b\t\u0001\t\u0001\t\u0001\t\u0001\n\u0001"+
		"\n\u0001\n\u0001\n\u0001\n\u0003\n\u0088\b\n\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0005"+
		"\f\u0094\b\f\n\f\f\f\u0097\t\f\u0003\f\u0099\b\f\u0001\f\u0003\f\u009c"+
		"\b\f\u0001\r\u0001\r\u0003\r\u00a0\b\r\u0001\u000e\u0001\u000e\u0001\u000e"+
		"\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000f\u0001\u000f\u0001\u000f"+
		"\u0001\u000f\u0003\u000f\u00ac\b\u000f\u0001\u000f\u0001\u000f\u0001\u000f"+
		"\u0001\u000f\u0001\u000f\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010"+
		"\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011"+
		"\u0003\u0011\u00bd\b\u0011\u0001\u0011\u0001\u0011\u0001\u0012\u0001\u0012"+
		"\u0001\u0012\u0001\u0012\u0003\u0012\u00c5\b\u0012\u0001\u0012\u0001\u0012"+
		"\u0001\u0012\u0003\u0012\u00ca\b\u0012\u0001\u0012\u0001\u0012\u0001\u0012"+
		"\u0001\u0012\u0001\u0013\u0001\u0013\u0001\u0013\u0005\u0013\u00d3\b\u0013"+
		"\n\u0013\f\u0013\u00d6\t\u0013\u0001\u0014\u0001\u0014\u0001\u0014\u0001"+
		"\u0014\u0001\u0015\u0001\u0015\u0001\u0015\u0005\u0015\u00df\b\u0015\n"+
		"\u0015\f\u0015\u00e2\t\u0015\u0001\u0016\u0001\u0016\u0003\u0016\u00e6"+
		"\b\u0016\u0001\u0017\u0001\u0017\u0001\u0017\u0005\u0017\u00eb\b\u0017"+
		"\n\u0017\f\u0017\u00ee\t\u0017\u0001\u0018\u0001\u0018\u0001\u0018\u0003"+
		"\u0018\u00f3\b\u0018\u0001\u0019\u0001\u0019\u0001\u0019\u0005\u0019\u00f8"+
		"\b\u0019\n\u0019\f\u0019\u00fb\t\u0019\u0001\u001a\u0001\u001a\u0001\u001a"+
		"\u0005\u001a\u0100\b\u001a\n\u001a\f\u001a\u0103\t\u001a\u0001\u001b\u0001"+
		"\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0003\u001b\u010a\b\u001b\u0001"+
		"\u001c\u0003\u001c\u010d\b\u001c\u0001\u001c\u0001\u001c\u0003\u001c\u0111"+
		"\b\u001c\u0001\u001c\u0001\u001c\u0001\u001c\u0001\u001c\u0001\u001c\u0003"+
		"\u001c\u0118\b\u001c\u0001\u001d\u0001\u001d\u0001\u001e\u0001\u001e\u0001"+
		"\u001e\u0001\u001e\u0001\u001e\u0001\u001e\u0001\u001e\u0005\u001e\u0123"+
		"\b\u001e\n\u001e\f\u001e\u0126\t\u001e\u0001\u001f\u0001\u001f\u0001\u001f"+
		"\u0003\u001f\u012b\b\u001f\u0001\u001f\u0001\u001f\u0001\u001f\u0001\u001f"+
		"\u0003\u001f\u0131\b\u001f\u0001\u001f\u0001\u001f\u0001\u001f\u0001\u001f"+
		"\u0003\u001f\u0137\b\u001f\u0001\u001f\u0003\u001f\u013a\b\u001f\u0001"+
		" \u0001 \u0001 \u0001 \u0001 \u0001 \u0000\u0000!\u0000\u0002\u0004\u0006"+
		"\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a\u001c\u001e \"$&(*,."+
		"02468:<>@\u0000\u0005\u0001\u0000)+\u0001\u0000\u001b\u001d\u0001\u0000"+
		"\u001e#\u0001\u0000\'(\u0001\u0000$&\u014e\u0000E\u0001\u0000\u0000\u0000"+
		"\u0002M\u0001\u0000\u0000\u0000\u0004Q\u0001\u0000\u0000\u0000\u0006_"+
		"\u0001\u0000\u0000\u0000\ba\u0001\u0000\u0000\u0000\ni\u0001\u0000\u0000"+
		"\u0000\fk\u0001\u0000\u0000\u0000\u000eo\u0001\u0000\u0000\u0000\u0010"+
		"q\u0001\u0000\u0000\u0000\u0012z\u0001\u0000\u0000\u0000\u0014\u0087\u0001"+
		"\u0000\u0000\u0000\u0016\u0089\u0001\u0000\u0000\u0000\u0018\u009b\u0001"+
		"\u0000\u0000\u0000\u001a\u009f\u0001\u0000\u0000\u0000\u001c\u00a1\u0001"+
		"\u0000\u0000\u0000\u001e\u00a7\u0001\u0000\u0000\u0000 \u00b2\u0001\u0000"+
		"\u0000\u0000\"\u00b6\u0001\u0000\u0000\u0000$\u00c0\u0001\u0000\u0000"+
		"\u0000&\u00cf\u0001\u0000\u0000\u0000(\u00d7\u0001\u0000\u0000\u0000*"+
		"\u00e0\u0001\u0000\u0000\u0000,\u00e3\u0001\u0000\u0000\u0000.\u00e7\u0001"+
		"\u0000\u0000\u00000\u00ef\u0001\u0000\u0000\u00002\u00f4\u0001\u0000\u0000"+
		"\u00004\u00fc\u0001\u0000\u0000\u00006\u0109\u0001\u0000\u0000\u00008"+
		"\u0117\u0001\u0000\u0000\u0000:\u0119\u0001\u0000\u0000\u0000<\u011b\u0001"+
		"\u0000\u0000\u0000>\u0139\u0001\u0000\u0000\u0000@\u013b\u0001\u0000\u0000"+
		"\u0000BD\u0003\u0002\u0001\u0000CB\u0001\u0000\u0000\u0000DG\u0001\u0000"+
		"\u0000\u0000EC\u0001\u0000\u0000\u0000EF\u0001\u0000\u0000\u0000FH\u0001"+
		"\u0000\u0000\u0000GE\u0001\u0000\u0000\u0000HI\u0005\u0000\u0000\u0001"+
		"I\u0001\u0001\u0000\u0000\u0000JN\u0003\u0004\u0002\u0000KN\u0003$\u0012"+
		"\u0000LN\u0003\u0014\n\u0000MJ\u0001\u0000\u0000\u0000MK\u0001\u0000\u0000"+
		"\u0000ML\u0001\u0000\u0000\u0000N\u0003\u0001\u0000\u0000\u0000OR\u0003"+
		"\u0006\u0003\u0000PR\u0003\b\u0004\u0000QO\u0001\u0000\u0000\u0000QP\u0001"+
		"\u0000\u0000\u0000R\u0005\u0001\u0000\u0000\u0000ST\u0005\u0001\u0000"+
		"\u0000TU\u00052\u0000\u0000UV\u0005\u0011\u0000\u0000VY\u0003\n\u0005"+
		"\u0000WX\u0005\u0010\u0000\u0000XZ\u0003.\u0017\u0000YW\u0001\u0000\u0000"+
		"\u0000YZ\u0001\u0000\u0000\u0000Z`\u0001\u0000\u0000\u0000[\\\u0005\u0001"+
		"\u0000\u0000\\]\u00052\u0000\u0000]^\u0005\u0010\u0000\u0000^`\u0003."+
		"\u0017\u0000_S\u0001\u0000\u0000\u0000_[\u0001\u0000\u0000\u0000`\u0007"+
		"\u0001\u0000\u0000\u0000ab\u0005\u0002\u0000\u0000bc\u00052\u0000\u0000"+
		"cd\u0005\u0010\u0000\u0000de\u0003\n\u0005\u0000e\t\u0001\u0000\u0000"+
		"\u0000fj\u0003\f\u0006\u0000gj\u0003\u000e\u0007\u0000hj\u00052\u0000"+
		"\u0000if\u0001\u0000\u0000\u0000ig\u0001\u0000\u0000\u0000ih\u0001\u0000"+
		"\u0000\u0000j\u000b\u0001\u0000\u0000\u0000kl\u0007\u0000\u0000\u0000"+
		"l\r\u0001\u0000\u0000\u0000mp\u0003\u0012\t\u0000np\u0003\u0010\b\u0000"+
		"om\u0001\u0000\u0000\u0000on\u0001\u0000\u0000\u0000p\u000f\u0001\u0000"+
		"\u0000\u0000qu\u0005\u0005\u0000\u0000rt\u0003\u0006\u0003\u0000sr\u0001"+
		"\u0000\u0000\u0000tw\u0001\u0000\u0000\u0000us\u0001\u0000\u0000\u0000"+
		"uv\u0001\u0000\u0000\u0000vx\u0001\u0000\u0000\u0000wu\u0001\u0000\u0000"+
		"\u0000xy\u0005\u0006\u0000\u0000y\u0011\u0001\u0000\u0000\u0000z{\u0005"+
		"\u0007\u0000\u0000{}\u0005\u0016\u0000\u0000|~\u0003.\u0017\u0000}|\u0001"+
		"\u0000\u0000\u0000}~\u0001\u0000\u0000\u0000~\u007f\u0001\u0000\u0000"+
		"\u0000\u007f\u0080\u0005\u0017\u0000\u0000\u0080\u0081\u0003\n\u0005\u0000"+
		"\u0081\u0013\u0001\u0000\u0000\u0000\u0082\u0088\u0003\u0016\u000b\u0000"+
		"\u0083\u0088\u0003\u0018\f\u0000\u0084\u0088\u0003\u001c\u000e\u0000\u0085"+
		"\u0088\u0003\u001e\u000f\u0000\u0086\u0088\u0003\"\u0011\u0000\u0087\u0082"+
		"\u0001\u0000\u0000\u0000\u0087\u0083\u0001\u0000\u0000\u0000\u0087\u0084"+
		"\u0001\u0000\u0000\u0000\u0087\u0085\u0001\u0000\u0000\u0000\u0087\u0086"+
		"\u0001\u0000\u0000\u0000\u0088\u0015\u0001\u0000\u0000\u0000\u0089\u008a"+
		"\u0003<\u001e\u0000\u008a\u008b\u0005\u0013\u0000\u0000\u008b\u008c\u0003"+
		".\u0017\u0000\u008c\u0017\u0001\u0000\u0000\u0000\u008d\u009c\u0003\u001a"+
		"\r\u0000\u008e\u008f\u00052\u0000\u0000\u008f\u0098\u0005\u0018\u0000"+
		"\u0000\u0090\u0095\u0003.\u0017\u0000\u0091\u0092\u0005\u0012\u0000\u0000"+
		"\u0092\u0094\u0003.\u0017\u0000\u0093\u0091\u0001\u0000\u0000\u0000\u0094"+
		"\u0097\u0001\u0000\u0000\u0000\u0095\u0093\u0001\u0000\u0000\u0000\u0095"+
		"\u0096\u0001\u0000\u0000\u0000\u0096\u0099\u0001\u0000\u0000\u0000\u0097"+
		"\u0095\u0001\u0000\u0000\u0000\u0098\u0090\u0001\u0000\u0000\u0000\u0098"+
		"\u0099\u0001\u0000\u0000\u0000\u0099\u009a\u0001\u0000\u0000\u0000\u009a"+
		"\u009c\u0005\u0019\u0000\u0000\u009b\u008d\u0001\u0000\u0000\u0000\u009b"+
		"\u008e\u0001\u0000\u0000\u0000\u009c\u0019\u0001\u0000\u0000\u0000\u009d"+
		"\u00a0\u0003>\u001f\u0000\u009e\u00a0\u0003@ \u0000\u009f\u009d\u0001"+
		"\u0000\u0000\u0000\u009f\u009e\u0001\u0000\u0000\u0000\u00a0\u001b\u0001"+
		"\u0000\u0000\u0000\u00a1\u00a2\u0005\b\u0000\u0000\u00a2\u00a3\u0003."+
		"\u0017\u0000\u00a3\u00a4\u0005\t\u0000\u0000\u00a4\u00a5\u0003*\u0015"+
		"\u0000\u00a5\u00a6\u0005\u0006\u0000\u0000\u00a6\u001d\u0001\u0000\u0000"+
		"\u0000\u00a7\u00a8\u0005\n\u0000\u0000\u00a8\u00a9\u00052\u0000\u0000"+
		"\u00a9\u00ab\u0005\u000b\u0000\u0000\u00aa\u00ac\u0005\f\u0000\u0000\u00ab"+
		"\u00aa\u0001\u0000\u0000\u0000\u00ab\u00ac\u0001\u0000\u0000\u0000\u00ac"+
		"\u00ad\u0001\u0000\u0000\u0000\u00ad\u00ae\u0003 \u0010\u0000\u00ae\u00af"+
		"\u0005\t\u0000\u0000\u00af\u00b0\u0003*\u0015\u0000\u00b0\u00b1\u0005"+
		"\u0006\u0000\u0000\u00b1\u001f\u0001\u0000\u0000\u0000\u00b2\u00b3\u0003"+
		".\u0017\u0000\u00b3\u00b4\u0005\u0015\u0000\u0000\u00b4\u00b5\u0003.\u0017"+
		"\u0000\u00b5!\u0001\u0000\u0000\u0000\u00b6\u00b7\u0005\r\u0000\u0000"+
		"\u00b7\u00b8\u0003.\u0017\u0000\u00b8\u00b9\u0005\u000e\u0000\u0000\u00b9"+
		"\u00bc\u0003*\u0015\u0000\u00ba\u00bb\u0005\u000f\u0000\u0000\u00bb\u00bd"+
		"\u0003*\u0015\u0000\u00bc\u00ba\u0001\u0000\u0000\u0000\u00bc\u00bd\u0001"+
		"\u0000\u0000\u0000\u00bd\u00be\u0001\u0000\u0000\u0000\u00be\u00bf\u0005"+
		"\u0006\u0000\u0000\u00bf#\u0001\u0000\u0000\u0000\u00c0\u00c1\u0005\u0003"+
		"\u0000\u0000\u00c1\u00c2\u00052\u0000\u0000\u00c2\u00c4\u0005\u0018\u0000"+
		"\u0000\u00c3\u00c5\u0003&\u0013\u0000\u00c4\u00c3\u0001\u0000\u0000\u0000"+
		"\u00c4\u00c5\u0001\u0000\u0000\u0000\u00c5\u00c6\u0001\u0000\u0000\u0000"+
		"\u00c6\u00c9\u0005\u0019\u0000\u0000\u00c7\u00c8\u0005\u0011\u0000\u0000"+
		"\u00c8\u00ca\u0003\n\u0005\u0000\u00c9\u00c7\u0001\u0000\u0000\u0000\u00c9"+
		"\u00ca\u0001\u0000\u0000\u0000\u00ca\u00cb\u0001\u0000\u0000\u0000\u00cb"+
		"\u00cc\u0005\u0010\u0000\u0000\u00cc\u00cd\u0003*\u0015\u0000\u00cd\u00ce"+
		"\u0005\u0006\u0000\u0000\u00ce%\u0001\u0000\u0000\u0000\u00cf\u00d4\u0003"+
		"(\u0014\u0000\u00d0\u00d1\u0005\u0012\u0000\u0000\u00d1\u00d3\u0003(\u0014"+
		"\u0000\u00d2\u00d0\u0001\u0000\u0000\u0000\u00d3\u00d6\u0001\u0000\u0000"+
		"\u0000\u00d4\u00d2\u0001\u0000\u0000\u0000\u00d4\u00d5\u0001\u0000\u0000"+
		"\u0000\u00d5\'\u0001\u0000\u0000\u0000\u00d6\u00d4\u0001\u0000\u0000\u0000"+
		"\u00d7\u00d8\u00052\u0000\u0000\u00d8\u00d9\u0005\u0011\u0000\u0000\u00d9"+
		"\u00da\u0003\n\u0005\u0000\u00da)\u0001\u0000\u0000\u0000\u00db\u00df"+
		"\u0003\u0004\u0002\u0000\u00dc\u00df\u0003\u0014\n\u0000\u00dd\u00df\u0003"+
		",\u0016\u0000\u00de\u00db\u0001\u0000\u0000\u0000\u00de\u00dc\u0001\u0000"+
		"\u0000\u0000\u00de\u00dd\u0001\u0000\u0000\u0000\u00df\u00e2\u0001\u0000"+
		"\u0000\u0000\u00e0\u00de\u0001\u0000\u0000\u0000\u00e0\u00e1\u0001\u0000"+
		"\u0000\u0000\u00e1+\u0001\u0000\u0000\u0000\u00e2\u00e0\u0001\u0000\u0000"+
		"\u0000\u00e3\u00e5\u0005\u0004\u0000\u0000\u00e4\u00e6\u0003.\u0017\u0000"+
		"\u00e5\u00e4\u0001\u0000\u0000\u0000\u00e5\u00e6\u0001\u0000\u0000\u0000"+
		"\u00e6-\u0001\u0000\u0000\u0000\u00e7\u00ec\u00030\u0018\u0000\u00e8\u00e9"+
		"\u0007\u0001\u0000\u0000\u00e9\u00eb\u00030\u0018\u0000\u00ea\u00e8\u0001"+
		"\u0000\u0000\u0000\u00eb\u00ee\u0001\u0000\u0000\u0000\u00ec\u00ea\u0001"+
		"\u0000\u0000\u0000\u00ec\u00ed\u0001\u0000\u0000\u0000\u00ed/\u0001\u0000"+
		"\u0000\u0000\u00ee\u00ec\u0001\u0000\u0000\u0000\u00ef\u00f2\u00032\u0019"+
		"\u0000\u00f0\u00f1\u0007\u0002\u0000\u0000\u00f1\u00f3\u00032\u0019\u0000"+
		"\u00f2\u00f0\u0001\u0000\u0000\u0000\u00f2\u00f3\u0001\u0000\u0000\u0000"+
		"\u00f31\u0001\u0000\u0000\u0000\u00f4\u00f9\u00034\u001a\u0000\u00f5\u00f6"+
		"\u0007\u0003\u0000\u0000\u00f6\u00f8\u00034\u001a\u0000\u00f7\u00f5\u0001"+
		"\u0000\u0000\u0000\u00f8\u00fb\u0001\u0000\u0000\u0000\u00f9\u00f7\u0001"+
		"\u0000\u0000\u0000\u00f9\u00fa\u0001\u0000\u0000\u0000\u00fa3\u0001\u0000"+
		"\u0000\u0000\u00fb\u00f9\u0001\u0000\u0000\u0000\u00fc\u0101\u00036\u001b"+
		"\u0000\u00fd\u00fe\u0007\u0004\u0000\u0000\u00fe\u0100\u00036\u001b\u0000"+
		"\u00ff\u00fd\u0001\u0000\u0000\u0000\u0100\u0103\u0001\u0000\u0000\u0000"+
		"\u0101\u00ff\u0001\u0000\u0000\u0000\u0101\u0102\u0001\u0000\u0000\u0000"+
		"\u01025\u0001\u0000\u0000\u0000\u0103\u0101\u0001\u0000\u0000\u0000\u0104"+
		"\u010a\u00038\u001c\u0000\u0105\u0106\u0005\u0018\u0000\u0000\u0106\u0107"+
		"\u0003.\u0017\u0000\u0107\u0108\u0005\u0019\u0000\u0000\u0108\u010a\u0001"+
		"\u0000\u0000\u0000\u0109\u0104\u0001\u0000\u0000\u0000\u0109\u0105\u0001"+
		"\u0000\u0000\u0000\u010a7\u0001\u0000\u0000\u0000\u010b\u010d\u0003:\u001d"+
		"\u0000\u010c\u010b\u0001\u0000\u0000\u0000\u010c\u010d\u0001\u0000\u0000"+
		"\u0000\u010d\u010e\u0001\u0000\u0000\u0000\u010e\u0118\u00053\u0000\u0000"+
		"\u010f\u0111\u0003:\u001d\u0000\u0110\u010f\u0001\u0000\u0000\u0000\u0110"+
		"\u0111\u0001\u0000\u0000\u0000\u0111\u0112\u0001\u0000\u0000\u0000\u0112"+
		"\u0118\u00054\u0000\u0000\u0113\u0118\u0005,\u0000\u0000\u0114\u0118\u0005"+
		"-\u0000\u0000\u0115\u0118\u0003<\u001e\u0000\u0116\u0118\u0003\u0018\f"+
		"\u0000\u0117\u010c\u0001\u0000\u0000\u0000\u0117\u0110\u0001\u0000\u0000"+
		"\u0000\u0117\u0113\u0001\u0000\u0000\u0000\u0117\u0114\u0001\u0000\u0000"+
		"\u0000\u0117\u0115\u0001\u0000\u0000\u0000\u0117\u0116\u0001\u0000\u0000"+
		"\u0000\u01189\u0001\u0000\u0000\u0000\u0119\u011a\u0007\u0003\u0000\u0000"+
		"\u011a;\u0001\u0000\u0000\u0000\u011b\u0124\u00052\u0000\u0000\u011c\u011d"+
		"\u0005\u0014\u0000\u0000\u011d\u0123\u00052\u0000\u0000\u011e\u011f\u0005"+
		"\u0016\u0000\u0000\u011f\u0120\u0003.\u0017\u0000\u0120\u0121\u0005\u0017"+
		"\u0000\u0000\u0121\u0123\u0001\u0000\u0000\u0000\u0122\u011c\u0001\u0000"+
		"\u0000\u0000\u0122\u011e\u0001\u0000\u0000\u0000\u0123\u0126\u0001\u0000"+
		"\u0000\u0000\u0124\u0122\u0001\u0000\u0000\u0000\u0124\u0125\u0001\u0000"+
		"\u0000\u0000\u0125=\u0001\u0000\u0000\u0000\u0126\u0124\u0001\u0000\u0000"+
		"\u0000\u0127\u0128\u0005.\u0000\u0000\u0128\u012a\u0005\u0018\u0000\u0000"+
		"\u0129\u012b\u0003.\u0017\u0000\u012a\u0129\u0001\u0000\u0000\u0000\u012a"+
		"\u012b\u0001\u0000\u0000\u0000\u012b\u012c\u0001\u0000\u0000\u0000\u012c"+
		"\u013a\u0005\u0019\u0000\u0000\u012d\u012e\u0005/\u0000\u0000\u012e\u0130"+
		"\u0005\u0018\u0000\u0000\u012f\u0131\u0003.\u0017\u0000\u0130\u012f\u0001"+
		"\u0000\u0000\u0000\u0130\u0131\u0001\u0000\u0000\u0000\u0131\u0132\u0001"+
		"\u0000\u0000\u0000\u0132\u013a\u0005\u0019\u0000\u0000\u0133\u0134\u0005"+
		"0\u0000\u0000\u0134\u0136\u0005\u0018\u0000\u0000\u0135\u0137\u0003.\u0017"+
		"\u0000\u0136\u0135\u0001\u0000\u0000\u0000\u0136\u0137\u0001\u0000\u0000"+
		"\u0000\u0137\u0138\u0001\u0000\u0000\u0000\u0138\u013a\u0005\u0019\u0000"+
		"\u0000\u0139\u0127\u0001\u0000\u0000\u0000\u0139\u012d\u0001\u0000\u0000"+
		"\u0000\u0139\u0133\u0001\u0000\u0000\u0000\u013a?\u0001\u0000\u0000\u0000"+
		"\u013b\u013c\u00051\u0000\u0000\u013c\u013d\u0005\u0018\u0000\u0000\u013d"+
		"\u013e\u0003\n\u0005\u0000\u013e\u013f\u0005\u0019\u0000\u0000\u013fA"+
		"\u0001\u0000\u0000\u0000$EMQY_iou}\u0087\u0095\u0098\u009b\u009f\u00ab"+
		"\u00bc\u00c4\u00c9\u00d4\u00de\u00e0\u00e5\u00ec\u00f2\u00f9\u0101\u0109"+
		"\u010c\u0110\u0117\u0122\u0124\u012a\u0130\u0136\u0139";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}