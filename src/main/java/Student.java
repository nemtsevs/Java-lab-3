import java.util.ArrayList;
import java.time.LocalDate;

public class Student
{
    private int id;
    private String FIO;
    private LocalDate birthDay;
    private String groupName;
    private ArrayList<Integer> marks;
    public Student(int id, String FIO, LocalDate birthDay) { //constructor without name of group
        this(id, FIO, birthDay, null);
    }
    public Student(int id, String FIO, LocalDate birthDay, String groupName) { //constructor with name of group
        this.id = id;
        this.FIO = FIO;
        this.birthDay = birthDay;
        this.groupName = (groupName != null && Dekanat.isThereGroup(groupName)) ? groupName : null;
        this.marks = new ArrayList<Integer>(); //initialization arrayList of marks
    }
    public void setGroupName(String groupName) { //set group`s name for student
        this.groupName = (groupName != null && Dekanat.isThereGroup(groupName)) ? groupName : null;
    }
    public void addMark(int mark) { //add student's mark
        if (marks.size() == 1 && marks.get(0) == 0) {
            marks.remove(0);
        }
        marks.add(mark);
    }
    public int getId() { //get student's identification number
        return id;
    }
    public String getFIO() { //get student's surname, name, patronymic
        return FIO;
    }
    public LocalDate getBirthDay() { //get student's birthDate
        return birthDay;
    }
    public String getGroupName() { //get student's name of group
        return groupName;
    }
    public int getMark(int num) { //get student's mark by number of arrayList marks
        return marks.get(num);
    }
    public ArrayList<Integer> getMarks() { //get student's marks
        return marks;
    }
    public double calcAverMarkStudent() { //calculate average student's mark
        double sum = 0;
        for(int val : marks) {
            sum += val;
        }
        return sum / marks.size();
    }
}
