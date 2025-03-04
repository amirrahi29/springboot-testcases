package com.crud.example.demo_crud.response;

public class BasicResponseMsg {

    private int status;
    private String message;
    private Object data;

    public BasicResponseMsg(){}

    public BasicResponseMsg(int status,String message,Object data){
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public int getStatus() {
        return status;
    }
    public void setStatus(int status) {
        this.status = status;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public Object getData() {
        return data;
    }
    public void setData(Object data) {
        this.data = data;
    }
}
