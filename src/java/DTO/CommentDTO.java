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
public class CommentDTO {
    public int commentID;
    public String body;
    public int react;
    public Date createTime;
    public int blogID;
    public int accountID;

    public CommentDTO() {
    }

    public CommentDTO(int commentID, String body, int react, Date createTime, int blogID, int accountID) {
        this.commentID = commentID;
        this.body = body;
        this.react = react;
        this.createTime = createTime;
        this.blogID = blogID;
        this.accountID = accountID;
    }

    public int getCommentID() {
        return commentID;
    }

    public void setCommentID(int commentID) {
        this.commentID = commentID;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public int getReact() {
        return react;
    }

    public void setReact(int react) {
        this.react = react;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public int getBlogID() {
        return blogID;
    }

    public void setBlogID(int blogID) {
        this.blogID = blogID;
    }

    public int getAccountID() {
        return accountID;
    }

    public void setAccountID(int accountID) {
        this.accountID = accountID;
    }
    
    
}
