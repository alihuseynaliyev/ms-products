package com.alianazim.ms.product.model.client.response;

import com.alianazim.ms.product.model.enums.TicketStatus;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TicketResponse {
    private Long ticketId;
    private Long orderId;
    private TicketStatus ticketStatus;
}
