package com.example.Quiz.businesslayer;

public class ServerAnswers {

    private boolean success;
    private String feedback;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public ServerAnswers(boolean success, String feedback) {
        this.success = success;
        this.feedback = feedback;
    }
}
