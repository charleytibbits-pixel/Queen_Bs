package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;

//@TeleOp(name = "Launch Wheel", group = "Linear OpMode")
public class LaunchWheel  {

    // Hardware declarations
    private DcMotorEx flywheelMotor;

    // Target velocity constants (in encoder ticks per second)
    private static final double TARGET_VELOCITY_MAX = 8000.0;
    private static final double VELOCITY_TOLERANCE = 100.0; // Allowed margin to check if flywheel is fast enough

    public void init(HardwareMap hardwareMap) {
// Save the OpMode's telemetry so this class can use it
        flywheelMotor = hardwareMap.get(DcMotorEx.class, "Launch_motor");

    }
    public void launch(double speed) {
        // Initialize hardware from the robot configuration screen


            flywheelMotor.setPower(speed);
    }
}

