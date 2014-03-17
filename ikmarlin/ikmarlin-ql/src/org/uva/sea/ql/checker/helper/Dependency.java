package org.uva.sea.ql.checker.helper;


public class Dependency implements IPair<String , String> {
	
	private String x, y;
	
	public Dependency(String x, String y){
		setX(x);
		setY(y);
	}
	
	public Dependency(Dependency d){
		setX(d.getX());
		setY(d.getY());
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
	public IPair<String, String> getPair(){
		return this;
	}
	
	@Override
	public String toString(){
		return "<"+getX()+", "+getY()+">";
	}
	
	@Override
	public void flip() {
		String z = getX();
		setX(getY());
		setY(z);
	}
	
	public boolean equals(Dependency d){
		boolean equals = false;
		if(getX().equals(d.getX()) && getY().equals(d.getY())){
			equals = true;
		}		
		return equals;
	}

}
