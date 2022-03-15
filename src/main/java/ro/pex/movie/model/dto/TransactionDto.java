package ro.pex.movie.model.dto;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import ro.pex.movie.model.entity.RentalEntity;
import ro.pex.movie.model.entity.UserEntity;

public class TransactionDto {

	
	@JsonIgnore
	private int id;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "userid", nullable = false)
	private UserEntity userEntity;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "rentalid", nullable = false)
	private RentalEntity rentalEntity;
	
	@Column(name="quantity", nullable=false)
	private String quantity;

	public UserEntity getUserEntity() {
		return userEntity;
	}

	public void setUserEntity(UserEntity userEntity) {
		this.userEntity = userEntity;
	}

	public RentalEntity getRentalEntity() {
		return rentalEntity;
	}

	public void setRentalEntity(RentalEntity rentalEntity) {
		this.rentalEntity = rentalEntity;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	
	
}
