package com.example.funovahue.entity;

import com.example.funovahue.constant.GenderEnum;
import com.example.funovahue.constant.ProvinceEnum;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Collection;

@Entity @Data @NoArgsConstructor @AllArgsConstructor
@Table(name="Users")
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String username;
    private String facebookLink;
    private String password;
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Collection<Blog> blogs;

    @ManyToOne
    @JoinColumn(name="role_id")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Role role;
}
