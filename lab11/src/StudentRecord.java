import java.util.ArrayList;

public class StudentRecord {
    private ArrayList<Student> studentArrayList = new ArrayList<>();

    public void addStudent(Student student) {
        studentArrayList.add(student);
    }

    public void removeStudent(Student student) {
        studentArrayList.remove(student);
    }

    public String getStudentArrayList() {
        StringBuilder studentList = new StringBuilder();
        for (Student student : studentArrayList) {
            studentList.append("Name: " + student.getName() + " ID: "+ student.getId() + " GPA : " + student.getGpa() + "\n");
        }
        return String.valueOf(studentList);
    }

    public String getStudentInfo(String studentName) {
        StringBuilder studentBuild = new StringBuilder();
        for (Student student : studentArrayList) {
            if (student.getName().equals(studentName)) {
                studentBuild.append("Name: " + student.getName() + " ID: "+ student.getId() + " GPA : " + student.getGpa() + "\n");
                break;
            }
        }
        return String.valueOf(studentBuild);
    }

    public Student getStudent(String name) {
        Student foundStudent = null;
        for(Student student : studentArrayList){
            if(student.getName().equals(name)){
                foundStudent = student;
                break;
            }
        }
        return foundStudent;
    }
}
