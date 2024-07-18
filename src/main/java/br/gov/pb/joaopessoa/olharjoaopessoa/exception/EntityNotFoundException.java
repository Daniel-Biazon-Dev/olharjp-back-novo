package br.gov.pb.joaopessoa.olharjoaopessoa.exception;

public class EntityNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 2336722412869241617L;

	public EntityNotFoundException(String message) {
		super(message);
	}
}
