/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codazen;

import sorting.Mergesort;

/**
 *
 * @author vasher
 */
public class Codazen {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Student a = new Student("Jinisha","Shah", 25);
        Student f = new Student("Jinisha","Shah", 26);
        Student b = new Student("Priyanka", "Shah", 30);
        Student e = new Student("Priyanka", "Shah", 31);
        Student c = new Student("Vinit","Asher", 31);
        Student d = new Student("Vinit","Asher", 32);
      
        Course c1 = new Course();
//        c1.addStudent(a);
        c1.addStudent(b);
//        c1.addStudent(d);
//        c1.addStudent(f);
        c1.addStudent(e);
        Course c2 = new Course();
//        c2.addStudent(b);
//        c2.addStudent(c);
        c2.addStudent(a);
        c2.addStudent(d);
        c2.addStudent(f);
        
        Object[] c1Stu = (Object[]) Mergesort.sort(c1.getStudents().toArray(), new StudentComparator());
        Object[] c2Stu = (Object[]) Mergesort.sort(c2.getStudents().toArray(), new StudentComparator());
        
        int m = c1Stu.length;
        int n = c2Stu.length;
        int common = 0;
        for(int i=0, j=0; i<m && j<n;){
            int result = ((Student)c1Stu[i]).getId().compareToIgnoreCase(((Student)c2Stu[j]).getId());
            if(result == 0){
                common++;
                i++;
                j++;
            } else if(result < 0){
                i++;
            } else if(result > 0){
                j++;
            }
        }
        
        System.out.println(common);
        
    }
    
}
