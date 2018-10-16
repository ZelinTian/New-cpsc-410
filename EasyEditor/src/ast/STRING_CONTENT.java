package ast;

import libs.InvalidInputException;
import ui.Main;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zelin on 2018/10/9.
 */
public class STRING_CONTENT extends STATEMENT {

    private String content;
    private String contentId;
    private List<SECTION> subsection = new ArrayList<SECTION>();
    @Override
    public void parse() throws InvalidInputException {
        String blank1 = tokenizer.getNext();
        String quotation1 = tokenizer.getNext();
        content = tokenizer.getNext();
        System.out.println("asc" + content);
//        tokenizer.getAndCheckNext("Called");
        String quotation2 = tokenizer.getNext();
        String blank2 = tokenizer.getNext();
        String called = tokenizer.getNext();
        contentId = tokenizer.getNext();
        System.out.println("id" + contentId);
        if (!blank1.equals(" ") || !quotation1.equals("\"") || !quotation2.equals("\"") || !blank2.equals(" ") || !called.equals("CALLED")) {
            throw new InvalidInputException("Correct CREATE STRING statement: Create STRING \"STRING_CONTENT\" CALLED STRING_NAME");
        }
    }

    @Override
    public String evaluate() throws FileNotFoundException, UnsupportedEncodingException {
        Main.symbolTable.put(contentId.trim(),content.trim());

        return  null;
    }
}
