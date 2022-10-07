package com.example.goGreen.repository;

import com.example.goGreen.business.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository <Item, Long> {
}
