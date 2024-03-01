package com.app.socailmedia.Exception;
import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorDetails {
    private LocalDate  timeStamp;
    private String messgae;
    private String details;

}
