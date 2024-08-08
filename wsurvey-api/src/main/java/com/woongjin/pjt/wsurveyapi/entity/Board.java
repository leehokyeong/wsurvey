package com.woongjin.pjt.wsurveyapi.entity;

import lombok.Data;

@Data
public class Board {
    //향후 entity 로 활용
    String title;
    String content;
    String writer;
    String isContentOpenYn;

}
