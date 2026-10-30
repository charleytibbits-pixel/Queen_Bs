package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.*;

public class LaunchWheel {
    public static double P = 1.5, F = 12;          // tuned values
    public static double NOMINAL_VOLTAGE = 12.5; // battery voltage when you tuned
    public static double HIGH_VELOCITY = 1500, LOW_VELOCITY = 900;

    private DcMotorEx motor;
    private VoltageSensor battery;
    private double target = 0;

    public void init(HardwareMap hardwareMap) {
        motor = hardwareMap.get(DcMotorEx.class, "Launch_motor");
        motor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        motor.setDirection(DcMotorSimple.Direction.FORWARD);
        battery = hardwareMap.voltageSensor.iterator().next();
    }

    /** Set speed in ticks/sec (0 = stop). Call every loop so it keeps adjusting for the battery. */
    public void launch(double velocity) {
        target = velocity;
        double scale = NOMINAL_VOLTAGE / battery.getVoltage();
        motor.setPIDFCoefficients(DcMotor.RunMode.RUN_USING_ENCODER,
                new PIDFCoefficients(P * scale, 0, 0, F * scale));
        motor.setVelocity(velocity);
    }

    public boolean isAtSpeed() {
        return target > 0 && Math.abs(target - motor.getVelocity()) < 100;
    }

    public double getVelocity() { return motor.getVelocity(); }
    public double getVoltage()  { return battery.getVoltage(); }
}