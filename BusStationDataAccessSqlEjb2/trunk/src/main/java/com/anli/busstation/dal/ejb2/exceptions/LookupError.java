package com.anli.busstation.dal.ejb2.exceptions;

public class LookupError extends RuntimeException {

    public LookupError() {
        super();
    }

    public LookupError(Throwable cause) {
        super(cause);
    }

    public LookupError(String message) {
        super(message);
    }

    public LookupError(String message, Throwable cause) {
        super(message, cause);
    }
}
