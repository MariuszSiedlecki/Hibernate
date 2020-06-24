package src;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "persons")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String surname;

    @Column(name = "age_id_person")
    @Enumerated(EnumType.STRING)
    private AgeIdPerson ageIdPerson;

    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;

    public Person() {
    }

    public Person(String name, String surname, AgeIdPerson ageIdPerson, LocalDate dateOfBirth) {

        this.name = name;
        this.surname = surname;
        this.ageIdPerson = ageIdPerson;
        this.dateOfBirth = dateOfBirth;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public AgeIdPerson getAgeIdPerson() {
        return ageIdPerson;
    }

    public void setAgeIdPerson(AgeIdPerson ageIdPerson) {
        this.ageIdPerson = ageIdPerson;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", ageIdPerson=" + ageIdPerson +
                '}';
    }
}
