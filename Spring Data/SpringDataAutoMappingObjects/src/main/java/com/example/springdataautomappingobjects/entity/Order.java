package com.example.springdataautomappingobjects.entity;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "orders")
public class Order {
    private Long id;
    private User buyer;
    private Set<Game> games;

    public Order() {
    }

    @ManyToOne
    public User getBuyer() {
        return buyer;
    }

    public void setBuyer(User buyer) {
        this.buyer = buyer;
    }

    @ManyToMany
    public Set<Game> getGames() {
        return games;
    }

    public void setGames(Set<Game> games) {
        this.games = games;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }
}
