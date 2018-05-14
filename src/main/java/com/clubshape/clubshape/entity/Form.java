package com.clubshape.clubshape.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "form")
public class Form {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private int price;

    private int size;

    private String description;

    private String image;

    private boolean main;



    @OneToMany(mappedBy = "form")
    private Set<ClubForm> playerForms = new HashSet<>();


    @OneToMany(mappedBy = "form")
    private  Set<UserFormPlayer> userFormSet = new HashSet<>();



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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public boolean isMain() {
        return main;
    }

    public void setMain(boolean main) {
        this.main = main;
    }

    public Set<UserFormPlayer> getUserFormSet() {
        return userFormSet;
    }

    public void setUserFormSet(Set<UserFormPlayer> userFormSet) {
        this.userFormSet = userFormSet;
    }

    public Set<ClubForm> getPlayerForms() {
        return playerForms;
    }

    public void setPlayerForms(Set<ClubForm> playerForms) {
        this.playerForms = playerForms;
    }
}
