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
            TokenType tokenType = tokens.get(0).getTokenType();
            if (tokenType.equals(TokenType.Identifier)) {
                return Optional.of(new IdentifierNode());
            } else if (tokenType.equals(TokenType.StringLiteral)) {
                return Optional.of(new StringNode());
            } else if (tokenType.equals(TokenType.NumberLiteral)) {
                return Optional.of(new NumberNode());
            } else if (tokenType.equals(TokenType.BooleanLiteral)) {
                return Optional.of(new BooleanNode());
            }
            return Optional.empty();
        } else {
            for (int i = 0; i < tokens.size(); i++) {
                Token token = tokens.get(i);
                TokenType tokenType = token.getTokenType();
                if (tokenType.equals(TokenType.ArithmeticOperation)) {
                    Optional<Node> left = match(tokens.subList(0, i));
                    Optional<Node> right = match(tokens.subList(i + 1, tokens.size() - 1));
                    if (left.isPresent() && right.isPresent()) {
                        return Optional.of(new ExpressionComposeNode((ExpressionNode) left.get(), (ExpressionNode) right.get(), getOperatorFromToken(token)));
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
