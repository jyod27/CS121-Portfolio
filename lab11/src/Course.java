public class Course {
    private String courseName;
    private int courseCredits;

    public Course(String name, int credits) {
        this.courseName = name;
        this.courseCredits = credits;
    }

    public String getCourseName() {
        return courseName;
    }
    public int getCourseCredits() {
        return courseCredits;
    }

    @Override
    public String toString() {
        return String.format("Course: %s\nCredits: %d", courseName, courseCredits);
    }

}
