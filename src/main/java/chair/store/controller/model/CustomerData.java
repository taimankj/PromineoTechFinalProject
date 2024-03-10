package chair.store.controller.model;

import java.util.HashSet;
import java.util.Set;

import chair.store.entity.Chair;
import chair.store.entity.Customer;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CustomerData {
	private Long customerId;
	private String name;
	private Set<ChairData> chairs = new HashSet<ChairData>();
	
	public CustomerData(Customer customer) {
		customerId = customer.getCustomerId();
		name = customer.getName();
		
		for (Chair chair : customer.getChairs()) {
			chairs.add(new ChairData(chair));
		}
	}
	
	public Customer toCustomer() {
		Customer customer = new Customer();
		
		customer.setCustomerId(customerId);
		customer.setName(name);
		
		for (ChairData chairData : chairs) {
			customer.getChairs().add(chairData.toChair());
		}
		
		return customer;
	}
}
