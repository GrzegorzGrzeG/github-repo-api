package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.Map;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Branch {
    @JsonProperty("name")
    private String name;

    private String sha;

    @JsonProperty("commit")
    private void unpackSha(Map<String,Object> sha){
        this.sha = (String)sha.get("sha");
    }





}
