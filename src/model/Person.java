package model;

public class Person {
    private String name;
    private String dateOfBirth;
    private String identity;

    public Person() {
    }

    public Person(String name, String dateOfBirth, String identity) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.identity = identity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }

    @Override
    public String toString() {
        return name + ", " + dateOfBirth +", " + identity ;
    }
}
