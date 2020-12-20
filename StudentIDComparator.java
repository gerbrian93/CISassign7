import java.util.Comparator;

public class StudentIDComparator implements Comparator<Student3>{

         public int compare(Student3 s1, Student3 s2) {
             
             return s2.getID() - s1.getID();//since the ID is integer we can simply subtract one from another to get a negative, positive or zero return value
                    }
                    
         
}
