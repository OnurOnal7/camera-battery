
package hw1;

/*
 * @author - Onur Onal
 */

public class CameraBattery {
	
	// The number of external charge settings
	public static final int NUM_CHARGER_SETTINGS = 4; 
	
	// The constant used to calculate the charge rate of the external charger
	public static final double CHARGE_RATE = 2.0; 
	
	// Default power consumption of the camera
	public static final double DEFAULT_CAMERA_POWER_CONSUMPTION = 1.0; 
	
	// Initial battery charge
	private double batteryStartingCharge;
	
	// Charging capacity for the battery
	private double batteryCapacity;
	
	// Charge of the battery
	private double batteryCharge;
	
	// Initial charge setting
	private int chargeSetting = 0;
	
	// Charge of battery connected to camera
	private double cameraCharge = 0;
	
	// The status of the connection of the external charger to the battery
	private int externalChargerToBattery = 0;
	
	// The status of the connection of the battery to the camera
	private int batteryToCamera = 0;
	
	// Total battery drain count
	private double totalBatteryDrain = 0;
	
	// Total camera power consumption
	private double cameraPowerConsumption = 1.0;
	
	/*
	 *  Constructor to create a new camera battery simulation. 
	 *  @param - batteryStartingCharge: Starting charge of the battery
	 *  @param - batteryCapacity: Charging capacity for the battery
	 */
	public CameraBattery(double batteryStartingCharge, double batteryCapacity) {
				
		this.batteryStartingCharge = batteryStartingCharge;
		this.batteryCapacity = batteryCapacity;
		
		batteryCharge = Math.min(batteryStartingCharge, batteryCapacity);
				
	}
	
	// Increments charge setting by 1 until maximum setting
	public void buttonPress() {
		
		chargeSetting++;
		
		chargeSetting = chargeSetting % NUM_CHARGER_SETTINGS;
	}
	
	/*
	 *  Charges the battery connected to camera
	 *  @param - minutes: The amount of time the battery is connected to camera
	 */
	public double cameraCharge(double minutes) {
		
		double charge = (minutes * CHARGE_RATE * batteryToCamera);
								
		charge = Math.min(charge, batteryCapacity - cameraCharge);
		
		cameraCharge += charge;

		batteryCharge += charge;
				
		return charge;
	}
	
	/*
	 * Drains the battery connected to camera
	 * @param - minutes: The amount of time the battery is drained
	 */
	public double drain(double minutes) {
		
		double drain = (minutes * DEFAULT_CAMERA_POWER_CONSUMPTION * batteryToCamera * cameraPowerConsumption);
		
		drain = Math.min(drain, batteryCharge);
		
		cameraCharge -= drain;
		batteryCharge -= drain;
		totalBatteryDrain += drain;
		
		return drain;
	}
	
	/*
	 * Charges battery connected to external charger
	 * @param - minutes: The amount of time the battery is connected to external charger
	 */
    public double externalCharge(double minutes) {
    	
    	double charge = (minutes * CHARGE_RATE * chargeSetting * externalChargerToBattery);
    	
    	charge = Math.min(charge, batteryCapacity - batteryCharge);
    	
    	batteryCharge += charge;
    	
    	return charge;
    }
    
    // Resets battery drain count to 0
    public void resetBatteryMonitor() {
    	totalBatteryDrain = 0;
    }
    
    // Returns battery capacity
    public double getBatteryCapacity() {
    	return batteryCapacity;
    }
    
    // Returns current battery charge
    public double getBatteryCharge() {
    	return batteryCharge;
    }
    
    // Returns current camera charge
    public double getCameraCharge() {
    	return cameraCharge;
    }
    
    // Returns the power consumption of the camera
    public double getCameraPowerConsumption() {
    	return cameraPowerConsumption; 
    }
    
    // Returns the charger setting
    public int getChargerSetting() {
    	return chargeSetting;
    }
    
    // Returns the total amount of power drained from the battery
    public double getTotalDrain() {
    	return totalBatteryDrain;
    }
    
    // Moves the battery to the external charger
    public void moveBatteryExternal() {
    	externalChargerToBattery = 1;
    	batteryToCamera = 0;
    }
    
    // Moves the battery to the camera
    public void moveBatteryCamera() {
    	cameraCharge = batteryCharge;
    	
    	
    	externalChargerToBattery = 0;
    	batteryToCamera = 1;    
    }
    
    // Removes the battery from the camera or external charger
    public void removeBattery() {
    	cameraCharge = 0;
    	
    	externalChargerToBattery = 0;
    	batteryToCamera = 0;   
    }
    
    /*
     * Sets the power consumption of the camera
     * @param - cameraPowerConsumption: The power consumption of the camera
     */
    public void setCameraPowerConsumption(double cameraPowerConsumption) {
    	this.cameraPowerConsumption = cameraPowerConsumption;
    }
}
























































