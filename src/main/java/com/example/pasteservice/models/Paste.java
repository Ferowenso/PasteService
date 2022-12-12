package com.example.pasteservice.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Paste {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String hash;

    private String content;

    private LocalDateTime createdAt;

    private LocalDateTime validUntil;

    @Enumerated(EnumType.ORDINAL)
    private Access access;

}
