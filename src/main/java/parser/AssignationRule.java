package parser;

import Lexer.Token;
import Lexer.TokenType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class AssignationRule implements Rule {

    List<Rule> matches;

    public AssignationRule() {
        SingleRule identifier = new SingleRule(TokenType.Identifier);
        SingleRule equal = new SingleRule(TokenType.EQUAL);
        ExpressionRule expressionRule = new ExpressionRule();
        matches = Arrays.asList(identifier, equal, expressionRule);
    }

    @Override
    public String getType() {
        return "ASSIGNATION";
    }

    @Override
    public Node generateTreeNode(List<Node> nodes) {
        return new AssignationNode(nodes.get(0), nodes.get(2));
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
        Optional<Node> match = matches.get(2).match(tokens.subList(2, tokens.size()));
        if (match.isPresent()) {
            nodes.add(match.get());
            return Optional.of(generateTreeNode(nodes));
        }
        return Optional.empty();
    }
}
