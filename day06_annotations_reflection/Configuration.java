package day06_annotations_reflection;

public class Configuration {
    private static String API_KEY = "original_api_key";

    // Method to get the value of API_KEY
    public static String getApiKey() {
        return API_KEY;
    }
}
