package com.finonyx.app.controller;

import javax.validation.Valid;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.finonyx.app.model.StudentAlertDTO;
import com.finonyx.app.model.StudentInfoDTO;
import com.finonyx.app.service.StudentService;

@RestController
@RequestMapping("/v3/stu")
@Validated
public class StudentController {
	@Autowired
	StudentService studentService;

	@PostMapping("/val")

	public ResponseEntity<String> StudentInfo(@RequestBody StudentInfoDTO studentInfo) throws Exception {

		try {
			if (StringUtils.isEmpty(studentInfo.getStudentNumber())) {
				throw new IllegalArgumentException("Empty student Number");
			}
			return ResponseEntity.ok(studentService.validateStudent(studentInfo));

		} catch (Exception e) {
			throw e;
		}

	}

	@PostMapping("/notify")
	public ResponseEntity<String> AlertStudent(@Valid @RequestBody StudentAlertDTO studentAlertDTO) throws Exception {

		try {

			return ResponseEntity.ok(studentService.alertStudent(studentAlertDTO));

		} catch (Exception e) {
			throw e;
		}

	}
}
