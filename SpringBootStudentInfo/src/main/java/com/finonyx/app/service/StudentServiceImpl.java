package com.finonyx.app.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.finonyx.app.model.StudentAlertDTO;
import com.finonyx.app.model.StudentAlertRequestDTO;
import com.finonyx.app.model.StudentInfoDTO;
import com.finonyx.app.model.StudentInfoRequestDTO;
import com.finonyx.app.repository.StudentAlertServiceDao;
import com.finonyx.app.repository.StudentInfoServiceDao;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class StudentServiceImpl implements StudentService {

	Logger log = LoggerFactory.getILoggerFactory().getLogger("StudentServiceImpl");
	@Autowired
	private StudentInfoServiceDao studentInfoDao;
	@Autowired
	private StudentAlertServiceDao studentAlertServiceDao;

	@Value(value = "${u}")
	private String userName;
	@Value(value = "${p}")
	private String password;

	@Override
	public String validateStudent(StudentInfoDTO studentInfo) throws Exception {
		log.info(password);
		log.info(userName);
		StudentInfoRequestDTO student = new StudentInfoRequestDTO();

		student.setStudentNumber(studentInfo.getStudentNumber());
		student.setUsername(userName);
		student.setPassword(password);

		return studentInfoDao.callStudentService(student);

	}

	@Override
	public String alertStudent(StudentAlertDTO theRequest) throws Exception {

		StudentAlertRequestDTO stuAlert = new StudentAlertRequestDTO();

		stuAlert.setAccountNumber(theRequest.getAccountNumber());
		stuAlert.setAmount(theRequest.getAmount());
		stuAlert.setPaymentMode(theRequest.getPaymentMode());
		stuAlert.setStudentNumber(theRequest.getStudentNumber());
		stuAlert.setTransactionCode(theRequest.getTransactionCode());
		stuAlert.setTransactionDate(theRequest.getTransactionDate());
		stuAlert.setUsername(userName);
		stuAlert.setPassword(password);

		return studentAlertServiceDao.callStudentAlertService(stuAlert);

	}

}
