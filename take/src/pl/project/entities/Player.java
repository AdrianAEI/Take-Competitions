package pl.project.entities;

import javax.persistence.*;

@Entity
@Table(name = "players")
public class Player {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "name", nullable = false)
	private String name;

	@Column(name = "age", nullable = false)
	private Integer age;
	
	@ManyToOne
	@JoinColumn(name = "eventDiscipline_id")
	private Start start;

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

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Start getEventDiscipline() {
		return start;
	}

	public void setEventDiscipline(Start start) {
		this.start = start;
	}
	
}
