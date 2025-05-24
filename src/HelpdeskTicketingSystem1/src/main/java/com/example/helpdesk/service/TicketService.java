package com.example.helpdesk.service;

import com.example.helpdesk.model.Reply;
import com.example.helpdesk.model.Ticket;
import com.example.helpdesk.repository.TicketRepository;
import com.example.helpdesk.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketService {
    @Autowired
    private TicketRepository ticketRepository;

    @Autowired
    private UserRepository userRepository;

    public Ticket createTicket(Ticket ticket) {
        if (!userRepository.findAll().containsKey(ticket.getUserId())) {
            throw new IllegalArgumentException("User ID does not exist.");
        }
        ticket.setStatus("Open");
        return ticketRepository.save(ticket);
    }

    public List<Ticket> getAllTickets() {
        return ticketRepository.findAll().values().stream().toList();
    }

    public Ticket getTicketById(int id) {
        Ticket ticket = ticketRepository.findById(id);
        if (ticket == null) {
            throw new IllegalArgumentException("Ticket not found.");
        }
        return ticket;
    }

    public Ticket updateTicketStatus(int ticketId, String status) {
        Ticket ticket = ticketRepository.findById(ticketId);
        if (ticket == null) {
            throw new IllegalArgumentException("Ticket not found.");
        }
        ticket.setStatus(status);
        return ticketRepository.save(ticket);
    }
}
