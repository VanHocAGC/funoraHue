package com.example.funovahue.entity;


import com.example.funovahue.constant.GenderEnum;
import com.example.funovahue.constant.ProvinceEnum;
import com.example.funovahue.dto.SaveBlogDTO;
import lombok.*;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity @Data @AllArgsConstructor @NoArgsConstructor
@Table(name="Blogs")
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String content;
    private LocalDate createdAt;
    @Nullable
    private LocalDate updatedAt;
    @Nullable
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
    @Column(nullable = false, length = 64)
    private String photos;

    private String career;
    @ManyToOne
    @JoinColumn(name="users_id")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Users user;

    @Transient
    public String getPhotoPath(){
        if(photos==null || id==null){
            return null;
        }
        return "/blog-photos/" + id + "/" + photos;
    }
    @Transient
    public Blog(SaveBlogDTO blogdto, Users user, String photor){
        setId(null);
        setTitle(blogdto.getTitle());
        setContent(blogdto.getContent());
        setCreatedAt(blogdto.getCreatedAt());
        setUpdatedAt(blogdto.getUpdatedAt());
        setFacebookLink(blogdto.getFacebookLink());
        setGender(blogdto.getGender());
        setSalary(blogdto.getSalary());
        setLocation(blogdto.getLocation());
        setRequirement(blogdto.getRequirement());
        setCost(blogdto.getCost());
        setDegree(blogdto.getDegree());
        setAge(blogdto.getAge());
        setWorkTime(blogdto.getWorkTime());
        setAmount(blogdto.getAmount());
        setContractTerm(blogdto.getContractTerm());
        setCeoTitle(blogdto.getCeoTitle());
        setMetaTitle(blogdto.getMetaTitle());
        setMetaTitle(photor);
        setCareer(blogdto.getCareer());
        setUser(user);
    }
}
