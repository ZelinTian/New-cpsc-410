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
                    "\\usepackage[utf8]{inputenc}\n" +
                    "\\usepackage{color}\n" +
                    "% Colors\n" +
                    "\\definecolor{blu}{rgb}{0,0,1}\n" +
                    "\\def\\blu#1{{\\color{blu}#1}}\n" +
                    "\\definecolor{gre}{rgb}{0,.5,0}\n" +
                    "\\def\\gre#1{{\\color{gre}#1}}\n" +
                    "\\definecolor{red}{rgb}{1,0,0}\n" +
                    "\\def\\red#1{{\\color{red}#1}}\n" +
                    "\\def\\norm#1{\\|#1\\|}");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void setTitle(String HEADER){
        try {
            output.print("\n"+"\\title{" + HEADER +"}");
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

    public void setsuperString(String superString){
        try{
           List<String> splitSuperStrings = new ArrayList<String>();
           String superstringContent = (String)Main.symbolTable.get(superString);
           splitSuperStrings = Arrays.asList(superstringContent.split(" "));
           for (String s : splitSuperStrings){
               if (s.contains("[")){
                   int i = s.indexOf("[");
                   String color = s.substring(0,3).toLowerCase();
                   int j = s.indexOf("]");
                   String object = s.substring(i+1,j);
                   output.print("\\"+color+"{"+object+"} ");
               }else {
                   output.print(s+" ");
               }
           }
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public void build_section(String id){
        String section_title = (String)Main.symbolTable.get(id+"_TITLE");
        try {
            output.print("\n"+"\n"+
                    "\\section{"+section_title+"}");
        } catch (Exception e) {
            e.printStackTrace();
        }
        String section_content = (String) Main.symbolTable.get(id+"_CONTENT");

        List<String> listOfcontents = new ArrayList<>();
        listOfcontents = Arrays.asList(section_content.split(","));
        for (int i =0;i < listOfcontents.size();i++) {
            String content_id = listOfcontents.get(i);
            if (Main.symbolTable.containsKey(content_id+"_SUPER_STRING_"+id)){
                setsuperString(content_id+"_SUPER_STRING_"+id);
                continue;
            }else if (Main.symbolTable.containsKey(content_id+"_SECTION_"+id)){
                build_subsection(content_id+"_SECTION_"+id);
                continue;
            }else if (Main.symbolTable.containsKey(content_id+"_STRING_"+id)){
                String stringContent = (String) Main.symbolTable.get(content_id+"_STRING_"+id);
                output.print("\n" + stringContent+"\n");
                continue;
            } else if (Main.symbolTable.containsKey(content_id+"_LIST_"+id)){
                build_list(content_id+"_LIST_"+id);
                continue;
            } else if (Main.symbolTable.containsKey(content_id)) {
                String stringContent = (String) Main.symbolTable.get(content_id);
                output.print("\n" + stringContent+"\n");
                continue;
            } else if (Main.symbolTable.containsKey(content_id+"_LIST")){
                build_list(content_id+"_LIST");
                continue;
            } else if (Main.symbolTable.containsKey(content_id+"_SUPER_STRING")){
                setsuperString(content_id+"_SUPER_STRING");
                continue;
            } else {
                build_subsection(content_id);
                continue;
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
        output.print("\n \\end{itemize} \n");

    }
    public void build_subsection(String id){
        String scope = id;
        if (Main.symbolTable.containsKey(id+"_TITLE")) {
            String subsection_title = (String) Main.symbolTable.get(id + "_TITLE");
            String subsection_content = (String) Main.symbolTable.get(id + "_CONTENT");
            List<String> listcontent = new ArrayList<>();
            listcontent = Arrays.asList(subsection_content.split(","));
            for (int i =0;i < listcontent.size();i++){
                String target = listcontent.get(i);
                if (Main.symbolTable.containsKey(target)){
                    output.print("\n \\subsection{" + subsection_title + "}"+Main.symbolTable.get(target));
                }else {
                    output.print("\n \\subsection{" + subsection_title + "}");
                    if (Main.symbolTable.containsKey(id+"_TITLE_"+scope)){
                        build_list(target+"_LIST_"+scope);
                    }
                    else {build_list(target+"_LIST");}
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
