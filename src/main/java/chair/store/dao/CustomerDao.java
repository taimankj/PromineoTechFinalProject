package chair.store.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import chair.store.entity.Customer;

public interface CustomerDao extends JpaRepository<Customer, Long> {

}
