package projects.SimulatedParking.Business;

import projects.SimulatedParking.Data.Car;
import projects.SimulatedParking.Data.Parking;

/**
 * 模拟一次停车任务
 * @author XZP
 *
 */
public class ParkRunnable implements Runnable {
	private Car car;
	private Parking park;
	private int plate;
	public ParkRunnable(Car car, Parking park) {
		// TODO Auto-generated constructor stub
		this.car = car;
		this.park = park;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			while (true) {
				park.park(car);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
