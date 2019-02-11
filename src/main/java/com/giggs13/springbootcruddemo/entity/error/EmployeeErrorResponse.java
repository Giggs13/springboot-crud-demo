package com.giggs13.springbootcruddemo.entity.error;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class EmployeeErrorResponse {

    private int status;
    private String message;
    private long timeStamp;
}
