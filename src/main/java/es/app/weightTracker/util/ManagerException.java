package es.app.weightTracker.util;

import org.springframework.dao.DataAccessException;
import org.springframework.http.ResponseEntity;

import es.app.weightTracker.dto.ExceptionDto;


public interface ManagerException {
	
	public ResponseEntity<ExceptionDto> getExceptionDto(DataAccessException e);

}