import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class DekanatTest {
    private static DateTimeFormatter form = DateTimeFormatter.ofPattern("dd.MM.yyyy");
    private static String doubleForm(double val) {
        return String.format("%(.2f", val);
    }
    @org.junit.Test
    public void isThereGroup() {
        Dekanat.init();
        assertEquals(false, Dekanat.isThereGroup(null));
    }

    @org.junit.Test
    public void isThereGroup2() {
        Dekanat.init();
        assertEquals(false, Dekanat.isThereGroup("G02"));
    }

    @org.junit.Test
    public void isThereGroup3() {
        Dekanat.init();
        Dekanat.newGroup("G02", 0);
        assertEquals(true, Dekanat.isThereGroup("G02"));
    }

    @org.junit.Test
    public void isThereGroup4() {
        Dekanat.init();
        Dekanat.newGroup("G02", 123);
        assertEquals(true, Dekanat.isThereGroup("G02"));
    }

    @org.junit.Test
    public void isThereStudent() {
        Dekanat.init();
        Student student = new Student(128, "Kostyuk Nazar Elizarovich", LocalDate.parse("07.02.1998", form));
        Dekanat.newStudent(128, "Kostyuk Nazar Elizarovich", LocalDate.parse("07.02.1998", form), null, null);
        assertEquals(false, Dekanat.isThereStudent(student));
    }

    @org.junit.Test
    public void isThereStudent2() {
        Dekanat.init();
        Dekanat.newStudent(128, "Kostyuk Nazar Elizarovich", LocalDate.parse("07.02.1998", form), null, null);
        assertEquals(true, Dekanat.isThereStudent(Dekanat.seachStudentById(128)));
    }

    @org.junit.Test
    public void newStudentIsThereGroup3() {
        Dekanat.init();
        Dekanat.newStudent(128, "Kostyuk Nazar Elizarovich", LocalDate.parse("07.02.1998", form), "G05", null);
        assertEquals(true, Dekanat.isThereGroup("G05"));
    }

    @org.junit.Test
    public void getName() {
        Dekanat.init();
        Dekanat.newStudent(128, "Kostyuk Nazar Elizarovich", LocalDate.parse("07.02.1998", form), "G05", null);
        assertEquals("G05", Dekanat.seachGroupByStudent(Dekanat.seachStudentById(128)).getName());
    }

    @org.junit.Test
    public void getNumOfStudents() {
        Dekanat.init();
        Dekanat.newStudent(128, "Kostyuk Nazar Elizarovich", LocalDate.parse("07.02.1998", form), "G05", null);
        assertEquals(1, Dekanat.seachGroupByStudent(Dekanat.seachStudentById(128)).getNumOfStudents());
    }

    @org.junit.Test
    public void getHead() {
        Dekanat.init();
        Dekanat.newStudent(128, "Kostyuk Nazar Elizarovich", LocalDate.parse("07.02.1998", form), "G05", null);
        assertEquals(null, Dekanat.seachGroupByStudent(Dekanat.seachStudentById(128)).getHead());
    }

    @org.junit.Test
    public void setHeadGetHead2() {
        Dekanat.init();
        Dekanat.newStudent(128, "Kostyuk Nazar Elizarovich", LocalDate.parse("07.02.1998", form), "G05", null);
        Dekanat.seachGroupByStudent(Dekanat.seachStudentById(128)).setHead(Dekanat.seachStudentById(128));
        assertEquals(Dekanat.seachStudentById(128), Dekanat.seachGroupByStudent(Dekanat.seachStudentById(128)).getHead());
    }

    @org.junit.Test
    public void getId() {
        Dekanat.init();
        Dekanat.newStudent(128, "Kostyuk Nazar Elizarovich", LocalDate.parse("07.02.1998", form), "G05", null);
        assertEquals(128, Dekanat.seachStudentById(128).getId());
    }

    @org.junit.Test
    public void getFIO() {
        Dekanat.init();
        Dekanat.newStudent(128, "Kostyuk Nazar Elizarovich", LocalDate.parse("07.02.1998", form), "G05", null);
        assertEquals("Kostyuk Nazar Elizarovich", Dekanat.seachStudentById(128).getFIO());
    }

    @org.junit.Test
    public void getBirthDay() {
        Dekanat.init();
        Dekanat.newStudent(128, "Kostyuk Nazar Elizarovich", LocalDate.parse("07.02.1998", form), "G05", null);
        assertEquals(LocalDate.parse("07.02.1998", form), Dekanat.seachStudentById(128).getBirthDay());
    }

    @org.junit.Test
    public void getGroupName() {
        Dekanat.init();
        Dekanat.newStudent(128, "Kostyuk Nazar Elizarovich", LocalDate.parse("07.02.1998", form), "G05", null);
        assertEquals("G05", Dekanat.seachStudentById(128).getGroupName());
    }

    @org.junit.Test
    public void getMarks() {
        Dekanat.init();
        Dekanat.newStudent(128, "Kostyuk Nazar Elizarovich", LocalDate.parse("07.02.1998", form), "G05", null);
        assertEquals(0, Dekanat.seachStudentById(128).getMarks().size());
    }

    @org.junit.Test
    public void getMarks2() {
        Dekanat.init();
        ArrayList<Integer> marks = new ArrayList<Integer>();
        marks.add(0);
        Dekanat.newStudent(128, "Kostyuk Nazar Elizarovich", LocalDate.parse("07.02.1998", form), "G05", marks);
        assertEquals(1, Dekanat.seachStudentById(128).getMarks().size());
    }

    @org.junit.Test
    public void getMarks3() {
        Dekanat.init();
        ArrayList<Integer> marks = new ArrayList<Integer>();
        marks.add(5);
        Dekanat.newStudent(128, "Kostyuk Nazar Elizarovich", LocalDate.parse("07.02.1998", form), "G05", marks);
        assertEquals(1, Dekanat.seachStudentById(128).getMarks().size());
    }

    @org.junit.Test
    public void getMarks4() {
        Dekanat.init();
        ArrayList<Integer> marks = new ArrayList<Integer>();
        marks.add(5);
        Dekanat.newStudent(128, "Kostyuk Nazar Elizarovich", LocalDate.parse("07.02.1998", form), "G05", marks);
        assertEquals(5, Dekanat.seachStudentById(128).getMarks().get(0), 0.001);
    }

    @org.junit.Test
    public void getMarks5() {
        Dekanat.init();
        ArrayList<Integer> marks = new ArrayList<Integer>();
        marks.add(0);
        Dekanat.newStudent(128, "Kostyuk Nazar Elizarovich", LocalDate.parse("07.02.1998", form), "G05", marks);
        assertEquals(0, Dekanat.seachStudentById(128).getMarks().get(0), 0.01);
    }

    @org.junit.Test
    public void getMarks6() {
        Dekanat.init();
        ArrayList<Integer> marks = new ArrayList<Integer>();
        marks.add(0);
        Dekanat.newStudent(128, "Kostyuk Nazar Elizarovich", LocalDate.parse("07.02.1998", form), "G05", marks);
        assertEquals(0, Dekanat.seachStudentById(128).getMark(0));
    }

    @org.junit.Test
    public void getMarks7() {
        Dekanat.init();
        ArrayList<Integer> marks = new ArrayList<Integer>();
        marks.add(4);
        Dekanat.newStudent(128, "Kostyuk Nazar Elizarovich", LocalDate.parse("07.02.1998", form), "G05", marks);
        assertEquals(4, Dekanat.seachStudentById(128).getMark(0));
    }

    @org.junit.Test
    public void marks() {
        Dekanat.init();
        ArrayList<Integer> marks = new ArrayList<Integer>();
        marks.add(4);
        marks.add(3);
        marks.add(5);
        Dekanat.newStudent(128, "Kostyuk Nazar Elizarovich", LocalDate.parse("07.02.1998", form), "G05", marks);
        assertEquals(4, Dekanat.seachStudentById(128).calcAverMarkStudent(), 0.01);
    }

    @org.junit.Test
    public void marks1() {
        Dekanat.init();
        ArrayList<Integer> marks = new ArrayList<Integer>();
        marks.add(0);
        Dekanat.newStudent(128, "Kostyuk Nazar Elizarovich", LocalDate.parse("07.02.1998", form), "G05", marks);
        assertEquals(0, Dekanat.seachStudentById(128).calcAverMarkStudent(), 0.01);
    }

    @org.junit.Test
    public void marks2() {
        Dekanat.init();
        ArrayList<Integer> marks = new ArrayList<Integer>();
        marks.add(4);
        marks.add(4);
        marks.add(5);
        marks.add(5);
        Dekanat.newStudent(128, "Kostyuk Nazar Elizarovich", LocalDate.parse("07.02.1998", form), "G05", marks);
        assertEquals(4.50, Dekanat.seachGroupByStudent(Dekanat.seachStudentById(128)).calcAverMarkGroup(), 0.01);
    }

    @org.junit.Test
    public void marks3() {
        Dekanat.init();
        ArrayList<Integer> marks = new ArrayList<Integer>();
        marks.add(0);
        Dekanat.newStudent(128, "Kostyuk Nazar Elizarovich", LocalDate.parse("07.02.1998", form), "G05", marks);
        assertEquals(0, Dekanat.seachGroupByStudent(Dekanat.seachStudentById(128)).calcAverMarkGroup(), 0.01);
    }

    @org.junit.Test
    public void delStudentFromGroup() {
        Dekanat.init();
        Dekanat.newStudent(128, "Kostyuk Nazar Elizarovich", LocalDate.parse("07.02.1998", form), "G05", null);
        Dekanat.delStudentFromGroup(Dekanat.seachStudentById(128));
        assertEquals(null, Dekanat.seachStudentById(128).getGroupName());
    }

    @org.junit.Test
    public void delStudentFromGroup2() {
        Dekanat.init();
        Dekanat.newGroup("G05", 0);
        Dekanat.newStudent(128, "Kostyuk Nazar Elizarovich", LocalDate.parse("07.02.1998", form), "G05", null);
        Dekanat.seachGroupByStudent(Dekanat.seachStudentById(128)).setHead(Dekanat.seachStudentById(128));
        Dekanat.delStudentFromGroup(Dekanat.seachStudentById(128));
        assertEquals(null, Dekanat.seachStudentById(128).getGroupName());
    }

    @org.junit.Test
    public void checkHeadGroup() {
        Dekanat.init();
        Dekanat.newGroup("G05", 0);
        Dekanat.newStudent(128, "Kostyuk Nazar Elizarovich", LocalDate.parse("07.02.1998", form), "G05", null);
        Dekanat.seachGroupByStudent(Dekanat.seachStudentById(128)).setHead(Dekanat.seachStudentById(128));
        assertEquals(true, Dekanat.checkHeadGroup("G05"));
    }

    @org.junit.Test
    public void checkHeadGroup2() {
        Dekanat.init();
        Dekanat.newStudent(128, "Kostyuk Nazar Elizarovich", LocalDate.parse("07.02.1998", form), "G05", null);
        Dekanat.newGroup("G05", 128);
        assertEquals(true, Dekanat.checkHeadGroup("G05"));
    }

    @org.junit.Test
    public void checkHeadGroup3() {
        Dekanat.init();
        Dekanat.newStudent(128, "Kostyuk Nazar Elizarovich", LocalDate.parse("07.02.1998", form), "G05", null);
        Dekanat.newGroup("G05", 128);
        assertEquals(Dekanat.seachStudentById(128), Dekanat.seachGroupByStudent(Dekanat.seachStudentById(128)).getHead());
    }

    @org.junit.Test
    public void checkHeadGroup4() {
        Dekanat.init();
        Dekanat.newGroup("G05", 0);
        assertEquals(false, Dekanat.checkHeadGroup("G05"));
    }

    @org.junit.Test
    public void checkHeadGroup5() {
        Dekanat.init();
        Dekanat.newStudent(128, "Kostyuk Nazar Elizarovich", LocalDate.parse("07.02.1998", form), "G05", null);
        Dekanat.newGroup("G05", 128);
        Dekanat.delStudentFromGroup(Dekanat.seachStudentById(128));
        assertEquals(false, Dekanat.checkHeadGroup("G05"));
    }

    @org.junit.Test
    public void checkStudentHeadOfGroup() {
        Dekanat.init();
        Dekanat.newStudent(128, "Kostyuk Nazar Elizarovich", LocalDate.parse("07.02.1998", form), "G05", null);
        Dekanat.newGroup("G05", 128);
        assertEquals(true, Dekanat.checkStudentHeadOfGroup(Dekanat.seachStudentById(128)));
    }

    @org.junit.Test
    public void checkStudentHeadOfGroup2() {
        Dekanat.init();
        Dekanat.newStudent(128, "Kostyuk Nazar Elizarovich", LocalDate.parse("07.02.1998", form), "G05", null);
        Dekanat.newGroup("G05", 128);
        Dekanat.delStudentFromGroup(Dekanat.seachStudentById(128));
        assertEquals(false, Dekanat.checkStudentHeadOfGroup(Dekanat.seachStudentById(128)));
    }

    @org.junit.Test
    public void checkStudentHeadOfGroup3() {
        Dekanat.init();
        Dekanat.newStudent(128, "Kostyuk Nazar Elizarovich", LocalDate.parse("07.02.1998", form), "G05", null);
        Dekanat.newGroup("G05", 0);
        Dekanat.seachGroupByStudent(Dekanat.seachStudentById(128)).setHead(Dekanat.seachStudentById(128));
        assertEquals(true, Dekanat.checkStudentHeadOfGroup(Dekanat.seachStudentById(128)));
    }

    @org.junit.Test
    public void checkStudentHeadOfGroup4() {
        Dekanat.init();
        Dekanat.newStudent(128, "Kostyuk Nazar Elizarovich", LocalDate.parse("07.02.1998", form), "G05", null);
        Dekanat.newGroup("G05", 0);
        Dekanat.seachGroupByStudent(Dekanat.seachStudentById(128)).setHead(Dekanat.seachStudentById(128));
        Dekanat.delStudentFromGroup(Dekanat.seachStudentById(128));
        assertEquals(false, Dekanat.checkStudentHeadOfGroup(Dekanat.seachStudentById(128)));
    }

    @org.junit.Test
    public void checkStudentHeadOfGroup5() {
        Dekanat.init();
        Dekanat.newStudent(128, "Kostyuk Nazar Elizarovich", LocalDate.parse("07.02.1998", form), null, null);
        Dekanat.newGroup("G05", 0);
        Dekanat.addStudentToGroup(Dekanat.seachStudentById(128), "G05");
        assertEquals(false, Dekanat.checkStudentHeadOfGroup(Dekanat.seachStudentById(128)));
    }

    @org.junit.Test
    public void addDelStudentSeachGroupByStudent() {
        Dekanat.init();
        Dekanat.newStudent(128, "Kostyuk Nazar Elizarovich", LocalDate.parse("07.02.1998", form), "G05", null);
        Dekanat.addStudentToGroup(Dekanat.seachStudentById(128), "G05");
        Dekanat.delStudentFromGroup(Dekanat.seachStudentById(128));
        assertEquals(null, Dekanat.seachGroupByStudent(Dekanat.seachStudentById(128)));
    }

    @org.junit.Test
    public void addDelStudentGetGroupName() {
        Dekanat.init();
        Dekanat.newStudent(128, "Kostyuk Nazar Elizarovich", LocalDate.parse("07.02.1998", form), "G05", null);
        Dekanat.addStudentToGroup(Dekanat.seachStudentById(128), "G05");
        Dekanat.delStudentFromGroup(Dekanat.seachStudentById(128));
        assertEquals(null, Dekanat.seachStudentById(128).getGroupName());
    }

    @org.junit.Test
    public void moveStudentFromTo() {
        Dekanat.init();
        Dekanat.newStudent(128, "Kostyuk Nazar Elizarovich", LocalDate.parse("07.02.1998", form), null, null);
        Dekanat.newGroup("G07", 0);
        Dekanat.moveStudentFromTo(Dekanat.seachStudentById(128), "G07");
        assertEquals("G07", Dekanat.seachStudentById(128).getGroupName());
    }

    @org.junit.Test
    public void moveStudentFromTo2() {
        Dekanat.init();
        Dekanat.newStudent(128, "Kostyuk Nazar Elizarovich", LocalDate.parse("07.02.1998", form), null, null);
        Dekanat.newGroup("G07", 0);
        Dekanat.addStudentToGroup(Dekanat.seachStudentById(128), "G07");
        Dekanat.newGroup("G08", 0);
        Dekanat.moveStudentFromTo(Dekanat.seachStudentById(128), "G08");
        assertEquals("G08", Dekanat.seachStudentById(128).getGroupName());
    }

    @org.junit.Test
    public void moveStudentFromTo3() {
        Dekanat.init();
        Dekanat.newStudent(128, "Kostyuk Nazar Elizarovich", LocalDate.parse("07.02.1998", form), null, null);
        Dekanat.newGroup("G07", 0);
        Dekanat.addStudentToGroup(Dekanat.seachStudentById(128), "G07");
        Dekanat.newGroup("G08", 0);
        Dekanat.moveStudentFromTo(Dekanat.seachStudentById(128), "G08");
        assertEquals("G08", Dekanat.seachGroupByStudent(Dekanat.seachStudentById(128)).getName());
    }

    @org.junit.Test
    public void moveStudentFromTo4() {
        Dekanat.init();
        Dekanat.newStudent(128, "Kostyuk Nazar Elizarovich", LocalDate.parse("07.02.1998", form), null, null);
        Dekanat.newGroup("G07", 0);
        Dekanat.newGroup("G08", 0);
        Dekanat.newGroup("G09", 0);
        Dekanat.addStudentToGroup(Dekanat.seachStudentById(128), "G07");
        Dekanat.moveStudentFromTo(Dekanat.seachStudentById(128), "G08");
        Dekanat.moveStudentFromTo(Dekanat.seachStudentById(128), "G09");
        assertEquals("G09", Dekanat.seachGroupByStudent(Dekanat.seachStudentById(128)).getName());
    }

    @org.junit.Test
    public void moveStudentFromTo5() {
        Dekanat.init();
        Dekanat.newStudent(128, "Kostyuk Nazar Elizarovich", LocalDate.parse("07.02.1998", form), null, null);
        Dekanat.newGroup("G07", 0);
        Dekanat.newGroup("G08", 0);
        Dekanat.newGroup("G09", 0);
        Dekanat.addStudentToGroup(Dekanat.seachStudentById(128), "G07");
        Dekanat.delStudentFromGroup(Dekanat.seachStudentById(128));
        Dekanat.moveStudentFromTo(Dekanat.seachStudentById(128), "G08");
        Dekanat.delStudentFromGroup(Dekanat.seachStudentById(128));
        Dekanat.moveStudentFromTo(Dekanat.seachStudentById(128), "G09");
        assertEquals("G09", Dekanat.seachGroupByStudent(Dekanat.seachStudentById(128)).getName());
    }

    @org.junit.Test
    public void moveStudentFromTo6() {
        Dekanat.init();
        Dekanat.newStudent(128, "Kostyuk Nazar Elizarovich", LocalDate.parse("07.02.1998", form), null, null);
        Dekanat.newGroup("G07", 0);
        Dekanat.newGroup("G08", 0);
        Dekanat.newGroup("G09", 0);
        Dekanat.addStudentToGroup(Dekanat.seachStudentById(128), "G07");
        Dekanat.delStudentFromGroup(Dekanat.seachStudentById(128));
        Dekanat.moveStudentFromTo(Dekanat.seachStudentById(128), "G08");
        Dekanat.delStudentFromGroup(Dekanat.seachStudentById(128));
        Dekanat.moveStudentFromTo(Dekanat.seachStudentById(128), "G09");
        Dekanat.delStudentFromGroup(Dekanat.seachStudentById(128));
        assertEquals(null, Dekanat.seachGroupByStudent(Dekanat.seachStudentById(128)));
    }

    @org.junit.Test
    public void moveStudentFromTo7() {
        Dekanat.init();
        Dekanat.newStudent(128, "Kostyuk Nazar Elizarovich", LocalDate.parse("07.02.1998", form), null, null);
        Dekanat.newGroup("G07", 0);
        Dekanat.addStudentToGroup(Dekanat.seachStudentById(128), "G07");
        Dekanat.delStudentFromGroup(Dekanat.seachStudentById(128));
        Dekanat.moveStudentFromTo(Dekanat.seachStudentById(128), "G07");
        assertEquals("G07", Dekanat.seachStudentById(128).getGroupName());
    }

    @org.junit.Test
    public void moveStudentFromTo8() {
        Dekanat.init();
        Dekanat.newStudent(128, "Kostyuk Nazar Elizarovich", LocalDate.parse("07.02.1998", form), null, null);
        Dekanat.newGroup("G07", 0);
        Dekanat.moveStudentFromTo(Dekanat.seachStudentById(128), "G07");
        Dekanat.moveStudentFromTo(Dekanat.seachStudentById(128), "G07");
        assertEquals("G07", Dekanat.seachStudentById(128).getGroupName());
    }

    @org.junit.Test
    public void delStudentFromDekanat() {
        Dekanat.init();
        Dekanat.newStudent(128, "Kostyuk Nazar Elizarovich", LocalDate.parse("07.02.1998", form), null, null);
        Dekanat.delStudentFromDekanat(Dekanat.seachStudentById(128));
        assertEquals(false, Dekanat.isThereStudent(Dekanat.seachStudentById(128)));
    }

    @org.junit.Test
    public void delStudentFromDekanat2() {
        Dekanat.init();
        Dekanat.newStudent(128, "Kostyuk Nazar Elizarovich", LocalDate.parse("07.02.1998", form), null, null);
        Dekanat.delStudentFromDekanat(Dekanat.seachStudentById(128));
        assertEquals(null, Dekanat.seachStudentById(128));
    }

    @org.junit.Test
    public void delStudentFromDekanat3() {
        Dekanat.init();
        Dekanat.newStudent(128, "Kostyuk Nazar Elizarovich", LocalDate.parse("07.02.1998", form), "G01", null);
        Dekanat.delStudentFromDekanat(Dekanat.seachStudentById(128));
        assertEquals(null, Dekanat.seachGroupByStudent(Dekanat.seachStudentById(128)));
    }

    @org.junit.Test
    public void delStudentFromDekanat4() {
        Dekanat.init();
        Dekanat.newStudent(128, "Kostyuk Nazar Elizarovich", LocalDate.parse("07.02.1998", form), "G01", null);
        Dekanat.newStudent(157, "Shalushkin Ernst Miroslavovich", LocalDate.parse("05.12.1999", form), "G01", null);
        Dekanat.delStudentFromDekanat(Dekanat.seachStudentById(157));
        assertEquals(1, Dekanat.seachGroupByStudent(Dekanat.seachStudentById(128)).getNumOfStudents());
    }

    @org.junit.Test
    public void delStudentFromDekanat5() {
        Dekanat.init();
        Dekanat.newStudent(128, "Kostyuk Nazar Elizarovich", LocalDate.parse("07.02.1998", form), "G01", null);
        Dekanat.newStudent(157, "Shalushkin Ernst Miroslavovich", LocalDate.parse("05.12.1999", form), "G01", null);
        Dekanat.seachGroupByStudent(Dekanat.seachStudentById(157)).setHead(Dekanat.seachStudentById(157));
        Dekanat.delStudentFromDekanat(Dekanat.seachStudentById(157));
        assertEquals(null, Dekanat.seachGroupByStudent(Dekanat.seachStudentById(128)).getHead());
    }

    @org.junit.Test
    public void delStudentFromDekanat6() {
        Dekanat.init();
        Dekanat.newStudent(128, "Kostyuk Nazar Elizarovich", LocalDate.parse("07.02.1998", form), "G01", null);
        Dekanat.newStudent(157, "Shalushkin Ernst Miroslavovich", LocalDate.parse("05.12.1999", form), "G01", null);
        Dekanat.newGroup("G01", 128);
        Dekanat.delStudentFromDekanat(Dekanat.seachStudentById(128));
        assertEquals(null, Dekanat.seachGroupByStudent(Dekanat.seachStudentById(157)).getHead());
    }

    @org.junit.Test
    public void delStudentFromDekanat7() {
        Dekanat.init();
        Dekanat.newStudent(128, "Kostyuk Nazar Elizarovich", LocalDate.parse("07.02.1998", form), "G01", null);
        Dekanat.newStudent(157, "Shalushkin Ernst Miroslavovich", LocalDate.parse("05.12.1999", form), "G01", null);
        Dekanat.newGroup("G01", 128);
        Dekanat.delStudentFromDekanat(Dekanat.seachStudentById(128));
        Dekanat.seachGroupByStudent(Dekanat.seachStudentById(157)).setHead(Dekanat.seachStudentById(157));
        assertEquals(Dekanat.seachStudentById(157), Dekanat.seachGroupByStudent(Dekanat.seachStudentById(157)).getHead());
    }

    @org.junit.Test
    public void delCheckStudentHeadOfGroup() {
        Dekanat.init();
        Dekanat.newStudent(128, "Kostyuk Nazar Elizarovich", LocalDate.parse("07.02.1998", form), "G01", null);
        Dekanat.newGroup("G01", 128);
        Dekanat.delStudentFromDekanat(Dekanat.seachStudentById(128));
        assertEquals(false, Dekanat.checkStudentHeadOfGroup(Dekanat.seachStudentById(128)));
    }

    @org.junit.Test
    public void delCheckStudentHeadOfGroup2() {
        Dekanat.init();
        Dekanat.newStudent(128, "Kostyuk Nazar Elizarovich", LocalDate.parse("07.02.1998", form), null, null);
        Dekanat.newGroup("G01", 128);
        assertEquals(false, Dekanat.checkStudentHeadOfGroup(Dekanat.seachStudentById(128)));
    }

    @org.junit.Test
    public void delCheckStudentHeadOfGroup3() {
        Dekanat.init();
        Dekanat.newStudent(128, "Kostyuk Nazar Elizarovich", LocalDate.parse("07.02.1998", form), null, null);
        Dekanat.newGroup("G01", 128);
        Dekanat.moveStudentFromTo(Dekanat.seachStudentById(128), "G01");
        assertEquals(true, Dekanat.checkStudentHeadOfGroup(Dekanat.seachStudentById(128)));
    }

    @org.junit.Test
    public void setHeadOfGroup() {
        Dekanat.init();
        Dekanat.newStudent(128, "Kostyuk Nazar Elizarovich", LocalDate.parse("07.02.1998", form), null, null);
        Dekanat.setHeadOfGroup(Dekanat.seachStudentById(128), "G02");
        assertEquals(false, Dekanat.checkStudentHeadOfGroup(Dekanat.seachStudentById(128)));
    }

    @org.junit.Test
    public void setHeadOfGroup2() {
        Dekanat.init();
        Dekanat.newStudent(128, "Kostyuk Nazar Elizarovich", LocalDate.parse("07.02.1998", form), "G02", null);
        Dekanat.setHeadOfGroup(Dekanat.seachStudentById(128), "G02");
        assertEquals(true, Dekanat.checkStudentHeadOfGroup(Dekanat.seachStudentById(128)));
    }

    @org.junit.Test
    public void setHeadOfGroup3() {
        Dekanat.init();
        Dekanat.newStudent(128, "Kostyuk Nazar Elizarovich", LocalDate.parse("07.02.1998", form), "G02", null);
        Dekanat.setHeadOfGroup(Dekanat.seachStudentById(128), "G02");
        assertEquals(true, Dekanat.checkHeadGroup("G02"));
    }

    @org.junit.Test
    public void setHeadOfGroup4() {
        Dekanat.init();
        Dekanat.newStudent(128, "Kostyuk Nazar Elizarovich", LocalDate.parse("07.02.1998", form), "G02", null);
        Dekanat.setHeadOfGroup(Dekanat.seachStudentById(128), "G02");
        assertEquals(true, Dekanat.checkStudentHeadOfGroup(Dekanat.seachStudentById(128)));
    }

    @org.junit.Test
    public void whoIsHeadOfGroup() {
        Dekanat.init();
        Dekanat.newStudent(128, "Kostyuk Nazar Elizarovich", LocalDate.parse("07.02.1998", form), "G02", null);
        Dekanat.setHeadOfGroup(Dekanat.seachStudentById(128), "G02");
        assertEquals(Dekanat.seachStudentById(128), Dekanat.whoIsHeadOfGroup("G02"));
    }

    @org.junit.Test
    public void whoIsHeadOfGroup2() {
        Dekanat.init();
        Dekanat.newStudent(128, "Kostyuk Nazar Elizarovich", LocalDate.parse("07.02.1998", form), "G01", null);
        Dekanat.setHeadOfGroup(Dekanat.seachStudentById(128), "G02");
        assertEquals(null, Dekanat.whoIsHeadOfGroup("G02"));
    }

    @org.junit.Test
    public void whoIsHeadOfGroup3() {
        Dekanat.init();
        Dekanat.newStudent(128, "Kostyuk Nazar Elizarovich", LocalDate.parse("07.02.1998", form), null, null);
        Dekanat.setHeadOfGroup(Dekanat.seachStudentById(128), "G02");
        assertEquals(null, Dekanat.whoIsHeadOfGroup("G02"));
    }

    @org.junit.Test
    public void whoIsHeadOfGroup4() {
        Dekanat.init();
        Dekanat.newStudent(128, "Kostyuk Nazar Elizarovich", LocalDate.parse("07.02.1998", form), null, null);
        Dekanat.setHeadOfGroup(Dekanat.seachStudentById(128), "G02");
        assertEquals(null, Dekanat.whoIsHeadOfGroup(null));
    }


    @org.junit.Test
    public void addMarkStudent() {
        Dekanat.init();
        Dekanat.newStudent(128, "Kostyuk Nazar Elizarovich", LocalDate.parse("07.02.1998", form), null, null);
        Dekanat.addMarkStudent(Dekanat.seachStudentById(128), 5);
        assertEquals(5, Dekanat.seachStudentById(128).getMark(0));
    }

    @org.junit.Test
    public void addMarkStudent2() {
        Dekanat.init();
        Dekanat.newStudent(128, "Kostyuk Nazar Elizarovich", LocalDate.parse("07.02.1998", form), null, null);
        Dekanat.addMarkStudent(Dekanat.seachStudentById(128), 5);
        Dekanat.addMarkStudent(Dekanat.seachStudentById(128), 2);
        Dekanat.addMarkStudent(Dekanat.seachStudentById(128), 4);
        assertEquals(2, Dekanat.seachStudentById(128).getMark(1));
    }

    @org.junit.Test
    public void addMarkStudent3() {
        Dekanat.init();
        Dekanat.newStudent(128, "Kostyuk Nazar Elizarovich", LocalDate.parse("07.02.1998", form), null, null);
        Dekanat.addMarkStudent(Dekanat.seachStudentById(128), 5);
        Dekanat.addMarkStudent(Dekanat.seachStudentById(128), 3);
        Dekanat.addMarkStudent(Dekanat.seachStudentById(128), 4);
        assertEquals(4, Dekanat.seachStudentById(128).calcAverMarkStudent(), 0.01);
    }

    @org.junit.Test
    public void addMarksToStudent() {
        Dekanat.init();
        Dekanat.newStudent(128, "Kostyuk Nazar Elizarovich", LocalDate.parse("07.02.1998", form), null, null);
        ArrayList<Integer> marks = new ArrayList<Integer>();
        marks.add(3);
        marks.add(4);
        Dekanat.addMarksToStudent(Dekanat.seachStudentById(128), marks);
        assertEquals(3.5, Dekanat.seachStudentById(128).calcAverMarkStudent(), 0.01);
    }

    @org.junit.Test
    public void addMarksToStudent2() {
        Dekanat.init();
        Dekanat.newStudent(128, "Kostyuk Nazar Elizarovich", LocalDate.parse("07.02.1998", form), null, null);
        ArrayList<Integer> marks = new ArrayList<Integer>();
        marks.add(3);
        marks.add(2);
        Dekanat.addMarksToStudent(Dekanat.seachStudentById(128), marks);
        assertEquals(2, Dekanat.seachStudentById(128).getMark(1));
    }

    @org.junit.Test
    public void excludeStudents() {
        Dekanat.init();
        Dekanat.newStudent(128, "Kostyuk Nazar Elizarovich", LocalDate.parse("07.02.1998", form), null, null);
        ArrayList<Integer> marks = new ArrayList<Integer>();
        marks.add(3);
        marks.add(2);
        Dekanat.addMarksToStudent(Dekanat.seachStudentById(128), marks);
        Dekanat.excludeStudents();
        assertEquals(false, Dekanat.isThereStudent(Dekanat.seachStudentById(128)));
    }

    @org.junit.Test
    public void excludeStudents2() {
        Dekanat.init();
        Dekanat.newStudent(128, "Kostyuk Nazar Elizarovich", LocalDate.parse("07.02.1998", form), null, null);
        ArrayList<Integer> marks = new ArrayList<Integer>();
        marks.add(3);
        marks.add(4);
        Dekanat.addMarksToStudent(Dekanat.seachStudentById(128), marks);
        Dekanat.excludeStudents();
        assertEquals(true, Dekanat.isThereStudent(Dekanat.seachStudentById(128)));
    }

    @org.junit.Test
    public void getStatistic() {
        Dekanat.init();
        assertEquals("\n\n", Dekanat.getStatistic());
    }

    @org.junit.Test
    public void getStatGroups() {
        Dekanat.init();
        assertEquals("", Dekanat.getStatGroups());
    }

    @org.junit.Test
    public void getStatStudents() {
        Dekanat.init();
        assertEquals("", Dekanat.getStatStudents());
    }

    @org.junit.Test
    public void getStatistic2() {
        Dekanat.init();
        Dekanat.newStudent(128, "Kostyuk Nazar Elizarovich", LocalDate.parse("07.02.1998", form), null, null);
        ArrayList<Integer> marks = new ArrayList<Integer>();
        marks.add(3);
        marks.add(4);
        Dekanat.addMarksToStudent(Dekanat.seachStudentById(128), marks);
        assertEquals("'128'\t'Kostyuk Nazar Elizarovich'\t'07.02.1998'\t'null'\t'[3, 4]'\t" + doubleForm(3.5) + "\n\n\n", Dekanat.getStatistic());
    }

    @org.junit.Test
    public void getStatistic3() {
        Dekanat.init();
        Dekanat.newStudent(128, "Kostyuk Nazar Elizarovich", LocalDate.parse("07.02.1998", form), "G005", null);
        ArrayList<Integer> marks = new ArrayList<Integer>();
        marks.add(3);
        marks.add(4);
        Dekanat.addMarksToStudent(Dekanat.seachStudentById(128), marks);
        assertEquals("'128'\t'Kostyuk Nazar Elizarovich'\t'07.02.1998'\t'G005'\t'[3, 4]'\t" + doubleForm(3.5) + "\n\n'G005'\t'0'\t1\t" + doubleForm(3.5) + "\n\n", Dekanat.getStatistic());
    }
}
