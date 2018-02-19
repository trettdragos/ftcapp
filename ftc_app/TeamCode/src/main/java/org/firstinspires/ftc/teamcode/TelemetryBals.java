package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

/**
 * Created by trett on 2/19/18.
 */
@Autonomous(name="TelemetryBals", group="Linear Opmode")

public class TelemetryBals extends LinearOpMode{

    DcMotor left_motor;
    DcMotor right_motor;
    Servo putulica;
    ColorSensor sensorPutulica;

    @Override
    public void runOpMode() throws InterruptedException {
        left_motor = hardwareMap.dcMotor.get("leftmotor");
        right_motor = hardwareMap.dcMotor.get("rightmotor");
        putulica = hardwareMap.servo.get("putulica");
        sensorPutulica = hardwareMap.get(ColorSensor.class, "sensorPutulica");
        sensorPutulica.enableLed(true);

        waitForStart();

        while(opModeIsActive()){
            telemetry.addData("red:", sensorPutulica.red());
            telemetry.addData("blue:", sensorPutulica.blue());
            telemetry.update();
        }
    }
}
