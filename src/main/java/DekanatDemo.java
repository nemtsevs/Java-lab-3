public class DekanatDemo
{
    public static void dekanatWorkExample() { //dekanat programm example
        DekanatLogFile.load();
        show(Dekanat.getStatistic());
        Student student = Dekanat.seachStudentById(101);
        Dekanat.moveStudentFromTo(student, "G1802");
        Dekanat.setHeadOfGroup(student, "G1802");
        student = Dekanat.seachStudentById(102);
        Dekanat.moveStudentFromTo(student, "G1801");
        Dekanat.setHeadOfGroup(student, "G1801");
        student = Dekanat.seachStudentById(103);
        Dekanat.moveStudentFromTo(student, "G1803");
        Dekanat.setHeadOfGroup(student, "G1803");
        Dekanat.excludeStudents();
        show(Dekanat.getStatistic());
        Dekanat.addMarkStudent(Dekanat.seachStudentById(104), 5);
        Dekanat.addMarkStudent(Dekanat.seachStudentById(103), 2);
        Dekanat.randomMarksStudents(7);
        show(Dekanat.getStatistic());
        Dekanat.randomMarksStudents(20);
        show(Dekanat.getStatistic());
        Dekanat.excludeStudents();
        DekanatLogFile.write();
        DekanatLogFile.load();
        show(Dekanat.getStatistic());
    }
    public static void show(String message) { //show message to screen
        System.out.print(message);
    }
    public static void main(String[] args) {
        dekanatWorkExample();
    }
}
