package com.fpoly.java6.model.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import com.fpoly.java6.entities.Brand;
import com.fpoly.java6.entities.Favorite;
import com.fpoly.java6.entities.Product;
import com.fpoly.java6.entities.Type;
import com.fpoly.java6.entities.Variant;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {
	@Column(name = "id")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	
	@ManyToOne
	@JoinColumn(name = "type_id")
	private Type type;	
	
	@ManyToOne
	@JoinColumn(name = "brand_id")
	private Brand brand;
	
	
	@Column(name = "name",columnDefinition = "nvarchar(255)")
	private String name;
	@Column(name = "description", length = 1000,columnDefinition = "nvarchar(max)")
	private String description;
	@Column(name = "date")
	private Date date;
	@Column(name = "image")
	private String image;
	@Column(name = "status")
	private int status;
	
	@OneToMany(mappedBy = "product")
	private List<Variant> variants = new ArrayList<>();
	
	@OneToMany(mappedBy = "product")
	private List<Favorite> favorites = new ArrayList<>();
}
