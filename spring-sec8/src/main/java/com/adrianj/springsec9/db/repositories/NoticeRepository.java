package com.adrianj.springsec9.db.repositories;

import com.adrianj.springsec9.db.entities.NoticeDetailEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoticeRepository extends JpaRepository<NoticeDetailEntity, Integer> {
}
