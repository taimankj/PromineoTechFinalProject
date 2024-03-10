package chair.store.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import chair.store.controller.model.ChairData;
import chair.store.controller.model.CustomerData;
import chair.store.controller.model.StoreData;
import chair.store.service.ChairService;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/chair_store")
@Slf4j
public class ChairController {
	
	@Autowired
	private ChairService chairService;
	
	/////////////////////////Create Methods/////////////////////////
	@PostMapping("/store")
	@ResponseStatus(code = HttpStatus.CREATED)
	public StoreData saveStore(@RequestBody StoreData storeData) {
		log.info("Creating store {}", storeData);
		return chairService.saveStore(storeData);
	}
	
	@PostMapping("/customer")
	@ResponseStatus(code = HttpStatus.CREATED)
	public CustomerData saveCustomer(@RequestBody CustomerData customerData) {
		log.info("Creating customer {}", customerData);
		return chairService.saveCustomer(customerData);
	}
	
	@PostMapping("/chair")
	@ResponseStatus(code = HttpStatus.CREATED)
	public ChairData saveChair(@RequestBody ChairData chairData) {
		log.info("Creating chair {}", chairData);
		return chairService.saveChair(chairData);
	}
	
	/////////////////////////Read Methods/////////////////////////
	@GetMapping("/store/{storeId}")
	public StoreData retrieveStore(@PathVariable Long storeId) {
		log.info("Retrieving store with ID={}", storeId);
		return chairService.retrieveStoreById(storeId);
	}
	
	@GetMapping("/customer/{customerId}")
	public CustomerData retrieveCustomer(@PathVariable Long customerId) {
		log.info("Retrieving customer with ID={}", customerId);
		return chairService.retrieveCustomerById(customerId);
	}
	
	@GetMapping("/chair/{chairId}")
	public ChairData retrieveChair(@PathVariable Long chairId) {
		log.info("Retrieving chair with ID={}", chairId);
		return chairService.retrieveChairById(chairId);
	}
	
	/////////////////////////Update Methods/////////////////////////
	@PutMapping("/store/{storeId}")
	public StoreData updateStore(@PathVariable Long storeId, @RequestBody StoreData storeData) {
		storeData.setStoreId(storeId);
		log.info("Upating store {}", storeData);
		return chairService.saveStore(storeData);
	}
	
	@PutMapping("/customer/{customerId}")
	public CustomerData updateCustomer(@PathVariable Long customerId, @RequestBody CustomerData customerData) {
		customerData.setCustomerId(customerId);
		log.info("Updating customer {}", customerData);
		return chairService.saveCustomer(customerData);
	}
	
	@PutMapping("/chair/{chairId}")
	public ChairData updateChair(@PathVariable Long chairId, @RequestBody ChairData chairData) {
		chairData.setChairId(chairId);
		log.info("Updating chair {}", chairData);
		return chairService.saveChair(chairData);
	}
	
	/////////////////////////Delete Methods/////////////////////////
	@DeleteMapping("/store/{storeId}")
	public Map<String, String> deleteStore(@PathVariable Long storeId) {
		log.info("Deleting store with ID={}", storeId);
		chairService.deleteStore(storeId);
		return Map.of("message", "Store with ID=" + storeId + " was deleted successfully.");
	}
	
	@DeleteMapping("/customer/{customerId}")
	public Map<String, String> deleteCustomer(@PathVariable Long customerId) {
		log.info("Deleting customer with ID={}", customerId);
		chairService.deleteCustomer(customerId);
		return Map.of("message", "Customer with ID=" + customerId + " was deleted successfully.");
	}
	
	@DeleteMapping("/chair/{chairId}")
	public Map<String, String> deleteChair(@PathVariable Long chairId) {
		log.info("Deleting chair with ID={}", chairId);
		chairService.deleteChair(chairId);
		return Map.of("message", "Chair with ID=" + chairId + " was deleted successfully.");
	}
	
	/////////////////////////Get List of Chairs/////////////////////////
	@GetMapping("/chair")
	public List<ChairData> retrieveAllChairs() {
		log.info("Retrieving all chairs");
		return chairService.retrieveAllChairs();
	}
}
