package com.example.funovahue.entity;


import com.example.funovahue.constant.GenderEnum;
import com.example.funovahue.constant.ProvinceEnum;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Entity @Data @AllArgsConstructor @NoArgsConstructor
@Table(name="Blogs")
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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
    private String photos;
    @Column(nullable = false, length = 64)
    private String career;
    @ManyToOne
    @JoinColumn(name="users_id")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Users user;

}
