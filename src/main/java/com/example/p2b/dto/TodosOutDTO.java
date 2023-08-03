package com.example.p2b.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class TodosOutDTO {
    private Long tdId;
    private String tdTitle;
    private String tdContent;
    private LocalDateTime tdStartDate;
    private LocalDateTime tdEndDate;
}
