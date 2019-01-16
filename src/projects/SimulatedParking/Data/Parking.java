package projects.SimulatedParking.Data;

import java.util.HashMap;

import projects.SimulatedParking.utils.Util;

public class Parking {
	private String name;
	private boolean[] ps; // ָ��ͣ��λ��һ������
	private int size = 0; // ��λ��Ŀ
	private HashMap<Integer, String> map;
	public Parking(String name, int size) {
		this.name = name;
		ps = new boolean[size]; // ��ʼ��ͣ��λ��Ϣ
		map = new HashMap<>(); // ����ά��ͣ��λ�����ƺŵ�һ��ӳ���ϵ
		this.size = size;
	}
	/**
	 * ��ʾһ������ͣ�������
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
		System.out.println(car.getPlate() + " ��ͣ������ " + this.name + "�� �ĳ�λ  " + index  + " ������");
		notifyAll();
	}
	/**
	 * ���ݳ�����Ϣͣ��
	 * @param car 
	 * @return
	 * @throws InterruptedException 
	 */
	public synchronized void park(Car car) throws InterruptedException {
		int index = this.getSpace();
		while (index < 0) {
			wait();
		}
		// ����λ��Ϊtrue����ά��������Ϣ��ͣ��λ��Ϣ
		ps[index] = true;
		map.put(index, car.getPlate());
		System.out.println(car.getPlate() + " ������ͣ���� " + this.name + " ͣ���˳�λ  " + index);
		notifyAll();
	}
	/**
	 * ��ʾһ������ͣ�������
	 * @param index ���ߵĳ���Ӧ��ͣ��λ���
	 * @return ���߳ɹ�����true�����򷵻�false
	 */
	public boolean drive(int index) {
		if (index < 0 || index >= this.size || ps[index] == false) { // ע��Ҫ���ö�·�ж��±��Ƿ��ޣ����ж����ͣ��λ�Ƿ��г�
			return false;
		}
		// ȡ����������Ϣ��������һ��map��ά��
		ps[index] = false;
		return true;
	}
	/**
	 * �����������ͣ��������
	 * @param index ͣ����������
	 * @return �ɹ�����true�����򷵻�false
	 */
	public boolean park(int index) {
		if (index < 0 || index >= this.size || ps[index] == true) { // ע��Ҫ���ö�·�ж��±��Ƿ��ޣ����ж����ͣ��λ�Ƿ��г�
			return false;
		}
		// ��������Ϣ��ͣ��λ��Ӧ����
		ps[index] = true;
		return true;
	}
	/**
	 * �ж�ͣ�����Ƿ���ͣ��
	 * @return ֻҪ���п�λ�ͷ���false
	 */
	public boolean isFull() { 
		for (int i = 0; i < this.size; i++) {
			if (ps[i] == false) {
				return false;
			}
		}
		Util.Println("��λ���ˣ�������");
		return true;
	}
	/**
	 * �ж�ͣ�����Ƿ��п�λ
	 * @return ֻҪ���п�λ�ͷ���true���������������б���isFull���ж�ͣ�����Ƿ�һ������û�У����������£�û������Ӧ�ó����������������ưɣ���
	 */
	public boolean isEmpty() {
		for (int i = 0; i < this.size; i++) {
			if (ps[i] == false) {
				return true;
			}
		}
		Util.Println("��λ���ˣ�������");
		return false;
	}
	// һЩ˽�з���
	/**
	 * ��������ͬ����ȷ�Եķ���(ͬ������һ��ʵ��)
	 */
	
	/**
	 * ���ݳ�����Ϣ���ҳ�λ���
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
	 * ��ȡ��ǰͣ��λΪ�յĵ�һ������ֵ
	 * @return ͣ��λ��������-1�����������±�ֵ
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
