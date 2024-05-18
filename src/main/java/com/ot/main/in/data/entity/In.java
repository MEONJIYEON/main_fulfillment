package com.ot.main.in.data.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="F_In")
public class In {
	@Id
	private Long id;
}
