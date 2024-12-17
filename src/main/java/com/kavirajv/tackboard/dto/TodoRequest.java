package com.kavirajv.tackboard.dto;

import lombok.Getter;

@Getter
public class TodoRequest {
    private Long id;
    private String title;
    private String description;
}
