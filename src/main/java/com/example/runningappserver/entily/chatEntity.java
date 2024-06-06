package com.example.runningappserver.entily;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class chatEntity {
    public static final int SEND = 0;
    //接收
    public static final int RECEIVE = 1;

    private String username;
    private String context;
    private int TYPE;

}
