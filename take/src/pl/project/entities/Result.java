package pl.project.entities;

import javax.persistence.*;

@Entity
@Table(name= "results")
public class Result {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "points")
	private Long points;

	@ManyToOne
	@JoinColumn(name = "player_id")
	private Player player;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getPoint() {
		return points;
	}

	public void setPoint(Long point) {
		this.points = point;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}
	
	
}
