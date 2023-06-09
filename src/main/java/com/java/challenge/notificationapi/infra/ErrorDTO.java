package com.java.challenge.notificationapi.infra;

public class ErrorDTO {

    private String path;
    private long timestamp;
    private String message;

    public ErrorDTO(String path, long timestamp, String message) {
        this.path = path;
        this.timestamp = timestamp;
        this.message = message;
    }

    public String getPath() {
        return path;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public String getMessage() {
        return message;
    }
}
