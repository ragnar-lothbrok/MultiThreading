package com.company.threads.producerconsumer;

public class Data {

    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Data(String message) {
        super();
        this.message = message;
    }

}
