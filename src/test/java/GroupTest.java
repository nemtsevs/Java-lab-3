import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static org.junit.Assert.*;

public class GroupTest
{
    private static DateTimeFormatter form = DateTimeFormatter.ofPattern("dd.MM.yyyy");

    @org.junit.Test
    public void group() {
        Group group = new Group("G01");
        assertEquals("G01", group.getName());
    }

    @org.junit.Test
    public void groupGetHead() {
        Group group = new Group("G01");
        assertEquals(null, group.getHead());
    }

    @org.junit.Test
    public void groupHeadNull() {
        Group group = new Group("G01", null);
        assertEquals(null, group.getHead());
    }

    @org.junit.Test
    public void getName() {
        Student head = new Student(128, "Kostyuk Nazar Elizarovich", LocalDate.parse("07.02.1998", form));
        Group group = new Group("G01", head);
        assertEquals("G01", group.getName());
    }

    @org.junit.Test
    public void getHead() {
        Student head = new Student(128, "Kostyuk Nazar Elizarovich", LocalDate.parse("07.02.1998", form));
        Group group = new Group("G01", head);
        assertEquals(null, group.getHead());
    }

    @org.junit.Test
    public void getNumOfStudents() {
        Student head = new Student(128, "Kostyuk Nazar Elizarovich", LocalDate.parse("07.02.1998", form));
        Group group = new Group("G01", head);
        assertEquals(0, group.getNumOfStudents());
    }

    @org.junit.Test
    public void setHead() {
        Student head = new Student(128, "Kostyuk Nazar Elizarovich", LocalDate.parse("07.02.1998", form));
        Group group = new Group("G01");
        group.setHead(head);
        assertEquals(null, group.getHead());
    }

    @org.junit.Test
    public void addStudentToGroup() {
        Student student = new Student(128, "Kostyuk Nazar Elizarovich", LocalDate.parse("07.02.1998", form));
        Group group = new Group("G01");
        group.addStudentToGroup(student);
        assertEquals(0, group.getNumOfStudents());
    }


    @org.junit.Test
    public void delStudentFromGroup() {
        Student student = new Student(128, "Kostyuk Nazar Elizarovich", LocalDate.parse("07.02.1998", form));
        Group group = new Group("G01");
        group.delStudentFromGroup(student);
        assertEquals(0, group.getNumOfStudents());
    }

    @org.junit.Test
    public void calcAverMarkGroup() {
        Group group = new Group("G01");
        assertEquals(0, group.calcAverMarkGroup(), 0.00);
    }
}
