
package com.finonyx.app.repository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.finonyx.app.model.StudentInfoRequestDTO;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;

@Repository
public class StudentInfoServiceDao {

	@Value(value = "${validateurl}")
	private String url;

	private static final Logger log = LoggerFactory.getILoggerFactory().getLogger("StudentInfoServiceDao");

	public String callStudentService(StudentInfoRequestDTO student) throws Exception {
		log.info(url);
		HttpResponse<String> response = Unirest.post(url).header("accept", "application/json")
				.header("Accept-Encoding", "gzip, dflate, br").body(new ObjectMapper().writeValueAsString(student))
				.asString();
		return response.getBody();
	}

}