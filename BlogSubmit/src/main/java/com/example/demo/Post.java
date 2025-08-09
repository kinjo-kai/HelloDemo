package com.example.demo;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;

import lombok.Data;

@Entity
@Data
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // 主キー

    @Column(nullable = false)
    private String title; // 記事タイトル

    @Column(nullable = false, length = 5000)
    private String content; // 記事本文

    private LocalDateTime createdAt; // 作成日時

    @PrePersist
    public void prePersist() {
        createdAt = LocalDateTime.now();
    }
}
