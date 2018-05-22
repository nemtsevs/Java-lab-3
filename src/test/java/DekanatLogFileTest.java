import static org.junit.Assert.*;

public class DekanatLogFileTest
{
    @org.junit.Test
    public void groupsLoadWriteLoad() {
        DekanatLogFile.load();
        String log1 = Dekanat.getStatGroups();
        DekanatLogFile.write();
        DekanatLogFile.load();
        String log2 = Dekanat.getStatGroups();
        assertEquals(log1, log2);
    }

    @org.junit.Test
    public void studentsLoadWriteLoad() {
        DekanatLogFile.load();
        String log1 = Dekanat.getStatStudents();
        DekanatLogFile.write();
        DekanatLogFile.load();
        String log2 = Dekanat.getStatStudents();
        assertEquals(log1, log2);
    }

    @org.junit.Test
    public void groupsStudentsLoadWriteLoad() {
        DekanatLogFile.load();
        String log1 = Dekanat.getStatGroups() + Dekanat.getStatStudents();
        DekanatLogFile.write();
        DekanatLogFile.load();
        String log2 = Dekanat.getStatGroups() + Dekanat.getStatStudents();
        assertEquals(log1, log2);
    }

    @org.junit.Test
    public void studentsGroupsLoadWriteLoad() {
        DekanatLogFile.load();
        String log1 = Dekanat.getStatStudents() + Dekanat.getStatGroups();
        DekanatLogFile.write();
        DekanatLogFile.load();
        String log2 = Dekanat.getStatStudents() + Dekanat.getStatGroups();
        assertEquals(log1, log2);
    }

    @org.junit.Test
    public void loadWriteLoad() {
        DekanatLogFile.load();
        String log1 = Dekanat.getStatistic();
        DekanatLogFile.write();
        DekanatLogFile.load();
        String log2 = Dekanat.getStatistic();
        assertEquals(log1, log2);
    }

    @org.junit.Test
    public void loadWriteLoadTwoTimes() {
        DekanatLogFile.load();
        String log1 = Dekanat.getStatistic();
        DekanatLogFile.write();
        DekanatLogFile.load();
        DekanatLogFile.write();
        DekanatLogFile.load();
        String log2 = Dekanat.getStatistic();
        assertEquals(log1, log2);
    }

    @org.junit.Test
    public void loadWriteLoadManyTimes() {
        DekanatLogFile.load();
        String log1 = Dekanat.getStatistic();
        for(int i=0; i < 5; i++) {
            DekanatLogFile.write();
            DekanatLogFile.load();
        }
        String log2 = Dekanat.getStatistic();
        assertEquals(log1, log2);
    }
}
