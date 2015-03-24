package no.mesan.fagark.persistering.neo4j.vo;

public class Percent {

	private int percent;
	
	private Percent(final int percent) {
		this.percent = percent;
	}
	
	public Integer getValue() {
		return percent;
	}
	
	public static Percent fromInteger(final Integer percent) {
		if(percent == null) {
			return null;
		}
		
		return new Percent(percent);
	}
	
	public static Percent fromString(final String percent) {
		if(percent == null) {
			return null;
		}
		
		return new Percent(Integer.parseInt(percent));
	}
	
	public String toString() {
		return percent + "";
	}
	
}
