import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class StudentTest
{
    private static DateTimeFormatter form = DateTimeFormatter.ofPattern("dd.MM.yyyy");

    @org.junit.Test
    public void getId() {
        Student student = new Student(128, "Kostyuk Nazar Elizarovich", LocalDate.parse("07.02.1998", form));
        assertEquals(128, student.getId());
    }

    @org.junit.Test
    public void getFIO() {
        Student student = new Student(128, "Kostyuk Nazar Elizarovich", LocalDate.parse("07.02.1998", form));
        assertEquals("Kostyuk Nazar Elizarovich", student.getFIO());
    }

    @org.junit.Test
    public void getBirthDay1() {
        Student student = new Student(128, "Kostyuk Nazar Elizarovich", LocalDate.parse("07.02.1998", form));
        assertEquals(LocalDate.parse("07.02.1998", form), student.getBirthDay());
    }

    @org.junit.Test
    public void getBirthDay2() {
        Student student = new Student(128, "Kostyuk Nazar Elizarovich", LocalDate.parse("07.02.1998", form));
        assertEquals("07.02.1998", student.getBirthDay().format(form));
    }

    @org.junit.Test
    public void getGroupName() {
        Student student = new Student(128, "Kostyuk Nazar Elizarovich", LocalDate.parse("07.02.1998", form), "G1001");
        assertEquals(null, student.getGroupName());
    }

    @org.junit.Test
    public void getGroupName2() {
        Student student = new Student(128, "Kostyuk Nazar Elizarovich", LocalDate.parse("07.02.1998", form), "null");
        assertEquals(null, student.getGroupName());
    }

    @org.junit.Test
    public void getGroupName3() {
        Student student = new Student(128, "Kostyuk Nazar Elizarovich", LocalDate.parse("07.02.1998", form), null);
        assertEquals(null, student.getGroupName());
    }

    @org.junit.Test
    public void addMarkGetMark1() {
        Student student = new Student(128, "Kostyuk Nazar Elizarovich", LocalDate.parse("07.02.1998", form));
        student.addMark(5);
        assertEquals(5, student.getMark(0));
    }

    @org.junit.Test
    public void addMarkGetMark2() {
        Student student = new Student(128, "Kostyuk Nazar Elizarovich", LocalDate.parse("07.02.1998", form));
        student.addMark(5);
        student.addMark(3);
        student.addMark(4);
        assertEquals(4, student.getMark(2));
    }

    @org.junit.Test
    public void addMarkGetMarks() {
        Student student = new Student(128, "Kostyuk Nazar Elizarovich", LocalDate.parse("07.02.1998", form));
        student.addMark(5);
        student.addMark(3);
        student.addMark(4);
        ArrayList<Integer> mrk = student.getMarks();
        int value = mrk.get(1);
        assertEquals(3, value);
    }

    @org.junit.Test
    public void calcAverMarkStudent1() {
        Student student = new Student(128, "Kostyuk Nazar Elizarovich", LocalDate.parse("07.02.1998", form));
        student.addMark(5);
        student.addMark(3);
        student.addMark(4);
        assertEquals(4, student.calcAverMarkStudent(), 0.00);
    }

    @org.junit.Test
    public void calcAverMarkStudent2() {
        Student student = new Student(128, "Kostyuk Nazar Elizarovich", LocalDate.parse("07.02.1998", form));
        student.addMark(0);
        assertEquals(0, student.calcAverMarkStudent(), 0.00);
    }

    @org.junit.Test
    public void calcAverMarkStudent3() {
        Student student = new Student(128, "Kostyuk Nazar Elizarovich", LocalDate.parse("07.02.1998", form));
        student.addMark(0);
        student.addMark(0);
        student.addMark(0);
        assertEquals(0, student.calcAverMarkStudent(), 0.00);
    }

    @org.junit.Test
    public void calcAverMarkStudent4() {
        Student student = new Student(128, "Kostyuk Nazar Elizarovich", LocalDate.parse("07.02.1998", form));
        student.addMark(1);
        student.addMark(2);
        student.addMark(3);
        student.addMark(4);
        student.addMark(5);
        assertEquals(3, student.calcAverMarkStudent(), 0.00);
    }

    @org.junit.Test
    public void calcAverMarkStudent5() {
        Student student = new Student(128, "Kostyuk Nazar Elizarovich", LocalDate.parse("07.02.1998", form));
        student.addMark(5);
        student.addMark(5);
        student.addMark(5);
        student.addMark(4);
        student.addMark(5);
        assertEquals(4.8, student.calcAverMarkStudent(), 0.00);
    }
}
