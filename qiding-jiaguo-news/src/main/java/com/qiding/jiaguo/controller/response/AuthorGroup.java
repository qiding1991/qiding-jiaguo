package com.qiding.jiaguo.controller.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AuthorGroup {
    private String groupName;
    private Integer groupId;
    private List<AuthorProfile>  authorList;
}
