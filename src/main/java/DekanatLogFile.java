import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.regex.*;
import java.util.ArrayList;

public class DekanatLogFile
{
    public static void load() { //load information of students and groups
        Dekanat.init();
        loadStudents();
        loadGroups();
    }
    public static void write() { //write information of students and groups
        writeStudents();
        writeGroups();
    }
    private static void loadStudents() { //load information of students from file Students.txt
        DateTimeFormatter form = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        try(FileReader fr = new FileReader("src/main/java/Students.txt")) {
            Scanner scan = new Scanner(fr);
            while(scan.hasNextLine()) {
                String strVal = scan.nextLine();
                Pattern p = Pattern.compile("^\'([0-9]+)\'\t+\'([A-Za-z]+\\s+[A-Za-z]+\\s+[A-Za-z]+)\'\t+\'([0-9]{2}\\.[0-9]{2}\\.[0-9]{4})\'\t+\'([A-Za-z0-9]+)\'\t+\'\\[([0-9]?(\\,\\s+[0-9])*)\\]\'.*$");
                Matcher m = p.matcher(strVal);
                if (m.matches()) {
                    int id = Integer.parseInt(m.group(1));
                    String FIO = m.group(2);
                    LocalDate birthDay = LocalDate.parse(m.group(3), form);
                    String groupName = m.group(4);
                    String[] marksStrArr = m.group(5).split(", ");
                    ArrayList<Integer> marks = new ArrayList<Integer>();
                    for(String markVal : marksStrArr) {
                        marks.add(Integer.parseInt(markVal));
                    }
                    Dekanat.newStudent(id, FIO, birthDay, groupName, marks);
                }
            }
            scan.close();
        }
        catch(FileNotFoundException e) {
            e.printStackTrace();
        }
        catch(IOException e) {
            e.printStackTrace();
        }
    }
    private static void loadGroups() { //load information of groups from file Groups.txt
        try(FileReader fr = new FileReader("src/main/java/Groups.txt")) {
            Scanner scan = new Scanner(fr);
            while(scan.hasNextLine()) {
                String strVal = scan.nextLine();
                Pattern p = Pattern.compile("^\'([A-Za-z0-9]+)\'\t+\'([0-9]+)\'.*$");
                Matcher m = p.matcher(strVal);
                if (m.matches()) {
                    String groupName = m.group(1);
                    int idHead = Integer.parseInt(m.group(2));
                    Dekanat.newGroup(groupName, idHead);
                }
            }
            scan.close();
        }
        catch(FileNotFoundException e) {
            e.printStackTrace();
        }
        catch(IOException e) {
            e.printStackTrace();
        }
    }
    private static void writeStudents() { //write information of students to file Students.txt
        try(FileWriter wr = new FileWriter("src/main/java/Students.txt")) {
            String[] strArr = Dekanat.getStatStudents().split("\n");
            for(String strVal : strArr) {
                wr.write(strVal);
                wr.write(System.lineSeparator());
            }
        }
        catch(FileNotFoundException e) {
            e.printStackTrace();
        }
        catch(IOException e) {
            e.printStackTrace();
        }
    }
    private static void writeGroups() { //write information of groups to file Groups.txt
        try(FileWriter wr = new FileWriter("src/main/java/Groups.txt")) {
            String[] strArr = Dekanat.getStatGroups().split("\n");
            for(String strVal : strArr) {
                wr.write(strVal);
                wr.write(System.lineSeparator());
            }
        }
        catch(FileNotFoundException e) {
            e.printStackTrace();
        }
        catch(IOException e) {
            e.printStackTrace();
        }
    }
}
