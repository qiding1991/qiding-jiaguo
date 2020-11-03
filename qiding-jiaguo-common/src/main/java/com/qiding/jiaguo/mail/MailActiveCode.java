package com.qiding.jiaguo.mail;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class MailActiveCode {
    private String activeCode;
    private String receiver;
}
