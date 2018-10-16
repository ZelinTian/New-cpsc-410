package ast;

import libs.InvalidInputException;
import ui.Main;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

/**
 * Created by zelin on 2018/10/12.
 */
public class LIST extends STATEMENT {
    private String listContent;
    private String listId;
    public void parse() throws InvalidInputException {
        String blank1 = tokenizer.getNext();
        String quotation1 = tokenizer.getNext();
        listContent = tokenizer.getNext();
        String quotation2 = tokenizer.getNext();
        String blank2 = tokenizer.getNext();
        String called = tokenizer.getNext();
        listId = tokenizer.getNext().trim();
        if (!blank1.equals(" ") || !quotation1.equals("\"") || !quotation2.equals("\"") || !blank2.equals(" ") || !called.equals("CALLED")) {
            throw new InvalidInputException("Correct CREATE LIST statement: CREATE LIST \"ITEM1,ITEM2...\" CALLED LIST_NAME");
        }
    }
    public String evaluate() throws FileNotFoundException, UnsupportedEncodingException {
        Main.symbolTable.put(listId+"_LIST", listContent);
        return null;
    }

    public String evaluate(String scope) throws FileNotFoundException, UnsupportedEncodingException {
        Main.symbolTable.put(listId+"_LIST", listContent);
        return null;
    }
}
