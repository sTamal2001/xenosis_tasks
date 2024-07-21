public class Person {
    String name;
    int age;

    // Constructor
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Method displayDetails
    public void displayDetails() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }

    public static void main(String[] args) {
        // Instantiate an object of the Person class in main method
        Person person = new Person("Tamal Sen", 23);

        // Call the displayDetails method
        person.displayDetails();
    }
}