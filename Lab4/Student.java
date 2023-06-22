/* C11 = 0
 * Identify a student class that consists of at least 5 fields.
 */
                                       
package Lab4;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

public class Student {
    private int course;
    private String group;
    private String name;
    private String surname;
    private double averageMark;

    public static void main(String[] args) {
        Student[] students = new Student[5];

        students[0] = new Student(4, "IV-91", "Andrew", "Frolov", 85.5);
        students[1] = new Student(5, "IV-92", "Michael", "Frolov", 91.5);
        students[2] = new Student(3, "IV-92", "Ivan", "Borisov", 98.0);
        students[3] = new Student(2, "IV-92", "Igor", "Alekseev", 88.98);
        students[4] = new Student(3, "IV-92", "Victor", "Gromov", 78.91);

        System.out.println("\u001B[32m" + "Unsorted:" + "\u001B[0m");
        for (Student student : students) {
            System.out.println(student);
        }

        //Arrays.sort(students, Comparator.comparing(Student::getSurname).thenComparing(Collections.reverseOrder(Student::getName)));
        //Arrays.sort(students, Comparator.comparing(Student::getSurname)
        //        .thenComparing(Collections.reverseOrder(Comparator.comparing(Student::getName))));
        Arrays.sort(students, Comparator.comparing(Student::getSurname).reversed()
                      .thenComparing(Comparator.comparing(Student::getName).reversed()));
        System.out.println("\u001B[32m" + "\nSorting by surname in ascending order:" + "\u001B[0m");
        for (Student student : students) {
            System.out.println(student);
        }

        Arrays.sort(students, Comparator.comparing(Student::getAverageMark).reversed());
        System.out.println("\u001B[32m" + "\nSorting by average marks in descending order:" + "\u001B[0m");
        for (Student student : students) {
            System.out.println(student);
        }
    }

    public Student(int course, String group, String name, String surname, double averageMark) {
        this.course = course;
        this.group = group;
        this.name = name;
        this.surname = surname;
        this.averageMark = averageMark;
    }

    public String getName() { return name; }

    public String getSurname() { return surname; }

    public Double getAverageMark() { return averageMark; }

    public String toString() {
        return "Student " + surname + " " + name + ", " + course + " course, group " + group + ", " +
                "averageMark = " + averageMark + ";";
    }
}
