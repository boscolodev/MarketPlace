package dev.boscolo.mktoauth.services.exceptions;

public class IllegalArguments extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public IllegalArguments(String msg){
        super(msg);
    }
}
