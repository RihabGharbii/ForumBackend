package org.sid.dao;

import org.sid.entities.Data;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DataRepository extends JpaRepository<Data, Long>{

}
