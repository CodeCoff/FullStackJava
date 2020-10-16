package com.example.codeengine.expense.model;

import java.time.Instant;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="expense")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Expense{

	@Id
	private long id;

	// time object to get the timestamp
	private Instant expenseDate;

	private String description;

	/*
		the data will be something like the below:
			ID (primary key)	       Date			Description		User ID		Category ID
			    1000				06/16/2019		'Visiting NY'		1		    10
	*/

	// this is basically a sql join
	@ManyToOne
	private Category category;

	@ManyToOne
	private User user;

}
