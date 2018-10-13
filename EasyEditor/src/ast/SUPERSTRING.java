package ast;

import ui.Main;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

public class SUPERSTRING extends STATEMENT {

    private String content;
    private String contentId;
    private List<SECTION> subsection = new ArrayList<SECTION>();
    @Override
    public void parse() {
        tokenizer.getNext();
        tokenizer.getNext();
        content = tokenizer.getNext();
//        tokenizer.getAndCheckNext("Called");
        tokenizer.getNext();
        tokenizer.getNext();
        tokenizer.getAndCheckNext("Called");
        contentId = tokenizer.getNext();
    }

    @Override
    public String evaluate() throws FileNotFoundException, UnsupportedEncodingException {
        Main.symbolTable.put(contentId.trim()+"_superstring",content.trim());

        return  null;
    }

}
