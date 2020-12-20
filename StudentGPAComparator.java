import java.util.Comparator;

public class StudentGPAComparator implements Comparator<Student3>{

         public int compare(Student3 s1, Student3 s2) {
             float gpa1 = s1.getGPA();
             float gpa2 = s2.getGPA();
             
             if (gpa1 > gpa2) { //since the gpa is float  i implemented some logic to return -1, 0, or 1 
               return -1;
             }
              else if (gpa1 < gpa2) {
               return 1;
             }  
             else {
               return 0;
             }
                    
         }
}
