package ro.pex.movie.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ro.pex.movie.model.entity.RentalEntity;

@Repository
public interface RentalRepository extends JpaRepository<RentalEntity, Long> {

}
