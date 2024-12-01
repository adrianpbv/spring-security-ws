package com.adrianj.springsec9.controllers;

import com.adrianj.springsec9.db.entities.CardEntity;
import com.adrianj.springsec9.db.repositories.CardsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CardsController {

    private final CardsRepository cardsRepository;

    @GetMapping("/myCards")
    public List<CardEntity> getCardDetails(@RequestParam Integer id) {
        List<CardEntity> cards = cardsRepository.findByCustomer(id);
        if (!cards.isEmpty()) {
            return cards;
        } else {
            return null;
        }
    }

}
