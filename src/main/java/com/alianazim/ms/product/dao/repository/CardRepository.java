package com.alianazim.ms.product.dao.repository;

import com.alianazim.ms.product.dao.entity.CardEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardRepository extends JpaRepository<CardEntity, Long> {
}
