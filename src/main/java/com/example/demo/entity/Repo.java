package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.*;

import java.util.List;
import java.util.Map;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonPropertyOrder({"name", "login"})
public class Repo {

    @JsonProperty("name")
    private String name;

    private String login;

    @JsonIgnore
    @JsonProperty("fork")
    private boolean fork;

    private List<Branch> branches;


    @JsonProperty("owner")
    private void unpackSha(Map<String,Object> login){
        this.login = (String)login.get("login");
    }
}
