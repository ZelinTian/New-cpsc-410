package ast;

import libs.InvalidInputException;
import ui.Main;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

/**
 * Created by zelin on 2018/9/18.
 */
public class AUTHOR extends STATEMENT {
    private String name;
    @Override
    public void parse() throws InvalidInputException{
//        tokenizer.getAndCheckNext("connect");
//        //some shape string
        String blank1 = tokenizer.getNext();
        String quotation1 = tokenizer.getNext();
        name = tokenizer.getNext();
        String quotation2 = tokenizer.getNext();
        tokenizer.getNext();
        if (!blank1.equals(" ") || !quotation1.equals("\"") || !quotation2.equals("\"")) {
            throw new InvalidInputException("Correct SET AUTHOR statement: SET AUTHOR \"AUTHOR_NAME\"");
        }

        System.out.println("!!!" + name);
//        //"called"
//        tokenizer.getAndCheckNext("to");
//        //some name string
//        name2 = tokenizer.getNext();
//        //"please"
//        tokenizer.getAndCheckNext("please");
    }

    @Override
    public String evaluate() throws FileNotFoundException, UnsupportedEncodingException, InvalidInputException {
        if (Main.symbolTable.containsKey("AUTHOR")) {
            throw new InvalidInputException("AUTHOR has been set");
        } else {
            Main.symbolTable.put("AUTHOR", name);
        }
        return  null;
    }

    @Override
    public String evaluate(String scope) throws FileNotFoundException, UnsupportedEncodingException, InvalidInputException {
        return null;
    }
}
