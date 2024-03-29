package parser;

import lexer.Token;
import lexer.TokenType;

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
            Optional<Integer> index = lookForPlusOrMinusIndex(tokens);
            if (index.isPresent()) {
                Integer indexOfOperation = index.get();
                Optional<Node> left = match(tokens.subList(0, indexOfOperation));
                Optional<Node> right = match(tokens.subList(indexOfOperation + 1, tokens.size()));
                if (left.isPresent() && right.isPresent()) {
                    Token token = tokens.get(indexOfOperation);
                    return Optional.of(new ExpressionComposeNode((ExpressionNode) left.get(), (ExpressionNode) right.get(), getOperatorFromToken(token), token));
                } else {
                    return Optional.empty();
                }
            } else {

                for (int i = 0; i < tokens.size(); i++) {
                    Token token = tokens.get(i);
                    TokenType tokenType = token.getTokenType();
                    if (tokenType.equals(TokenType.ArithmeticOperation)) {
                        Optional<Node> left = match(tokens.subList(0, i));
                        Optional<Node> right = match(tokens.subList(i + 1, tokens.size()));
                        if (left.isPresent() && right.isPresent()) {
                            return Optional.of(new ExpressionComposeNode((ExpressionNode) left.get(), (ExpressionNode) right.get(), getOperatorFromToken(token), token));
                        } else {
                            return Optional.empty();
                        }
                    }
                }
            }
        }


        return Optional.empty();
    }

    private Optional<Integer> lookForPlusOrMinusIndex(List<Token> tokens) {
        for (int i = 0; i < tokens.size(); i++) {
            Token token = tokens.get(i);
            TokenType tokenType = token.getTokenType();
            if (tokenType.equals(TokenType.ArithmeticOperation)) {
                Operator operatorFromToken = getOperatorFromToken(token);
                if (operatorFromToken.equals(Operator.PLUS) || operatorFromToken.equals(Operator.MINUS)) {
                    return Optional.of(i);
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
