package org.uva.sea.ql.checker;

public class Dependancy implements Pair<String, String> {
	
	private String x, y;
	
	public Dependancy(String x, String y){
		setX(x);
		setY(y);
	}

	@Override
	public String getX() {
		return x;
	}

	@Override
	public String getY() {
		return y;
	}

	@Override
	public void setX(String x) {
		this.x = x;
	}

	@Override
	public void setY(String y) {
		this.y = y;
	}
	
	@Override
	public Pair<String, String> getPair(){
		return this;
	}
	
	@Override
	public String toString(){
		return "<"+getX()+", "+getY()+">";
	}
	
	@Override
	public void flip() {
		System.out.println("flip: "+toString());
		String z = getX();
		setX(getY());
		setY(z);
		System.out.println("to: "+toString());
	}
	
	public boolean equals(Dependancy d){
		boolean equals = false;
		if(getX().equals(d.getX()) && getY().equals(d.getY())){
			equals = true;
		}		
		return equals;
	}

}
