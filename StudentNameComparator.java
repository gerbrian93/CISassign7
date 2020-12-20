import java.util.Comparator;

public class StudentNameComparator implements Comparator<Student3>{

         public int compare(Student3 s1, Student3 s2) {
             String name1 = s1.getName();
             String name2 = s2.getName();
             
             return name2.compareTo(name1);//for string i used the string .compareTo() method to sort alphabetically 
                    }
                    
         
}
