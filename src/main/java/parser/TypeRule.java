package parser;

import lexer.Token;
import lexer.TokenType;

import java.util.List;
import java.util.Optional;

public class TypeRule implements Rule {
    @Override
    public String getType() {
        return "TYPE";
    }

    @Override
    public Node generateTreeNode(List<Node> nodes) {
        return null;
    }

    @Override
    public Optional<Node> match(List<Token> tokens) {
        Token token = tokens.get(0);
        TokenType tokenType = token.getTokenType();
        if (tokenType.equals(TokenType.BooleanType) || tokenType.equals(TokenType.StringType) || tokenType.equals(TokenType.NumberType)){
            return Optional.of(new TypeNode(token));
        }
        return Optional.empty();
    }
}
