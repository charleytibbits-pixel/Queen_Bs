package org.firstinspires.ftc.teamcode;

import androidx.annotation.NonNull;

import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion;
import org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion;
import org.firstinspires.ftc.robotcore.external.Telemetry;

public class RevolvingDoor {

    private CRServo myServo;
    private Telemetry telemetry;

    public void init(@NonNull HardwareMap hardwareMap, Telemetry telemetry) {
        // Initialize the servo using the name configured in your Robot Controller app
        myServo = hardwareMap.get(CRServo.class, "crServo");

        // Optional: Set an initial position (e.g., 0.0)
        this.telemetry = telemetry;
    }


    public void revolve(double speed) {
        // Read the right trigger value (returns 0.0 when unpressed, up to 1.0 when fully pressed)

        // Set the servo position proportionally to how far the trigger is pressed
        myServo.setPower(speed);

        // Optional: Send telemetry back to the Driver Station for debugging
    }
}
