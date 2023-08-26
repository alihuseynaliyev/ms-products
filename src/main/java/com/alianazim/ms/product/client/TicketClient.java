package com.alianazim.ms.product.client;

import com.alianazim.ms.product.model.client.response.TicketResponse;
import com.alianazim.ms.product.model.enums.TicketStatus;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

@FeignClient(name = "ms-ticket", url = "http://localhost:8082/v1/tickets")
public interface TicketClient {

    @GetMapping("/{ticketId}")
    TicketResponse getTicket(@PathVariable Long ticketId);
    @PutMapping("/{ticketId}/status/{status}")
    void updateTicket(@PathVariable Long ticketId, @PathVariable TicketStatus status);
}
