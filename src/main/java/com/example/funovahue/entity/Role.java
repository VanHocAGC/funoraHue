package com.example.funovahue.entity;

import com.example.funovahue.constant.RoleEnum;
import lombok.*;


import javax.persistence.*;
import java.util.Collection;

@Entity @Data @AllArgsConstructor @NoArgsConstructor
public class Role {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private RoleEnum name;
    @OneToMany(mappedBy = "role", cascade=CascadeType.ALL)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Collection<Users> users;
}
