package enums;

import lombok.Getter;

@Getter
public enum SettlementType {
	
	COASTAL_CAPITAL_CITY(6, true, true),
	COASTAL_CITY(6, false, true),
	COASTAL_CAPITAL_TOWN(4, true, true),
	COASTAL_TOWN(4, false, true),
	CAPITAL_CITY(6, true, false),
	CITY(6, false, false),
	CAPITAL_TOWN(4, true, false),
	TOWN(4, false, false);
	
	private int limit;
	private boolean capital;
	private boolean coastal;
	
	private SettlementType(int limit, boolean capital, boolean coastal) {
		this.limit = limit;
		this.capital = capital;
		this.coastal = coastal;
	}
	
}
