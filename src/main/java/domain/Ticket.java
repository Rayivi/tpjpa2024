package domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Ticket {
	@Id
	@GeneratedValue
	private Long id;
	private int numPlace;
	private String choixEnvoie;
	
	@ManyToOne
	 Concert concert;
	

	public Ticket(Long id, int numPlace, String choixEnvoie, Concert concert) {
		this.id = id;
		this.numPlace = numPlace;
		this.choixEnvoie = choixEnvoie;
		this.concert = concert;
	}
	

	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public int getNumPlace() {
		return numPlace;
	}



	public void setNumPlace(int numPlace) {
		this.numPlace = numPlace;
	}



	public String getChoixEnvoie() {
		return choixEnvoie;
	}



	public void setChoixEnvoie(String choixEnvoie) {
		this.choixEnvoie = choixEnvoie;
	}


	public Concert getConcert() {
		return concert;
	}



	public void setConcert(Concert concert) {
		this.concert = concert;
	}



	public void payer() {
		
	}
	
	public void rembourser() {
		
	}
	
	//cette methode devrait utiliser rembouser apres avoir annuler le paiment du ticket
	public void annuler() {
		
	}
}
