/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package person;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author vasher
 */
public class Zillow {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try
        {
            // TODO code application logic here
            List<Person> persons = new ArrayList<>();
            persons.add(new Person(null, new Date("11/03/1986"), null, "Mason", new Double(5),
                    new Double(120)));
            persons.add(new Person("1222", new Date("10/01/1988"), "Jinisha", "Shah", new Double(7),
                    new Double(160)));
            persons.add(new Person("1112", new Date("07/05/1989"), "Vinit", "Asher", new Double(6),
                    new Double(200)));

            List<Person> sortedPersons = Persons.sort(persons, Persons.SortField.FIRST_NAME, Persons.SortOrder.DESCENDING);

            for (Person p : sortedPersons) {
                System.out.println(p.getFirstName() +" "+ p.getLastName() +" "+ p.getDateOfBirth() +" "+ p.getSsn()
                        +" "+ p.getHeightIn() +" "+ p.getWeightLb());
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
