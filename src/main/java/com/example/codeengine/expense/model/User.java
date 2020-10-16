package com.example.codeengine.expense.model;

import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// lombok shortcut for no arguement constructor
// We need @NoArgsConstructor to make 
@NoArgsConstructor

// lombok shortcut for all arg constructor. Here in this case, we will create
//		a constructor with id, name, email
@AllArgsConstructor

// To let know JPA that we want to work with our database
@Entity

// Lombok shortcut to get getters, setters, toString and hash functions
@Data

// To let know JPA that we want to create a table 
@Table(name="user")
public class User {

	@Id
	private String id;
	
	private String  name;
	
	private String email;

}

