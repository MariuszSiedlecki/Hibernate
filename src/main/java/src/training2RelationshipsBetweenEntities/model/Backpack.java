package src.training2RelationshipsBetweenEntities.model;


import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "backpacks")
public class Backpack {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String brand;
    @OneToMany
    @JoinColumn(name = "backpack_id")
    private Set<Book> bookSet;


    public Backpack() {
    }

    public Backpack(Long id, Set<Book> bookSet) {
        this.id = id;
        this.bookSet = bookSet;
    }

    public Set<Book> getBookSet() {
        return bookSet;
    }

    public void setBookSet(Set<Book> bookSet) {
        this.bookSet = bookSet;
    }

    public Backpack(String brand) {
        this.brand = brand;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Override
    public String toString() {
        return "Backpack{" +
                "id=" + id +
                ", brand='" + brand + '\'' +
                ", bookSet=" + bookSet +
                '}';
    }
}
