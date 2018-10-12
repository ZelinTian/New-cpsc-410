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
        Main.symbolTable.put("s1_content","string1,list1");
        Main.symbolTable.put("s2_title","skills");
        Main.symbolTable.put("s3_title","java skill");
        Main.symbolTable.put("s4_title","python skill");
        Main.symbolTable.put("string3","3 year exp");
        Main.symbolTable.put("string4","4 year exp");
        Main.symbolTable.put("s2_content","string3,s3,s4");
        Main.symbolTable.put("s3_content","string3,list1");
        Main.symbolTable.put("list1_list","math,cpsc,stat,engl");
        Main.symbolTable.put("s4_content","string4");
        //////////////////////////
        System.out.println("show the results:" );
        MAKER maker = new MAKER();
        maker.startWrite();
        if (Main.symbolTable.containsKey("Title")){
            String title =(String)Main.symbolTable.get("Title");
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
