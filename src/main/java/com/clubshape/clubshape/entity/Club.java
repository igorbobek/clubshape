package com.clubshape.clubshape.entity;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "club")
public class Club {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String image;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_league")
    private League league;


    @OneToMany(mappedBy = "club", orphanRemoval = true, cascade = CascadeType.REFRESH)
    private Set<Player> players = new HashSet<>();

    @OneToMany(mappedBy = "club")
    private  Set<ClubForm> clubFormSet = new HashSet<>();

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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public League getLeague() {
        return league;
    }

    public void setLeague(League league) {
        this.league = league;
    }

    public Set<ClubForm> getClubFormSet() {
        return clubFormSet;
    }

    public void setClubFormSet(Set<ClubForm> clubFormSet) {
        this.clubFormSet = clubFormSet;
    }

    public Set<Player> getPlayers() {
        return players;
    }

    public void setPlayers(Set<Player> players) {
        this.players = players;
    }
}
