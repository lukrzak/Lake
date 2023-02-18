package com.lukrzak.lake.lake.exceptions;

public class UserLoginAlreadyTakenException extends Exception{
    public UserLoginAlreadyTakenException(){
        super("Login or email already taken");
    }
}
