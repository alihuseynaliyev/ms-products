package com.alianazim.ms.product.dao.entity;

import com.alianazim.ms.product.model.enums.CardType;
import com.alianazim.ms.product.model.enums.ProductType;
import lombok.Builder;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Builder
@Table(name = "cards")
public class CardEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private ProductType productType;

    private String holderName;
    private String pan;

    @Enumerated(EnumType.STRING)
    private CardType cardType;
    private String cvv;
    private String expireDate;

}
