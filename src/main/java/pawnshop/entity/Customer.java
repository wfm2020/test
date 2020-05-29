package pawnshop.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Customer implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String firstName;
    @Column
    private String lastName;
    @Column
    @NotNull
    private String email;
    @Column
    private LocalDate birthDate;
    @Column
    private String phoneNumber;
    @OneToMany
    private List<PawnedItem> pawnedItems;

    public Customer() {
    }

    public Customer(String firstName, String lastName, String email, LocalDate birthDate, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.birthDate = birthDate;
        this.phoneNumber = phoneNumber;
        pawnedItems = new ArrayList<>();
    }

    public List<PawnedItem> getPawnedItems() {
        return pawnedItems;
    }

    public void addPawnedItem(PawnedItem pawnedItem){
        this.pawnedItems.add(pawnedItem);
    }

    public void setPawnedItems(List<PawnedItem> pawnedItems) {
        this.pawnedItems = pawnedItems;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
}
