package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@TeleOp(name = "IntakeWheel", group = "Linear OpMode")
public class IntakeWheel extends LinearOpMode {

    // Declare the DC Motor
    private DcMotor intakeMotor = null;

    // Define speed constants
    private static final double INTAKE_SPEED  = 1.0;   // 100% power for collection
    private static final double OUTTAKE_SPEED = -0.6;  // 60% power for controlled ejection
    private static final double MOTOR_OFF     = 0.0;   // Stopped

    @Override
    public void runOpMode() {

        // Initialize hardware mapping (ensure "intake" matches your Driver Station config)
        intakeMotor = hardwareMap.get(DcMotor.class, "IntakeWheel");

        // Direction configuration: change to REVERSE if the motor spins the wrong way
        intakeMotor.setDirection(DcMotorSimple.Direction.FORWARD);

        // Intakes do not require encoders; run on pure voltage/power control
        intakeMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        // FLOAT allows the wheels to spin down naturally, saving gear wear
        intakeMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);

        telemetry.addData("Status", "IntakeWheel Initialized!");
        telemetry.update();
        waitForStart();

        while (opModeIsActive()) {

            // Control loop for driving the intake wheels via bumpers
            if (gamepad1.right_bumper) {
                intakeMotor.setPower(INTAKE_SPEED);
            }
            else if (gamepad1.left_bumper) {
                intakeMotor.setPower(OUTTAKE_SPEED);
            }
            else {
                intakeMotor.setPower(MOTOR_OFF);
            }

            // Simple telemetry readout for debugging
            telemetry.addData("Intake Power", intakeMotor.getPower());
            telemetry.addData("Controls", "RB = Intake | LB = Outtake");
            telemetry.update();
        }
    }
}
