package projects.SimulatedParking.test;

import projects.SimulatedParking.Business.DriveRunnable;
import projects.SimulatedParking.Business.ParkRunnable;
import projects.SimulatedParking.Data.Car;
import projects.SimulatedParking.Data.Parking;
import projects.SimulatedParking.utils.Util;

/**
 * 整个项目的测试类
 * @author XZP
 *
 */
public class Test {
	public static final int ONE_DAY_CARS = 100;
	public static void main(String[] args) {
		Parking parking = new Parking("浙江大学停车场", 1000); // 实例化一个停车场
		for (int i = 0; i < ONE_DAY_CARS; i++) {
			Car car = new Car();
			DriveRunnable dr = new DriveRunnable(car, parking);
			ParkRunnable pr = new ParkRunnable(car, parking);
			Thread thread = new Thread(dr);
			Thread thread1 = new Thread(pr);
			thread.start();
			thread1.start();
		}
	}

}
