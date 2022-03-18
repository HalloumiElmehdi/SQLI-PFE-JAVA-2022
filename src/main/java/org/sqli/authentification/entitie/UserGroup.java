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
    @Column(name = "id", nullable = false)
    private Long id;

    private String name;
}
