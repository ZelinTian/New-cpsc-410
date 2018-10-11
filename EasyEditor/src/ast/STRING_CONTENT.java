package ast;

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
    public void parse() {
        tokenizer.getNext();
        tokenizer.getNext();
        content = tokenizer.getNext();
        System.out.println("asc" + content);
//        tokenizer.getAndCheckNext("Called");
        tokenizer.getNext();
        tokenizer.getNext();
        tokenizer.getAndCheckNext("Called");
        contentId = tokenizer.getNext();
        System.out.println("id" + contentId);
    }

    @Override
    public String evaluate() throws FileNotFoundException, UnsupportedEncodingException {
        Main.symbolTable.put(contentId.trim(),content.trim());

        return  null;
    }
}
