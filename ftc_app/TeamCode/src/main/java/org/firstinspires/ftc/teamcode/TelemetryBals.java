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
//@Autonomous(name="TelemetryBals", group="Linear Opmode")

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
        putulica.setPosition(0.53);

        waitForStart();

        while(sensorPutulica.red() == 0 && sensorPutulica.blue() == 0){
            left_motor.setPower(-0.2);
            right_motor.setPower(0.2);
        }
        sleep(100);
        left_motor.setPower(0);
        right_motor.setPower(0);
        //pushing red
        if(sensorPutulica.red()>sensorPutulica.blue()){
            putulica.setPosition(0.1);
        }else if(sensorPutulica.red()<sensorPutulica.blue()){
            putulica.setPosition(0.9);
        }
        telemetry.addData("r b:", sensorPutulica.red()+";"+sensorPutulica.blue());
        telemetry.update();
        sleep(5000);
    }
}
