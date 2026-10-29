import java.util.*;

// Student class
class Student {
    private int id;
    private String fname;
    private double cgpa;

    public Student(int id, String fname, double cgpa) {
        this.id = id;
        this.fname = fname;
        this.cgpa = cgpa;
    }

    public int getId() {
        return id;
    }

    public String getFname() {
        return fname;
    }

    public double getCgpa() {
        return cgpa;
    }
}

// Comparator implementation
class StudentComparator implements Comparator<Student> {
    @Override
    public int compare(Student a, Student b) {
        // Compare by CGPA (descending)
        if (Double.compare(b.getCgpa(), a.getCgpa()) != 0) {
            return Double.compare(b.getCgpa(), a.getCgpa());
        }
        // If CGPA is equal, compare by name (ascending)
        if (!a.getFname().equals(b.getFname())) {
            return a.getFname().compareTo(b.getFname());
        }
        // If name is also equal, compare by ID (ascending)
        return a.getId() - b.getId();
    }
}

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        List<Student> students = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int id = in.nextInt();
            String fname = in.next();
            double cgpa = in.nextDouble();
            students.add(new Student(id, fname, cgpa));
        }
        in.close();

        Collections.sort(students, new StudentComparator());

        for (Student st : students) {
            System.out.println(st.getFname());
        }
    }
}
