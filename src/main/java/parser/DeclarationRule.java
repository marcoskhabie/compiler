package parser;

import lexer.Token;
import lexer.TokenType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class DeclarationRule implements Rule {

    private List<Rule> matches;

    public DeclarationRule() {

        SingleRule let = new SingleRule(TokenType.Let);
        SingleRule identifier = new SingleRule(TokenType.Identifier);
        SingleRule colon = new SingleRule(TokenType.Colon);
        TypeRule type = new TypeRule();

        matches = Arrays.asList(let, identifier, colon, type);

    }

    @Override
    public String getType() {
        return "DECLARATION";
    }

    @Override
    public Node generateTreeNode(List<Node> nodes) {
        return new DeclarationNode(nodes.get(0), nodes.get(1), nodes.get(3), nodes.get(2).getToken());
    }

    @Override
    public Optional<Node> match(List<Token> tokens) {
        if (tokens.size() == 4) {
            ArrayList<Node> nodes = new ArrayList<>();
            for (int i = 0; i < 4; i++) {
                Optional<Node> match = matches.get(i).match(Arrays.asList(tokens.get(i)));
                if (match.isPresent()) {
                    nodes.add(match.get());
                } else {
                    return Optional.empty();
                }

            }
            return Optional.of(generateTreeNode(nodes));
        }
        return Optional.empty();
    }
}
