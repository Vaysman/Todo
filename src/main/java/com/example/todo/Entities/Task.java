package com.example.todo.Entities;

import javax.persistence.*;

@Entity
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String text;


    private Boolean is_done = false;

    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name="user_id")
    private User user;


    public Task() {
    }

    public Task(String text, Boolean isDone, User user) {
        this.text = text;
        this.is_done = isDone;
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Boolean getDone() {
        return is_done;
    }

    public void setDone(Boolean done) {
        is_done = done;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
