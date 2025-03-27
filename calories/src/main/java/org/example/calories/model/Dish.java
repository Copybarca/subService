package org.example.calories.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="dish",schema = "calories",catalog = "caloriesManager")
public class Dish {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String label;
    @Column
    private int calories_per_position;
    @Column
    private int proteins;
    @Column
    private int fats;
    @Column
    private int carbohydrates;
    @Deprecated
    public Dish() {
    }



}
