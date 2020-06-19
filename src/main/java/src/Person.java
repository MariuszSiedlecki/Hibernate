package src;

import javax.persistence.*;

@Entity
@Table(name = "persons")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String surname;

    @Column(name = "age_id")
    private String ageId;

    public Person() {
    }

    public Person( String name, String surname, String ageId) {

        this.name = name;
        this.surname = surname;
        this.ageId= ageId;
    }

    public Long getId() {
        return id;
    }

    public String getAgeId() {
        return ageId;
    }

    public void setAgeId(String ageId) {
        this.ageId = ageId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Override
    public String toString() {
        return "Person{" +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", ageId='" + ageId + '\'' +
                '}';
    }
}
