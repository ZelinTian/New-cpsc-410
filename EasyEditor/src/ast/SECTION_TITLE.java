package ast;

import libs.InvalidInputException;
import ui.Main;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

public class SECTION_TITLE extends STATEMENT {
    String sectionTitle;
    String targetSection;

    @Override
    public void parse() throws InvalidInputException {
        //"make me a"
        targetSection = tokenizer.getNext();
        System.out.println("target" + targetSection);
        String quotation1 = tokenizer.getNext();
        sectionTitle = tokenizer.getNext();
        System.out.println("titlesss" + sectionTitle);
        String quotation2 = tokenizer.getNext();
        tokenizer.getNext();
        if (!quotation1.equals("\"") || !quotation2.equals("\"")) {
            throw new InvalidInputException("Correct Set Section Title statement: Set the title of \"SECTION_TITLE\"");
        }
    }

    @Override
    public String evaluate() throws FileNotFoundException, UnsupportedEncodingException, InvalidInputException {
        if (Main.symbolTable.containsKey(targetSection.trim())) {
            Main.symbolTable.remove(targetSection.trim());
            Main.symbolTable.put(targetSection.trim()+"_title", sectionTitle);
        } else {
            throw new InvalidInputException("Section " + targetSection.trim() + " is not created yet");
        }

        return  null;
    }
}
