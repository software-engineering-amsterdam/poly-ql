package ql.ast;

import java.util.ArrayList;

public class Questionnares {
	private ArrayList<Questionnare> questionnares;
	
	public Questionnares() {
		this.questionnares = new ArrayList<Questionnare>();
	}
	
	public void add(Questionnare q) {
		this.questionnares.add(q);
	}
	
	public ArrayList<Questionnare> getQuestionnares() {
		return this.questionnares;
	}
}
