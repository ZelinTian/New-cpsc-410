package ast;

import ui.Main;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

/**
 * Created by shuibo on 2018/10/11.
 */
public class TITLE extends STATEMENT {
    private String name;
    @Override
    public void parse() {
        tokenizer.getNext();
        tokenizer.getNext();
        name = tokenizer.getNext();
        tokenizer.getNext();
        tokenizer.getNext();
    }

    @Override
    public String evaluate() throws FileNotFoundException, UnsupportedEncodingException {
        Main.symbolTable.put("Title", name);
        return  null;
    }
}