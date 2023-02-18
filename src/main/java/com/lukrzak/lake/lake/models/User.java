package com.lukrzak.lake.lake.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class User {

    public User(String login, String email) {
        this.login = login;
        this.email = email;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private Long id;
    private String login;
    private String email;
    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinTable(
            name = "users_teams",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "team_id")
    )
    @ToString.Exclude
    private Set<Team> teams = new HashSet<>();

    public void addUserToTeam(Team team){
        this.teams.add(team);
        team.getUsers().add(this);
    }

    public void removeUserFromTeam(Team team){
        this.teams.remove(team);
        team.getUsers().remove(this);
    }
}
