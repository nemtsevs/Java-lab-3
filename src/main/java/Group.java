import java.util.ArrayList;

public class Group
{
    private String name;
    private ArrayList<Student> students;
    private Student head;
    public Group(String name) { //constructor without groups head
        this(name, null);
    }
    public Group(String name, Student head) { //constructor with group's head
        this.name = name;
        this.head = (head != null && Dekanat.isThereStudent(head)) ? head : null;
        this.students = new ArrayList<Student>(); //initialization arrayList of group's students
    }
    public void setHead(Student head) { //set group's head
        this.head = (head != null && Dekanat.isThereStudent(head)) ? head : null;
    }
    public String getName() { //get group's name
        return name;
    }
    public Student getHead() { //get group's head
        return head;
    }
    public int getNumOfStudents() { //get number of group's students
        return students.size();
    }
    public void addStudentToGroup(Student student) { //add student to group
        if (Dekanat.isThereStudent(student)) {
            students.add(student);
        }
    }
    public void delStudentFromGroup(Student student) { //delete student from group - remove student from arrayList group's students
        if (students != null) {
            for(int i=0; i < students.size(); i++) {
                if (student == students.get(i)) {
                    students.remove(i);
                }
            }
        }
    }
    public double calcAverMarkGroup() { //calculate average group's mark
        double sum = 0;
        if (students.size() != 0) {
            for (Student student : students) {
                sum += student.calcAverMarkStudent();
            }
            sum /= students.size();
        }
        return sum;
    }
}
