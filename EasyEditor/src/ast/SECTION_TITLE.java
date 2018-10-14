package ast;

import ui.Main;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

public class SECTION_TITLE extends STATEMENT {
    String sectionTitle;
    String targetSection;

    @Override
    public void parse() {
        //"make me a"
        targetSection = tokenizer.getNext();
        System.out.println("target" + targetSection);
        tokenizer.getNext();
        sectionTitle = tokenizer.getNext();
        System.out.println("titlesss" + sectionTitle);
        tokenizer.getNext();
        tokenizer.getNext();
    }

    @Override
    public String evaluate() throws FileNotFoundException, UnsupportedEncodingException {
        if (Main.symbolTable.containsKey(targetSection.trim())) {
            Main.symbolTable.remove(targetSection.trim());
            Main.symbolTable.put(targetSection.trim()+"_title", sectionTitle);
        }

        return  null;
    }
}
