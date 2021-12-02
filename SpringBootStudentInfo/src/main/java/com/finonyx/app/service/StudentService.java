package com.finonyx.app.service;

import com.finonyx.app.model.StudentAlertDTO;
import com.finonyx.app.model.StudentInfoDTO;

public interface StudentService {
	String alertStudent(StudentAlertDTO studentAlertDTO) throws Exception;

	String validateStudent(StudentInfoDTO studentInfo) throws Exception;
}
