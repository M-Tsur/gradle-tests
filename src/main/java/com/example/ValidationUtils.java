package com.example;

import java.util.regex.Pattern;

public class ValidationUtils {

    private static final Pattern EMAIL_PATTERN =
            Pattern.compile("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$");

    private static final Pattern PHONE_PATTERN =
            Pattern.compile("^\\+?[0-9]{7,15}$");

    private static final Pattern IPV4_PATTERN =
            Pattern.compile("^((25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$");

    public boolean isValidEmail(String email) {
        if (email == null) return false;
        return EMAIL_PATTERN.matcher(email).matches();
    }

    public boolean isValidPhone(String phone) {
        if (phone == null) return false;
        return PHONE_PATTERN.matcher(phone.replaceAll("[\\s()-]", "")).matches();
    }

    public boolean isValidIpv4(String ip) {
        if (ip == null) return false;
        return IPV4_PATTERN.matcher(ip).matches();
    }

    public boolean isInRange(int value, int min, int max) {
        return value >= min && value <= max;
    }

    public boolean isValidPassword(String password) {
        if (password == null || password.length() < 8) return false;
        boolean hasUpper = false, hasLower = false, hasDigit = false, hasSpecial = false;
        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) hasUpper = true;
            else if (Character.isLowerCase(c)) hasLower = true;
            else if (Character.isDigit(c)) hasDigit = true;
            else hasSpecial = true;
        }
        return hasUpper && hasLower && hasDigit && hasSpecial;
    }

    public boolean isValidUrl(String url) {
        if (url == null) return false;
        return url.matches("^https?://[\\w.-]+(:\\d+)?(/.*)?$");
    }

    public boolean isAlphanumeric(String input) {
        if (input == null || input.isEmpty()) return false;
        return input.chars().allMatch(Character::isLetterOrDigit);
    }

    public boolean isValidHexColor(String color) {
        if (color == null) return false;
        return color.matches("^#([0-9A-Fa-f]{3}|[0-9A-Fa-f]{6})$");
    }
}
