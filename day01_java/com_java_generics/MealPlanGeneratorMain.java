package day01_java.com_java_generics;

import java.util.ArrayList;
import java.util.List;

// MealPlan Interface
interface MealPlan {
    String getMealDetails();
}

// Vegetarian Meal Class
class VegetarianMeal implements MealPlan {
    private String mealName;

    public VegetarianMeal(String mealName) {
        this.mealName = mealName;
    }

    @Override
    public String getMealDetails() {
        return "Vegetarian Meal: " + mealName;
    }
}

// Vegan Meal Class
class VeganMeal implements MealPlan {
    private String mealName;

    public VeganMeal(String mealName) {
        this.mealName = mealName;
    }

    @Override
    public String getMealDetails() {
        return "Vegan Meal: " + mealName;
    }
}

// Keto Meal Class
class KetoMeal implements MealPlan {
    private String mealName;

    public KetoMeal(String mealName) {
        this.mealName = mealName;
    }

    @Override
    public String getMealDetails() {
        return "Keto Meal: " + mealName;
    }
}

// High-Protein Meal Class
class HighProteinMeal implements MealPlan {
    private String mealName;

    public HighProteinMeal(String mealName) {
        this.mealName = mealName;
    }

    @Override
    public String getMealDetails() {
        return "High-Protein Meal: " + mealName;
    }
}

// Generic Meal Class

class Meal<T extends MealPlan> {
    private List<T> meals;

    public Meal() {
        meals = new ArrayList<>();
    }

    public void addMeal(T meal) {
        meals.add(meal);
    }

    public List<T> getMeals() {
        return meals;
    }
}

// Utility Class for Generating Meal Plans
class MealUtility {
    public static <T extends MealPlan> void generateMealPlan(List<T> meals) {
        for (MealPlan meal : meals) {
            System.out.println(meal.getMealDetails());
        }
    }
}

// Main Class to Demonstrate Functionality
public class MealPlanGeneratorMain {
    public static void main(String[] args) {
        // Create meal lists for each type
        Meal<VegetarianMeal> vegetarianMeals = new Meal<>();
        Meal<VeganMeal> veganMeals = new Meal<>();
        Meal<KetoMeal> ketoMeals = new Meal<>();
        Meal<HighProteinMeal> highProteinMeals = new Meal<>();

        // Add meals to respective lists
        vegetarianMeals.addMeal(new VegetarianMeal("Vegetarian Lasagna"));
        veganMeals.addMeal(new VeganMeal("Vegan Salad"));
        ketoMeals.addMeal(new KetoMeal("Keto Chicken Breast"));
        highProteinMeals.addMeal(new HighProteinMeal("Grilled Steak"));

        // Display all meal plans
        System.out.println("Vegetarian Meals:");
        MealUtility.generateMealPlan(vegetarianMeals.getMeals());

        System.out.println("\nVegan Meals:");
        MealUtility.generateMealPlan(veganMeals.getMeals());

        System.out.println("\nKeto Meals:");
        MealUtility.generateMealPlan(ketoMeals.getMeals());

        System.out.println("\nHigh-Protein Meals:");
        MealUtility.generateMealPlan(highProteinMeals.getMeals());
    }
}
