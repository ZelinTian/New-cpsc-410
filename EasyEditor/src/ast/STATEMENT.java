package ast;

import libs.Node;

public  abstract class STATEMENT extends Node {
    public static STATEMENT getSubStatement(){
        if (tokenizer.checkToken("SET")) {
            return new SET();
        } else if (tokenizer.checkToken("CREATE")){
            return new CREATE();
        } else if (tokenizer.checkToken("PRESENT")){
            return new PRESENT();
        } else if (tokenizer.checkToken("ADD")){
            return new ADD();
        }
        else return null;
    }
}
