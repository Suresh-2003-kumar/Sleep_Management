package Sleep_Management;

public class Person {
    private String name;
    private int age;
    private String contact;
    private String email;

    public Person(String name, int age, String contact, String email) {
        this.name = name;
        this.age = age;
        this.contact = contact;
        this.email = email;
    }

    // Getters
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getContact() {
        return contact;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Age: " + age + ", Contact: " + contact + ", Email: " + email;
    }
}