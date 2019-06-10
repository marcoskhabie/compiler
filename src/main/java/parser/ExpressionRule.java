package parser;

import Lexer.Token;
import Lexer.TokenImpl;
import Lexer.TokenType;

import java.util.List;
import java.util.Optional;

public class ExpressionRule implements Rule {

    @Override
    public String getType() {
        return null;
    }

    @Override
    public Node generateTreeNode(List<Node> nodes) {

        return null;
    }

    @Override
    public Optional<Node> match(List<Token> tokens) {
        if (tokens.size() == 1) {
            Token token = tokens.get(0);
            TokenType tokenType = token.getTokenType();
            if (tokenType.equals(TokenType.Identifier)) {
                return Optional.of(new IdentifierNode(token.getValue(), token));
            } else if (tokenType.equals(TokenType.StringLiteral)) {
                return Optional.of(new StringNode(token.getValue(), token));
            } else if (tokenType.equals(TokenType.NumberLiteral)) {
                return Optional.of(new NumberNode(token.getValue(), token));
            } else if (tokenType.equals(TokenType.BooleanLiteral)) {
                return Optional.of(new BooleanNode(token.getValue(), token));
            }
            return Optional.empty();
        } else {
            for (int i = 0; i < tokens.size(); i++) {
                Token token = tokens.get(i);
                TokenType tokenType = token.getTokenType();
                if (tokenType.equals(TokenType.ArithmeticOperation)) {
                    Optional<Node> left = match(tokens.subList(0, i));
                    Optional<Node> right = match(tokens.subList(i + 1, tokens.size()));
                    if (left.isPresent() && right.isPresent()) {
                        return Optional.of(new ExpressionComposeNode((ExpressionNode) left.get(), (ExpressionNode) right.get(), getOperatorFromToken(token),token));
                    } else {
                        return Optional.empty();
                    }
                }
            }
        }


        return Optional.empty();
    }

    private Operator getOperatorFromToken(Token token) {
        String value = token.getValue();

        switch (value) {
            case "+":
                return Operator.PLUS;
            case "-":
                return Operator.MINUS;
            case "*":
                return Operator.PRODUCT;
        }
        return Operator.DIVISION;
    }
}
