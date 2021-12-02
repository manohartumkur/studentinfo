package com.finonyx.app.repository;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.finonyx.app.model.StudentAlertRequestDTO;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;

import lombok.extern.slf4j.Slf4j;

@Repository
@Slf4j
public class StudentAlertServiceDao {
	@Value(value = "${notificationurl}")
	private String url;

	public String callStudentAlertService(StudentAlertRequestDTO stuAlert) throws Exception {
		HttpResponse<String> response = Unirest.post(url).header("accept", "application/json")
				.header("Accept-Encoding", "gzip, dflate, br").body(new ObjectMapper().writeValueAsString(stuAlert))
				.asString();

		return response.getBody();
	}

}