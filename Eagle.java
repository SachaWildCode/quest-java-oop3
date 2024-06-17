public class Eagle extends Bird implements Fly {

    private boolean flying;
    private int altitude;

    public Eagle(String name) {
        super(name);
        this.flying = false;
        this.altitude = 0;
    }

    public int getAltitude() {
        return altitude;
    }

    public boolean isFlying() {
        return flying;
    }

    @Override
    public String sing() {
        return "Screech!";
    }

    @Override
    public int ascend(int meters) {
        if (meters < 0) {
            System.out.println("Cannot ascend by a negative number of meters.");
            return this.altitude;
        }
        if (this.isFlying()) {
            this.altitude += meters;
            System.out.println(getName() + " flies upward, altitude: " + this.getAltitude());
        } else {
            System.out.println(getName() + " is not flying, it can't ascend.");
        }
        return this.altitude;
    }

    @Override
    public int descend(int meters) {
        if (meters < 0) {
            System.out.println("Cannot descend by a negative number of meters.");
            return this.altitude;
        }
        if (this.isFlying()) {
            if (this.altitude - meters < 0) {
                System.out.println(getName() + " cannot descend below 0 meters.");
                return this.altitude;
            }
            this.altitude -= meters;
            System.out.println(getName() + " flies downward, altitude: " + this.getAltitude());
        } else {
            System.out.println(getName() + " is not flying, it can't descend.");
        }
        return this.altitude;
    }

    @Override
    public int glide() {
        if (this.isFlying()) {
            System.out.println(getName() + " glides into the air.");
            return this.altitude;
        } else {
            System.out.println(getName() + " is not flying, it can't glide.");
            return this.altitude;
        }
    }

    @Override
    public void takeOff() {
        if (this.isFlying()) {
            System.out.println(getName() + " is already flying.");
        } else {
            this.flying = true;
            System.out.println(this.getName() + " takes off in the sky.");
        }
    }

    @Override
    public void land() {
        if (!this.isFlying()) {
            System.out.println(getName() + " is not flying, it can't land.");
        } else if (this.altitude > 1) {
            System.out.println(this.getName() + " is too high, it can't land.");
        } else {
            this.flying = false;
            System.out.println(this.getName() + " lands on the ground.");
        }
    }

}
