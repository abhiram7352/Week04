package day06_annotations_reflection.java_annotations;


    public class AnimalMain {

        // Parent class Animal
        public static class Animal {
            public void makeSound() {
                System.out.println("Animal makes a sound");
            }
        }

        // Child class Dog that overrides the makeSound method
        public static class Dog extends Animal {
            @Override
            public void makeSound() {
                System.out.println("Dog barks");
            }
        }

        public static void main(String[] args) {
            // Create an instance of Dog
            Dog dog = new Dog();

            // Call the makeSound() method
            dog.makeSound();
        }
    }
