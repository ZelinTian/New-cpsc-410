package ast;

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
    public void parse() {
        tokenizer.getAndCheckNext("SET");
        String target = tokenizer.getNext();
        a = tokenizer.getNext();
//        String s1 = tokenizer.getNext();
        if (a.equals("TITLE")){
            codeSectionTitle = new SECTION_TITLE();
            codeSectionTitle.parse();
        } else if (a.equals("AUTHOR")){
            codeAuthor = new AUTHOR();
            codeAuthor.parse();
        } else if (a.equals("DATE")){
            codeDate = new DATE();
            codeDate.parse();
        } else if (a.equals("HEADER")){
            codeTitle = new HEADER();
            codeTitle.parse();
        }
    }

    @Override
    public String evaluate() throws FileNotFoundException, UnsupportedEncodingException {
        if (a.equals("TITLE")){
            codeSectionTitle.evaluate();
        } else if (a.equals("AUTHOR")){
            codeAuthor.evaluate();
        }  else if (a.equals("DATE")){
            codeDate.evaluate();
        } else if (a.equals("HEADER")){
            codeTitle.evaluate();
        }

        return  null;
    }
}
