package org.example.service;

import java.util.Set;

public class DisposableEmailService {
    private static final Set<String> DISPOSABLE_DOMAINS = Set.of(
            "mailinator.com",
            "10minutemail.com",
            "guerrillamail.com",
            "tempmail.com"

    );

    public static boolean isDisposableEmail(String email) {
        if (email == null || !email.contains("@")) {
            return false;
        }
        String domain = email.substring(email.indexOf("@") + 1);
        return DISPOSABLE_DOMAINS.contains(domain);
    }

}
