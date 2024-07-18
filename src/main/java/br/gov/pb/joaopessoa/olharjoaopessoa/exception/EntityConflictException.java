package br.gov.pb.joaopessoa.olharjoaopessoa.exception;

public class EntityConflictException extends RuntimeException {

	private static final long serialVersionUID = -2522681306714867343L;

	public EntityConflictException(String message) {
		super(message);
	}
}
