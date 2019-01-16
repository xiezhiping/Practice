package projects.SimulatedParking.Business;

import projects.SimulatedParking.Data.Car;
import projects.SimulatedParking.Data.Parking;

/**
 * 模拟一次检出任务
 * @author XZP
 *
 */
public class DriveRunnable implements Runnable {
	private Car car;
	private Parking park;
	private int plate;
	public DriveRunnable(Car car, Parking park) {
		// TODO Auto-generated constructor stub
		this.car = car;
		this.park = park;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			while (true) {
				park.drive(car);
				Thread.sleep(1000);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
