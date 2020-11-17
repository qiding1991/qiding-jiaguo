package com.qiding.jiaguo.content.type;

import com.qiding.jiaguo.content.NewContent;
import lombok.Data;

/**
 * 链接形式
 */
@Data
public class TextAndLink implements NewContent {
    private String text;
    private Long id;

    public TextAndLink(String text, Long id) {
        this.text = text;
        this.id = id;
    }
}
