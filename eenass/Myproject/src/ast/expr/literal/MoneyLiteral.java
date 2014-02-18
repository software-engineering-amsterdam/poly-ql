package ast.expr.literal;

import typecheck.Symboles;
import ast.Visitor;
import ast.types.MoneyType;
import ast.types.Types;

public class MoneyLiteral extends Literals{
	
	private Double money;

	public MoneyLiteral(Double money) {
		this.setMoney(money);
	}

	public Double getMoney() {
		return money;
	}

	public void setMoney(Double money) {
		this.money = money;
	}

	@Override
	public <T> T accept(Visitor<T> visitor) {
		return visitor.visit(this);
	}

	@Override
	public Types typeof(Symboles symb) {
		return new MoneyType();
	}

}
