package com.lukrzak.lake.lake.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "teams")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Team {

    public Team(String name, User admin) {
        this.name = name;
        this.admin = admin;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "team_id")
    private Long id;
    private String name;
    @ManyToMany(mappedBy = "teams")
    @ToString.Exclude
    private Set<User> users = new HashSet<>();
    @OneToOne
    @JoinColumn(name = "admin_id")
    private User admin;
}
