package com.jhonnybooy.myapy.myapy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.jhonnybooy.myapy.myapy.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
