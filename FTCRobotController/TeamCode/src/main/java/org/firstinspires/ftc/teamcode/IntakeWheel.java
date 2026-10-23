package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import org.firstinspires.ftc.robotcore.external.Telemetry;

public class IntakeWheel {

    // Declare the DC Motor
    private DcMotor intakeMotor = null;

    // Telemetry passed in from the OpMode
    private Telemetry telemetry = null;

    // Define speed constants
    public static final double INTAKE_SPEED = 0.6; // 100% power for collection
    public static final double OUTTAKE_SPEED = -0.6; // 60% power for controlled ejection
    public static final double MOTOR_OFF = 0.0; // Stopped

    public void init(HardwareMap hardwareMap, Telemetry telemetry) {
// Save the OpMode's telemetry so this class can use it
        this.telemetry = telemetry;

// Name must EXACTLY match the motor name in your Driver Hub configuration
        intakeMotor = hardwareMap.get(DcMotor.class, "IntakeWheel");

// Change to REVERSE if the motor spins the wrong way
        intakeMotor.setDirection(DcMotorSimple.Direction.FORWARD);

// Intakes do not need encoders
        intakeMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

// FLOAT lets the wheels spin down naturally
        intakeMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);

        telemetry.addData("Status", "IntakeWheel Initialized!");
        telemetry.update();
    }

    public void intake(double speed) {
        intakeMotor.setPower(speed);

// Simple telemetry readout for debugging
        telemetry.addData("Intake Power", intakeMotor.getPower());
    }


}
