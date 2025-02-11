package jpa;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Concert{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	private Artiste artiste;
	
	private String date;
	private String lieu;
	private long prix;
	private String description;
	private int nbrePlace;
	
	@OneToMany(mappedBy = "concert", cascade = CascadeType.PERSIST)
	private List<Ticket> tickets;
	
	public Concert() {
		
	}

	public Concert(Artiste artiste, String date, String lieu, long prix, String description, int nbrePlace) {
		this.artiste = artiste;
		this.date = date;
		this.lieu = lieu;
		this.prix = prix;
		this.description = description;
		this.nbrePlace = nbrePlace;
		this.tickets = new ArrayList<Ticket>();
		}
	
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Artiste getArtiste() {
		return artiste;
	}

	public void setArtiste(Artiste artiste) {
		this.artiste = artiste;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getLieu() {
		return lieu;
	}

	public void setLieu(String lieu) {
		this.lieu = lieu;
	}

	public long getPrix() {
		return prix;
	}

	public void setPrix(long prix) {
		this.prix = prix;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getNbrePlace() {
		return nbrePlace;
	}

	public void setNbrePlace(int nbrePlace) {
		this.nbrePlace = nbrePlace;
	}

	public List<Ticket> getTickets() {
		return tickets;
	}

	public void setConcerts(List<Ticket> tickets) {
		this.tickets = tickets;
	}
}