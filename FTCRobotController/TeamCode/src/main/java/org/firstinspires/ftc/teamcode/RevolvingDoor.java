package org.firstinspires.ftc.teamcode;

import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.gamepad1;
import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.hardwareMap;
import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.telemetry;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp(name = "Servo Trigger Control", group = "TeleOp")
public class RevolvingDoor {

    private Servo myServo;

    @Override
    public void init() {
        // Initialize the servo using the name configured in your Robot Controller app
        myServo = hardwareMap.get(Servo.class, "servoName");

        // Optional: Set an initial position (e.g., 0.0)
        myServo.setPosition(0.0);
    }

    @Override
    public void loop() {
        // Read the right trigger value (returns 0.0 when unpressed, up to 1.0 when fully pressed)
        float rightTriggerValue = gamepad1.right_trigger;

        // Set the servo position proportionally to how far the trigger is pressed
        myServo.setPosition(rightTriggerValue);

        // Optional: Send telemetry back to the Driver Station for debugging
        telemetry.addData("Trigger Value", rightTriggerValue);
        telemetry.addData("Servo Position", myServo.getPosition());
        telemetry.update();
    }
}
