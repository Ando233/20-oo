public class Motorbike extends Vehical{
    Person driver;
    Person passenager;

    public Motorbike(int wheelNum, Person driver, Person passenager) {
        super(wheelNum);
        setDriver(driver);
        setPassenager(passenager);
    }

    public void setDriver(Person driver) {
        this.driver = driver;
    }

    public void setPassenager(Person passenager) {
        this.passenager = passenager;
    }

    @Override
    public String toString() {
        return ("Wheel_num:" + wheelNum + '\n' +
                "Driver:" + driver.name + '\n' +
                "Passenager:" + passenager.name + '\n');
    }
}
