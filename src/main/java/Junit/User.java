package Junit;

public class User {
    private String name;
    private int age;
    private boolean blocked;

    public User(String name, int age, boolean blocked) {
        this.name = name;
        this.age = age;
        this.blocked = blocked;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isBlocked() {
        return blocked;
    }

    public void setBlocked(boolean blocked) {
        this.blocked = blocked;
    }
}
