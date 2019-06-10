package parser;

import lexer.Lexer;
import lexer.Token;
import lexer.TokenType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class ParserImpl implements Parser {

    private List<Rule> rules;
    private Lexer lexer;


    public ParserImpl(Lexer lexer) {
        rules = Arrays.asList(new AssignationRule(),new PrintRule(), new AssignationDeclarationRule(), new DeclarationRule());

        this.lexer = lexer;
    }


    public ParserImpl() {
        rules = Arrays.asList(new AssignationRule(),new PrintRule(), new AssignationDeclarationRule(), new DeclarationRule());
    }

    @Override
    public Node parse(String s) {
       return generateTree(lexer.generateTokens(s));
    }

    @Override
    public Node generateTree(List<Token> tokens) {
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
                continue;
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
