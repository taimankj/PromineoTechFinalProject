package chair.store.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import chair.store.entity.Store;

public interface StoreDao extends JpaRepository<Store, Long> {

}
