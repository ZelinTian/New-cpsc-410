package ast;

import libs.InvalidInputException;
import libs.Node;

public  abstract class STATEMENT extends Node {
    public static STATEMENT getSubStatement() throws InvalidInputException {
        if (tokenizer.checkToken("Set")) {
            return new SET();
        } else if (tokenizer.checkToken("Create")){
            return new CREATE();
        } else if (tokenizer.checkToken("Present")){
            return new PRESENT();
        } else if (tokenizer.checkToken("Add")){
            return new Add();
        } else {
            throw new InvalidInputException("Valid statement start with Set/Create/Present/Add");
        }
    }
}
