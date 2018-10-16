package ast;

import libs.InvalidInputException;
import ui.Main;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

/**
 * Created by shuibo on 2018/10/11.
 */
public class HEADER extends STATEMENT {
    private String name;
    @Override
    public void parse() throws InvalidInputException {
        String blank1 = tokenizer.getNext();
        String quotation1 = tokenizer.getNext();
        name = tokenizer.getNext();
        String quotation2 = tokenizer.getNext();
        if (!blank1.equals(" ") || !quotation1.equals("\"") || !quotation2.equals("\"")) {
            throw new InvalidInputException("Correct SET HEADER statement: SET HEADER \"HEADER_NAME\"");
        }
        tokenizer.getNext();
//        tokenizer.getNext();
//        tokenizer.getNext();
//        name = tokenizer.getNext();
//        tokenizer.getNext();
//        tokenizer.getNext();
    }

    @Override
    public String evaluate() throws FileNotFoundException, UnsupportedEncodingException, InvalidInputException {
        if (Main.symbolTable.containsKey("HEADER")) {
            throw new InvalidInputException("HEADER has been set");
        } else {
            Main.symbolTable.put("HEADER", name);
        }
        return null;
    }
}