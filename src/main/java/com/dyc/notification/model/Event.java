package com.dyc.notification.model;

public class Event<T> {
    private String id;
    private String type;
    private T msgObj;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public T getMsgObj() {
        return msgObj;
    }

    public void setMsgObj(T msgObj) {
        this.msgObj = msgObj;
    }
}
