package com.Ty.user.userDetails.dto;

import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.Ty.user.userDetails.util.AesEncryption;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	String name;
	long phone;
	String email;
	@Convert(converter = AesEncryption.class)
	String password;
	String address;

}
