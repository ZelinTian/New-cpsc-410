package ast;

import libs.InvalidInputException;
import libs.Node;
import ui.Main;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

public class SECTION extends Node{
    private String  sectionId;

    @Override
    public void parse() throws InvalidInputException {
        String blank = tokenizer.getNext();
        String called = tokenizer.getNext();
        sectionId = tokenizer.getNext();
        System.out.println("section id: " + sectionId);
        if (!blank.equals(" ") || !called.equals("CALLED")) {
            throw new InvalidInputException("Correct CREATE SECTION statement: CREATE SECTION CALLED SECTION_NAME");
        }
    }

    @Override
    public String evaluate() throws FileNotFoundException, UnsupportedEncodingException {
        Main.symbolTable.put(sectionId.trim(),"");
        return  null;
    }
}
