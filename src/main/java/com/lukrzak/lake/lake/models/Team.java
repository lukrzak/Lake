package com.lukrzak.lake.lake.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "teams")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "team_id")
    private Long id;
    private String name;

}
