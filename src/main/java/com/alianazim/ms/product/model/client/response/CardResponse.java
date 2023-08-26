package com.alianazim.ms.product.model.client.response;

import com.alianazim.ms.product.model.enums.CardType;
import lombok.Data;

@Data
public class CardResponse {
    private String fullName;
    private CardType cardType;
    private String expireTime;
}
