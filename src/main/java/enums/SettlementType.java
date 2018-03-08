package enums;

import lombok.Getter;

@Getter
public enum SettlementType {
	
	CAPITAL_CITY(6, true),
	CITY(6, false),
	CAPITAL_TOWN(4, true),
	TOWN(4, false);
	
	private int limit;
	private boolean capital;
	
	private SettlementType(int limit, boolean capital) {
		this.limit = limit;
		this.capital = capital;
	}
	
}
