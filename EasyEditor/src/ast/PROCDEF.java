package ast;

import libs.InvalidInputException;
import ui.Main;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

public class PROCDEF extends STATEMENT {
    private String functionName;
    private BLOCK codeBlock;
    private String title;
    @Override
    public void parse() throws InvalidInputException {
        tokenizer.getAndCheckNext("DEF");
        tokenizer.getNext();
        tokenizer.getNext();
        tokenizer.getNext();
        tokenizer.getNext();
//        tokenizer.getAndCheckNext("SECTION");
//        tokenizer.getAndCheckNext("CALLED");
        functionName = tokenizer.getNext().trim();
        tokenizer.getNext();

        title = tokenizer.getNext();
        tokenizer.getNext();
        tokenizer.getNext();
        System.out.println("function: " + functionName);
        tokenizer.getAndCheckNext("START");
        codeBlock = new BLOCK();
        codeBlock.parse(functionName);
    }

    @Override
    public String evaluate() throws FileNotFoundException, UnsupportedEncodingException, InvalidInputException {
        Main.symbolTable.put(functionName+"_TITLE",title.trim());
        Main.symbolTable.put(functionName,codeBlock);
        return null;
    }

    @Override
    public String evaluate(String scope) throws FileNotFoundException, UnsupportedEncodingException, InvalidInputException {
        return null;
    }
}
