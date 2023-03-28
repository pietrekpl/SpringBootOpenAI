package com.example.springbootopenai.chatGpt.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserResponse implements Serializable {
    private String message;
}
