package parser;

import lexer.Token;
import lexer.TokenType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class AssignationDeclarationRule implements Rule {

    private List<Rule> matches;


    public AssignationDeclarationRule() {
        SingleRule let = new SingleRule(TokenType.Let);
        SingleRule identifier = new SingleRule(TokenType.Identifier);
        SingleRule colon = new SingleRule(TokenType.Colon);
        TypeRule type = new TypeRule();
        SingleRule equal = new SingleRule(TokenType.EQUAL);
        ExpressionRule expressionRule = new ExpressionRule();

        matches = Arrays.asList(let, identifier, colon, type, equal, expressionRule);

    }

    @Override
    public String getType() {
        return "ASSIGNATION DECLARATION";
    }

    @Override
    public Node generateTreeNode(List<Node> nodes) {

        return new AssignationDeclarationNode(nodes.get(0), nodes.get(1), nodes.get(3), nodes.get(5), nodes.get(2).getToken());
    }

    @Override
    public Optional<Node> match(List<Token> tokens) {
        if (tokens.size() < 5) return Optional.empty();
        ArrayList<Node> nodes = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Optional<Node> match = matches.get(i).match(Arrays.asList(tokens.get(i)));
            if (match.isPresent()) {
                nodes.add(match.get());
            } else {
                return Optional.empty();
            }
        }
        Optional<Node> match = matches.get(5).match(tokens.subList(5, tokens.size()));
        if (match.isPresent()) {
            nodes.add(match.get());
            return Optional.of(generateTreeNode(nodes));
        }
        return Optional.empty();
    }
}
