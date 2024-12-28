package com.example.intern.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.Date;

@Entity
public class Discount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Code must not be null or empty")
    @Column(unique = true)
    private String code;

    @NotNull(message = "ValidUntil must not be null")
    @Temporal(TemporalType.DATE)
    private Date validUntil;

    @NotNull(message = "Percentage must not be null")
    @Min(value = 1, message = "Percentage must be at least 1")
    @Max(value = 100, message = "Percentage must not exceed 100")
    private Integer percentage;

    // Default constructor
    public Discount() {}

    // Constructor with parameters
    public Discount(String code, Date validUntil, Integer percentage) {
        this.code = code;
        this.validUntil = validUntil;
        this.percentage = percentage;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Date getValidUntil() {
        return validUntil;
    }

    public void setValidUntil(Date validUntil) {
        this.validUntil = validUntil;
    }

    public Integer getPercentage() {
        return percentage;
    }

    public void setPercentage(Integer percentage) {
        this.percentage = percentage;
    }

    @Override
    public String toString() {
        return "Discount{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", validUntil=" + validUntil +
                ", percentage=" + percentage +
                '}';
    }
}
