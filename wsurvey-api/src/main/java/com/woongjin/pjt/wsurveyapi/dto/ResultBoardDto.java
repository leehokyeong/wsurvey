package com.woongjin.pjt.wsurveyapi.dto;

import lombok.Data;

@Data
public class ResultBoardDto {
    String title;
    String content;
    String writer;
    String isContentOpenYn;
}
