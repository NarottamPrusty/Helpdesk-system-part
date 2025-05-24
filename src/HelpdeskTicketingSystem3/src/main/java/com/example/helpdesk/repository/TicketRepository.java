package com.example.helpdesk.repository;

import com.example.helpdesk.model.Ticket;
import com.example.helpdesk.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Integer> {

    // ✅ Find all tickets assigned to a specific user
    List<Ticket> findByUser(User user);
}
