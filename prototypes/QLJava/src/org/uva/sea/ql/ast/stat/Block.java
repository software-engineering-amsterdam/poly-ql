package org.uva.sea.ql.ast.stat;

import java.util.List;

public class Block extends Stat {
	private final List<Stat> stats;

	public Block(List<Stat> stats) {
		this.stats = stats;
	}

	public List<Stat> getStats() {
		return stats;
	}
	
	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}

}
