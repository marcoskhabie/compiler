import lexer.*;
import org.junit.Assert;
import org.junit.Test;
import parser.*;

import java.util.ArrayList;
import java.util.List;

public class ParserTest {

    Parser parser = new ParserImpl(new LexerImpl());

    @Test
    public void testAssignationParse() {
        List<Token> tokens = new ArrayList<>();
        tokens.add(new TokenImpl(new RangeImpl(0, 4), new RangeImpl(0, 0), TokenType.Identifier, "pepe"));
        tokens.add(new TokenImpl(new RangeImpl(4, 5), new RangeImpl(0, 0), TokenType.EQUAL, "="));
        tokens.add(new TokenImpl(new RangeImpl(5, 6), new RangeImpl(0, 0), TokenType.NumberLiteral, "5"));
        tokens.add(new TokenImpl(new RangeImpl(6, 7), new RangeImpl(0, 0), TokenType.Semicolon, ";"));

        Node node = parser.generateTree(tokens);

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

        Node node = parser.generateTree(tokens);

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

        Node node = parser.generateTree(tokens);

        Assert.assertEquals(2,node.getChildren().size());

    }

    @Test
    public void testAssignationDeclaration() {
        List<Token> tokens = new ArrayList<>();

        tokens.add(new TokenImpl(new RangeImpl(0, 4), new RangeImpl(1, 1), TokenType.Let, "let"));
        tokens.add(new TokenImpl(new RangeImpl(4, 9), new RangeImpl(1, 1), TokenType.Identifier, "pepe"));
        tokens.add(new TokenImpl(new RangeImpl(9, 10), new RangeImpl(1, 1), TokenType.Colon, ":"));
        tokens.add(new TokenImpl(new RangeImpl(10, 16), new RangeImpl(1, 1), TokenType.StringType, "string"));
        tokens.add(new TokenImpl(new RangeImpl(16, 17), new RangeImpl(1, 1), TokenType.EQUAL, "="));
        tokens.add(new TokenImpl(new RangeImpl(17, 23), new RangeImpl(0,0), TokenType.StringLiteral,"\"hola\""));
        tokens.add(new TokenImpl(new RangeImpl(23, 24), new RangeImpl(1, 1), TokenType.Semicolon, ";"));


        Node node = parser.generateTree(tokens);

        Assert.assertEquals(1,node.getChildren().size());

    }

    @Test
    public void testDeclaration() {
        List<Token> tokens = new ArrayList<>();

        tokens.add(new TokenImpl(new RangeImpl(0, 4), new RangeImpl(1, 1), TokenType.Let, "let"));
        tokens.add(new TokenImpl(new RangeImpl(4, 9), new RangeImpl(1, 1), TokenType.Identifier, "pepe"));
        tokens.add(new TokenImpl(new RangeImpl(9, 10), new RangeImpl(1, 1), TokenType.Colon, ":"));
        tokens.add(new TokenImpl(new RangeImpl(10, 16), new RangeImpl(1, 1), TokenType.NumberType, "number"));
        tokens.add(new TokenImpl(new RangeImpl(23, 24), new RangeImpl(1, 1), TokenType.Semicolon, ";"));


        Node node = parser.generateTree(tokens);

        Assert.assertEquals(1,node.getChildren().size());

    }

    @Test
    public void testLexAndThenParse() {
        String file = "let hola:string=\"hola\"+\"hola\";";


        TokenImpl let = new TokenImpl(new RangeImpl(0, 3), new RangeImpl(0,0), TokenType.Let,"let");
        TokenImpl space = new TokenImpl(new RangeImpl(3, 4), new RangeImpl(0,0), TokenType.Space," ");
        TokenImpl identifier = new TokenImpl(new RangeImpl(4, 8), new RangeImpl(0,0), TokenType.Identifier,"hola");
        TokenImpl colon = new TokenImpl(new RangeImpl(8, 9), new RangeImpl(0,0), TokenType.Colon,":");
        TokenImpl stringType = new TokenImpl(new RangeImpl(9, 15), new RangeImpl(0,0), TokenType.StringType,"string");
        TokenImpl equal = new TokenImpl(new RangeImpl(15, 16), new RangeImpl(0,0), TokenType.EQUAL,"=");
        TokenImpl stringLiteral = new TokenImpl(new RangeImpl(16, 22), new RangeImpl(0,0), TokenType.StringLiteral,"\"hola\"");
        TokenImpl plus = new TokenImpl(new RangeImpl(22, 23), new RangeImpl(0,0), TokenType.ArithmeticOperation,"+");
        TokenImpl stringLiteral2 = new TokenImpl(new RangeImpl(23, 29), new RangeImpl(0,0), TokenType.StringLiteral,"\"hola\"");
        TokenImpl semiColon = new TokenImpl(new RangeImpl(29, 30), new RangeImpl(0,0), TokenType.Semicolon,";");


        Node parse = parser.parse(file);
        SingleNode let1 = new SingleNode(let, let.getValue());
        IdentifierNode identifierNode = new IdentifierNode(identifier.getValue(), identifier);
        TypeNode type = new TypeNode(stringType);
        StringNode left = new StringNode(stringLiteral.getValue(), stringLiteral);
        StringNode right = new StringNode(stringLiteral2.getValue(), stringLiteral2);
        ExpressionComposeNode expression = new ExpressionComposeNode(left, right, Operator.PLUS, plus);
        Node assignationDeclaration = new AssignationDeclarationNode(let1, identifierNode, type, expression, colon);
        boolean condition = assertNodes(assignationDeclaration, parse.getChildren().get(0));
        Assert.assertTrue(condition);


    }

    private static boolean assertNodes(Node node1, Node node2){
        List<Node> children = node1.getChildren();
        List<Node> children1 = node2.getChildren();
        for (int i = 0; i < children.size(); i++) {
            if (!children.get(i).getToken().equals(children1.get(i).getToken())) return false;
        }
        return node1.getToken().equals(node2.getToken());

    }
}
