package com.java.challenge.notificationapi.domain.notification.dto;

public class RequestDTO {

    private String category;
    private String message;

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "RequestDTO{" +
                "category='" + category + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
