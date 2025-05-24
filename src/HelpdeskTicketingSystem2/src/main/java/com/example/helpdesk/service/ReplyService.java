package com.example.helpdesk.service;

import com.example.helpdesk.model.Reply;
import com.example.helpdesk.repository.ReplyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ReplyService {
    @Autowired
    private ReplyRepository replyRepository;

    public Reply addReplyToTicket(Reply reply) {
        reply.setTimestamp(LocalDateTime.now());
        return replyRepository.save(reply);
    }
}
