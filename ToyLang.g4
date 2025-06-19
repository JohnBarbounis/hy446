grammar ToyLang;

// --- Parser Rules ---
program: statement+;

statement:
	'var' ID '=' expression ';'				# VarDecl
	| ID '=' expression ';'					# Assignment
	| expression '.' ID '=' expression ';'	# MemberAssignment
	| 'if' '(' expression ')' '{' program '}' (
		'else' '{' program '}'
	)?												# IfStatement
	| 'while' '(' expression ')' '{' program '}'	# WhileStatement
	| 'function' ID '(' idList? ')' '{' program '}'	# FunctionDecl
	| '{' program '}'								# BlockStatement
	| expression ';'								# ExprStatement
	| 'return' expression? ';'						# ReturnStatement;

expression:
	<assoc = left> expression op = (LT | GT | LTEQ | GTEQ) expression	# CompareExpr
	| <assoc = left> expression op = (EQ | NEQ) expression				# EqualityExpr
	| <assoc = left> expression op = ('*' | '/') expression				# MulDivExpr
	| <assoc = left> expression op = ('+' | '-') expression				# AddSubExpr
	| <assoc = left> expression '.' ID									# MemberAccessExpr
	| atom																# AtomExpr
	| ID '(' exprList? ')'												# FunctionCallExpr;

atom:
	'(' expression ')'			# ParenExpr
	| ID						# IdAtom
	| NUMBER					# NumberAtom
	| STRING					# StringAtom
	| NULL						# NullAtom
	| '{' pair (',' pair)* '}'	# ObjectAtom
	| 'true'					# TrueAtom
	| 'false'					# FalseAtom;

pair: STRING ':' expression;
idList: ID (',' ID)*;
exprList: expression (',' expression)*;

// --- Lexer Rules --- Keywords (must come before ID)
TRUE: 'true';
FALSE: 'false';
WHILE: 'while';
IF: 'if';
ELSE: 'else';
RETURN: 'return';
FUNCTION: 'function';
NULL: 'null';
VAR: 'var';

// Operators
EQ: '==';
NEQ: '!=';
GT: '>';
LT: '<';
GTEQ: '>=';
LTEQ: '<=';
ASSIGN: '=';
LPAREN: '(';
RPAREN: ')';
LBRACE: '{';
RBRACE: '}';
LBRACK: '[';
RBRACK: ']';
COMMA: ',';
COLON: ':';
SEMI: ';';
PLUS: '+';
MINUS: '-';
MUL: '*';
DIV: '/';

// Primitives
ID: [a-zA-Z_][a-zA-Z0-9_]*;
NUMBER: [0-9]+ ('.' [0-9]+)?;
STRING: '"' (~["\r\n\\] | '\\' .)*? '"';
WS: [ \t\r\n]+ -> skip;
COMMENT: '//' ~[\r\n]* -> skip;