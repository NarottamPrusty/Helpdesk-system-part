package com.example.helpdesk.repository;

import com.example.helpdesk.model.Ticket;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class TicketRepository {
    private final Map<Integer, Ticket> tickets = new HashMap<>();

    public Ticket save(Ticket ticket) {
        tickets.put(ticket.getId(), ticket);
        return ticket;
    }

    public Ticket findById(int id) {
        return tickets.get(id);
    }

    public Map<Integer, Ticket> findAll() {
        return tickets;
    }

    public void deleteById(int id) {
        tickets.remove(id);
    }
}
