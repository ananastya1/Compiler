grammar IlangCodeGeneration;

// Keywords
VAR: 'var';
TYPE: 'type';
ROUTINE: 'routine';
RETURN: 'return';
RECORD: 'record';
END: 'end';
ARRAY: 'array';
WHILE: 'while';
LOOP: 'loop';
FOR: 'for';
IN: 'in';
REVERSE: 'reverse';
IF: 'if';
THEN: 'then';
ELSE: 'else';
// Not included as it's commented out in the grammar
//FOREACH: 'foreach';
//FROM: 'from';

// Operators
IS: 'is';
COLON: ':';
COMMA: ',';
ASSIGN: ':=';
DOT: '.';
DOTDOT: '..';
LBRACK: '[';
RBRACK: ']';
LPAREN: '(';
RPAREN: ')';
NOT: 'not';
AND: 'and';
OR: 'or';
XOR: 'xor';
LT: '<';
LEQ: '<=';
GT: '>';
GEQ: '>=';
EQ: '=';
NEQ: '/=';
MUL: '*';
DIV: '/';
MOD: '%';
PLUS: '+';
MINUS: '-';

// Primitive types
INTEGER_KEYWORD: 'integer';
REAL_KEYWORD: 'real';
BOOLEAN_KEYWORD: 'boolean';
TRUE: 'true';
FALSE: 'false';

// Built-in Routines
WRITE: 'write';
WRITES: 'writes';
WRITELN: 'writeln';
INPUT: 'input';

// Identifiers and Literals
Identifier: [a-zA-Z_][a-zA-Z_0-9]*;
IntegerLiteral: [0-9]+;
RealLiteral: [0-9]+ DOT [0-9]+;
WS: [ \t\r\n;]+ -> skip;  // Ignore white spaces
COMMENT : '//' ~[\r\n]* -> skip;

main: program*  EOF;
program: simpleDeclaration | routineDeclaration | statement;

simpleDeclaration: variableDeclaration | typeDeclaration;

variableDeclaration: VAR Identifier COLON type (IS expression)?
                 | VAR Identifier IS expression
                 ;

typeDeclaration: TYPE Identifier IS type;

type: primitiveType | userType | Identifier;

primitiveType: INTEGER_KEYWORD | REAL_KEYWORD | BOOLEAN_KEYWORD;

userType: arrayType | recordType ;

recordType: RECORD variableDeclaration*  END;

arrayType: ARRAY LBRACK expression? RBRACK type;

statement: assignment
         | routineCall
         | whileLoop
         | forLoop
         | ifStatement
         ;

assignment: modifiablePrimary ASSIGN expression;

routineCall : builtInRoutines | Identifier ( LPAREN expression (COMMA expression)* RPAREN )?;

builtInRoutines : writeStatement
                | inputStatement
                ;

whileLoop: WHILE expression LOOP  body END;

forLoop: FOR Identifier IN ( REVERSE )? range LOOP body END;

range: expression DOTDOT expression;

ifStatement: IF expression THEN body ( ELSE body )? END;

// RoutineDeclaration
routineDeclaration: ROUTINE Identifier LPAREN parameters? RPAREN ( COLON type )? IS body END;

parameters: parameterDeclaration ( COMMA parameterDeclaration )*;

parameterDeclaration: Identifier COLON type;

body: ( simpleDeclaration | statement | returnStatement )* ;

returnStatement : RETURN expression? ;

// Expression
expression: relation ( ( AND | OR | XOR ) relation )*;

relation: simple ( ( LT | LEQ | GT | GEQ | EQ | NEQ ) simple )?;

simple: summand ( ( PLUS | MINUS ) summand )*;

summand: factor ( ( MUL | DIV | MOD )  factor )*;

factor: primary | LPAREN expression RPAREN;

primary: (sign)? IntegerLiteral
        | (sign)? RealLiteral
        | TRUE
        | FALSE
        | modifiablePrimary
        | routineCall
        ;

sign : PLUS | MINUS ;

modifiablePrimary: Identifier ( DOT Identifier | LBRACK expression RBRACK )*;

writeStatement:
        WRITE LPAREN expression? RPAREN |
        WRITES LPAREN expression? RPAREN |
        WRITELN LPAREN expression? RPAREN
        ;

inputStatement
    : INPUT LPAREN type RPAREN           // take input of the given type
    ;