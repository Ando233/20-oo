public class Tank extends Vehical{
    Person driver;

    public Tank(int wheelNum, Person driver) {
        super(wheelNum);
        setDriver(driver);
    }

    public void setDriver(Person driver) {
        this.driver = driver;
    }

    @Override
    public String toString() {
        return ("Wheel_num:" + wheelNum + '\n' +
                "Driver:" + driver.name + '\n');
    }
}
