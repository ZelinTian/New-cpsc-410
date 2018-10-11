package ast;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

public class PRESENT extends STATEMENT {
    List<String> presentList = new ArrayList<>();
    @Override
    public void parse() {
        tokenizer.getAndCheckNext("Present");
        String target = tokenizer.getNext().trim();
        System.out.println("present Element: " + target);
    }

    @Override
    public String evaluate() throws FileNotFoundException, UnsupportedEncodingException {
        return null;
    }
}
