package ql.main;

public class ASTCheckerError extends Exception {
	private static final long serialVersionUID = 1L;

	public ASTCheckerError(String errors) {
		super(errors);
	}

}
