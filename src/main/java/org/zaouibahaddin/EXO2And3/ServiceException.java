package org.zaouibahaddin.EXO2And3;

public class ServiceException extends Exception {
    public ServiceException(String message) {
        super(message);
    }

    // I have not used it in the code!!!
    public ServiceException(String message, Throwable cause) {
        super(message, cause);
    }
}