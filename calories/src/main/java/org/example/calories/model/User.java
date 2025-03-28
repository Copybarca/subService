package org.example.calories.model;

import jakarta.persistence.*;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name="user",schema = "calories",catalog = "caloriesManager")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;
    @Column()
    @Size(min = 1,max = 20, message = "In range of 1 to 10 characters")
    private String name;
    @Column()
    @Size(min = 1,max = 30, message = "In range of 1 to 10 characters")
    private String email;
    @Column()
    @Size(min = 1,max = 4, message = "In range of 1 to 10 characters")
    private int age;
    @Column()
    @Size(min = 1,max = 4, message = "In range of 1 to 10 characters")
    private int weight;
    @Column()
    @Size(min = 1,max = 4, message = "In range of 1 to 10 characters")
    private int height;
    @Column()
    @Enumerated(EnumType.STRING)
    private Target target;
    @Column
    private double calorie_intake;

    /*@OneToMany(fetch = FetchType.LAZY)
    List<MealPlan> mealPlanList;*/



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
