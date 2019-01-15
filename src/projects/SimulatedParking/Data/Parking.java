package projects.SimulatedParking.Data;

import java.awt.RenderingHints.Key;
import java.util.HashMap;

public class Parking {
	private String name;
	private boolean[] ps; // 指向停车位的一个数组
	private int size = 0; // 车位数目
	private HashMap<Integer, String> map;
	public Parking(String name, int size) {
		this.name = name;
		ps = new boolean[size]; // 初始化停车位信息
		map = new HashMap<>(); // 用于维护停车位到车牌号的一个映射关系
		this.size = size;
	}
	/**
	 * 表示一辆车从停车场检出
	 * @param car
	 * @return
	 */
	public boolean drive(Car car) {
		int index = this.getIndex(car);
		if (index < 0) {
			return false;
		}
		ps[index] = false;
		map.remove(index);
		return true;
	}
	/**
	 * 根据车牌信息停车
	 * @param car 
	 * @return
	 */
	public boolean park(Car car) {
		int index = this.getSpace();
		if (index < 0) {
			return false;
		}
		// 将车位置为true，并维护车牌信息和停车位信息
		ps[index] = true;
		map.put(index, car.getPlate());
		return true;
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
		return false;
	}
	// 一些私有方法
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
