package com.alianazim.ms.product.service.strategy.concrete;

import com.alianazim.ms.product.client.OrderClient;
import com.alianazim.ms.product.client.TicketClient;
import com.alianazim.ms.product.dao.entity.CardEntity;
import com.alianazim.ms.product.dao.repository.CardRepository;
import com.alianazim.ms.product.model.client.response.CardResponse;
import com.alianazim.ms.product.model.enums.ProductType;
import com.alianazim.ms.product.service.strategy.abstraction.ProductStrategy;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import static com.alianazim.ms.product.mapper.factory.CardMapper.CARD_MAPPER;
import static com.alianazim.ms.product.model.enums.TicketStatus.DONE;

@Service
@RequiredArgsConstructor
public class CardProductStrategyHandler implements ProductStrategy {
    private final CardRepository cardRepository;
    private final OrderClient orderClient;
    private final TicketClient ticketClient;

    @Override
    public boolean supports(ProductType type) {
        return ProductType.CARD == type;
    }

    @SneakyThrows
    @Override
    public void execute(Long ticketId, Long orderId, String details) {
        var order = orderClient.getOrder(orderId);
        var cardResponse = new ObjectMapper().readValue(order.getDetails(), CardResponse.class);

        var cardEntity = CARD_MAPPER.buildCardEntity(order, cardResponse);
        cardRepository.save(cardEntity);
        orderClient.updateOrder(orderId, cardEntity.getId());

        ticketClient.updateTicket(ticketId, DONE);
    }
}

