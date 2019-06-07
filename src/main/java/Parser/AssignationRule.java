package Parser;

import Lexer.Token;
import Lexer.TokenType;

import java.util.List;
import java.util.Optional;

public class AssignationRule implements Rule {

    @Override
    public String getType() {

        return "ASSIGNATION";
    }

    @Override
    public Node generateTreeNode() {

        return null;
    }

    @Override
    public Optional<Node> match(List<Token> tokens) {

        for (int i = 0; i < tokens.size(); i++) {
            if (tokens.get(i).getTokenType().equals(TokenType.Space)) break;
        }
        return Optional.empty();
    }
}
