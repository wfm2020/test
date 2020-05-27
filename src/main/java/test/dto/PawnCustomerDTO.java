package test.dto;

import test.enums.Material;
import java.time.LocalDate;

public class PawnCustomerDTO {

    private String name;
    private Material material;
    private Float weight;
    private Integer karats;

    private String firstName;
    private String lastName;
    private String email;
    private LocalDate birthDate;
    private String phoneNumber;

    public PawnCustomerDTO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    public Float getWeight() {
        return weight;
    }

    public void setWeight(Float weight) {
        this.weight = weight;
    }

    public Integer getKarats() {
        return karats;
    }

    public void setKarats(Integer karats) {
        this.karats = karats;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public PawnCustomerDTO(String name, Material material, Float weight, Integer karats, String firstName, String lastName, String email, LocalDate birthDate, String phoneNumber) {
        this.name = name;
        this.material = material;
        this.weight = weight;
        this.karats = karats;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.birthDate = birthDate;
        this.phoneNumber = phoneNumber;
    }
}
