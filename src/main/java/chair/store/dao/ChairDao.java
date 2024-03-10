package chair.store.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import chair.store.entity.Chair;

public interface ChairDao extends JpaRepository<Chair, Long> {

}
