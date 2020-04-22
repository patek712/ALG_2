/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comparingstudents;

import comparingstudents.mycomparing.CompareInterface;
import java.util.Objects;

/**
 *
 * @author vojta
 */
public class Student implements CompareInterface, Comparable {
    private String firstName;
    private String lastName;
    private int studentNumber;
    //TODO 23.4. pole znamek, metoda na pridani znamek,vypoctu prumeru 
    private double[] grades;

    public Student(String firstName, String lastName, int studentNumber, double... grades) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.studentNumber = studentNumber;
        this.grades = grades;
    }

   

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setStudentNumber(int studentNumber) {
        this.studentNumber = studentNumber;
    }

    public void setGrades(double[] grades) {
        this.grades = grades;
    }

    @Override
    public String toString() {
        return String.format("%10s%10s%10d",firstName,lastName,studentNumber);
    }

    boolean isBigger(Student student) {
        return this.studentNumber > student.studentNumber;
    }

    @Override
    public boolean isBigger(CompareInterface o) {
       return this.studentNumber > ((Student)o).studentNumber;
    }

    @Override
    public int compareTo(Object o) {
        return this.studentNumber - ((Student)o).studentNumber;
    }
    //pri zmene equals zmenit i hashCode
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.firstName);
        hash = 97 * hash + Objects.hashCode(this.lastName);
        hash = 97 * hash + this.studentNumber;
        return hash;
    }
    //default in Object
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Student other = (Student) obj;
        if (this.studentNumber != other.studentNumber) {
            return false;
        }
        if (!Objects.equals(this.firstName, other.firstName)) {
            return false;
        }
        if (!Objects.equals(this.lastName, other.lastName)) {
            return false;
        }
        return true;
    }

    public int getStudentNumber() {
        return studentNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
    
    public double getAverage() {
        double s = 0;
        for (int i = 0; i < grades.length; i++) {
            s += grades[i];
        }
        return s/grades.length;
    }
    
    
    
    
    
}
