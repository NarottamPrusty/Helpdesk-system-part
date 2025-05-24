package com.example.helpdesk.controller;

import com.example.helpdesk.TicketDTO;
import com.example.helpdesk.model.Role;
import com.example.helpdesk.model.Ticket;
import com.example.helpdesk.model.User;
import com.example.helpdesk.repository.TicketRepository;
import com.example.helpdesk.repository.UserRepository;
import com.example.helpdesk.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tickets")
public class TicketController {

    @Autowired
    private TicketRepository ticketRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtUtil jwtUtil;

    // Fetch tickets based on user role
    @GetMapping
    public ResponseEntity<List<Ticket>> getTickets(@RequestHeader("Authorization") String token) {
        String email = jwtUtil.extractEmail(token.substring(7)); // Remove "Bearer "
        User user = userRepository.findByEmail(email).orElseThrow();

        if (user.getRole() == Role.ADMIN) {
            return ResponseEntity.ok(ticketRepository.findAll()); // Admin gets all tickets
        }
        return ResponseEntity.ok(ticketRepository.findByUser(user)); // Users get only their tickets
    }

    // Create a new ticket
    @PostMapping
    public ResponseEntity<String> createTicket(@RequestHeader("Authorization") String token, @RequestBody TicketDTO ticketDTO) {
        String email = jwtUtil.extractEmail(token.substring(7));
        User user = userRepository.findByEmail(email).orElseThrow();

        Ticket ticket = new Ticket();
        ticket.setTitle(ticketDTO.getTitle());
        ticket.setDescription(ticketDTO.getDescription());
        ticket.setUser(user);

        ticketRepository.save(ticket);
        return ResponseEntity.ok("Ticket created successfully!");
    }

    // Admin can delete any ticket
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTicket(@PathVariable Integer id, @RequestHeader("Authorization") String token) {
        String email = jwtUtil.extractEmail(token.substring(7));
        User user = userRepository.findByEmail(email).orElseThrow();

        if (user.getRole() == Role.ADMIN) {
            ticketRepository.deleteById(id);
            return ResponseEntity.ok("Ticket deleted!");
        }
        return ResponseEntity.status(403).body("Permission denied.");
    }
}
