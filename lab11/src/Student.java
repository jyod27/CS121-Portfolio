import java.util.ArrayList;

public class Student {
    private String name;
    private int id;
    private double gpa;
    private ArrayList<Course> courseArrayList = new ArrayList<>();

    public Student(String name, int id, double gpa) {
        this.name = name;
        this.id = id;
        this.gpa = gpa;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public double getGpa() {
        return gpa;
    }

    public void addCourse(Course course) {
        courseArrayList.add(course);
    }

    public void removeCourse(Course course) {
        courseArrayList.remove(course);
    }

    public String getCourseArrayList() {
        StringBuilder courseList = new StringBuilder();
        for (Course course : courseArrayList) {
            courseList.append("Course name: " + course.getCourseName() + " Course Credits: "+ course.getCourseCredits() + "\n");
        }
        return String.valueOf(courseList);
    }

    public String getCourse(String courseName) {
        StringBuilder courseBuild = new StringBuilder();
        for (Course course : courseArrayList) {
            if (course.getCourseName().equals(courseName)) {
                courseBuild.append("Course name: " + course.getCourseName() + " Course Credits: "+ course.getCourseCredits() + "\n");
                break;
            }
        }
        return String.valueOf(courseBuild);
    }

    @Override
    public String toString() {
        return String.format("Name: %s\nID: %d\nGPA: %.2f", name, id, gpa);
    }
}

