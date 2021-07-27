package com.example.obuchen.entities;

import lombok.AllArgsConstructor;
import lombok.Data;


import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;



import javax.persistence.*;
import java.util.Collection;
import java.util.Set;


/**
 * Сделать так, чтобы у id не было сеттера
 * */
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


  @ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER)
  @CollectionTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"))
  @Enumerated(EnumType.STRING)
  private Set<Role> roles;


}
