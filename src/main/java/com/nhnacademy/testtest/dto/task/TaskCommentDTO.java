package com.nhnacademy.testtest.dto.task;

import com.nhnacademy.testtest.dto.comment.CommentDto;
import com.nhnacademy.testtest.entity.Comment;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class  TaskCommentDTO {

    private String title;
    private String content;
    private String milestoneName;
    private String tagName;
    private List<CommentDto> comments = new ArrayList<>();

    public TaskCommentDTO(String title, String content, String milestoneName, String tagName) {
        this.title = title;
        this.content = content;
        this.milestoneName = milestoneName;
        this.tagName = tagName;
    }
}
