package com.clubshape.clubshape.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "player")
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fio;

    private String position;

    private int number;


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_club")
    private Club club;

    @OneToMany(mappedBy = "form")
    private  Set<UserFormPlayer> userFormPlayerSet = new HashSet<>();


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Set<UserFormPlayer> getUserFormPlayerSet() {
        return userFormPlayerSet;
    }

    public void setUserFormPlayerSet(Set<UserFormPlayer> userFormPlayerSet) {
        this.userFormPlayerSet = userFormPlayerSet;
    }

    public Club getClub() {
        return club;
    }

    public void setClub(Club club) {
        this.club = club;
    }
}
