package jpa;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Administrateur {
	@Id
	@GeneratedValue
	 private Long id;
}
