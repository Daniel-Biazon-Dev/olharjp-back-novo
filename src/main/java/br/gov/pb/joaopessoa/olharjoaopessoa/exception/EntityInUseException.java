package br.gov.pb.joaopessoa.olharjoaopessoa.exception;

public class EntityInUseException extends RuntimeException {

	private static final long serialVersionUID = 4817914074327688284L;
	
	public EntityInUseException(String message) {
		super(message);
	}

}
