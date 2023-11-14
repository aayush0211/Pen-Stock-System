package core;

//import java.util.Objects;

public enum Company {
        CELLO(10.0),PARKER(20.0),REYNOLDS(25.0),INKPEN(30.0);
	private Double cost;

	private Company(double cost) {
		this.cost = cost;
	}

	public double getCost() {
		return cost;
	}
	
	
}
