package pl.project.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "competitions")
public class Competition {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "name", nullable = false)
	private String name;
	
	@Column(name = "location", nullable = false)
	private String location;
	
	@Column(name = "date", nullable = false)
	private String date;
	
	@OneToMany(mappedBy = "competition", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Start> starts = new ArrayList<Start>();
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	
	public List<Start> getEventDisciplines() {
		return starts;
	}

	public void setEventDisciplines(List<Start> starts) {
		this.starts = starts;
	}
	
}
