package com.bh.service;

import com.bh.entity.EmpEntity;
import com.bh.model.EmpLoginModel;
import com.bh.model.EmpModel;
import com.bh.model.EmpOTPModel;

public interface EmpService {

	EmpModel empRegisterService(EmpModel empModel);
 
	EmpModel getUserByEmailOrMobile(EmpModel empModel);
	EmpEntity getuserByEmailAndOtp(EmpOTPModel empModel);
	EmpLoginModel empLoginService(EmpLoginModel empLoginModel);

}
