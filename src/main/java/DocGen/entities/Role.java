package DocGen.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by alloyer on 11.01.2018.
 */
@Entity
public class Role {

    @Id
    @GeneratedValue
    private Long id;
    String name;

    Role() {}

    public Role(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}