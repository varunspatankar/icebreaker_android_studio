package com.example.tsa_softdev_24;

public class ChatData {


    private String tone;
    private String recipient;
    private String setting;
    private String prompt;

    public ChatData (String t, String r, String s, String p) {
        tone = t;
        recipient = r;
        setting = s;
        prompt = p;
    }

    public String getTone() {
        return tone;
    }

    public String getRecipient() {
        return recipient;
    }

    public String getSetting() {
        return setting;
    }

    public String getPrompt() {
        return prompt;
    }

    public void setTone(String t) {
        tone = t;
    }

    public void setRecipient(String r) {
        recipient = r;
    }

    public void setSetting(String s) {
        setting = s;
    }

    public void setPrompt(String p) {
        prompt = p;
    }

    public String toJSON() {
        String answer = "{\"Tone\": \"" + tone + "\", \"Recipient\": \"" + recipient + "\", \"Setting\": \"" + setting + "\", \"Prompt\": \"" + prompt + "\"}";
        return answer;

//        "{\"name\": \"Apple iPad Air\", \"data\": { \"Generation\": \"4th\", \"Price\": \"519.99\", \"Capacity\": \"256 GB\" }}"
    }
}
