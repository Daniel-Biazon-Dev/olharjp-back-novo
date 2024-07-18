package br.gov.pb.joaopessoa.olharjoaopessoa.exceptionhandler;

import java.io.PrintWriter;
import java.io.StringWriter;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import br.gov.pb.joaopessoa.olharjoaopessoa.exception.EntityCannotBeNull;
import br.gov.pb.joaopessoa.olharjoaopessoa.exception.EntityConflictException;
import br.gov.pb.joaopessoa.olharjoaopessoa.exception.EntityInUseException;
import br.gov.pb.joaopessoa.olharjoaopessoa.exception.EntityNotFoundException;

@ControllerAdvice
public class ControllerExceptionHandler extends ResponseEntityExceptionHandler {

	// TODO
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatusCode status, WebRequest request) {

		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw);
		ex.printStackTrace(pw);
		
		ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(
				HttpStatus.BAD_REQUEST, sw.toString());
		problemDetail.setTitle(ex.getMessage());
		
		return super.handleExceptionInternal(ex, problemDetail, headers, status, request);
	}
	
	@ExceptionHandler(EntityNotFoundException.class)
	public ResponseEntity<Object> handleNegocioException(EntityNotFoundException ex, WebRequest request) {
		var status = HttpStatus.BAD_REQUEST;
		
		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw);
		ex.printStackTrace(pw);
		
		ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(
				HttpStatus.NOT_FOUND, sw.toString());
		problemDetail.setTitle(ex.getMessage());
		
		return handleExceptionInternal(ex, problemDetail, new HttpHeaders(), status, request);
	}
	
	@ExceptionHandler(EntityConflictException.class)
	public ResponseEntity<Object> handleNegocioException(EntityConflictException ex, WebRequest request) {
		var status = HttpStatus.CONFLICT;
		
		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw);
		ex.printStackTrace(pw);
		
		ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(
				HttpStatus.CONFLICT, sw.toString());
		problemDetail.setTitle(ex.getMessage());
		
		return handleExceptionInternal(ex, problemDetail, new HttpHeaders(), status, request);
	}
	
	@ExceptionHandler(EntityInUseException.class)
	public ResponseEntity<Object> handleNegocioException(EntityInUseException ex, WebRequest request) {
		var status = HttpStatus.BAD_REQUEST;
		
		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw);
		ex.printStackTrace(pw);
		
		ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(
				HttpStatus.BAD_REQUEST, sw.toString());
		problemDetail.setTitle(ex.getMessage());
		
		return handleExceptionInternal(ex, problemDetail, new HttpHeaders(), status, request);
	}
	
	@SuppressWarnings("static-access")
	@ExceptionHandler(EntityCannotBeNull.class)
	public ResponseEntity<Object> handleNegocioException(EntityCannotBeNull ex, WebRequest request) {
		var status = HttpStatus.BAD_REQUEST;
		
		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw);
		ex.printStackTrace(pw);
		
		ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(
				HttpStatus.BAD_REQUEST, sw.toString());
		problemDetail.setTitle(ex.getMessage());
		
		return handleExceptionInternal(ex, problemDetail, new HttpHeaders(), status.BAD_REQUEST, request);
	}
}
