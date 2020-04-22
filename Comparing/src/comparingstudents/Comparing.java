
package comparingstudents;

import comparingstudents.mycomparing.MyComparing;
import comparingstudents.mycomparing.PorovnavacStudentByFirstname;
import static comparingstudents.Main.print;
import static comparingstudents.Main.sort;
import java.text.Collator;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Locale;


/**
 *
 * @author vojta
 */
public class Comparing {
    public static void main(String[] args) {
        Student[] students = Datasource.loadDataAsArray();
        //pridat studentum znamky
        //test shodnosti objektu
        System.out.println(students[0].equals(students[1]));
        print(students);
        System.out.println("Sort by number");
        //sortByNumber(students);
        Arrays.sort(students); //students musi byt typove kompatibilni s Intarface Comparable
        print(students);
        System.out.println("Sort by name");
        MyComparing.sort(students, new PorovnavacStudentByFirstname());
        print(students);
        
        System.out.println("Sort by FirstName");
        Arrays.sort(students, new ComparatorByFirstName());
        print(students);
        
        System.out.println("Sort by lastName");
        Arrays.sort(students, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                Collator col = Collator.getInstance(new Locale("cs","CZ"));
                return col.compare(o1.getLastName(), o2.getLastName());
                //return o1.getLastName().compareTo(o2.getLastName());
            }
        });
        print(students);
        
        //Arrays.sort(students, (Student o1, Student o2) -> o1.getLastName().compareTo(o2.getLastName()));//lambda výraz
        
        //TODO tridit podle prumeru
        System.out.println("Sort by Average");
        Arrays.sort(students, new comparingstudents.ComparatorByGrades());
        print(students);
        
    }

    
}
