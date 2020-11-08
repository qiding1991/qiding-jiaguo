package com.qiding.jiaguo.content.type;

import com.qiding.jiaguo.content.NewContent;
import lombok.Data;

/**
 * 链接形式
 */
@Data
public class TextAndLink implements NewContent {
    private String text;

    public TextAndLink(String text) {
        this.text = text;
    }
}
