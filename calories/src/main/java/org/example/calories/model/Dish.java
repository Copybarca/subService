package org.example.calories.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Size;
import java.util.List;

@Data
@Entity
@Table(name="dish",schema = "calories",catalog = "caloriesManager")
public class Dish {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column()
    @Size(min = 1,max = 20, message = "In range of 1 to 30 characters")
    private String label;
    @Column
    @Size(min = 1,max = 20, message = "In range of 1 to 20 characters")
    private int calories_per_position;
    @Column
    @Size(min = 1,max = 20, message = "In range of 1 to 10 characters")
    private int proteins;
    @Column
    @Size(min = 1,max = 20, message = "In range of 1 to 10 characters")
    private int fats;
    @Column
    @Size(min = 1,max = 20, message = "In range of 1 to 10 characters")
    private int carbohydrates;
    /*@OneToMany(fetch = FetchType.LAZY)
    List<MealPlan> mealPlanList;*/

    @Deprecated
    public Dish() {
    }



}
