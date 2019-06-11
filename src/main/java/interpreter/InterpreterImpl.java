package interpreter;

import parser.Node;
import parser.Parser;
import parser.ParserImpl;

public class InterpreterImpl implements Interpreter {

    private Parser parser;
    private Executor executor;
    private Displayer displayer;




    public InterpreterImpl(Parser parser) {
        this.parser = parser;
    }

    public InterpreterImpl() {
        parser = new ParserImpl();
        executor= new Executor(new Context());
        displayer = new DisplayerImpl();
    }

    @Override
    public void execute(String s) {
        try {
            Node parserResult = parser.parse(s);
            parserResult.accept(executor);
        }catch (Exception e){
            displayer.show(e.getMessage());
        }


    }
}
