package ui;

import ast.PROGRAM;
import ast.SECTION;
import libs.Tokenizer;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.*;

public class Main {
    public static Map<String,Object> symbolTable = new HashMap<>();

    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
        List<String> literals = Arrays.asList("Section","Set","Author","Create","String","Called", "the title of","\"","Present","Date","HEADER","List","Add","To","Superstring");
        Tokenizer.makeTokenizer("input.tdot",literals);
        PROGRAM p = new PROGRAM ();
        p.parse();
        p.evaluate();
        System.out.println("Show the table");
        System.out.println(symbolTable);
        System.out.println("Completed successfully!!!!!");

    }

}
