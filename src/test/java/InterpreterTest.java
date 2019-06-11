import interpreter.Interpreter;
import interpreter.InterpreterImpl;
import lexer.RangeImpl;
import lexer.Token;
import lexer.TokenImpl;
import lexer.TokenType;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class InterpreterTest {
    private Interpreter interpreter = new InterpreterImpl();

    @Test
    public void testDeclareAssignPrint(){

        String file = "let pepito:string=\"pepito\"; let hola:number; \n hola = 5+5; \nprint(hola); \nprint(pepito);";
        interpreter.execute(file);

    }
}
