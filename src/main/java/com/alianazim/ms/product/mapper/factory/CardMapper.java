package com.alianazim.ms.product.mapper.factory;

import com.alianazim.ms.product.dao.entity.CardEntity;
import com.alianazim.ms.product.model.client.response.CardResponse;
import com.alianazim.ms.product.model.client.response.ProductResponse;

import java.util.Random;

import static com.alianazim.ms.product.model.enums.ProductType.CARD;
import static com.alianazim.ms.product.util.PanUtil.PAN_UTIL;

public enum CardMapper {
    CARD_MAPPER;

    public CardEntity buildCardEntity(ProductResponse order, CardResponse cardResponse) {
        return CardEntity.builder()
                .productType(order.getProductType())
                .pan(PAN_UTIL.primaryAccountNumberUtil())
                .productType(CARD)
                .holderName(cardResponse.getFullName())
                .cardType(cardResponse.getCardType())
                .cvv(String.valueOf(new Random().nextInt(900)))
                .expireDate(cardResponse.getExpireTime())
                .build();
    }
}
