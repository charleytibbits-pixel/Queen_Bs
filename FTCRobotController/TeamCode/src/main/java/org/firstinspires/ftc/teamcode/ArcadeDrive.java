package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class ArcadeDrive {

    private DcMotor leftDrive;
    private DcMotor rightDrive;
    private double leftPower = 0;
    private double rightPower = 0;

    public void init(HardwareMap hwMap) {
        // Names in quotes MUST match the Driver Station configuration exactly
        leftDrive  = hwMap.get(DcMotor.class, "left_drive");
        rightDrive = hwMap.get(DcMotor.class, "right_drive");

        // Motors on opposite sides face opposite ways, so one side gets reversed
        leftDrive.setDirection(DcMotorSimple.Direction.REVERSE);
        rightDrive.setDirection(DcMotorSimple.Direction.FORWARD);

        // TeleOp: plain joystick power, no encoder modes
        leftDrive.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        rightDrive.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        // Stop quickly when the stick is let go
        leftDrive.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        rightDrive.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    }

    public void drive(double throttle, double spin) {
        leftPower  = throttle + spin;
        rightPower = throttle - spin;

        // Keep both powers between -1 and 1 without changing the turn shape
        double max = Math.max(Math.abs(leftPower), Math.abs(rightPower));
        if (max > 1.0) {
            leftPower  /= max;
            rightPower /= max;
        }

        leftDrive.setPower(leftPower);
        rightDrive.setPower(rightPower);
    }

    public double getLeftPower()  { return leftPower; }
    public double getRightPower() { return rightPower; }
}