package parser;

import Lexer.Token;
import Lexer.TokenType;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class ParserImpl implements Parser {

    List<Rule> rules;


    public ParserImpl(List<Rule> rules) {
        this.rules = rules;
    }

    public ParserImpl() {
        rules = Arrays.asList(new AssignationRule());
    }

    @Override
    public Node GenerateTree(List<Token> tokens) {
        ProgramNode result = new ProgramNode();
        List<List<Token>> filteredTokens = splitTokens(tokens);

        for (List<Token> tokenSublist : filteredTokens) {

            for (Rule r : rules) {
                Optional<Node> match = r.match(tokenSublist);
                if (match.isPresent()){
                    result.addStatement((Statement) match.get());
                    break;
                }
            }
            //if no matcheo
        }
        return result;
    }

    private List<List<Token>> splitTokens(List<Token> tokens){

            List<List<Token>> result = new ArrayList<>();
            List<Token> sublist = new ArrayList<>();

        for (int i = 0; i < tokens.size() ; i++) {
            Token token = tokens.get(i);
            TokenType actualType = token.getTokenType();
            if (actualType.equals(TokenType.Space)){
                break;
            }else if (actualType.equals(TokenType.Semicolon)){
                result.add(sublist);
                sublist = new ArrayList<>();
            }else {
                sublist.add(token);
            }
        }
        return result;
    }
}
