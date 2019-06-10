import Lexer.RangeImpl;
import Lexer.Token;
import Lexer.TokenImpl;
import Lexer.TokenType;
import org.junit.Assert;
import org.junit.Test;
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
}
