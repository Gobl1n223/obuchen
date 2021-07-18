package com.example.obuchen.entities;

import lombok.Data;


import org.hibernate.annotations.GenericGenerator;



import javax.persistence.*;
import java.util.Collection;
import java.util.Set;


@Entity
@Data
@Table(name= "user")
public class User  {
  @Id
  @GeneratedValue(generator = "increment")
  @GenericGenerator(name = "increment", strategy = "increment")
  private long id;

  private String username;
  private String password;
  private String name;
  private int active;
  private String googleName;
  private String googleUsername;

  @ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER)
  @CollectionTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"))
  @Enumerated(EnumType.STRING)
  private Set<Role> roles;


}
