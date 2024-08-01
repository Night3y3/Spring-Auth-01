package org.example.service;

import org.example.exception.DisposableEmailException;
import org.example.exception.InvalidEmailException;
import org.example.exception.WeakPasswordException;

import java.util.regex.Pattern;

public class ValidationService {
    public static void validateEmail(String email) {
        if (!isValidEmail(email)) {
            throw new InvalidEmailException("Invalid email address.");
        }
        if (DisposableEmailService.isDisposableEmail(email)) {
            throw new DisposableEmailException("Disposable email addresses are not allowed.");
        }
    }

    public static void validatePassword(String password) {
        if (!isStrongPassword(password)) {
            throw new WeakPasswordException("Password must be at least 8 characters long and contain at least one uppercase letter, one lowercase letter, one digit, and one special character.");
        }
    }

    private static boolean isValidEmail(String email) {
        if (email == null || !email.contains("@")) {
            return false;
        }
        // Additional email format validation can be added here
        return true;
    }

    private static boolean isStrongPassword(String password) {
        if (password == null) return false;
        return password.length() >= 8 &&
                Pattern.compile("[A-Z]").matcher(password).find() &&
                Pattern.compile("[a-z]").matcher(password).find() &&
                Pattern.compile("[0-9]").matcher(password).find() &&
                Pattern.compile("[^a-zA-Z0-9]").matcher(password).find();
    }
}
