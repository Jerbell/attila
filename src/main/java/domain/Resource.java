package domain;

import lombok.Getter;

@Getter
public enum Resource {
	
	DYES(12),
	GEMSTONES(20),
	SALT(8),
	SPICES(14),
	IRON(6),
	LEAD(5),
	FURS(10),
	MARBLE(8),
	OLIVE_OIL(6),
	SILK(16),
	TIMBER(5),
	WINE(10);
	
	private int value;
	
	private Resource(int value) {
		this.value = value;
	}
	
}
