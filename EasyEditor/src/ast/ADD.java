package ast;

import sun.awt.image.ImageWatched;
import ui.Main;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by zelin on 2018/10/10.
 */
public class ADD extends STATEMENT {
    private String key;
    private String value;
    @Override
    public void parse() {
        tokenizer.getAndCheckNext("ADD");
        value = tokenizer.getNext();
        tokenizer.getAndCheckNext("TO");
        key = tokenizer.getNext();
    }

    @Override
    public String evaluate() throws FileNotFoundException, UnsupportedEncodingException {
        if (!Main.symbolTable.containsKey(key.trim()+"_content")) {
            Main.symbolTable.put(key.trim()+"_content",value.trim());
        } else if (Main.symbolTable.get(key.trim()+"_content") instanceof String) {
            String str = ((String) Main.symbolTable.get(key.trim()+"_content"));
            str = str.trim()+","+value.trim();
            System.out.println(str);
            Main.symbolTable.put(key.trim()+"_content",str);
        }
        return  null;
    }
}
