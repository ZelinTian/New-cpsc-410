package ast;

import libs.InvalidInputException;
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
    public void parse() throws InvalidInputException {
        tokenizer.getAndCheckNext("ADD");
        value = tokenizer.getNext();
        String to = tokenizer.getNext();
        if (!to.equals("TO")) {
            throw new InvalidInputException("Correct ADD statement: ADD ITEM_NAME TO SECTION_NAME");
        }
        key = tokenizer.getNext();
    }

    @Override
    public String evaluate() throws FileNotFoundException, UnsupportedEncodingException, InvalidInputException {
        if (!Main.symbolTable.containsKey(key.trim() + "_TITLE")) {
            throw new InvalidInputException("SECTION " + key.trim() + " is not created yet");
        }
        boolean isExist = false;
        for (Object item : Main.symbolTable.keySet()) {
            if (item instanceof String) {
                String itemString = (String) item;
                String[] original =  itemString.split("_", 2);
                for (String a : original) {
                    if (value.trim().equals(a)) {
                        isExist = true;
                    }
                }
            }
        }
        if (!isExist) {
            throw new InvalidInputException("ITEM " + value.trim() + " is not created yet");
        }

        if (!Main.symbolTable.containsKey(key.trim()+"_CONTENT")) {
            Main.symbolTable.put(key.trim()+"_CONTENT",value.trim());
        } else if (Main.symbolTable.get(key.trim()+"_CONTENT") instanceof String) {
            String str = ((String) Main.symbolTable.get(key.trim()+"_CONTENT"));
            str = str.trim()+","+value.trim();
            System.out.println(str);
            Main.symbolTable.put(key.trim()+"_CONTENT",str);
        }
        return null;
    }

    @Override
    public String evaluate(String scope) throws FileNotFoundException, UnsupportedEncodingException, InvalidInputException {
        return null;
    }
}
