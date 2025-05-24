package com.example.helpdesk;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TicketDTO {
    @NotBlank
    private String title;

    @NotBlank
    private String description;
}
