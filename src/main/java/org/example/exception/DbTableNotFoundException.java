package org.example.exception;

public class DbTableNotFoundException extends RuntimeException {
    public DbTableNotFoundException(String message) {
        super(message);
    }
}
