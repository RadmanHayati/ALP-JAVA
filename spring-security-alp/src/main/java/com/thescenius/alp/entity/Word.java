package com.thescenius.alp.entity;


import com.thescenius.alp.entity.token.TokenType;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Word {

    @Id
    @GeneratedValue
    public Integer id;
    @NotNull
    public String title;
    private String imageURL;
    public String meaning;
    private Date createdDate;
    private Date updateDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    public User user;

    public Word(User user, String title, String meaning) {
        this.user = user;
        this.title = title;
        this.meaning = meaning;
        this.createdDate = new Date();
    }
}