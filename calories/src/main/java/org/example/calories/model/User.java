package org.example.calories.model;

import jakarta.persistence.*;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column()
    private String name;
    @Column()
    private String email;
    @Column()
    private int age;
    @Column()
    private int weight;
    @Column()
    private int height;
    @Column()
    @Enumerated(EnumType.STRING)
    private Target target;
    @Column
    private double calorie_intake;
    @Deprecated
    public User() {
    }
    public User(String name, String email, int age, int weight, int height, Target target) {
        this.name = name;
        this.email = email;
        this.age = age;
        this.weight = weight;
        this.height = height;
        this.target = target;
        this.calorie_intake = AppliedCalculation.BenedictHarrisCalculation(weight,height,age);
    }
}
