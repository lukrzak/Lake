package com.lukrzak.lake.lake.exceptions;

public class TeamNameAlreadyTaken extends Exception{
    TeamNameAlreadyTaken(){
        super("Team with given name is already taken");
    }
}
