package com.bh.entity;

import java.util.Date;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "Emp5555")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmpEntity {
	
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private int id;
	
	
    private String name;
	private String email;
	private String mobile;
	private String password;
    private String otp;
    private String status;
   
   @Column( insertable = false, updatable = false,columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
   @Temporal(TemporalType.TIMESTAMP)
   private Date registertime; 
   @Transient
   private List<MultipartFile> images;
}
