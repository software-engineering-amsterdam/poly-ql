package org.uva.sea.ql.checker;

public interface Pair<A,B> {
	
	void setX(A x);
	A getX();
	void setY(B y);
	B getY();
	Pair<A,B> getPair();
	void flip();
}
