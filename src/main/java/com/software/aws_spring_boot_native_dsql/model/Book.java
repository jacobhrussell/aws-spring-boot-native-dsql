package com.software.aws_spring_boot_native_dsql.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.UUID;

@Data
@Entity
public class Book {
    @Id()
    @GeneratedValue()
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;
    private String title;
}
