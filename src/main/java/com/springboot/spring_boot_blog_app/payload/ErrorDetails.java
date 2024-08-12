package com.springboot.spring_boot_blog_app.payload;

import lombok.Data;

import java.util.Date;

public class ErrorDetails {
    private Date timeStamp;
    private String message;

    public ErrorDetails(Date timeStamp, String message, String details) {
        this.timeStamp = timeStamp;
        this.message = message;
        this.details = details;
    }

    private String details;

    public String getMessage() {
        return message;
    }

    public Date getTimeStamp() {
        return timeStamp;
    }

    public String getDetails() {
        return details;
    }
}
