/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

import java.util.Date;

/**
 *
 * @author PC
 */
public class ReplyDTO {
    private int replyID;
    private int accountID;
    private String body;
    private Date createTime;
    private int feedbackID;

    public ReplyDTO() {
    }

    public ReplyDTO(int replyID, int accountID, String body, Date createTime, int feedbackID) {
        this.replyID = replyID;
        this.accountID = accountID;
        this.body = body;
        this.createTime = createTime;
        this.feedbackID = feedbackID;
    }

    public int getReplyID() {
        return replyID;
    }

    public void setReplyID(int replyID) {
        this.replyID = replyID;
    }

    public int getAccountID() {
        return accountID;
    }

    public void setAccountID(int accountID) {
        this.accountID = accountID;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public int getFeedbackID() {
        return feedbackID;
    }

    public void setFeedbackID(int feedbackID) {
        this.feedbackID = feedbackID;
    }
    
    
}
