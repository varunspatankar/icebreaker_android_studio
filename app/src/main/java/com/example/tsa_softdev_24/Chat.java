package com.example.tsa_softdev_24;

public class Chat {

    private ChatData chatdata;
    private String response;

    public ChatData getChatData() {
        return chatdata;
    }

    public String getResponse() {
        return response;
    }

    public String getChatTone() {
        return chatdata.getTone();
    }

    public String getChatRecipient() {
        return chatdata.getRecipient();
    }

    public String getChatSetting() {
        return chatdata.getSetting();
    }

    public String getChatPrompt() {
        return chatdata.getPrompt();
    }

    public void setChatData(ChatData c) {
        chatdata = c;
    }

    public void setResponse(String s) {
        response = s;
    }

}
