package org.sqli.authentification.entitie;


import lombok.*;
import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "userGroup")
public class UserGroup {

    @Id
    @Column(nullable = false, updatable = false)
    @SequenceGenerator(
            name = "PRIMARY_SEQUENCE_GEN",
            sequenceName = "PRIMARY_SEQUENCE",
            allocationSize = 1

    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "PRIMARY_SEQUENCE"

    )
    private Long id;

    private String name;
}
