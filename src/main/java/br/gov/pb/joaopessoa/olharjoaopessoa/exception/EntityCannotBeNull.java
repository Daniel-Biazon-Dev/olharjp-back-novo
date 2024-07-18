package br.gov.pb.joaopessoa.olharjoaopessoa.exception;

public class EntityCannotBeNull extends RuntimeException {

	private static final long serialVersionUID = -961253264191828691L;

	public EntityCannotBeNull(String message) {
		super(message);
	}
}
