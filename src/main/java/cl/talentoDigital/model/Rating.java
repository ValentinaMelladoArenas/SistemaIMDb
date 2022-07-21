package cl.talentoDigital.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name="SQ_RATING", initialValue=1, allocationSize=1)
public class Rating {

	@Id
	@GeneratedValue(strategy= GenerationType.SEQUENCE, generator="SQ_RATING")
	private Long id;
	private int rating;
	
	@ManyToOne
	@JoinColumn(name = "user_id", referencedColumnName = "id")//clave foránea y nombre del atributo de la tabla de referencia
	private User user;
	@ManyToOne
	@JoinColumn(name = "show_id", referencedColumnName = "id")
	private Show show;
	
	public Rating() {
		// TODO Auto-generated constructor stub
	}

	public Rating(Long id, int rating, User user, Show show) {
		super();
		this.id = id;
		this.rating = rating;
		this.user = user;
		this.show = show;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Show getShow() {
		return show;
	}

	public void setShow(Show show) {
		this.show = show;
	}

	@Override
	public String toString() {
		return "Rating [id=" + id + ", rating=" + rating + ", user=" + user + ", show=" + show + "]";
	}
}
