package ro.pex.movie.model.listener;

import java.time.LocalDateTime;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import ro.pex.movie.model.entity.AbstractEntity;

public class AbstractEntityListener {

	@PrePersist
	public void setCreatedOn(AbstractEntity abstractEntity) {
		abstractEntity.setCreatedOn(LocalDateTime.now());
	}

	@PreUpdate
	public void setUpdatedOn(AbstractEntity abstractEntity) {
		abstractEntity.setUpdatedOn(LocalDateTime.now());
	}

}
