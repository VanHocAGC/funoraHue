package com.example.funovahue.dto;

import com.example.funovahue.constant.GenderEnum;
import com.example.funovahue.constant.ProvinceEnum;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.transaction.Transactional;
import java.time.LocalDate;

@Data
public class SaveBlogDTO {
    @ApiModelProperty(hidden = true)
    private Long id;
    private String title;
    private String content;
    private LocalDate createdAt;
    private LocalDate updatedAt;
    private String facebookLink;
    private GenderEnum gender;
    private Integer salary;
    private ProvinceEnum location;
    private String requirement;
    private Integer cost;
    private String degree;
    private Integer age;
    private String workTime;
    private Integer amount;
    private Integer contractTerm;
    private String ceoTitle;
    private String metaTitle;
    private Long userId;
    private String career;
}
