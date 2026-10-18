
package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import org.firstinspires.ftc.robotcore.external.Telemetry;
@TeleOp(name = "Arcade Drive")
public class ArcadeDriveOpMode extends OpMode {

    ArcadeDrive drive = new ArcadeDrive();
    IntakeWheel intake = new IntakeWheel();
    double throttle, strafe, spin;

    @Override
    public void init() {
        drive.init(hardwareMap);
        intake.init(hardwareMap, telemetry);
    }

    @Override
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
            intake.intake(0.5);
        }
        else if (gamepad1.left_bumper) {
            intake.intake(-0.5);
        }
        else {
            intake.intake(0);
        }
    }
}
