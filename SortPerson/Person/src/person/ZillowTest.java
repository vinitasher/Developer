
package person;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class ZillowTest {

    @Test
    public void testForSSNValidations() {
        boolean thrown = false;
        try {
            List<Person> persons = new ArrayList<>();
            persons.add(new Person("123-495-8989", "01-01-0001", "Bob", "Mason", new Double(5),
                    new Double(120)));

        }
        catch (Exception ex) {
            thrown = true;
        }
        assertTrue(thrown);
    }

    @Test
    public void testForCorrectSortfield() {
        boolean thrown = false;
        try {
            List<Person> persons = new ArrayList<>();
            persons.add(new Person("123-49-8989", "01-01-0001", "Bob", "Mason", new Double(5),
                    new Double(120)));
            persons.add(new Person("122-49-8989", "10-01-1988", "Jinisha", "Shah", new Double(7),
                    new Double(160)));

            List<Person> sortedPersons = Persons.sort(persons, "fName", "ascending");
        }
        catch (Exception ex) {
            thrown = true;
        }
        assertTrue(thrown);
    }

    @Test
    public void testForCorrectSortOrder() {
        boolean thrown = false;
        try {
            List<Person> persons = new ArrayList<>();
            persons.add(new Person("123-49-8989", "01-01-0001", "Bob", "Mason", new Double(5),
                    new Double(120)));
            persons.add(new Person("122-49-8989", "10-01-1988", "Jinisha", "Shah", new Double(7),
                    new Double(160)));

            List<Person> sortedPersons = Persons.sort(persons, "fName", "random");
        }
        catch (Exception ex) {
            thrown = true;
        }
        assertTrue(thrown);
    }

    @Test
    public void testForCorrectSort() {

        try {
            List<Person> persons = new ArrayList<>();
            persons.add(new Person("123-49-8989", "01-01-0001", "Bob", "Mason", new Double(5),
                    new Double(120)));
            persons.add(new Person("122-49-8989", "10-01-1988", "Jinisha", "Shah", new Double(7),
                    new Double(160)));

            List<Person> sortedPersons = Persons.sort(persons, "heightIn", "descending");
            for (Person p : sortedPersons) {
                Double ht = p.getHeightIn();
                assertEquals(ht, new Double(7));
                break;
            }

        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

    }

}
