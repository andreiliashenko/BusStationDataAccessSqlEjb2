package com.anli.busstation.dal.ejb2.exceptions;

public class ManualTransactionError extends RuntimeException {

    public ManualTransactionError(Throwable cause) {
        super(cause);
    }
}
