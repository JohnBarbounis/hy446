// Generated from /home/john/hy446/hy446/ToyLang.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class ToyLangParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, TRUE=2, FALSE=3, WHILE=4, IF=5, ELSE=6, RETURN=7, FUNCTION=8, 
		NULL=9, VAR=10, EQ=11, NEQ=12, GT=13, LT=14, GTEQ=15, LTEQ=16, ASSIGN=17, 
		LPAREN=18, RPAREN=19, LBRACE=20, RBRACE=21, LBRACK=22, RBRACK=23, COMMA=24, 
		COLON=25, SEMI=26, PLUS=27, MINUS=28, MUL=29, DIV=30, ID=31, NUMBER=32, 
		STRING=33, WS=34, COMMENT=35;
	public static final int
		RULE_program = 0, RULE_statement = 1, RULE_expression = 2, RULE_atom = 3, 
		RULE_pair = 4, RULE_idList = 5, RULE_exprList = 6;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "statement", "expression", "atom", "pair", "idList", "exprList"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'.'", "'true'", "'false'", "'while'", "'if'", "'else'", "'return'", 
			"'function'", "'null'", "'var'", "'=='", "'!='", "'>'", "'<'", "'>='", 
			"'<='", "'='", "'('", "')'", "'{'", "'}'", "'['", "']'", "','", "':'", 
			"';'", "'+'", "'-'", "'*'", "'/'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, "TRUE", "FALSE", "WHILE", "IF", "ELSE", "RETURN", "FUNCTION", 
			"NULL", "VAR", "EQ", "NEQ", "GT", "LT", "GTEQ", "LTEQ", "ASSIGN", "LPAREN", 
			"RPAREN", "LBRACE", "RBRACE", "LBRACK", "RBRACK", "COMMA", "COLON", "SEMI", 
			"PLUS", "MINUS", "MUL", "DIV", "ID", "NUMBER", "STRING", "WS", "COMMENT"
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
	public String getGrammarFileName() { return "ToyLang.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public ToyLangParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProgramContext extends ParserRuleContext {
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(15); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(14);
				statement();
				}
				}
				setState(17); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 15033698236L) != 0) );
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
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
	 
		public StatementContext() { }
		public void copyFrom(StatementContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AssignmentContext extends StatementContext {
		public TerminalNode ID() { return getToken(ToyLangParser.ID, 0); }
		public TerminalNode ASSIGN() { return getToken(ToyLangParser.ASSIGN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(ToyLangParser.SEMI, 0); }
		public AssignmentContext(StatementContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IfStatementContext extends StatementContext {
		public TerminalNode IF() { return getToken(ToyLangParser.IF, 0); }
		public TerminalNode LPAREN() { return getToken(ToyLangParser.LPAREN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(ToyLangParser.RPAREN, 0); }
		public List<TerminalNode> LBRACE() { return getTokens(ToyLangParser.LBRACE); }
		public TerminalNode LBRACE(int i) {
			return getToken(ToyLangParser.LBRACE, i);
		}
		public List<ProgramContext> program() {
			return getRuleContexts(ProgramContext.class);
		}
		public ProgramContext program(int i) {
			return getRuleContext(ProgramContext.class,i);
		}
		public List<TerminalNode> RBRACE() { return getTokens(ToyLangParser.RBRACE); }
		public TerminalNode RBRACE(int i) {
			return getToken(ToyLangParser.RBRACE, i);
		}
		public TerminalNode ELSE() { return getToken(ToyLangParser.ELSE, 0); }
		public IfStatementContext(StatementContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class MemberAssignmentContext extends StatementContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode ID() { return getToken(ToyLangParser.ID, 0); }
		public TerminalNode ASSIGN() { return getToken(ToyLangParser.ASSIGN, 0); }
		public TerminalNode SEMI() { return getToken(ToyLangParser.SEMI, 0); }
		public MemberAssignmentContext(StatementContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class VarDeclContext extends StatementContext {
		public TerminalNode VAR() { return getToken(ToyLangParser.VAR, 0); }
		public TerminalNode ID() { return getToken(ToyLangParser.ID, 0); }
		public TerminalNode ASSIGN() { return getToken(ToyLangParser.ASSIGN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(ToyLangParser.SEMI, 0); }
		public VarDeclContext(StatementContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExprStatementContext extends StatementContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(ToyLangParser.SEMI, 0); }
		public ExprStatementContext(StatementContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ReturnStatementContext extends StatementContext {
		public TerminalNode RETURN() { return getToken(ToyLangParser.RETURN, 0); }
		public TerminalNode SEMI() { return getToken(ToyLangParser.SEMI, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ReturnStatementContext(StatementContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class BlockStatementContext extends StatementContext {
		public TerminalNode LBRACE() { return getToken(ToyLangParser.LBRACE, 0); }
		public ProgramContext program() {
			return getRuleContext(ProgramContext.class,0);
		}
		public TerminalNode RBRACE() { return getToken(ToyLangParser.RBRACE, 0); }
		public BlockStatementContext(StatementContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class WhileStatementContext extends StatementContext {
		public TerminalNode WHILE() { return getToken(ToyLangParser.WHILE, 0); }
		public TerminalNode LPAREN() { return getToken(ToyLangParser.LPAREN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(ToyLangParser.RPAREN, 0); }
		public TerminalNode LBRACE() { return getToken(ToyLangParser.LBRACE, 0); }
		public ProgramContext program() {
			return getRuleContext(ProgramContext.class,0);
		}
		public TerminalNode RBRACE() { return getToken(ToyLangParser.RBRACE, 0); }
		public WhileStatementContext(StatementContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FunctionDeclContext extends StatementContext {
		public TerminalNode FUNCTION() { return getToken(ToyLangParser.FUNCTION, 0); }
		public TerminalNode ID() { return getToken(ToyLangParser.ID, 0); }
		public TerminalNode LPAREN() { return getToken(ToyLangParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(ToyLangParser.RPAREN, 0); }
		public TerminalNode LBRACE() { return getToken(ToyLangParser.LBRACE, 0); }
		public ProgramContext program() {
			return getRuleContext(ProgramContext.class,0);
		}
		public TerminalNode RBRACE() { return getToken(ToyLangParser.RBRACE, 0); }
		public IdListContext idList() {
			return getRuleContext(IdListContext.class,0);
		}
		public FunctionDeclContext(StatementContext ctx) { copyFrom(ctx); }
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_statement);
		int _la;
		try {
			setState(82);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				_localctx = new VarDeclContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(19);
				match(VAR);
				setState(20);
				match(ID);
				setState(21);
				match(ASSIGN);
				setState(22);
				expression(0);
				setState(23);
				match(SEMI);
				}
				break;
			case 2:
				_localctx = new AssignmentContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(25);
				match(ID);
				setState(26);
				match(ASSIGN);
				setState(27);
				expression(0);
				setState(28);
				match(SEMI);
				}
				break;
			case 3:
				_localctx = new MemberAssignmentContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(30);
				expression(0);
				setState(31);
				match(T__0);
				setState(32);
				match(ID);
				setState(33);
				match(ASSIGN);
				setState(34);
				expression(0);
				setState(35);
				match(SEMI);
				}
				break;
			case 4:
				_localctx = new IfStatementContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(37);
				match(IF);
				setState(38);
				match(LPAREN);
				setState(39);
				expression(0);
				setState(40);
				match(RPAREN);
				setState(41);
				match(LBRACE);
				setState(42);
				program();
				setState(43);
				match(RBRACE);
				setState(49);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ELSE) {
					{
					setState(44);
					match(ELSE);
					setState(45);
					match(LBRACE);
					setState(46);
					program();
					setState(47);
					match(RBRACE);
					}
				}

				}
				break;
			case 5:
				_localctx = new WhileStatementContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(51);
				match(WHILE);
				setState(52);
				match(LPAREN);
				setState(53);
				expression(0);
				setState(54);
				match(RPAREN);
				setState(55);
				match(LBRACE);
				setState(56);
				program();
				setState(57);
				match(RBRACE);
				}
				break;
			case 6:
				_localctx = new FunctionDeclContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(59);
				match(FUNCTION);
				setState(60);
				match(ID);
				setState(61);
				match(LPAREN);
				setState(63);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ID) {
					{
					setState(62);
					idList();
					}
				}

				setState(65);
				match(RPAREN);
				setState(66);
				match(LBRACE);
				setState(67);
				program();
				setState(68);
				match(RBRACE);
				}
				break;
			case 7:
				_localctx = new BlockStatementContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(70);
				match(LBRACE);
				setState(71);
				program();
				setState(72);
				match(RBRACE);
				}
				break;
			case 8:
				_localctx = new ExprStatementContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(74);
				expression(0);
				setState(75);
				match(SEMI);
				}
				break;
			case 9:
				_localctx = new ReturnStatementContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(77);
				match(RETURN);
				setState(79);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 15033696780L) != 0)) {
					{
					setState(78);
					expression(0);
					}
				}

				setState(81);
				match(SEMI);
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
	public static class ExpressionContext extends ParserRuleContext {
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
	 
		public ExpressionContext() { }
		public void copyFrom(ExpressionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FunctionCallExprContext extends ExpressionContext {
		public TerminalNode ID() { return getToken(ToyLangParser.ID, 0); }
		public TerminalNode LPAREN() { return getToken(ToyLangParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(ToyLangParser.RPAREN, 0); }
		public ExprListContext exprList() {
			return getRuleContext(ExprListContext.class,0);
		}
		public FunctionCallExprContext(ExpressionContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class EqualityExprContext extends ExpressionContext {
		public Token op;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode EQ() { return getToken(ToyLangParser.EQ, 0); }
		public TerminalNode NEQ() { return getToken(ToyLangParser.NEQ, 0); }
		public EqualityExprContext(ExpressionContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class MulDivExprContext extends ExpressionContext {
		public Token op;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode MUL() { return getToken(ToyLangParser.MUL, 0); }
		public TerminalNode DIV() { return getToken(ToyLangParser.DIV, 0); }
		public MulDivExprContext(ExpressionContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class CompareExprContext extends ExpressionContext {
		public Token op;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode LT() { return getToken(ToyLangParser.LT, 0); }
		public TerminalNode GT() { return getToken(ToyLangParser.GT, 0); }
		public TerminalNode LTEQ() { return getToken(ToyLangParser.LTEQ, 0); }
		public TerminalNode GTEQ() { return getToken(ToyLangParser.GTEQ, 0); }
		public CompareExprContext(ExpressionContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AtomExprContext extends ExpressionContext {
		public AtomContext atom() {
			return getRuleContext(AtomContext.class,0);
		}
		public AtomExprContext(ExpressionContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class MemberAccessExprContext extends ExpressionContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode ID() { return getToken(ToyLangParser.ID, 0); }
		public MemberAccessExprContext(ExpressionContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AddSubExprContext extends ExpressionContext {
		public Token op;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode PLUS() { return getToken(ToyLangParser.PLUS, 0); }
		public TerminalNode MINUS() { return getToken(ToyLangParser.MINUS, 0); }
		public AddSubExprContext(ExpressionContext ctx) { copyFrom(ctx); }
	}

	public final ExpressionContext expression() throws RecognitionException {
		return expression(0);
	}

	private ExpressionContext expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpressionContext _localctx = new ExpressionContext(_ctx, _parentState);
		ExpressionContext _prevctx = _localctx;
		int _startState = 4;
		enterRecursionRule(_localctx, 4, RULE_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(92);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				{
				_localctx = new AtomExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(85);
				atom();
				}
				break;
			case 2:
				{
				_localctx = new FunctionCallExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(86);
				match(ID);
				setState(87);
				match(LPAREN);
				setState(89);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 15033696780L) != 0)) {
					{
					setState(88);
					exprList();
					}
				}

				setState(91);
				match(RPAREN);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(111);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(109);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
					case 1:
						{
						_localctx = new CompareExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(94);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(95);
						((CompareExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 122880L) != 0)) ) {
							((CompareExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(96);
						expression(8);
						}
						break;
					case 2:
						{
						_localctx = new EqualityExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(97);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(98);
						((EqualityExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==EQ || _la==NEQ) ) {
							((EqualityExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(99);
						expression(7);
						}
						break;
					case 3:
						{
						_localctx = new MulDivExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(100);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(101);
						((MulDivExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==MUL || _la==DIV) ) {
							((MulDivExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(102);
						expression(6);
						}
						break;
					case 4:
						{
						_localctx = new AddSubExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(103);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(104);
						((AddSubExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==PLUS || _la==MINUS) ) {
							((AddSubExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(105);
						expression(5);
						}
						break;
					case 5:
						{
						_localctx = new MemberAccessExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(106);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(107);
						match(T__0);
						setState(108);
						match(ID);
						}
						break;
					}
					} 
				}
				setState(113);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
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

	@SuppressWarnings("CheckReturnValue")
	public static class AtomContext extends ParserRuleContext {
		public AtomContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_atom; }
	 
		public AtomContext() { }
		public void copyFrom(AtomContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ObjectAtomContext extends AtomContext {
		public TerminalNode LBRACE() { return getToken(ToyLangParser.LBRACE, 0); }
		public List<PairContext> pair() {
			return getRuleContexts(PairContext.class);
		}
		public PairContext pair(int i) {
			return getRuleContext(PairContext.class,i);
		}
		public TerminalNode RBRACE() { return getToken(ToyLangParser.RBRACE, 0); }
		public List<TerminalNode> COMMA() { return getTokens(ToyLangParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(ToyLangParser.COMMA, i);
		}
		public ObjectAtomContext(AtomContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class TrueAtomContext extends AtomContext {
		public TerminalNode TRUE() { return getToken(ToyLangParser.TRUE, 0); }
		public TrueAtomContext(AtomContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FalseAtomContext extends AtomContext {
		public TerminalNode FALSE() { return getToken(ToyLangParser.FALSE, 0); }
		public FalseAtomContext(AtomContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class NumberAtomContext extends AtomContext {
		public TerminalNode NUMBER() { return getToken(ToyLangParser.NUMBER, 0); }
		public NumberAtomContext(AtomContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class StringAtomContext extends AtomContext {
		public TerminalNode STRING() { return getToken(ToyLangParser.STRING, 0); }
		public StringAtomContext(AtomContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class NullAtomContext extends AtomContext {
		public TerminalNode NULL() { return getToken(ToyLangParser.NULL, 0); }
		public NullAtomContext(AtomContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ParenExprContext extends AtomContext {
		public TerminalNode LPAREN() { return getToken(ToyLangParser.LPAREN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(ToyLangParser.RPAREN, 0); }
		public ParenExprContext(AtomContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IdAtomContext extends AtomContext {
		public TerminalNode ID() { return getToken(ToyLangParser.ID, 0); }
		public IdAtomContext(AtomContext ctx) { copyFrom(ctx); }
	}

	public final AtomContext atom() throws RecognitionException {
		AtomContext _localctx = new AtomContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_atom);
		int _la;
		try {
			setState(135);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LPAREN:
				_localctx = new ParenExprContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(114);
				match(LPAREN);
				setState(115);
				expression(0);
				setState(116);
				match(RPAREN);
				}
				break;
			case ID:
				_localctx = new IdAtomContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(118);
				match(ID);
				}
				break;
			case NUMBER:
				_localctx = new NumberAtomContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(119);
				match(NUMBER);
				}
				break;
			case STRING:
				_localctx = new StringAtomContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(120);
				match(STRING);
				}
				break;
			case NULL:
				_localctx = new NullAtomContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(121);
				match(NULL);
				}
				break;
			case LBRACE:
				_localctx = new ObjectAtomContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(122);
				match(LBRACE);
				setState(123);
				pair();
				setState(128);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(124);
					match(COMMA);
					setState(125);
					pair();
					}
					}
					setState(130);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(131);
				match(RBRACE);
				}
				break;
			case TRUE:
				_localctx = new TrueAtomContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(133);
				match(TRUE);
				}
				break;
			case FALSE:
				_localctx = new FalseAtomContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(134);
				match(FALSE);
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
	public static class PairContext extends ParserRuleContext {
		public TerminalNode STRING() { return getToken(ToyLangParser.STRING, 0); }
		public TerminalNode COLON() { return getToken(ToyLangParser.COLON, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public PairContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pair; }
	}

	public final PairContext pair() throws RecognitionException {
		PairContext _localctx = new PairContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_pair);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(137);
			match(STRING);
			setState(138);
			match(COLON);
			setState(139);
			expression(0);
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
	public static class IdListContext extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(ToyLangParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(ToyLangParser.ID, i);
		}
		public List<TerminalNode> COMMA() { return getTokens(ToyLangParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(ToyLangParser.COMMA, i);
		}
		public IdListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_idList; }
	}

	public final IdListContext idList() throws RecognitionException {
		IdListContext _localctx = new IdListContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_idList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(141);
			match(ID);
			setState(146);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(142);
				match(COMMA);
				setState(143);
				match(ID);
				}
				}
				setState(148);
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
	public static class ExprListContext extends ParserRuleContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(ToyLangParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(ToyLangParser.COMMA, i);
		}
		public ExprListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exprList; }
	}

	public final ExprListContext exprList() throws RecognitionException {
		ExprListContext _localctx = new ExprListContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_exprList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(149);
			expression(0);
			setState(154);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(150);
				match(COMMA);
				setState(151);
				expression(0);
				}
				}
				setState(156);
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 2:
			return expression_sempred((ExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 7);
		case 1:
			return precpred(_ctx, 6);
		case 2:
			return precpred(_ctx, 5);
		case 3:
			return precpred(_ctx, 4);
		case 4:
			return precpred(_ctx, 3);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001#\u009e\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0001\u0000\u0004\u0000\u0010"+
		"\b\u0000\u000b\u0000\f\u0000\u0011\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0003\u00012\b\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0003\u0001"+
		"@\b\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0003\u0001P\b\u0001\u0001\u0001"+
		"\u0003\u0001S\b\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0003\u0002Z\b\u0002\u0001\u0002\u0003\u0002]\b\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0005\u0002n\b\u0002\n\u0002\f\u0002q\t"+
		"\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0005\u0003\u007f\b\u0003\n\u0003\f\u0003\u0082\t\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0003\u0003\u0088\b\u0003\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0005\u0005\u0091\b\u0005\n\u0005\f\u0005\u0094\t\u0005\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0005\u0006\u0099\b\u0006\n\u0006\f\u0006\u009c\t\u0006"+
		"\u0001\u0006\u0000\u0001\u0004\u0007\u0000\u0002\u0004\u0006\b\n\f\u0000"+
		"\u0004\u0001\u0000\r\u0010\u0001\u0000\u000b\f\u0001\u0000\u001d\u001e"+
		"\u0001\u0000\u001b\u001c\u00b3\u0000\u000f\u0001\u0000\u0000\u0000\u0002"+
		"R\u0001\u0000\u0000\u0000\u0004\\\u0001\u0000\u0000\u0000\u0006\u0087"+
		"\u0001\u0000\u0000\u0000\b\u0089\u0001\u0000\u0000\u0000\n\u008d\u0001"+
		"\u0000\u0000\u0000\f\u0095\u0001\u0000\u0000\u0000\u000e\u0010\u0003\u0002"+
		"\u0001\u0000\u000f\u000e\u0001\u0000\u0000\u0000\u0010\u0011\u0001\u0000"+
		"\u0000\u0000\u0011\u000f\u0001\u0000\u0000\u0000\u0011\u0012\u0001\u0000"+
		"\u0000\u0000\u0012\u0001\u0001\u0000\u0000\u0000\u0013\u0014\u0005\n\u0000"+
		"\u0000\u0014\u0015\u0005\u001f\u0000\u0000\u0015\u0016\u0005\u0011\u0000"+
		"\u0000\u0016\u0017\u0003\u0004\u0002\u0000\u0017\u0018\u0005\u001a\u0000"+
		"\u0000\u0018S\u0001\u0000\u0000\u0000\u0019\u001a\u0005\u001f\u0000\u0000"+
		"\u001a\u001b\u0005\u0011\u0000\u0000\u001b\u001c\u0003\u0004\u0002\u0000"+
		"\u001c\u001d\u0005\u001a\u0000\u0000\u001dS\u0001\u0000\u0000\u0000\u001e"+
		"\u001f\u0003\u0004\u0002\u0000\u001f \u0005\u0001\u0000\u0000 !\u0005"+
		"\u001f\u0000\u0000!\"\u0005\u0011\u0000\u0000\"#\u0003\u0004\u0002\u0000"+
		"#$\u0005\u001a\u0000\u0000$S\u0001\u0000\u0000\u0000%&\u0005\u0005\u0000"+
		"\u0000&\'\u0005\u0012\u0000\u0000\'(\u0003\u0004\u0002\u0000()\u0005\u0013"+
		"\u0000\u0000)*\u0005\u0014\u0000\u0000*+\u0003\u0000\u0000\u0000+1\u0005"+
		"\u0015\u0000\u0000,-\u0005\u0006\u0000\u0000-.\u0005\u0014\u0000\u0000"+
		"./\u0003\u0000\u0000\u0000/0\u0005\u0015\u0000\u000002\u0001\u0000\u0000"+
		"\u00001,\u0001\u0000\u0000\u000012\u0001\u0000\u0000\u00002S\u0001\u0000"+
		"\u0000\u000034\u0005\u0004\u0000\u000045\u0005\u0012\u0000\u000056\u0003"+
		"\u0004\u0002\u000067\u0005\u0013\u0000\u000078\u0005\u0014\u0000\u0000"+
		"89\u0003\u0000\u0000\u00009:\u0005\u0015\u0000\u0000:S\u0001\u0000\u0000"+
		"\u0000;<\u0005\b\u0000\u0000<=\u0005\u001f\u0000\u0000=?\u0005\u0012\u0000"+
		"\u0000>@\u0003\n\u0005\u0000?>\u0001\u0000\u0000\u0000?@\u0001\u0000\u0000"+
		"\u0000@A\u0001\u0000\u0000\u0000AB\u0005\u0013\u0000\u0000BC\u0005\u0014"+
		"\u0000\u0000CD\u0003\u0000\u0000\u0000DE\u0005\u0015\u0000\u0000ES\u0001"+
		"\u0000\u0000\u0000FG\u0005\u0014\u0000\u0000GH\u0003\u0000\u0000\u0000"+
		"HI\u0005\u0015\u0000\u0000IS\u0001\u0000\u0000\u0000JK\u0003\u0004\u0002"+
		"\u0000KL\u0005\u001a\u0000\u0000LS\u0001\u0000\u0000\u0000MO\u0005\u0007"+
		"\u0000\u0000NP\u0003\u0004\u0002\u0000ON\u0001\u0000\u0000\u0000OP\u0001"+
		"\u0000\u0000\u0000PQ\u0001\u0000\u0000\u0000QS\u0005\u001a\u0000\u0000"+
		"R\u0013\u0001\u0000\u0000\u0000R\u0019\u0001\u0000\u0000\u0000R\u001e"+
		"\u0001\u0000\u0000\u0000R%\u0001\u0000\u0000\u0000R3\u0001\u0000\u0000"+
		"\u0000R;\u0001\u0000\u0000\u0000RF\u0001\u0000\u0000\u0000RJ\u0001\u0000"+
		"\u0000\u0000RM\u0001\u0000\u0000\u0000S\u0003\u0001\u0000\u0000\u0000"+
		"TU\u0006\u0002\uffff\uffff\u0000U]\u0003\u0006\u0003\u0000VW\u0005\u001f"+
		"\u0000\u0000WY\u0005\u0012\u0000\u0000XZ\u0003\f\u0006\u0000YX\u0001\u0000"+
		"\u0000\u0000YZ\u0001\u0000\u0000\u0000Z[\u0001\u0000\u0000\u0000[]\u0005"+
		"\u0013\u0000\u0000\\T\u0001\u0000\u0000\u0000\\V\u0001\u0000\u0000\u0000"+
		"]o\u0001\u0000\u0000\u0000^_\n\u0007\u0000\u0000_`\u0007\u0000\u0000\u0000"+
		"`n\u0003\u0004\u0002\bab\n\u0006\u0000\u0000bc\u0007\u0001\u0000\u0000"+
		"cn\u0003\u0004\u0002\u0007de\n\u0005\u0000\u0000ef\u0007\u0002\u0000\u0000"+
		"fn\u0003\u0004\u0002\u0006gh\n\u0004\u0000\u0000hi\u0007\u0003\u0000\u0000"+
		"in\u0003\u0004\u0002\u0005jk\n\u0003\u0000\u0000kl\u0005\u0001\u0000\u0000"+
		"ln\u0005\u001f\u0000\u0000m^\u0001\u0000\u0000\u0000ma\u0001\u0000\u0000"+
		"\u0000md\u0001\u0000\u0000\u0000mg\u0001\u0000\u0000\u0000mj\u0001\u0000"+
		"\u0000\u0000nq\u0001\u0000\u0000\u0000om\u0001\u0000\u0000\u0000op\u0001"+
		"\u0000\u0000\u0000p\u0005\u0001\u0000\u0000\u0000qo\u0001\u0000\u0000"+
		"\u0000rs\u0005\u0012\u0000\u0000st\u0003\u0004\u0002\u0000tu\u0005\u0013"+
		"\u0000\u0000u\u0088\u0001\u0000\u0000\u0000v\u0088\u0005\u001f\u0000\u0000"+
		"w\u0088\u0005 \u0000\u0000x\u0088\u0005!\u0000\u0000y\u0088\u0005\t\u0000"+
		"\u0000z{\u0005\u0014\u0000\u0000{\u0080\u0003\b\u0004\u0000|}\u0005\u0018"+
		"\u0000\u0000}\u007f\u0003\b\u0004\u0000~|\u0001\u0000\u0000\u0000\u007f"+
		"\u0082\u0001\u0000\u0000\u0000\u0080~\u0001\u0000\u0000\u0000\u0080\u0081"+
		"\u0001\u0000\u0000\u0000\u0081\u0083\u0001\u0000\u0000\u0000\u0082\u0080"+
		"\u0001\u0000\u0000\u0000\u0083\u0084\u0005\u0015\u0000\u0000\u0084\u0088"+
		"\u0001\u0000\u0000\u0000\u0085\u0088\u0005\u0002\u0000\u0000\u0086\u0088"+
		"\u0005\u0003\u0000\u0000\u0087r\u0001\u0000\u0000\u0000\u0087v\u0001\u0000"+
		"\u0000\u0000\u0087w\u0001\u0000\u0000\u0000\u0087x\u0001\u0000\u0000\u0000"+
		"\u0087y\u0001\u0000\u0000\u0000\u0087z\u0001\u0000\u0000\u0000\u0087\u0085"+
		"\u0001\u0000\u0000\u0000\u0087\u0086\u0001\u0000\u0000\u0000\u0088\u0007"+
		"\u0001\u0000\u0000\u0000\u0089\u008a\u0005!\u0000\u0000\u008a\u008b\u0005"+
		"\u0019\u0000\u0000\u008b\u008c\u0003\u0004\u0002\u0000\u008c\t\u0001\u0000"+
		"\u0000\u0000\u008d\u0092\u0005\u001f\u0000\u0000\u008e\u008f\u0005\u0018"+
		"\u0000\u0000\u008f\u0091\u0005\u001f\u0000\u0000\u0090\u008e\u0001\u0000"+
		"\u0000\u0000\u0091\u0094\u0001\u0000\u0000\u0000\u0092\u0090\u0001\u0000"+
		"\u0000\u0000\u0092\u0093\u0001\u0000\u0000\u0000\u0093\u000b\u0001\u0000"+
		"\u0000\u0000\u0094\u0092\u0001\u0000\u0000\u0000\u0095\u009a\u0003\u0004"+
		"\u0002\u0000\u0096\u0097\u0005\u0018\u0000\u0000\u0097\u0099\u0003\u0004"+
		"\u0002\u0000\u0098\u0096\u0001\u0000\u0000\u0000\u0099\u009c\u0001\u0000"+
		"\u0000\u0000\u009a\u0098\u0001\u0000\u0000\u0000\u009a\u009b\u0001\u0000"+
		"\u0000\u0000\u009b\r\u0001\u0000\u0000\u0000\u009c\u009a\u0001\u0000\u0000"+
		"\u0000\r\u00111?ORY\\mo\u0080\u0087\u0092\u009a";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}