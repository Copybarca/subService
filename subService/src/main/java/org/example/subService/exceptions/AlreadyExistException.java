package org.example.subService.exceptions;

public class AlreadyExistException extends  Exception{
    public AlreadyExistException(String message) {
        super(message);
    }
}

