package projects.SimulatedParking.Data;

import java.util.HashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import projects.SimulatedParking.utils.Util;

public class Parking {
	private String name;
	private boolean[] ps; // 指向停车位的一个数组
	private int size = 0; // 车位数目
	private HashMap<Integer, String> map;
	private Lock parkLock;
	public Parking(String name, int size) {
		this.name = name;
		ps = new boolean[size]; // 初始化停车位信息
		map = new HashMap<>(); // 用于维护停车位到车牌号的一个映射关系
		this.size = size;
		parkLock = new ReentrantLock();
	}
	/**
	 * 表示一辆车从停车场检出
	 * @param car
	 * @return
	 * @throws InterruptedException 
	 */
	public synchronized void drive(Car car) throws InterruptedException {
		int index = this.getIndex(car);
		while (index < 0) {
			wait();
		}
		ps[index] = false;
		map.remove(index);
		System.out.println(car.getPlate() + " 从停车场【 " + this.name + "】 的车位  " + index  + " 开走了");
		this.calcPlates();
		notifyAll();
	}
	/**
	 * 根据车牌信息停车
	 * @param car 
	 * @return
	 * @throws InterruptedException 
	 */
	public synchronized void park(Car car) throws InterruptedException {
		int index = this.getSpace();
		while (index < 0) {
			wait();
		}
		// 将车位置为true，并维护车牌信息和停车位信息
		ps[index] = true;
		map.put(index, car.getPlate());
		System.out.println(car.getPlate() + " 开进了停车场 " + this.name + " 停在了车位  " + index);
		this.calcPlates();
		notifyAll();
	}
	/**
	 * 表示一辆车从停车场检出
	 * @param index 开走的车对应的停车位编号
	 * @return 开走成功返回true，否则返回false
	 */
	public boolean drive(int index) {
		if (index < 0 || index >= this.size || ps[index] == false) { // 注意要先用短路判断下标是否超限，再判断这个停车位是否有车
			return false;
		}
		// 取车这辆车信息，后面用一个map来维护
		ps[index] = false;
		return true;
	}
	/**
	 * 给车办理进入停车场手续
	 * @param index 停车场的索引
	 * @return 成功返回true，否则返回false
	 */
	public boolean park(int index) {
		if (index < 0 || index >= this.size || ps[index] == true) { // 注意要先用短路判断下标是否超限，再判断这个停车位是否有车
			return false;
		}
		// 将车的信息与停车位对应起来
		ps[index] = true;
		return true;
	}
	/**
	 * 判断停车场是否已停满
	 * @return 只要还有空位就返回false
	 */
	public boolean isFull() { 
		for (int i = 0; i < this.size; i++) {
			if (ps[i] == false) {
				return false;
			}
		}
		Util.Println("车位满了！！！！");
		return true;
	}
	/**
	 * 判断停车场是否还有空位
	 * @return 只要还有空位就返回true（最初的设计是想有别于isFull，判断停车场是否一辆车都没有，后来想了下，没有这种应用场景，等有了再完善吧！）
	 */
	public boolean isEmpty() {
		for (int i = 0; i < this.size; i++) {
			if (ps[i] == false) {
				return true;
			}
		}
		Util.Println("车位满了！！！！");
		return false;
	}
	// 一些私有方法
	/**
	 * 用来检验同步正确性的方法(同步的另一种实现)
	 */
	private synchronized void calcPlates() {
		parkLock.lock();
		try {
			int  empty = 0, full = 0;
			for (int i = 0; i < size; i++) {
				if (ps[i] == true) {
					full++;
				} else if (ps[i] == false) {
					empty++;
				}
			}
			Util.Println("停车场还有空位 ： " + empty + " , 已经停了：  "  + full + " 个位置， 总共： " + this.size);
		} finally {
			parkLock.unlock();
		}
	}
	
	/**
	 * 根据车辆信息查找车位编号
	 * @param car
	 * @return
	 */
	private int getIndex(Car car) {
		String plate = car.getPlate();
		for (Integer key : map.keySet()) {
			if (map.get(key).equals(plate)) {
				return key;
			}
		}
		return -1;
	}
	/**
	 * 获取当前停车位为空的第一个索引值
	 * @return 停车位已满返回-1，其他返回下标值
	 */
	private int getSpace() {
		if (this.isFull()) {
			return -1;
		}
		for (int i = 0; i < this.size; i++) {
			if (ps[i] == false) {
				return i;
			}
		}
		return -1;
	}
	
	// getter and setter
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public boolean[] getPs() {
		return ps;
	}
	
}
