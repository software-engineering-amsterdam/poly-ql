package ast.errormsg;

public abstract class Message {
	
	private String message;
	
	public Message(String msg) {
		this.message = msg;
	}

	public String getMessage() {
		return message;
	}



}
