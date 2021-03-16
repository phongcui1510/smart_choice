package com.smartchoice.common.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomError {
    private LocalDateTime timestamp;
    private String message;
    private String details;
}
