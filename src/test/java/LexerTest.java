import Lexer.*;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class LexerTest {

    LexerImpl lexer = new LexerImpl();

    @Test
    public void testIdentifierLex(){

        String file = "hola";

        TokenImpl expected = new TokenImpl(new RangeImpl(0, 4), new RangeImpl(0,0), TokenType.Identifier,"hola");

        List<Token> tokens = lexer.generateTokens(file);


        assertEquals(expected, tokens.get(0));
    }

    @Test
    public void testSingleWordsLex(){

        String file = "let string\nboolean number";

        TokenImpl let = new TokenImpl(new RangeImpl(0, 3), new RangeImpl(0,0), TokenType.Let,"let");
        TokenImpl space = new TokenImpl(new RangeImpl(3, 4), new RangeImpl(0,0), TokenType.Space," ");
        TokenImpl string = new TokenImpl(new RangeImpl(4,10 ), new RangeImpl(0,0), TokenType.StringType,"string");

        TokenImpl enter = new TokenImpl(new RangeImpl(10,0), new RangeImpl(0,1), TokenType.Enter,"\n");
        TokenImpl booleanType = new TokenImpl(new RangeImpl(0,7 ), new RangeImpl(1,1), TokenType.BooleanType,"boolean");
        TokenImpl numberType = new TokenImpl(new RangeImpl(8,14 ), new RangeImpl(1,1), TokenType.NumberType,"number");

        List<Token> tokens = lexer.generateTokens(file);


        assertEquals(let, tokens.get(0));
        assertEquals(space, tokens.get(1));
        assertEquals(string, tokens.get(2));
        assertEquals(enter, tokens.get(3));
        assertEquals(booleanType, tokens.get(4));
        assertEquals(numberType, tokens.get(6));
    }

    @Test
    public void testPrintLex(){

        String file = "print(4) print(\"hola\") print(true)";

        TokenImpl print = new TokenImpl(new RangeImpl(0, 5), new RangeImpl(0,0), TokenType.Print,"print");
        TokenImpl leftParenthesis = new TokenImpl(new RangeImpl(5, 6), new RangeImpl(0,0), TokenType.LeftParenthesis,"(");
        TokenImpl number = new TokenImpl(new RangeImpl(6, 7), new RangeImpl(0,0), TokenType.NumberLiteral,"4");
        TokenImpl rightParenthesis = new TokenImpl(new RangeImpl(7, 8), new RangeImpl(0,0), TokenType.RightParenthesis,")");
        TokenImpl print2 = new TokenImpl(new RangeImpl(9, 14), new RangeImpl(0,0), TokenType.Print,"print");
        TokenImpl stringLiteral = new TokenImpl(new RangeImpl(15, 21), new RangeImpl(0,0), TokenType.StringLiteral,"\"hola\"");
        TokenImpl booleanLiteral = new TokenImpl(new RangeImpl(29, 33), new RangeImpl(0,0), TokenType.BooleanLiteral,"true");


        List<Token> tokens = lexer.generateTokens(file);


        assertEquals(print, tokens.get(0));
        assertEquals(leftParenthesis, tokens.get(1));
        assertEquals(number, tokens.get(2));
        assertEquals(rightParenthesis, tokens.get(3));
        assertEquals(print2, tokens.get(5));
        assertEquals(stringLiteral, tokens.get(7));
        assertEquals(booleanLiteral, tokens.get(12));
    }
    @Test
    public void testDeclarationAssignationLex(){

        String file = "let hola:string=\"hola\"+\"hola\"";

        TokenImpl let = new TokenImpl(new RangeImpl(0, 3), new RangeImpl(0,0), TokenType.Let,"let");
        TokenImpl space = new TokenImpl(new RangeImpl(3, 4), new RangeImpl(0,0), TokenType.Space," ");
        TokenImpl identifier = new TokenImpl(new RangeImpl(4, 8), new RangeImpl(0,0), TokenType.Identifier,"hola");
        TokenImpl colon = new TokenImpl(new RangeImpl(8, 9), new RangeImpl(0,0), TokenType.Colon,":");
        TokenImpl stringType = new TokenImpl(new RangeImpl(9, 15), new RangeImpl(0,0), TokenType.StringType,"string");
        TokenImpl equal = new TokenImpl(new RangeImpl(15, 16), new RangeImpl(0,0), TokenType.EQUAL,"=");
        TokenImpl stringLiteral = new TokenImpl(new RangeImpl(16, 22), new RangeImpl(0,0), TokenType.StringLiteral,"\"hola\"");
        TokenImpl plus = new TokenImpl(new RangeImpl(22, 23), new RangeImpl(0,0), TokenType.ArithmeticOperation,"+");
        TokenImpl stringLiteral2 = new TokenImpl(new RangeImpl(23, 29), new RangeImpl(0,0), TokenType.StringLiteral,"\"hola\"");


        List<Token> tokens = lexer.generateTokens(file);


        assertEquals(let, tokens.get(0));
        assertEquals(space, tokens.get(1));
        assertEquals(identifier, tokens.get(2));
        assertEquals(colon, tokens.get(3));
        assertEquals(stringType, tokens.get(4));
        assertEquals(equal, tokens.get(5));
        assertEquals(stringLiteral, tokens.get(6));
        assertEquals(plus, tokens.get(7));
        assertEquals(stringLiteral2, tokens.get(8));
    }


}
