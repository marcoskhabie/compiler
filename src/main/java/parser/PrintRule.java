package parser;

import Lexer.Token;
import Lexer.TokenType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class PrintRule implements Rule {
    List<Rule> matches;


    public PrintRule() {
        SingleRule print = new SingleRule(TokenType.Print);
        SingleRule leftParenthesis = new SingleRule(TokenType.LeftParenthesis);
        ExpressionRule expressionRule = new ExpressionRule();
        SingleRule rightParenthesis = new SingleRule(TokenType.RightParenthesis);
        matches = Arrays.asList(print, leftParenthesis, expressionRule,rightParenthesis);
    }

    @Override
    public String getType() {
        return "PRINT";
    }

    @Override
    public Node generateTreeNode(List<Node> nodes) {
        return new PrintNode(nodes.get(0).getToken(), nodes.get(1), nodes.get(2), nodes.get(3));
    }

    @Override
    public Optional<Node> match(List<Token> tokens) {

        ArrayList<Node> nodes = new ArrayList<>();

        for (int i = 0; i < 2; i++) {
            Optional<Node> match = matches.get(i).match(Arrays.asList(tokens.get(i)));
            if (match.isPresent()) {
                nodes.add(match.get());
            } else {
                return Optional.empty();
            }
        }
        Optional<Node> expression = matches.get(2).match(tokens.subList(2, tokens.size() - 1));
        Optional<Node> rightParenthesis = matches.get(3).match(tokens.subList(tokens.size() - 1, tokens.size()));

        if (expression.isPresent() && rightParenthesis.isPresent()) {
            nodes.add(expression.get());
            nodes.add(rightParenthesis.get());
            return Optional.of(generateTreeNode(nodes));
        }
        return Optional.empty();
    }
}

