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
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "status_id")
    private Long id;
    private StatusEnumeration status;

}
