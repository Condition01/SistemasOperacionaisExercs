package model;

public class Car {
	private String marca;
	private String carName;
	
	
	public Car(String marca, String carName) {
		super();
		this.marca = marca;
		this.carName = carName;
		
		
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}



	public String getCarName() {
		return carName;
	}

	public void setCarName(String carName) {
		this.carName = carName;
	}
	
}
