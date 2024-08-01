package org.example.exception;

public class DisposableEmailException extends RuntimeException {
    public DisposableEmailException(String message) {
        super(message);
    }
}
