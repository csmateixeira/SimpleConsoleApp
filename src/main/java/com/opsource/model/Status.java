package com.opsource.model;

public class Status {
    boolean error;
    String message;

    public Status(boolean error, String message) {
        this.error = error;
        this.message = message;
    }

    public Status() {  }

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
