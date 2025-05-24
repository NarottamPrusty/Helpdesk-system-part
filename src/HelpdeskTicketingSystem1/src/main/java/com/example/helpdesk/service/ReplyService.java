package com.example.helpdesk.service;

import com.example.helpdesk.model.Reply;
import com.example.helpdesk.model.Ticket;
import com.example.helpdesk.repository.ReplyRepository;
import com.example.helpdesk.repository.TicketRepository;
import com.example.helpdesk.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ReplyService {
    @Autowired
    private ReplyRepository replyRepository;

    @Autowired
    private TicketRepository ticketRepository;

    @Autowired
    private UserRepository userRepository;

    public Reply addReplyToTicket(Reply reply) {
        Ticket ticket = ticketRepository.findById(reply.getTicketId());
        if (ticket == null) {
            throw new IllegalArgumentException("Ticket not found.");
        }

        if (!userRepository.findAll().containsKey(reply.getUserId())) {
            throw new IllegalArgumentException("User ID does not exist.");
        }

        reply.setTimestamp(LocalDateTime.now());
        ticket.getReplies().add(reply);

        // If the ticket status is "Resolved" or "Closed", reopen it.
        if (ticket.getStatus().equalsIgnoreCase("Resolved") || ticket.getStatus().equalsIgnoreCase("Closed")) {
            ticket.setStatus("Open");
        }

        ticketRepository.save(ticket);
        return replyRepository.save(reply);
    }
}
