package com.losdesiempre.mypocketeam.exception;

public class MovementNotFoundException extends Exception{

    private String message;

    public MovementNotFoundException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
