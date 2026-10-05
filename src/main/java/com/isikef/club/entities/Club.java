package com.isikef.club.entities;
import jakarta.persistence.* ;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "clubs")
@Getter
@Setter
public class Club
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false,length = 30, unique = true)
    private String name;
    @Column(columnDefinition = "TEXT")
    private String description;
    @Column(name = "create_date", updatable = false)
    private LocalDateTime createDate;

    @Column(name = "update_date")
    private LocalDateTime updateDate;

}
