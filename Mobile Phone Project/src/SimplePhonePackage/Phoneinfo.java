package SimplePhonePackage;

public class Phoneinfo {
	
	/**
	 * Launch the application.
	 * Phoneinfo.java(SimplePhonePackage)
	 * 
	 * Use the integer variables for phone list, amount, totalamount
	 * Use the string variables for phone brand, model, os, ram, color
	 * Generate Constructor using fields for all variables
	 * Generate Getters and Setters method for all variables
	 * 
	 */
	private int list;
	private String brand;
	private int amount;
	private String model;
	private String os;
	private String ram;
	private String color;
	private int totamount;

	public Phoneinfo(int list, String brand, int amount, String model, String os, String ram, String color,
			int totamount) {
		super();
		this.list = list;
		this.brand = brand;
		this.amount = amount;
		this.model = model;
		this.os = os;
		this.ram = ram;
		this.color = color;
		this.totamount = totamount;
	}

	public int getList() {
		return list;
	}

	public void setList(int list) {
		this.list = list;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public int getamount() {
		return amount;
	}

	public void setamount(int amount) {
		this.amount = amount;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getOs() {
		return os;
	}

	public void setOs(String os) {
		this.os = os;
	}

	public String getRam() {
		return ram;
	}

	public void setRam(String ram) {
		this.ram = ram;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getTotamount() {
		return totamount;
	}

	public void setTotamount(int totamount) {
		this.totamount = totamount;
	}

}
