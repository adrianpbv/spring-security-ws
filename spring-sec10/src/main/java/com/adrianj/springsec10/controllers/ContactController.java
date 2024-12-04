package com.adrianj.springsec10.controllers;

import com.adrianj.springsec10.db.entities.ContactMessageEntity;
import com.adrianj.springsec10.db.repositories.ContactRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.Random;

@RestController
@RequiredArgsConstructor
public class ContactController {

    private final ContactRepository contactRepository;

    @PostMapping("/contact")
    public ContactMessageEntity saveContactInquiryDetails(@RequestBody ContactMessageEntity contact) {
        contact.setContactId(getServiceReqNumber());
        contact.setCreateDt(LocalDate.now());
        return contactRepository.save(contact);
    }

    public String getServiceReqNumber() {
        Random random = new Random();
        int ranNum = random.nextInt(999999999 - 9999) + 9999;
        return "SR" + ranNum;
    }
}
