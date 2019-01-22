package com.login.loginsys.dto;

public class ResultDTO {
    //getter + setter
    private String flow;
    private String status;
    private String errorMessage;

    public ResultDTO() {}

    public ResultDTO(String flow, String status, String errorMessage) {
        this.flow = flow;
        this.status = status;
        this.errorMessage = errorMessage;
    }

    public String getFlow() {
        return flow;
    }

    public void setFlow(String flow) {
        this.flow = flow;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    @Override
    public String toString() {
        return "Error Message: " +
                "Flow:'" + flow + ", Status:'" + status + ", Error:'" + errorMessage ;
    }
}
