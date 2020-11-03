package com.qiding.jiaguo.mail;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class JMailData {
    private String receiver;
    private String title;
    private String content;
}
