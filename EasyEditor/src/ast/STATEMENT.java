package ast;

import libs.Node;

public  abstract class STATEMENT extends Node {
    public static STATEMENT getSubStatement(){
        if (tokenizer.checkToken("Set")) {
            return new SET();
        } else if (tokenizer.checkToken("Create")){
            return new CREATE();
        } else if (tokenizer.checkToken("Present")){
            return new PRESENT();
        }
        else return null;
    }
}
