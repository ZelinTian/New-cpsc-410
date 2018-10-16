package libs;


import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

public abstract class Node {
    protected static Tokenizer tokenizer = Tokenizer.getTokenizer();
    static protected PrintWriter writer;

    abstract public void parse() throws InvalidInputException;
    abstract public String evaluate() throws FileNotFoundException, UnsupportedEncodingException, InvalidInputException;
    abstract public String evaluate(String scope) throws FileNotFoundException, UnsupportedEncodingException, InvalidInputException;


}
