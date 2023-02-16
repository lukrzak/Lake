package com.lukrzak.lake.lake.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Table(name = "events")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "event_id")
    private Long id;
    private Date startDate;
    private Date endDate;
    private String title;
    private String description;

}
