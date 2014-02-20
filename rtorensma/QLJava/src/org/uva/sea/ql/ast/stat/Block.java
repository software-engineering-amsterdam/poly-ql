package org.uva.sea.ql.ast.stat;

import java.util.List;

import org.uva.sea.ql.checker.FormVisitor;

public class Block extends Stat {
	private final List<Stat> stats;

	public Block(List<Stat> stats) {
		this.stats = stats;
	}

	public List<Stat> getStats() {
		return stats;
	}
	
	@Override
	public <T> T accept(FormVisitor<T> visitor) {
		return visitor.visit(this);
	}
}
