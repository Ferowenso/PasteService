package com.example.pasteservice.dtos;

import com.example.pasteservice.models.Access;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PasteDto {

    private String content;

    @Enumerated(EnumType.ORDINAL)
    private Access access;

}
