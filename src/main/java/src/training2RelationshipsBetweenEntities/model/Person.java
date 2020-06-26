package src.training2RelationshipsBetweenEntities.model;

import src.training2RelationshipsBetweenEntities.AgeIdPerson;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "persons2")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    public String name;
    public String surname;

    @Column(name = "age_id_person")
    @Enumerated(EnumType.STRING)
    public AgeIdPerson ageIdPerson;

    @OneToOne
    public Backpack backpack;

    @ManyToMany(mappedBy = "personSet")
    private Set<Doctor> doctorSet;

    public Set<Doctor> getDoctorSet() {
        return doctorSet;
    }

    public void setDoctorSet(Set<Doctor> doctorSet) {
        this.doctorSet = doctorSet;
    }

    public Person() {
    }

    public Person(String name, String surname, AgeIdPerson ageIdPerson) {
        this.name = name;
        this.surname = surname;
        this.ageIdPerson = ageIdPerson;

    }

    public Backpack getBackpack() {
        return backpack;
    }

    public void setBackpack(Backpack backpack) {
        this.backpack = backpack;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
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
                "Id=" + Id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", ageIdPerson=" + ageIdPerson +
                ", backpack=" + backpack +
                '}';
    }
}
