package ast;

import libs.InvalidInputException;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

public class BLOCK extends STATEMENT {
    List<STATEMENT> statements;
    String scope;
    @Override
    public void parse() throws InvalidInputException {
        System.out.println("should not be here");
    }

    public void parse(String functionName) throws InvalidInputException {
//        tokenizer.getAndCheckNext("START");
        scope = functionName;
        tokenizer.getNext();
        statements = new ArrayList<>();
        while (!tokenizer.checkToken("END")){
            STATEMENT s = STATEMENT.getSubStatement();
            statements.add(s);
            s.parse();
        }
        tokenizer.getAndCheckNext("END");
        tokenizer.getNext();
    }

    @Override
    public String evaluate() throws FileNotFoundException, UnsupportedEncodingException, InvalidInputException {
        for (STATEMENT s: statements){
            s.evaluate();
        }
        return null;
    }


    public String evaluate(String scope) throws FileNotFoundException, UnsupportedEncodingException, InvalidInputException {
        for (STATEMENT s: statements){
            s.evaluate(scope);
        }
        return null;
    }
}
