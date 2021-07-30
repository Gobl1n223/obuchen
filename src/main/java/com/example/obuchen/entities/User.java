package com.example.obuchen.entities;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;


@Entity
@Data
@Table(name= "user")
public class User  {
  @Id
  @GeneratedValue(generator = "increment")
  @GenericGenerator(name = "increment", strategy = "increment")
  private long id;

  private String email;
  private String username;
  private String password;
  private String name;
  private int active;
  @Enumerated(value = EnumType.STRING)
  private Role role;
  @Enumerated(value = EnumType.STRING)
  private Status status;


}
