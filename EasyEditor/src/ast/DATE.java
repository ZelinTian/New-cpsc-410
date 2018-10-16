
package ast;


import ui.Main;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
public class DATE extends STATEMENT{
    private String date;

    @Override
    public void parse() {
        //    tokenizer.getAndCheckNext("");
        tokenizer.getNext();
        tokenizer.getNext();
        date = tokenizer.getNext();
        tokenizer.getNext();
        tokenizer.getNext();
        System.out.println("Date: " + date);
    }

    @Override
    public String evaluate() throws FileNotFoundException, UnsupportedEncodingException {
        Main.symbolTable.put("Date", date);
        return null;
    }

}