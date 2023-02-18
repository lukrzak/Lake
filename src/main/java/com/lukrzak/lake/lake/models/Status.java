package com.lukrzak.lake.lake.models;

import com.lukrzak.lake.lake.enumerations.StatusEnumeration;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "status")
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
public class Status {

    public Status(StatusEnumeration status, User user, Event event) {
        this.status = status;
        this.user = user;
        this.event = event;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "status_id")
    private Long id;
    @Enumerated(EnumType.STRING)
    private StatusEnumeration status;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @ManyToOne
    @JoinColumn(name = "event_id")
    private Event event;

}
