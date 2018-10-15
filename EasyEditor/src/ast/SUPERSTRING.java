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
        String blank1 = tokenizer.getNext();
        String quotation1 = tokenizer.getNext();
        content = tokenizer.getNext();
//        tokenizer.getAndCheckNext("Called");
        String quotation2 = tokenizer.getNext();
        String blank2 = tokenizer.getNext();
        String called = tokenizer.getNext();
        contentId = tokenizer.getNext();
        if (!blank1.equals(" ") || !quotation1.equals("\"") || !quotation2.equals("\"") || !blank2.equals(" ") || !called.equals("Called")) {
            throw new InvalidInputException("Correct Create Superstring statement: Create Superstring \"SUPER_STRING_CONTENT\" Called SUPER_STRING_NAME");
        }

        List<String> splitSuperStrings = new ArrayList<String>();
        splitSuperStrings = Arrays.asList(content.split(" "));
        boolean isValid = false;
        for (String s : splitSuperStrings){
            if (s.contains("[")){
                int i = s.indexOf("[");
                String color = s.substring(0,i);
                switch (color) {
                    case "BLACK":
                        break;
                    case "BLUE":
                        break;
                    case "CYAN":
                        break;
                    case "DARK_GRAY":
                        break;
                    case "GRAY":
                        break;
                    case "GREEN":
                        break;
                    case "LIGHT_GRAY":
                        break;
                    case "MAGENTA":
                        break;
                    case "ORANGE":
                        break;
                    case "PINK":
                        break;
                    case "RED":
                        break;
                    case "WHITE":
                        break;
                    case "YELLOW":
                        break;
                    default: throw new InvalidInputException("Invalid Color " + color);
                }
                int j = s.indexOf("]");
                if (j != -1) {
                    isValid = true;
                }
            }
        }
        if (!isValid) {
            throw new InvalidInputException("Valid Superstring contain COLOR[STRING_CONTENT]");
        }
    }

    @Override
    public String evaluate() throws FileNotFoundException, UnsupportedEncodingException {
        Main.symbolTable.put(contentId.trim()+"_superstring",content.trim());

        return  null;
    }

}
