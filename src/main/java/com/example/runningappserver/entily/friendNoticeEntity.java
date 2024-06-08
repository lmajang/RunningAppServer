package com.example.runningappserver.entily;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class friendNoticeEntity {
    String noticeId;
    String senderId;
    String sender_hp_id;
    String sender_username;
    String sender_message;
}
