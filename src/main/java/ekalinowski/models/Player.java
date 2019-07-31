package ekalinowski.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "players")
public class Player {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
	@NotNull
    private String name;
    private String description;
    private int score;


    public Player (long id, String name, String description, int score) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.score = score;
    }
    
    public Player () {

    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
    
    public String getDescription() {
        return description;
    }

    public int getScore() {
        return score;
    }
}
