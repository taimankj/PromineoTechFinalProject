package chair.store.entity;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity
@Data
public class Chair {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long chairId;
	private String name;
	private String brand;
	private String model;
	private String price;
	
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	@ManyToMany(mappedBy = "chairs")
	private Set<Customer> customers = new HashSet<Customer>();
}
