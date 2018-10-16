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
            throw new InvalidInputException("Correct SET SECTION_TITLE statement: SET TITLE OF SECTION_ID \"SECTION_TITLE\"");
        }
    }

    @Override
    public String evaluate() throws FileNotFoundException, UnsupportedEncodingException, InvalidInputException {
        if (Main.symbolTable.containsKey(targetSection.trim())) {
            Main.symbolTable.remove(targetSection.trim());
            Main.symbolTable.put(targetSection.trim()+"_TITLE", sectionTitle);
        } else {
            throw new InvalidInputException("SECTION " + targetSection.trim() + " is not created yet");
        }

        return  null;
    }
}
