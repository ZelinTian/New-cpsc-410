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
public class Add extends STATEMENT {
    private String key;
    private String value;
    @Override
    public void parse() throws InvalidInputException {
        tokenizer.getAndCheckNext("Add");
        value = tokenizer.getNext();
        String to = tokenizer.getNext();
        if (!to.equals("To")) {
            throw new InvalidInputException("Correct Add statement: Add ITEM_NAME To SECTION_NAME");
        }
        key = tokenizer.getNext();
    }

    @Override
    public String evaluate() throws FileNotFoundException, UnsupportedEncodingException, InvalidInputException {
        if (!Main.symbolTable.containsKey(key.trim() + "_title")) {
            throw new InvalidInputException("Section " + key.trim() + " is not created yet");
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
            throw new InvalidInputException("Item " + value.trim() + " is not created yet");
        }

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
