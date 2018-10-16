package ast;

import libs.InvalidInputException;
import ui.Main;

import java.awt.*;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SUPERSTRING extends STATEMENT {

    private String content;
    private String contentId;
    private List<SECTION> subsection = new ArrayList<SECTION>();
    @Override
    public void parse() throws InvalidInputException {
        String string = tokenizer.getNext();
        String blank1 = tokenizer.getNext();
        String quotation1 = tokenizer.getNext();
        content = tokenizer.getNext();
//        tokenizer.getAndCheckNext("Called");
        String quotation2 = tokenizer.getNext();
        String blank2 = tokenizer.getNext();
        String called = tokenizer.getNext();
        contentId = tokenizer.getNext();
        if (!string.equals("STRING") || !blank1.equals(" ") || !quotation1.equals("\"") || !quotation2.equals("\"") || !blank2.equals(" ") || !called.equals("CALLED")) {
            throw new InvalidInputException("Correct Create SUPER STRING statement: CREATE SUPER STRING \"SUPER_STRING_CONTENT\" CALLED SUPER_STRING_NAME");
        }

        List<String> splitSuperStrings = new ArrayList<String>();
        splitSuperStrings = Arrays.asList(content.split(" "));
        boolean isValid = false;
        for (String s : splitSuperStrings){
            if (s.contains("[")){
                int i = s.indexOf("[");
                String color = s.substring(0,3);
                switch (color) {
                    case "BLU":
                        break;
                    case "GRE":
                        break;
                    case "RED":
                        break;
                    default: throw new InvalidInputException("Valid COLOR: BLU/GRE/RED");
                }
                int j = s.indexOf("]");
                if (j != -1) {
                    isValid = true;
                }
            }
        }
        if (!isValid) {
            throw new InvalidInputException("Valid SUPER STRING contain COLOR[STRING_CONTENT]");
        }
    }

    @Override
    public String evaluate() throws FileNotFoundException, UnsupportedEncodingException {
        Main.symbolTable.put(contentId.trim()+"_SUPER_STRING",content.trim());

        return  null;
    }

}
