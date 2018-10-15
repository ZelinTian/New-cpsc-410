package libs;

import java.io.IOException;

public class InvalidInputException extends IOException {
    public InvalidInputException() {
        super();
    }
    public InvalidInputException(String s) {
        super(s);
    }
}
