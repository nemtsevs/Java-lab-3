import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Random;

public class Dekanat
{
    private static ArrayList<Student> students;
    private static ArrayList<Group> groups;
    public static void init() { //initialization arrayLists of students and groups
        students = new ArrayList<Student>();
        groups = new ArrayList<Group>();
    }
    public static boolean isThereGroup(String groupName) { //seach group by groupName
        return (getGroupByName(groupName) != null);
    }
    public static boolean isThereStudent(Student someone) { //seach student in dekanat
        boolean result = false;
        if (students != null) {
            for(Student student : students) {
                if (someone == student) {
                    result = true;
                }
            }
        }
        return result;
    }
    public static void newGroup(String groupName, int idHead) { //creat group
        if (!groupName.equals("null")) {
            Group group = insertGroup(groupName);
            Student head = seachStudentById(idHead);
            group.setHead(head);
        }
    }
    public static void newStudent(int id, String FIO, LocalDate birthDay, String groupName, ArrayList<Integer> marks) { //new student with marks
        if (checkStudentInfo(id, FIO, birthDay)) {
            Student student = new Student(checkOrGetNewId(id), FIO, birthDay, groupName);
            students.add(student);
            addStudentToGroup(student, groupName);
            if (marks != null) {
                addMarksToStudent(student, marks);
            }
        }
    }
    public static void addStudentToGroup(Student student, String groupName) { //add student to groups
        if (student != null) {
            if (groupName != null && !groupName.equals("null")) {
                Group group = insertGroup(groupName); //checks groupName there is in groups, if there isn't the new group will be added to groups list.
                group.addStudentToGroup(student);
            }
            student.setGroupName(groupName);
        }
    }
    public static void delStudentFromGroup(Student student) { //del student from group
        if (students != null && groups != null) {
            if(student != null) {
                Group group = getGroupByName(student.getGroupName());
                if (checkStudentHeadOfGroup(student)) {
                    group.setHead(null);
                }
                if (group != null) {
                    group.delStudentFromGroup(student);
                }
                student.setGroupName(null);
            }
        }
    }
    public static void moveStudentFromTo(Student student, String nextGroup) { //move student from group one to group two
        if (students != null && groups != null) {
            if (student != null) {
                delStudentFromGroup(student);
                addStudentToGroup(student, nextGroup);
            }
        }
    }
    public static boolean delStudentFromDekanat(Student student) { //delete student from dekanat
        boolean result = false;
        if (students != null) {
            int i = seachStudentNumOfArrayList(student);
            if (i != -1) {
                if (student.getGroupName() != null) {
                    delStudentFromGroup(student);
                }
                students.remove(i);
                result = true;
            }
        }
        return result;
    }
    public static Student seachStudentById(int id) { //seach student in dekanat by student's identification number
        Student someone = null;
        if (students != null) {
            for(Student student : students) {
                if (id == student.getId()) {
                    someone = student;
                }
            }
        }
        return someone;
    }
    public static Group seachGroupByStudent(Student someone) { //seach group by student
        Group group = null;
        if (students != null && groups != null) {
            for(Student student : students) {
                if (someone == student) {
                    group = getGroupByName(someone.getGroupName());
                }
            }
        }
        return group;
    }
    public static boolean setHeadOfGroup(Student head, String groupName) { //set head of group from group's students
        boolean result = false;
        if (students != null && groups != null) {
            if (getGroupByName(groupName) != null & head != null) {
                if (head.getGroupName().equals(groupName)) {
                    getGroupByName(groupName).setHead(head);
                    return true;
                }
            }
        }
        return result;
    }
    public static boolean checkHeadGroup(String groupName) { //if head of group not found return false, else return true
        boolean result = false;
        if (whoIsHeadOfGroup(groupName) != null) {
            result = true;
        }
        return result;
    }
    public static Student whoIsHeadOfGroup(String groupName) { //seach head of group by group's name
        Student head = null;
        if (students != null && groups != null) {
            if (groupName != null && getGroupByName(groupName) != null) {
                head = getGroupByName(groupName).getHead();
            }
        }
        return head;
    }
    public static boolean checkStudentHeadOfGroup(Student student) { //check : is student a head of group, return false or true
        boolean result = false;
        if (student != null) {
            Student head = whoIsHeadOfGroup(student.getGroupName());
            if (student == head) {
                result = true;
            }
        }
        return result;
    }
    public static void addMarkStudent(Student student, int mark) { //add student's mark to arrayList marks;
        if (isThereStudent(student)) {
            student.addMark(mark);
        }
    }
    public static void addMarksToStudent(Student someone, ArrayList<Integer> marks) { //add student's marks to arrayList marks;
        if (students != null) {
            for(Student student : students) {
                if (someone == student) {
                    for(int val : marks) {
                        someone.addMark(val);
                    }
                }
            }
        }
    }
    public static void randomMarksStudents(int maxCount) { //randomize student's marks many times
        for(int i=0; i < maxCount; i++) {
            randomMarksStudents();
        }
    }
    public static void excludeStudents() { //exclude students with bad marks
        if (students != null) {
            for(int i=0; i < students.size(); i++) {
                if (students.get(i).calcAverMarkStudent() < 3) {
                    if (delStudentFromDekanat(students.get(i))) {
                        i--;
                    }
                }
            }
        }
    }
    public static String getStatistic() { //collect statistics of students and groups
        return getStatStudents() + "\n" + getStatGroups() + "\n";
    }
    public static String getStatGroups() { //collect statistics of groups
        String statistic = "";
        if (groups != null) {
            for(Group group : groups) {
                statistic += "'" + group.getName() + "'" + "\t";
                if (checkHeadGroup(group.getName())) {
                    statistic += "'" + Integer.toString(group.getHead().getId()) + "'" + "\t";
                }
                else {
                    statistic += "'0'" + "\t";
                }
                statistic += Integer.toString(group.getNumOfStudents()) + "\t";
                statistic += String.format("%(.2f", group.calcAverMarkGroup()) + "\n";
            }
        }
        return statistic;
    }
    public static String getStatStudents() { //collect statistics of students
        DateTimeFormatter form = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        String statistic = "";
        if (students != null) {
            for(Student student : students) {
                statistic += "'" + Integer.toString(student.getId()) + "'" + "\t";
                statistic += "'" + student.getFIO() + "'" + "\t";
                statistic += "'" + student.getBirthDay().format(form) + "'" + "\t";
                statistic += "'" + student.getGroupName() + "'" + "\t" + "'[";
                for(int i=0; i < student.getMarks().size(); i++) {
                    if (i > 0) {
                        statistic += ", ";
                    }
                    statistic += Integer.toString(student.getMark(i));
                }
                statistic += "]'" + "\t" + String.format("%(.2f", student.calcAverMarkStudent()) + "\n";
            }
        }
        return statistic;
    }
    private static boolean checkStudentInfo(int id, String FIO, LocalDate birthDay) { //check student's information by identification number
        Student student = seachStudentById(id);
        if (student != null) {
            if (student.getFIO().equals(FIO) & student.getBirthDay().equals(birthDay)) {
                return false;
            }
        }
        return true;
    }
    private static boolean checkId(int id) { //check is there identification number
        if (students != null) {
            for(Student student : students) {
                if (id == student.getId()) {
                    return true;
                }
            }
        }
        return false;
    }
    private static int checkOrGetNewId(int id) { //check id student or get new student's identification number
        if (id < 100) {
            return getNewStudentId();
        }
        if (students != null) {
            for(Student student : students) {
                if (id == student.getId()) {
                    return getNewStudentId();
                }
            }
        }
        return id;
    }
    private static int getNewStudentId() { //get new student's identification number
        int max = 100;
        if (students != null) {
            for (Student student : students) {
                if (student.getId() > max) {
                    max = student.getId();
                }
            }
        }
        return ++max;
    }
    private static Group getGroupByName(String name) { //get group by group's name
        Group result = null;
        if (groups != null) {
            for(Group group : groups) {
                if ((group.getName()).equals(name)) {
                    result = group;
                }
            }
        }
        return result;
    }
    private static Group insertGroup(String groupName) { //checks groupName there is in groups, if there isn't the new group will be added to groups list.
        Group result = getGroupByName(groupName);
        if (result == null && !groupName.equals("null")) {
            result = new Group(groupName);
            groups.add(result);
        }
        return result;
    }
    private static int seachStudentNumOfArrayList(Student student) { //seach student's number of arrayList students
        int num = -1;
        if (students != null) {
            for(int i=0; i < students.size(); i++) {
                if (student == students.get(i)) {
                    num = i;
                }
            }
        }
        return num;
    }
    private static int randomMark(int minMark, int maxMark) { //randomize mark in range minMark-maxMark
        return new Random().nextInt(maxMark - minMark + 1) + minMark;
    }
    private static void randomMarksStudents() { //randomize student's marks once
        if (students != null) {
            for (Student student : students) {
                if (new Random().nextBoolean()) {
                    student.addMark(randomMark(1, 5));
                }
            }
        }
    }
}
