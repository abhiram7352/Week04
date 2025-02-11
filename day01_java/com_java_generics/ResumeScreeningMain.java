package day01_java.com_java_generics;
import java.util.ArrayList;
import java.util.List;

// JobRole Abstract Class
abstract class JobRole {
    private String candidateName;
    private String role;

    public JobRole(String candidateName, String role) {
        this.candidateName = candidateName;
        this.role = role;
    }

    public String getCandidateName() {
        return candidateName;
    }

    public String getRole() {
        return role;
    }

    public abstract String getResumeDetails();
}

// Software Engineer Role Class
class SoftwareEngineer extends JobRole {
    private String programmingLanguages;

    public SoftwareEngineer(String candidateName, String programmingLanguages) {
        super(candidateName, "Software Engineer");
        this.programmingLanguages = programmingLanguages;
    }

    @Override
    public String getResumeDetails() {
        return "Candidate: " + getCandidateName() + ", Role: " + getRole() + ", Skills: " + programmingLanguages;
    }
}

// Data Scientist Role Class
class DataScientist extends JobRole {
    private String tools;

    public DataScientist(String candidateName, String tools) {
        super(candidateName, "Data Scientist");
        this.tools = tools;
    }

    @Override
    public String getResumeDetails() {
        return "Candidate: " + getCandidateName() + ", Role: " + getRole() + ", Tools: " + tools;
    }
}

// Product Manager Role Class
class ProductManager extends JobRole {
    private String experience;

    public ProductManager(String candidateName, String experience) {
        super(candidateName, "Product Manager");
        this.experience = experience;
    }

    @Override
    public String getResumeDetails() {
        return "Candidate: " + getCandidateName() + ", Role: " + getRole() + ", Experience: " + experience;
    }
}

// Generic Resume Class


class Resume<T extends JobRole> {
    private List<T> resumes;

    public Resume() {
        resumes = new ArrayList<>();
    }

    public void addResume(T resume) {
        resumes.add(resume);
    }

    public List<T> getResumes() {
        return resumes;
    }
}

// Utility Class for Screening Resumes
class ResumeUtility {
    public static void screenResumes(List<? extends JobRole> resumes) {
        for (JobRole resume : resumes) {
            System.out.println(resume.getResumeDetails());
        }
    }
}

// Main Class to Demonstrate Functionality
public class ResumeScreeningMain {
    public static void main(String[] args) {
        // Create resume lists for each job role
        Resume<SoftwareEngineer> softwareEngineerResumes = new Resume<>();
        Resume<DataScientist> dataScientistResumes = new Resume<>();
        Resume<ProductManager> productManagerResumes = new Resume<>();

        // Add resumes to respective lists
        softwareEngineerResumes.addResume(new SoftwareEngineer("Alice", "Java, Python"));
        dataScientistResumes.addResume(new DataScientist("Bob", "TensorFlow, Pandas"));
        productManagerResumes.addResume(new ProductManager("Charlie", "5 years in SaaS"));

        // Display all resumes
        System.out.println("Software Engineer Resumes:");
        ResumeUtility.screenResumes(softwareEngineerResumes.getResumes());

        System.out.println("\nData Scientist Resumes:");
        ResumeUtility.screenResumes(dataScientistResumes.getResumes());

        System.out.println("\nProduct Manager Resumes:");
        ResumeUtility.screenResumes(productManagerResumes.getResumes());
    }
}
