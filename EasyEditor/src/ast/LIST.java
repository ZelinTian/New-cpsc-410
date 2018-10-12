package ast;

import ui.Main;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

/**
 * Created by zelin on 2018/10/12.
 */
public class LIST extends STATEMENT {
    private String listContent;
    private String listId;
    public void parse() {
        tokenizer.getNext();
        tokenizer.getNext();
        listContent = tokenizer.getNext();
        tokenizer.getNext();
        tokenizer.getNext();
        tokenizer.getNext();
        listId = tokenizer.getNext().trim();
    }

    public String evaluate() throws FileNotFoundException, UnsupportedEncodingException {
        Main.symbolTable.put(listId+"_list", listContent);
        return null;
    }
}
