package com.thescenius.alp.model.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class WordDTO {
    private String title;
    private String imageURL;
    private String meaning;

    // getters and setters
}
