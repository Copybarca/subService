package org.example.subService.model;

import jakarta.persistence.*;

import lombok.Data;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Data
@Table(name="user",schema = "calories",catalog = "caloriesManager")
@Component
@Scope("prototype")
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
    @OneToMany
    private List<Subscribe> subscribeList;

    /*@OneToMany(fetch = FetchType.LAZY)
    List<MealPlan> mealPlanList;*/

    @Deprecated
    public User() {
    }

    public User(String name, String email, int age) {
        this.name = name;
        this.email = email;
        this.age = age;
    }


}
