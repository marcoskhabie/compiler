package lexer;

import java.util.List;

public interface Context {

    int getActualColumn();
    int getActualRow();
    int getInitialRow();
    int getInitialColumn();
    Range getColumnRange();
    Range getRowRange();

    void addToken(Token token);

    List<Token> getResult();

    void nextRow();

    void nextColumn();

    void restart();
}
