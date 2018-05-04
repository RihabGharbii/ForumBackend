package org.sid.dao;

import org.sid.entities.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Commentrepository extends JpaRepository<Comment, Long>{

}
