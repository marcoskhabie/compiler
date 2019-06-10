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
        TokenType tokenType = tokens.get(0).getTokenType();
        if (tokenType.equals(type)) {
            switch (tokenType){
                case Identifier:
                    return Optional.of(new IdentifierNode());
                case EQUAL:
                    return Optional.of(new EqualNode());
            }
        }
        return Optional.empty();
    }
}
