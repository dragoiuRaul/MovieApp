package ro.pex.movie.model.repository;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ro.pex.movie.model.entity.TransactionEntity;


@Repository
public interface TransactionRepository extends JpaRepository<TransactionEntity, Long> {

}
