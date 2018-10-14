package ast;

import ui.Main;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PRESENT extends STATEMENT {
    List<String> presentList = new ArrayList<>();
    @Override
    public void parse() {
        tokenizer.getAndCheckNext("Present");
        String target = tokenizer.getNext().trim();
        presentList = Arrays.asList(target.split(","));
    }

    @Override
    public String evaluate() throws FileNotFoundException, UnsupportedEncodingException {
        //make a fake symbolTable
//        Main.symbolTable.put("s1_content","string1,list1");
//        Main.symbolTable.put("s2_title","try");
//        Main.symbolTable.put("s2_content","st2");
//        Main.symbolTable.put("st2_superstring","skills RED[good] shshhs");

        //////////////////////////
        System.out.println("show the results:" );
        MAKER maker = new MAKER();
        maker.startWrite();
        if (Main.symbolTable.containsKey("Header")){
            String title =(String)Main.symbolTable.get("Header");
            maker.setTitle(title);
        }
        if (Main.symbolTable.containsKey("Author")){
            String author =(String)Main.symbolTable.get("Author");
            maker.setAuthor(author);
        }
        if (Main.symbolTable.containsKey("Date")){
            String date =(String)Main.symbolTable.get("Date");
            maker.setDate(date);
        }
        maker.beginDoc();
        for (int c = 0; c < presentList.size(); c++){
            String presentItem_id = presentList.get(c);
            maker.build_section(presentItem_id);
        }
        maker.finishWrite();
        return null;
    }
}
