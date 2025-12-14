package de.openaqua.batchdemo.dataloaderbatchprocessing.repository;


import de.openaqua.batchdemo.dataloaderbatchprocessing.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
}
