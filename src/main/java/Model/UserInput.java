package Model;

public class UserInput {
    // {"id":"1","name":"some_name","age":"24","course":"BTech."}

    // we have used private access modifier so that it can not be accessed globally
    private int id;
    private String name;
    private int age;
    private String course;

    public UserInput() {
    }

    public UserInput(int id, String name, int age, String course) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.course = course;

    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
    public String getCourse(){
        return course;
    }
}
