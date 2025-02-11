package day01_java.com_java_generics;
import java.util.ArrayList;
import java.util.List;
// Abstract Class for CourseType
class CourseType {
    private String courseName;
    private String instructor;

    public CourseType(String courseName, String instructor) {
        this.courseName = courseName;
        this.instructor = instructor;
    }

    public String getCourseName() {
        return courseName;
    }

    public String getInstructor() {
        return instructor;
    }

    public String getCourseDetails() {
        return "";
    }
}

// Exam-Based Course Class
class ExamCourse extends CourseType {
    private int examWeight;

    public ExamCourse(String courseName, String instructor, int examWeight) {
        super(courseName, instructor);
        this.examWeight = examWeight;
    }

    @Override
    public String getCourseDetails() {
        return "Exam Course: " + getCourseName() + ", Instructor: " + getInstructor() + ", Exam Weight: " + examWeight + "%";
    }
}

// Assignment-Based Course Class
class AssignmentCourse extends CourseType {
    private int assignmentCount;

    public AssignmentCourse(String courseName, String instructor, int assignmentCount) {
        super(courseName, instructor);
        this.assignmentCount = assignmentCount;
    }

    @Override
    public String getCourseDetails() {
        return "Assignment Course: " + getCourseName() + ", Instructor: " + getInstructor() + ", Assignments: " + assignmentCount;
    }
}

// Research-Based Course Class
class ResearchCourse extends CourseType {
    private String researchTopic;

    public ResearchCourse(String courseName, String instructor, String researchTopic) {
        super(courseName, instructor);
        this.researchTopic = researchTopic;
    }

    @Override
    public String getCourseDetails() {
        return "Research Course: " + getCourseName() + ", Instructor: " + getInstructor() + ", Research Topic: " + researchTopic;
    }
}

// Generic Course Class


class Course<T extends CourseType> {
    private List<T> courses;

    public Course() {
        courses = new ArrayList<>();
    }

    public void addCourse(T course) {
        courses.add(course);
    }

    public List<T> getCourses() {
        return courses;
    }
}

// Utility Class for Displaying Courses
class CourseUtility {
    public static void displayCourses(List<? extends CourseType> courses) {
        for (CourseType course : courses) {
            System.out.println(course.getCourseDetails());
        }
    }
}

// Main Class to Demonstrate Functionality
public class UniversityMain {
    public static void main(String[] args) {
        // Create course lists for each type
        Course<ExamCourse> examCourses = new Course<>();
        Course<AssignmentCourse> assignmentCourses = new Course<>();
        Course<ResearchCourse> researchCourses = new Course<>();

        // Add courses to respective lists
        examCourses.addCourse(new ExamCourse("Mathematics", "Dr. Smith", 70));
        assignmentCourses.addCourse(new AssignmentCourse("History", "Prof. Johnson", 5));
        researchCourses.addCourse(new ResearchCourse("Physics", "Dr. Brown", "Quantum Mechanics"));

        // Display all courses
        System.out.println("Exam-Based Courses:");
        CourseUtility.displayCourses(examCourses.getCourses());

        System.out.println("\nAssignment-Based Courses:");
        CourseUtility.displayCourses(assignmentCourses.getCourses());

        System.out.println("\nResearch-Based Courses:");
        CourseUtility.displayCourses(researchCourses.getCourses());
    }
}
