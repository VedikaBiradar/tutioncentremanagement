package com.vedikabiradar.sba_html_css_js.Entity;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Child {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long childId;
    private String childName;
    private LocalDate dob;
    private String medicalInfo;
    private String photoUrl;
    private String gender;
    private String standard;

    @ManyToOne
    @JoinColumn(name = "parent_id")
    private  User user;

    // Getters and Setters

    public int getAge() {
        return LocalDate.now().getYear() - dob.getYear();
    }
}