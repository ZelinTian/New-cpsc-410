package ast;

import ui.Main;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MAKER {
    private String fileName = "output.txt";
    private PrintWriter output;
    public void startWrite() {
        try {
            output = new PrintWriter(fileName);
            output.print("\\documentclass{article}\n" +
                    "\\usepackage[utf8]{inputenc}"+"\n");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void setTitle(String title){
        try {
            output.print("\n"+"\\title{" + title +"}");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void setAuthor(String author){
        try {
            output.print("\n"+"\\author{" + author +"}");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void setDate(String data){
        try {
            output.print("\n"+"\\date{" + data +"}");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void build_section(String id){
        String section_title = (String)Main.symbolTable.get(id+"_title");
        try {
            output.print("\n"+"\n"+
                    "\\section{"+section_title+"}");
        } catch (Exception e) {
            e.printStackTrace();
        }
        String section_content = (String) Main.symbolTable.get(id+"_content");
        List<String> listOfcontents = new ArrayList<>();
        listOfcontents = Arrays.asList(section_content.split(","));
        for (int i =0;i < listOfcontents.size();i++) {
            String content_id = listOfcontents.get(i);
            if (Main.symbolTable.containsKey(content_id)) {
                String stringContent = (String) Main.symbolTable.get(content_id);
                output.print("\n" + stringContent);
            } else if (Main.symbolTable.containsKey(content_id+"_list")){
                build_list(content_id+"_list");
            }
            else {
                build_subsection(content_id);
            }
        }
    }

    public void build_list(String content_id){
        String listContent = (String)Main.symbolTable.get(content_id);
        List<String> listitem = Arrays.asList(listContent.split(","));
        output.print("\n \\begin{itemize}");
        for(String item:listitem){
            output.print("\n \\item " + item);
        }
        output.print("\n \\end{itemize}");

    }
    public void build_subsection(String id){
        if (Main.symbolTable.containsKey(id+"_title")) {
            String subsection_title = (String) Main.symbolTable.get(id + "_title");
            String subsection_content = (String) Main.symbolTable.get(id + "_content");
            List<String> listcontent = new ArrayList<>();
            listcontent = Arrays.asList(subsection_content.split(","));
            for (int i =0;i < listcontent.size();i++){
                String target = listcontent.get(i);
                if (Main.symbolTable.containsKey(target)){
                    output.print("\n \\subsection{" + subsection_title + "}"+Main.symbolTable.get(target));
                }else {
                    build_list(target+"_list");
                }
            }

        }
    }

    public void beginDoc(){
        try {
            output.print("\n"+"\n"+"\\begin{document}\n" +
                    "\n" +
                    "\\maketitle\n" +
                    "\n");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void finishWrite(){
        try {
            output.print("\n"+"\n"+"\\end{document}");
            output.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


}
