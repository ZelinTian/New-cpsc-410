package ast;

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
    @Override
    public void parse() {
        tokenizer.getAndCheckNext("Create");
        String target = tokenizer.getNext();
        a = tokenizer.getNext();
//        String s1 = tokenizer.getNext();
        if (a.equals("Section")){
            codeSection = new SECTION();
            codeSection.parse();
        } else if (a.equals("String")){
            codeSectionContent = new STRING_CONTENT();
            codeSectionContent.parse();
        }else if (a.equals("List")){
            codeList = new LIST();
            codeList.parse();
        }
    }

    @Override
    public String evaluate() throws FileNotFoundException, UnsupportedEncodingException {
        if (a.equals("Section")){
            codeSection.evaluate();
        } else if (a.equals("String")){
            codeSectionContent.evaluate();
        } else if (a.equals("List")){
            codeList.evaluate();
        }
        return null;
    }
}
