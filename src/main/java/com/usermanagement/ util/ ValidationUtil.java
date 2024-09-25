package com.usermanagement.util;

import com.usermanagement.dto.UserRequest;
import com.usermanagement.exception.CustomException;

import java.util.regex.Pattern;

public class ValidationUtil {

    private static final String MOBILE_REGEX = "^[0-9]{10}$";
    private static final String PAN_REGEX = "[A-Z]{5}[0-9]{4}[A-Z]{1}";

    public static void validateUserRequest(UserRequest request) {
        if (request.getFullName() == null || request.getFullName().isEmpty()) {
            throw new CustomException("Full name is required");
        }

        if (!Pattern.matches(MOBILE_REGEX, request.getMobNum())) {
            throw new CustomException("Invalid mobile number");
        }

        if (!Pattern.matches(PAN_REGEX, request.getPanNum().toUpperCase())) {
            throw new CustomException("Invalid PAN number");
        }
    }

    public static String formatMobileNumber(String mobNum) {
        return mobNum.replaceAll("^(\\+91|0)", "");
    }

    public static String getCurrentTimestamp() {
        return java.time.LocalDateTime.now().toString();
    }
}
