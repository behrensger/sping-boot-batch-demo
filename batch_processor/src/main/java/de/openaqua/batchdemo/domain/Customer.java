package de.openaqua.batchdemo.domain;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@Entity
@Getter
@Setter
public class Customer {
    @Id
    private Long id;
    private String name;
    private String email;
    private String type;
}
