package ro.pex.movie.model.repository;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ro.pex.movie.model.entity.UserEntity;


@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

	public Optional<UserEntity> findByUserNameAndPassword(String username, String password);
}
