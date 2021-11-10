package io.github.anantharajuc.sbmwa.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Entity
@Table(name = "address")
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level=AccessLevel.PRIVATE)
public class Address extends AuditEntity
{
	private static final long serialVersionUID = 1L;
	
	public Address(String city2, String zipcode2) 
	{
		
	}
	
	@Column(name="city", nullable=true)
	@Size(min=3, max=15, message="city must be between 3 and 15 characters.")
	String city;
	
	@Column(name="zipcode", nullable=true)
	@Size(min=3, max=15, message="zipcode must be between 3 and 15 characters.")
	String zipcode;
	
	@JsonBackReference
	@OneToOne(mappedBy="address")
	Person person;
}
