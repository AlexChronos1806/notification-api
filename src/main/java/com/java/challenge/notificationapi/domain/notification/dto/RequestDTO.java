package com.java.challenge.notificationapi.domain.notification.dto;

public class RequestDTO {

    private String category;
    private String message;

    public RequestDTO() {
    }

    private RequestDTO(RequestDTOBuilder requestDTOBuilder) {
        this.category = requestDTOBuilder.category;
        this.message = requestDTOBuilder.message;
    }

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

    public static class RequestDTOBuilder {
        private String category;
        private String message;

        public RequestDTOBuilder category(String category) {
            this.category = category;
            return this;
        }

        public RequestDTOBuilder message(String message) {
            this.message = message;
            return this;
        }

        public RequestDTO build() {
            return new RequestDTO(this);
        }
    }
}
