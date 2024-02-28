package com.app.socailmedia.model;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;


@Data
@AllArgsConstructor
@ToString
public class User {
    Integer id;
    String userName;
    LocalDate localDate;
}
