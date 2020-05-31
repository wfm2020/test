package pawnshop.dto;

import pawnshop.enums.Material;

import java.time.LocalDate;

public class PawnedItemDTO {

    private String itemName;
    private Material material;
    private double weight;
    private double price;
    private boolean accepted;
    private boolean payed;
    private long id;

    public PawnedItemDTO() {
    }

    public PawnedItemDTO(String itemName, Material material, double weight, double price,
                         boolean accepted, boolean payed) {
        this.itemName = itemName;
        this.material = material;
        this.weight = weight;
        this.price = price;
        this.accepted = accepted;
        this.payed = payed;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isAccepted() {
        return accepted;
    }

    public void setAccepted(boolean accepted) {
        this.accepted = accepted;
    }

    public boolean isPayed() {
        return payed;
    }

    public void setPayed(boolean payed) {
        this.payed = payed;
    }
}
