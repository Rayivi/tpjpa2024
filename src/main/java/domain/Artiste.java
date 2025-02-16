package domain;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Artiste {
	 @Id
	 @GeneratedValue
	 private Long id;
	 private String nom;
	 private String genreMusical;
	 
	 @OneToMany (mappedBy = "artiste")
	 private List<Concert> concerts;
	 
	 public Artiste() {}
	 
	public Artiste( String nom, String genreMusical) {
		this.nom = nom;
		this.genreMusical = genreMusical;
		this.concerts = new ArrayList<Concert>();
	}
	
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getGenreMusical() {
		return genreMusical;
	}
	public void setGenreMusical(String genreMusical) {
		this.genreMusical = genreMusical;
	}
	public List<Concert> getConcerts() {
		return concerts;
	}
	public void setConcerts(List<Concert> concerts) {
		this.concerts = concerts;
	}
	 
}
