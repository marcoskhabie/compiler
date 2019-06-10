package parser;

import Lexer.Token;
import Lexer.TokenType;

import java.util.List;
import java.util.Optional;

public class SingleRule implements Rule{
    private TokenType type;

    public SingleRule(TokenType type) {
        this.type = type;
    }

    @Override
    public String getType() {
        return type.name();
    }

    @Override
    public Node generateTreeNode(List<Node> nodes) {
        return null;
    }

    @Override
    public Optional<Node> match(List<Token> tokens) {
        Token token = tokens.get(0);
        TokenType tokenType = token.getTokenType();
        if (tokenType.equals(type)) {
            switch (tokenType){
                case Identifier:
                    return Optional.of(new IdentifierNode(token.getValue(),token));
                case EQUAL:
                    return Optional.of(new EqualNode(token, token.getValue()));
                case LeftParenthesis:
                case RightParenthesis:
                    return Optional.of(new ParenthesisNode(token, token.getValue()));

                case Print:
                    return Optional.of(new PrintNode(token,null,null,null));
            }
        }
        return Optional.empty();
    }
}
