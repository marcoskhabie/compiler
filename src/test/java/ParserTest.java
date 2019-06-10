import Lexer.RangeImpl;
import Lexer.Token;
import Lexer.TokenImpl;
import Lexer.TokenType;
import org.junit.Assert;
import org.junit.Test;
import parser.AssignationNode;
import parser.Node;
import parser.Parser;
import parser.ParserImpl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ParserTest {

    Parser parser = new ParserImpl();

    @Test
    public void testAssignationParse() {
        List<Token> tokens = new ArrayList<>();
        tokens.add(new TokenImpl(new RangeImpl(0, 4), new RangeImpl(0, 0), TokenType.Identifier, "pepe"));
        tokens.add(new TokenImpl(new RangeImpl(4, 5), new RangeImpl(0, 0), TokenType.EQUAL, "="));
        tokens.add(new TokenImpl(new RangeImpl(5, 6), new RangeImpl(0, 0), TokenType.NumberLiteral, "5"));
        tokens.add(new TokenImpl(new RangeImpl(6, 7), new RangeImpl(0, 0), TokenType.Semicolon, ";"));

        Node node = parser.GenerateTree(tokens);

        Assert.assertEquals(1,node.getChildren().size());

    }

    @Test
    public void testAssignationWithSumParse() {
        List<Token> tokens = new ArrayList<>();
        tokens.add(new TokenImpl(new RangeImpl(0, 4), new RangeImpl(0, 0), TokenType.Identifier, "pepe"));
        tokens.add(new TokenImpl(new RangeImpl(4, 5), new RangeImpl(0, 0), TokenType.EQUAL, "="));
        tokens.add(new TokenImpl(new RangeImpl(5, 6), new RangeImpl(0, 0), TokenType.NumberLiteral, "5"));
        tokens.add(new TokenImpl(new RangeImpl(6, 7), new RangeImpl(0, 0), TokenType.ArithmeticOperation, "+"));
        tokens.add(new TokenImpl(new RangeImpl(7, 8), new RangeImpl(0, 0), TokenType.NumberLiteral, "5"));
        tokens.add(new TokenImpl(new RangeImpl(8, 9), new RangeImpl(0, 0), TokenType.ArithmeticOperation, "+"));
        tokens.add(new TokenImpl(new RangeImpl(9, 10), new RangeImpl(0, 0), TokenType.NumberLiteral, "5"));
        tokens.add(new TokenImpl(new RangeImpl(11, 12), new RangeImpl(0, 0), TokenType.Semicolon, ";"));

        tokens.add(new TokenImpl(new RangeImpl(0, 4), new RangeImpl(1, 1), TokenType.Identifier, "pepe"));
        tokens.add(new TokenImpl(new RangeImpl(4, 5), new RangeImpl(1, 1), TokenType.EQUAL, "="));
        tokens.add(new TokenImpl(new RangeImpl(5, 6), new RangeImpl(1, 1), TokenType.NumberLiteral, "5"));
        tokens.add(new TokenImpl(new RangeImpl(6, 7), new RangeImpl(1, 1), TokenType.ArithmeticOperation, "-"));
        tokens.add(new TokenImpl(new RangeImpl(7, 8), new RangeImpl(1, 1), TokenType.NumberLiteral, "5"));
        tokens.add(new TokenImpl(new RangeImpl(8, 9), new RangeImpl(1, 1), TokenType.ArithmeticOperation, "/"));
        tokens.add(new TokenImpl(new RangeImpl(9, 10), new RangeImpl(1, 1), TokenType.NumberLiteral, "5"));
        tokens.add(new TokenImpl(new RangeImpl(11, 12), new RangeImpl(1, 1), TokenType.Semicolon, ";"));

        Node node = parser.GenerateTree(tokens);

        Assert.assertEquals(2,node.getChildren().size());

    }

    @Test
    public void testPrintWithSumParse() {
        List<Token> tokens = new ArrayList<>();
        tokens.add(new TokenImpl(new RangeImpl(0, 5), new RangeImpl(0, 0), TokenType.Print, "print"));
        tokens.add(new TokenImpl(new RangeImpl(5, 6), new RangeImpl(0, 0), TokenType.LeftParenthesis, "("));
        tokens.add(new TokenImpl(new RangeImpl(6, 7), new RangeImpl(0, 0), TokenType.NumberLiteral, "5"));
        tokens.add(new TokenImpl(new RangeImpl(7, 8), new RangeImpl(0, 0), TokenType.ArithmeticOperation, "+"));
        tokens.add(new TokenImpl(new RangeImpl(8, 9), new RangeImpl(0, 0), TokenType.NumberLiteral, "5"));
        tokens.add(new TokenImpl(new RangeImpl(9, 10), new RangeImpl(0, 0), TokenType.RightParenthesis, ")"));
        tokens.add(new TokenImpl(new RangeImpl(11, 12), new RangeImpl(0, 0), TokenType.Semicolon, ";"));

        tokens.add(new TokenImpl(new RangeImpl(0, 5), new RangeImpl(1, 1), TokenType.Identifier, "pepe"));
        tokens.add(new TokenImpl(new RangeImpl(4, 5), new RangeImpl(1, 1), TokenType.EQUAL, "="));
        tokens.add(new TokenImpl(new RangeImpl(5, 6), new RangeImpl(1, 1), TokenType.NumberLiteral, "5"));
        tokens.add(new TokenImpl(new RangeImpl(6, 7), new RangeImpl(1, 1), TokenType.ArithmeticOperation, "-"));
        tokens.add(new TokenImpl(new RangeImpl(7, 8), new RangeImpl(1, 1), TokenType.NumberLiteral, "5"));
        tokens.add(new TokenImpl(new RangeImpl(8, 9), new RangeImpl(1, 1), TokenType.ArithmeticOperation, "/"));
        tokens.add(new TokenImpl(new RangeImpl(9, 10), new RangeImpl(1, 1), TokenType.NumberLiteral, "5"));
        tokens.add(new TokenImpl(new RangeImpl(11, 12), new RangeImpl(1, 1), TokenType.Semicolon, ";"));

        Node node = parser.GenerateTree(tokens);

        Assert.assertEquals(2,node.getChildren().size());

    }


    static boolean assertNodes(Node node1, Node node2){
        return node1.getToken().equals(node2.getToken()) && node1.getChildren().equals(node2.getChildren()) && node1.getValue().equals(node2.getValue());

    }
}
