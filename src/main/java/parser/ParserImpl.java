package parser;

import lexer.*;

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
        lexer = new LexerImpl();
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
            boolean matched = false;
            for (Rule r : rules) {
                Optional<Node> match = r.match(tokenSublist);
                if (match.isPresent()){
                    result.addStatement((Statement) match.get());
                    matched = true;
                    break;
                }
            }
            if (!matched) {
                List<RangeImpl> sublistRange = getSublistRange(tokenSublist);
                throw new ParserException("[PARSER ERROR] at rows: " + sublistRange.get(0).toString() + " columns: " + sublistRange.get(1).toString());
            }
        }
        return result;
    }

    private List<List<Token>> splitTokens(List<Token> tokens){

            List<List<Token>> result = new ArrayList<>();
            List<Token> sublist = new ArrayList<>();

        for (int i = 0; i < tokens.size() ; i++) {
            Token token = tokens.get(i);
            TokenType actualType = token.getTokenType();
            if (actualType.equals(TokenType.Space) || actualType.equals(TokenType.Enter)){
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

    private List<RangeImpl> getSublistRange(List<Token> tokens){
        Token token = tokens.get(0);
        int firstRow = token.getRowRange().getFirst();
        int firstColumn = token.getColumnRange().getFirst();
        Token token1 = tokens.get(tokens.size() - 1);
        int secondRow = token1.getRowRange().getSecond();
        int seconsColumn = token1.getColumnRange().getSecond();

        return Arrays.asList(new RangeImpl(firstRow,secondRow), new RangeImpl(firstColumn,seconsColumn));
    }
}
