package day06_annotations_reflection.java_annotations;

public class LegacyAPI {

    // Old method marked as deprecated
    @Deprecated
    public void oldFeature() {
        System.out.println("This is the old feature.");
    }

    // New method to replace the old feature
    public void newFeature() {
        System.out.println("This is the new feature.");
    }

    public static void main(String[] args) {
        // Create an instance of LegacyAPI
        LegacyAPI api = new LegacyAPI();

        // Call the deprecated oldFeature method
        api.oldFeature();

        // Call the newFeature method
        api.newFeature();
    }
}
