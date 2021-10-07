package xiii.geekbrains.java_pre_course.lesson_4;

public class Person {
    private String name;
    private int age;
    private String position;
    private String eMail;
    private String phoneNumber;
    private int salary;

    public Person(String name, int age, String position, String eMail, String phoneNumber, int salary) {
        this.name = name;
        this.age = age;
        this.position = position;
        this.eMail = eMail;
        this.phoneNumber = phoneNumber;
        this.salary = salary;
    }

    public static void printPerson(Person person) {
        System.out.println("ФИО: " + person.name);
        System.out.println("возраст: " + person.age);
        System.out.println("должность: " + person.position);
        System.out.println("eMail: " + person.eMail);
        System.out.println("телефон: " + person.phoneNumber);
        System.out.println("зарплата: " + person.salary);
    }

    public int getAge() {
        return age;
    }
}
