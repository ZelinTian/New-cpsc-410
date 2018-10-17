package ast;

import libs.InvalidInputException;
import ui.Main;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

public class PROCALL extends STATEMENT{
    private String functionName;
    @Override
    public void parse() throws InvalidInputException {
        tokenizer.getAndCheckNext("DO");
        functionName = tokenizer.getNext().trim();
    }

    @Override
    public String evaluate() throws FileNotFoundException, UnsupportedEncodingException, InvalidInputException {
        BLOCK block = (BLOCK) Main.symbolTable.get(functionName);
        return block.evaluate(functionName);
    }

    @Override
    public String evaluate(String scope) throws FileNotFoundException, UnsupportedEncodingException, InvalidInputException {
        Main.symbolTable.put(functionName.trim(),"");
        BLOCK block = (BLOCK) Main.symbolTable.get(functionName);
        return block.evaluate(scope);
    }
}
