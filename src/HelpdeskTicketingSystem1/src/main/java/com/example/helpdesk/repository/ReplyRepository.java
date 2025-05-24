package com.example.helpdesk.repository;

import com.example.helpdesk.model.Reply;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ReplyRepository {
    private final List<Reply> replies = new ArrayList<>();

    public Reply save(Reply reply) {
        replies.add(reply);
        return reply;
    }

    public List<Reply> findAll() {
        return replies;
    }
}
