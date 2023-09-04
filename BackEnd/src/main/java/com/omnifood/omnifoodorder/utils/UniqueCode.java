package com.omnifood.omnifoodorder.utils;

import java.util.UUID;

public class UniqueCode {
    public String getUniqueCode() {
        return UUID.randomUUID().toString();
    }
}
