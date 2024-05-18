package com.ot.main.out.data.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="F_Out")
public class Out {
	@Id
	private Long id;
}
