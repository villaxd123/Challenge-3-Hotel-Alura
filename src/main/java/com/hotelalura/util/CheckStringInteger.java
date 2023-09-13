package com.hotelalura.util;

public class CheckStringInteger {
    public Boolean verify(String checkString) {
        try {
            Integer.parseInt(checkString);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
