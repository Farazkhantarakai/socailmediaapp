package com.app.socailmedia.model;

import java.time.LocalDate;

import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@AllArgsConstructor
@ToString
public class User {

    Integer id;
    @Size(min = 2, message = "Name should be at least 2 characters")
    String userName;

    @Past(message = "birthdate should be in the past")
    LocalDate localDate;
}
