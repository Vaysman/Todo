package com.example.todo.entities;

import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.List;

@Data
@Entity
public class User {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  private String name;
  private String password;

  @ManyToOne(optional = false, cascade = CascadeType.ALL)
  private Role role;

  @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
  private List<Task> tasks;
}
