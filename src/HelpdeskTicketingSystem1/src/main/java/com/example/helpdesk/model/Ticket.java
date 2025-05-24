package com.example.helpdesk.model;

import java.util.ArrayList;
import java.util.List;

public class Ticket {
    private int id;
    private String title;
    private String status; // Open, Resolved, Closed
    private int userId;
    private List<Reply> replies = new ArrayList<>();

    // Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public int getUserId() { return userId; }
    public void setUserId(int userId) { this.userId = userId; }

    public List<Reply> getReplies() { return replies; }
    public void setReplies(List<Reply> replies) { this.replies = replies; }
}
