package ast;

import libs.InvalidInputException;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

/**
 * Created by zelin on 2018/10/10.
 */
public class SET extends STATEMENT {
//    private Title codeTitle;
    private AUTHOR codeAuthor;
    private SECTION_TITLE codeSectionTitle;
    private HEADER codeTitle;
    private DATE codeDate;
    private String a;
    @Override
    public void parse() throws InvalidInputException {
        try {
            tokenizer.getAndCheckNext("Set");
            String target = tokenizer.getNext();
            a = tokenizer.getNext();
//        String s1 = tokenizer.getNext();
            if (a.equals("the title of")) {
                codeSectionTitle = new SECTION_TITLE();
                codeSectionTitle.parse();
            } else if (a.equals("Author")) {
                codeAuthor = new AUTHOR();
                codeAuthor.parse();
            } else if (a.equals("Date")) {
                codeDate = new DATE();
                codeDate.parse();
            } else if (a.equals("HEADER")) {
                codeTitle = new HEADER();
                codeTitle.parse();
            } else {
                throw new InvalidInputException("Correct Set statement: Set Author/Date/HEADER/the title of CONTENT");
            }
        } catch (InvalidInputException e) {
            throw e;
        }
    }

    @Override
    public String evaluate() throws FileNotFoundException, UnsupportedEncodingException, InvalidInputException {
        try {
            if (a.equals("the title of")) {
                codeSectionTitle.evaluate();
            } else if (a.equals("Author")) {
                codeAuthor.evaluate();
            } else if (a.equals("Date")) {
                codeDate.evaluate();
            } else if (a.equals("HEADER")) {
                codeTitle.evaluate();
            }
        } catch (InvalidInputException e) {
            throw e;
        }

        return  null;
    }
}
