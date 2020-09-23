package com.radha;

public class Student {
    private Integer studId;
    private String firstName;
    private String lastName;

    public Student() {
    }

    public Student(Integer studId, String firstName, String lastName) {
        this.studId = studId;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Integer getStudId() {
        return studId;
    }

    public void setStudId(Integer studId) {
        this.studId = studId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studId=" + studId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
