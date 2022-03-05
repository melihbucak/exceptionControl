package com.project.mergentech.repository;

import com.project.mergentech.entity.Master;
import com.sun.jdi.Value;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;
@CrossOrigin

public interface RepositoryInterface extends JpaRepository<Master,Long> {
//    @Query(value="SELECT m FROM MASTER m")
//    List<Master> MastersWithDetails();
//
//    @Query(value = "SELECT m FROM MASTER m where m_Id = :id")
//    List<Master> findAllByid(Long id);

}
