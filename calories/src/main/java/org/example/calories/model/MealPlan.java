package org.example.calories.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;


@Table(name="meal_plan",schema = "calories",catalog = "caloriesManager")
@Getter
@Setter
@Entity
public class MealPlan {
    @Deprecated
    public MealPlan() {
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    @Column
    @Enumerated(EnumType.STRING)
    MealTime mealTime;
    @Column
    Date date;

    @ManyToOne(fetch = FetchType.EAGER)
    Dish dish;
    @ManyToOne(fetch = FetchType.EAGER)
    User user;

}
