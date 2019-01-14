package projects.SimulatedParking.Data;

import projects.SimulatedParking.utils.Util;

public class Car {
	private String plate;
	public Car() {
		this.plate = Util.getPalte(); // 每辆对应一个牌照id
	}
	
	// getter
	public String getPlate() {
		return plate;
	}
	
}
