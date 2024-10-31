package singleagency.project_fliq.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import singleagency.project_fliq.entities.Users;

import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<Users, UUID> {
}
