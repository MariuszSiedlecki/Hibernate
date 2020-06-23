package src.training1;

import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {

        PersonDao personDao = new PersonDao();
        personDao.save(new Person("Jan", "Kowalski", AgeIdPerson.CHILD_1, LocalDate.of(2019, 01, 22)));
        System.out.println(personDao.get(1L));
        personDao.save(new Person("Mariusz", "Kowalski", AgeIdPerson.ADULT_3, LocalDate.of(1978, 01, 22)));
        personDao.delete(1L);
        personDao.update(2L, new Person("Mariusz", "Kowalski", AgeIdPerson.OLD_4, LocalDate.of(1978, 01, 22)));
        System.out.println(personDao.get(2L));
    }
}
