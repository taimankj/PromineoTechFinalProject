package chair.store.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import chair.store.controller.model.ChairData;
import chair.store.controller.model.CustomerData;
import chair.store.controller.model.StoreData;
import chair.store.dao.ChairDao;
import chair.store.dao.CustomerDao;
import chair.store.dao.StoreDao;
import chair.store.entity.Chair;
import chair.store.entity.Customer;
import chair.store.entity.Store;

@Service
public class ChairService {
	
	@Autowired
	private StoreDao storeDao;
	@Autowired
	private CustomerDao customerDao;
	@Autowired
	private ChairDao chairDao;
	
	@Transactional(readOnly = false)
	public StoreData saveStore(StoreData storeData) {
		Store store = storeData.toStore();
		Store dbStore = storeDao.save(store);
		
		return new StoreData(dbStore);
	}
	
	@Transactional(readOnly = false)
	public CustomerData saveCustomer(CustomerData customerData) {
		Customer customer = customerData.toCustomer();
		Customer dbCustomer = customerDao.save(customer);
		
		return new CustomerData(dbCustomer);
	}
	
	@Transactional(readOnly = false)
	public ChairData saveChair(ChairData chairData) {
		Chair chair = chairData.toChair();
		Chair dbChair = chairDao.save(chair);
		
		return new ChairData(dbChair);
	}
	
	@Transactional(readOnly = true)
	public StoreData retrieveStoreById(Long storeId) {
		Store store = findStoreById(storeId);
		return new StoreData(store);
	}

	private Store findStoreById(Long storeId) {
		return storeDao.findById(storeId)
				.orElseThrow(() -> new NoSuchElementException("Store with ID=" + storeId + " was not found."));
	}
	
	@Transactional(readOnly = true)
	public CustomerData retrieveCustomerById(Long customerId) {
		Customer customer = findCustomerById(customerId);
		return new CustomerData(customer);
	}
	
	private Customer findCustomerById(Long customerId) {
		return customerDao.findById(customerId)
				.orElseThrow(() -> new NoSuchElementException("Customer with ID=" + customerId + " was not found."));
	}
	
	@Transactional(readOnly = true)
	public ChairData retrieveChairById(Long chairId) {
		Chair chair = findChairById(chairId);
		return new ChairData(chair);
	}
	
	private Chair findChairById(Long chairId) {
		return chairDao.findById(chairId)
				.orElseThrow(() -> new NoSuchElementException("Chair with ID=" + chairId + " was not found."));
	}
	
	@Transactional(readOnly = false)
	public void deleteStore(Long storeId) {
		Store store = findStoreById(storeId);
		storeDao.delete(store);
	}
	
	@Transactional(readOnly = false)
	public void deleteCustomer(Long customerId) {
		Customer customer = findCustomerById(customerId);
		customerDao.delete(customer);
	}
	
	@Transactional(readOnly = false)
	public void deleteChair(Long chairId) {
		Chair chair = findChairById(chairId);
		chairDao.delete(chair);
	}

	public List<ChairData> retrieveAllChairs() {
		// @formatter:off
		return chairDao.findAll()
				.stream()
				.map(chair -> new ChairData(chair))
				.toList();
		// @formatter:on
	}
	
	
}
