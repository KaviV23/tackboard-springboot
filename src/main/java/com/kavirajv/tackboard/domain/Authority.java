package com.kavirajv.tackboard.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Entity
public class Authority  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Getter
    private String authority;
    @ManyToOne
    private User user;

    public Authority(String authority) {
        this.authority = authority;
    }
}
