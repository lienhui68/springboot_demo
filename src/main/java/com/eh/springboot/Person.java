package com.eh.springboot;

import lombok.Data;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Email;
import java.util.Date;
import java.util.List;
import java.util.Map;

@ToString
@Data
@Component
@ConfigurationProperties(prefix = "person")
@Validated
public class Person {
    private String lastName;
    private Integer age;
    private Date birth;
    private Map<String, Pet> pets;
    private List<String> animals;
    private List<String> interests;
    private List<Object> friends;
    private List<Map<String, Child>> children;
    @Email
    private String email;
}


@Data
@ToString
class Pet {
    private String name;
    private String gender;
}

@Data
@ToString
class Child {
    private String name;
    private int age;
    private List<Pet> pets;
}