package test.models;

import org.hibernate.annotations.Type;

import javax.persistence.*;

/**
 * Created by N.Babenkov on 25.06.2018.
 **/
@Entity
public class Drink {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "drinksSequence")
    @SequenceGenerator(name="drinksSequence",sequenceName="DRINKS_SEQ")
    @Column(name="id", nullable=false)
    private int id;

    @Column(name="cost", nullable=false, precision=7, scale=2)
    private int cost;

    @Column(name="name", nullable=false, length=50, unique = true)
    private String name;

    @Column(name="contains_alcohol", nullable=false)
    @Type(type="yes_no")
    private boolean containsAlcohol;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isContainsAlcohol() {
        return containsAlcohol;
    }

    public void setContainsAlcohol(boolean containsAlcohol) {
        this.containsAlcohol = containsAlcohol;
    }
}
