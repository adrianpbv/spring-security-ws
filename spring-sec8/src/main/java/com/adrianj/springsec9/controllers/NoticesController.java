package com.adrianj.springsec9.controllers;

import com.adrianj.springsec9.db.entities.NoticeDetailEntity;
import com.adrianj.springsec9.db.repositories.NoticeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.CacheControl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.TimeUnit;

@RestController
@RequiredArgsConstructor
public class NoticesController {

    private final NoticeRepository noticeRepository;

    @GetMapping("/notices")
    public ResponseEntity<List<NoticeDetailEntity>> getNotices() {
        List<NoticeDetailEntity> notices = noticeRepository.findAll();
        if (!notices.isEmpty()) {
            return ResponseEntity.ok()
                    .cacheControl(CacheControl.maxAge(60, TimeUnit.SECONDS))
                    .body(notices);
        } else {
            return null;
        }
    }

}
