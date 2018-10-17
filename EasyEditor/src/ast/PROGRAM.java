package ast;

import libs.InvalidInputException;
import libs.Node;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

public class PROGRAM extends Node{
    private List<STATEMENT> statements = new ArrayList<>();

    @Override
    public void parse() {
        try {
            while (tokenizer.moreTokens()) {
                STATEMENT s = STATEMENT.getSubStatement();
//            if (tokenizer.checkToken("set")) {
//                s = new SET();
//            }
//            else if (tokenizer.checkToken("get")){
//                s = new USE();
//            }
//            else if (tokenizer.checkToken("new")){
//                s = new DEC();
//            }
//            else if (tokenizer.checkToken("print")){
//                s = new PRINT();
//            }
                s.parse();
                statements.add(s);
            }
        } catch (InvalidInputException e) {
            System.err.println(e.getMessage());
            System.exit(0);
        }

    }

    @Override
    public String evaluate() throws FileNotFoundException, UnsupportedEncodingException {
        try {
            for (STATEMENT s : statements) {
                s.evaluate();
            }
        } catch (InvalidInputException e) {
            System.err.println(e.getMessage());
            System.exit(0);
        }
        return null;
    }

    @Override
    public String evaluate(String scope) throws FileNotFoundException, UnsupportedEncodingException, InvalidInputException {
        try {
            for (STATEMENT s : statements) {
                s.evaluate(scope);
            }
        } catch (InvalidInputException e) {
            System.err.println(e.getMessage());
            System.exit(0);
        }
        return null;
    }
}
