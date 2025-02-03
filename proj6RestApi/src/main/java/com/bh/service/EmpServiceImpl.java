package com.bh.service;

import java.util.Optional;

import com.bh.model.EmpLoginModel;
import com.bh.model.EmpOTPModel;
import com.bh.utils.SendEmail;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.bh.entity.EmpEntity;
import com.bh.model.EmpModel;
import com.bh.repository.EmpRepository;
import com.bh.utils.OTPGenerator;

@Service
public class EmpServiceImpl implements EmpService {

	EmpRepository empRepository;
	ModelMapper modelMapper;

	public EmpServiceImpl(EmpRepository empRepository, ModelMapper modelMapper) {
		super();
		this.empRepository = empRepository;
		this.modelMapper = modelMapper;
	}

	@Override
	public EmpModel empRegisterService(EmpModel empModel) {

		Optional<EmpEntity> byEmailOrMobile = empRepository.findByEmailOrMobile(empModel.getEmail(),
				empModel.getMobile());
		if (byEmailOrMobile.isPresent()) {
			return null;
		}
		empModel.setStatus("inactive");
		String otp = OTPGenerator.generateOTP();
		empModel.setOtp(otp);
		empRepository.save(modelMapper.map(empModel, EmpEntity.class));


		System.out.println(otp);
		SendEmail.sendOtp(empModel.getEmail(), otp);
		return empModel;

	}


	@Override
	public EmpModel getUserByEmailOrMobile(EmpModel empModel) {

		return modelMapper.map(empRepository.findByEmailOrMobile(empModel.getEmail(),empModel.getMobile()),EmpModel.class);
	}


	@Override
	public EmpEntity getuserByEmailAndOtp(EmpOTPModel empModel) {
		EmpEntity entity = empRepository.findByEmailAndOtp(empModel.getEmail(), empModel.getOtp());
		if(entity != null) {
			entity.setStatus("active");
			empRepository.save(entity);
			return entity;
		}
		return null;
	}

	@Override
	public EmpLoginModel empLoginService(EmpLoginModel empLoginModel) {
		EmpEntity entity = empRepository.findByEmailAndPassword(empLoginModel.getEmail(), empLoginModel.getPassword());
		if(entity != null && entity.getStatus().equals("active") ) {
			return modelMapper.map(entity, EmpLoginModel.class);
		}
		return null;
	}

}
