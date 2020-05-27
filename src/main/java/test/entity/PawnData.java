package test.entity;

import test.enums.Material;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class PawnData implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;
    @Column
    @Enumerated(EnumType.STRING)
    private Material material;
    @Column
    private Float weight;
    @Column
    private Integer karats;

    public PawnData() {
    }

    public PawnData(String name, Material material, Float weight, Integer karats) {
        this.name = name;
        this.material = material;
        this.weight = weight;
        this.karats = karats;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    public void setWeight(Float weight) {
        this.weight = weight;
    }

    public void setKarats(Integer karats) {
        this.karats = karats;
    }

    public Material getMaterial() {
        return material;
    }

    public Float getWeight() {
        return weight;
    }

    public Integer getKarats() {
        return karats;
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
