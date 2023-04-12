package com.vky.graphql.model;


import lombok.Data;

@Data
public class UserProfileInput {
    Long authid;
    String userName;
    String name;
    String surName;
    String email;
}
