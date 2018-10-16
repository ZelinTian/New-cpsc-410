
package ast;


import libs.InvalidInputException;
import ui.Main;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
public class DATE extends STATEMENT{
    private String date;

    @Override
    public void parse() throws InvalidInputException{
        //    tokenizer.getAndCheckNext("");

        String blank1 = tokenizer.getNext();
        String quotation1 = tokenizer.getNext();
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        date = tokenizer.getNext();
        String quotation2 = tokenizer.getNext();
        if (!blank1.equals(" ") || !quotation1.equals("\"") || !quotation2.equals("\"")) {
            throw new InvalidInputException("Correct SET DATE statement: SET DATE \"DD/MM/YYYY\"");
        }
        tokenizer.getNext();
        try {
            df.parse(date);
        } catch (ParseException e) {
            throw new InvalidInputException("Correct DATE form: DD/MM/YYYY");
        }
        try {
            df.setLenient(false);
            df.parse(date);
        } catch (Exception e) {
            throw new InvalidInputException("Invalid DATE");
        }
        /*tokenizer.getNext();
        tokenizer.getNext();
        date = tokenizer.getNext();
        tokenizer.getNext();
        tokenizer.getNext();
        System.out.println("Date: " + date);*/
    }

    @Override
    public String evaluate() throws FileNotFoundException, UnsupportedEncodingException, InvalidInputException {
        if (Main.symbolTable.containsKey("DATE")) {
            throw new InvalidInputException("DATE has been set");
        } else {
            Main.symbolTable.put("DATE", date);
        }
        return null;
    }

    @Override
    public String evaluate(String scope) throws FileNotFoundException, UnsupportedEncodingException, InvalidInputException {
        return null;
    }
}