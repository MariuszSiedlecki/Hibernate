package src.training2RelationshipsBetweenEntities;

import src.training2RelationshipsBetweenEntities.model.Backpack;
import src.training2RelationshipsBetweenEntities.model.Book;
import src.training2RelationshipsBetweenEntities.model.Doctor;
import src.training2RelationshipsBetweenEntities.model.Person;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        //DTO
        Dao<Backpack> backpackDao = new Dao<>();
        Dao<Person> personDao = new Dao<>();
        Dao<Book> bookDao = new Dao<>();
        Dao<Doctor> doctorDao = new Dao<>();

        //Create Book
        Book book1 = new Book();
        book1.setTitle("Pan Tadeusz");
        bookDao.save(book1);

        Book book2 = new Book();
        book2.setTitle("Dziady");
        bookDao.save(book2);

        //Create Backpack
        Backpack backpackAdidas = new Backpack();
        backpackAdidas.setBrand("Adidas");
        backpackAdidas.setBookSet(Stream.of(book1, book2).collect(Collectors.toSet()));
        backpackDao.save(backpackAdidas);

        Backpack backpackLacosta = new Backpack();
        backpackLacosta.setBrand("Lacosta");
        backpackDao.save(backpackLacosta);

        //Create Person
        Person personMariusz = new Person("Mariusz", "Nowak", AgeIdPerson.BABY_0);
        personMariusz.setBackpack(backpackAdidas);
        personDao.save(personMariusz);

        Person personKamil = new Person("Kamil", "Kowalski", AgeIdPerson.CHILD_1);
        personKamil.setBackpack(backpackLacosta);
        personDao.save(personKamil);

        //Create Doctors

        Doctor doctorMałgorzata = new Doctor("Małgorzata", "Kowalska", "dr");
        Doctor doctorMichał = new Doctor("Michał", "Kowalska", "Proffessor");

        doctorMałgorzata.setPersonSet(Stream.of(personMariusz, personKamil).collect(Collectors.toSet()));
        doctorMałgorzata.setPersonSet(Stream.of(personKamil).collect(Collectors.toSet()));

        personDao.save(personMariusz);
        personDao.save(personKamil);

        doctorDao.save(doctorMałgorzata);
        doctorDao.save(doctorMichał);
    }
}
