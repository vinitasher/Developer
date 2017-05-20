/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package person;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author vasher
 */
public class Persons {
    
    public static int order;

    enum SortOrder {
        ASCENDING,
        DESCENDING
    }
    
    enum SortField {
        SSN,
        DATE_OF_BIRTH,
        FIRST_NAME,
        LAST_NAME,
        HEIGHT_IN,
        WEIGHT_LB
    }
    
    static List<Person> sort(Iterable<Person> people, final Persons.SortField sortField, Persons.SortOrder sortOrder){
        List<Person> peopleList = new ArrayList<>();
        for(Person p : people){
            peopleList.add(p);
        }
        order = 1;
        if(sortOrder.equals(Persons.SortOrder.DESCENDING)){
            order = -1;
        }
        Collections.sort(peopleList, new Comparator<Person>(){
            @Override
            public int compare(Person p1, Person p2){
                int sort = 1;
                switch(sortField){
                    case SSN:
                        sort = p1.getSsn().compareToIgnoreCase(p2.getSsn())*order;
                        break;
                    case FIRST_NAME:
                        sort = p1.getFirstName().compareToIgnoreCase(p2.getFirstName())*order;
                        break;
                    case LAST_NAME:
                        sort = p1.getLastName().compareToIgnoreCase(p2.getLastName())*order;
                        break;
                    case HEIGHT_IN:
                        sort = p1.getHeightIn().compareTo(p2.getHeightIn())*order;
                        break;
                    case WEIGHT_LB:
                        sort = p1.getWeightLb().compareTo(p2.getWeightLb())*order;
                        break;
                    case DATE_OF_BIRTH:
                        sort = p1.getDateOfBirth().compareTo(p2.getDateOfBirth())*order;
                        break;
                }
                return sort;
            }
        });
        return peopleList;
    }
    
}
