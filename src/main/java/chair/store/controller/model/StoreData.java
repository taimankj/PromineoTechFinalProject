package chair.store.controller.model;

import java.util.HashSet;
import java.util.Set;

import chair.store.entity.Customer;
import chair.store.entity.Store;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class StoreData {
	private Long storeId;
	private String name;
	private String address;
	private String city;
	private String state;
	private String zipcode;
	private Set<CustomerData> customers = new HashSet<CustomerData>();
	
	public StoreData(Store store) {
		storeId = store.getStoreId();
		name = store.getName();
		address = store.getAddress();
		city = store.getCity();
		state = store.getState();
		zipcode = store.getZipcode();
		
		for (Customer customer : store.getCustomers()) {
			customers.add(new CustomerData(customer));
		}
	}
	
	public Store toStore() {
		Store store = new Store();
		
		store.setStoreId(storeId);
		store.setName(name);
		store.setAddress(address);
		store.setCity(city);
		store.setState(state);
		store.setZipcode(zipcode);
		
		for (CustomerData customerData : customers) {
			store.getCustomers().add(customerData.toCustomer());
		}
		
		return store;
	}
}
