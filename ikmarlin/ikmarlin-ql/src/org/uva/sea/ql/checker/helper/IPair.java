package org.uva.sea.ql.checker.helper;

public interface IPair<A,B> {
	
	void setX(A x);
	A getX();
	void setY(B y);
	B getY();
	IPair<A,B> getPair();
	void flip();
}
