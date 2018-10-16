package ast;

import libs.InvalidInputException;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

/**
 * Created by zelin on 2018/10/10.
 */
public class CREATE extends STATEMENT {
    private STRING_CONTENT codeSectionContent;
    private SECTION codeSection;
    private String a;
    private LIST codeList;
    private SUPERSTRING codesuperstring;
    @Override
    public void parse() throws InvalidInputException {
        try {
            tokenizer.getAndCheckNext("CREATE");
            String blank = tokenizer.getNext();
            if (!blank.equals(" ")) {
                System.out.println(blank);
                System.out.println("here 1 <<<<<<<<<<<<<<<");
                throw new InvalidInputException("Correct CREATE statement: CREATE SECTION/STRING/LIST/SUPER STRING CONTENT");
            }
            a = tokenizer.getNext();
//        String s1 = tokenizer.getNext();
            if (a.equals("SECTION")) {
                codeSection = new SECTION();
                codeSection.parse();
            } else if (a.equals("STRING")) {
                codeSectionContent = new STRING_CONTENT();
                codeSectionContent.parse();
            } else if (a.equals("LIST")) {
                codeList = new LIST();
                codeList.parse();
            } else if (a.equals("SUPER ")) {
                codesuperstring = new SUPERSTRING();
                codesuperstring.parse();
            } else {
                System.out.println(a);
                System.out.println("here 2 <<<<<<<<<<<<<<<");
                throw new InvalidInputException("Correct CREATE statement: CREATE SECTION/STRING/LIST/SUPER STRING CONTENT");
            }
        } catch (InvalidInputException e) {
            throw e;
        }
    }

    @Override
    public String evaluate() throws FileNotFoundException, UnsupportedEncodingException {
        if (a.equals("SECTION")) {
            codeSection.evaluate();
        } else if (a.equals("STRING")) {
            codeSectionContent.evaluate();
        } else if (a.equals("LIST")) {
            codeList.evaluate();
        } else if (a.equals("SUPER ")) {
            codesuperstring.evaluate();
        }
        return null;
    }
}
