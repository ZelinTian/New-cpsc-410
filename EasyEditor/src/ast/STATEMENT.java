package ast;

import libs.InvalidInputException;
import libs.Node;

public  abstract class STATEMENT extends Node {
    public static STATEMENT getSubStatement() throws InvalidInputException {
        if (tokenizer.checkToken("SET")) {
            return new SET();
        } else if (tokenizer.checkToken("CREATE")){
            return new CREATE();
        } else if (tokenizer.checkToken("PRESENT")){
            return new PRESENT();
        } else if (tokenizer.checkToken("ADD")){
            return new ADD();
        } else if (tokenizer.checkToken("DEF")){
            return new PROCDEF();
        } else if (tokenizer.checkToken("DO")){
            return new PROCALL();
        }

        else {
            throw new InvalidInputException("Valid statement start with SET/CREATE/PRESENT/ADD");
        }
    }
}