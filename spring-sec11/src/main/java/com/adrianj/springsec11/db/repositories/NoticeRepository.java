package com.adrianj.springsec11.db.repositories;

import com.adrianj.springsec11.db.entities.NoticeDetailEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoticeRepository extends JpaRepository<NoticeDetailEntity, Integer> {
}
