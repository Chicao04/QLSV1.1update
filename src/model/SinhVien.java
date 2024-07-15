package model;

import java.util.Objects;

public class SinhVien {
    private int id;
    private String name;
    private int age;
    private String address;
    private double gpa; // Add GPA attribute

    public SinhVien() {
    }

    public SinhVien(int id, String name, int age, String address, double gpa) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.address = address;
        this.gpa = gpa;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    @Override
    public String toString() {
        return "SinhVien [id=" + id + ", name=" + name + ", age=" + age + ", address=" + address + ", gpa=" + gpa + "]";
    }

    @Override
    public int hashCode() {
        return Objects.hash(address, age, gpa, id, name);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        SinhVien other = (SinhVien) obj;
        return age == other.age && Double.doubleToLongBits(gpa) == Double.doubleToLongBits(other.gpa) && id == other.id
                && Objects.equals(address, other.address) && Objects.equals(name, other.name);
    }
}
