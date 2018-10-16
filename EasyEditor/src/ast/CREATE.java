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
    private SUPERSTRING codesuperstring;
    @Override
    public void parse() {
        tokenizer.getAndCheckNext("CREATE");
        String target = tokenizer.getNext();
        a = tokenizer.getNext();
//        String s1 = tokenizer.getNext();
        if (a.equals("SECTION")){
            codeSection = new SECTION();
            codeSection.parse();
        } else if (a.equals("STRING")){
            codeSectionContent = new STRING_CONTENT();
            codeSectionContent.parse();
        }else if (a.equals("LIST")){
            codeList = new LIST();
            codeList.parse();
        }else if (a.equals("SUPERSTRING")){
            codesuperstring = new SUPERSTRING();
            codesuperstring.parse();
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
        } else if (a.equals("SUPERSTRING")) {
            codesuperstring.evaluate();
        }
        return null;
    }
}
