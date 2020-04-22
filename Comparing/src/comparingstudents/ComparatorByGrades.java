/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comparingstudents;

import java.util.Comparator;

/**
 *
 * @author vojta
 */
public class ComparatorByGrades implements Comparator<Student>{

    @Override
    public int compare(Student o1, Student o2) {
        int res = 0;
        if (o1.getAverage() < o2.getAverage()){
            res = -1;
        } else if (o1.getAverage() > o2.getAverage()){
            res = 1;
        } else if (o1.getAverage() == o2.getAverage()){
            res = 0;
        }
        return res;
    }
    
}
