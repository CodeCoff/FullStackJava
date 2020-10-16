package com.example.codeengine.expense.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.NoArgsConstructor;
import lombok.NonNull;

// for notes on what the annotations below are doing, please refer to User.java file
@Entity
@NoArgsConstructor
@Table(name = "category")
public class Category {
	@Id
	@NonNull
	private Long id;

	private String name;

	public String getId() {
		return this.name;
	}

}
