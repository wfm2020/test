package pawnshop.entity;

import pawnshop.enums.Material;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class PawnedItem implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;
    @Column
    @Enumerated(EnumType.STRING)
    private Material material;
    @Column
    private double weight;
    @Column
    private double price;
    @Column
    private boolean payed;
    @ManyToOne
    @JoinColumn(name = "customerID", nullable = false)
    private Customer customer;

    public PawnedItem() {
    }

    public PawnedItem(String name, Material material, double weight, Customer customer) {
        this.name = name;
        this.material = material;
        this.weight = weight;
        this.customer = customer;
    }

    public Customer getCustomer() { return customer; }

    public void setCustomer(Customer customer) { this.customer = customer; }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isPayed() {
        return payed;
    }

    public void setPayed(boolean payed) {
        this.payed = payed;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public Material getMaterial() {
        return material;
    }

    public double getWeight() {
        return weight;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
