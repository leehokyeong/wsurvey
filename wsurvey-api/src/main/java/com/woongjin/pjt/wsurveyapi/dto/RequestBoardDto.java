package com.woongjin.pjt.wsurveyapi.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Data
public class RequestBoardDto {

    @NotBlank(message = "제목은 필수입력")
    String title;

    @NotBlank(message = "내용은 필수입력")
    String content;

    @NotBlank(message = "작성자는 필수입력")
    String writer;

    @Pattern(regexp = "true|false", message = "글공개여부는 'true' or 'false' 만 허용")
    String isContentOpenYn;

}
