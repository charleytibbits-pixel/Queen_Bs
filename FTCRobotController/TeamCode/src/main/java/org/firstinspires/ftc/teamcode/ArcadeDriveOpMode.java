package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import org.firstinspires.ftc.robotcore.external.Telemetry;
@TeleOp(name = "Arcade Drive")
public class ArcadeDriveOpMode extends OpMode {

    ArcadeDrive drive = new ArcadeDrive();
    IntakeWheel intake = new IntakeWheel();
    LaunchWheel launch = new LaunchWheel ();

    RevolvingDoor revolve = new RevolvingDoor();
    double throttle, strafe, spin;
    boolean flywheelOn = false;   // remembers if the flywheel is on or off

    public void init() {
        drive.init(hardwareMap);
        intake.init(hardwareMap, telemetry);
        revolve.init(hardwareMap, telemetry);
        launch.init(hardwareMap);
    }

    public void loop() {
        throttle = gamepad1.left_stick_y *-0.5;  // forward/backward
        strafe   = gamepad1.right_stick_x;   // left/right (side to side)
        spin     = gamepad1.right_stick_x*0.5;  // rotation
// Show joystick information as some other illustrative data
        telemetry.addLine("left joystick | ")
                .addData("x", gamepad1.left_stick_x)
                .addData("y", gamepad1.left_stick_y);
        telemetry.addLine("right joystick | ")
                .addData("x", gamepad1.right_stick_x)
                .addData("y", gamepad1.right_stick_y);
        drive.drive(throttle, spin);
        if (gamepad1.right_bumper) {
            intake.intake(0.8);
        }
        else if (gamepad1.left_bumper) {
            intake.intake(-0.5);
        }
        else {
            intake.intake(0);
        }
        //launch wheel code: press B once to start, press B again to stop
        if (gamepad1.bWasPressed()) {
            flywheelOn = !flywheelOn;
        }
        if (flywheelOn) {
            launch.launch(LaunchWheel.HIGH_VELOCITY);
        }
        else {
            launch.launch(0);
        }
        telemetry.addData("Flywheel speed", "%.0f", launch.getVelocity());
        telemetry.addData("Ready to shoot", launch.isAtSpeed());

        if (gamepad1.right_trigger >0){
            revolve.revolve(-0.5);
        }
        else {
            revolve.revolve(0);
        }
    }
}