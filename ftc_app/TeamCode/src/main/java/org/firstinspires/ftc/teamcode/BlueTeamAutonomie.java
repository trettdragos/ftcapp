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
@Autonomous(name="BlueTeamAuto", group="Linear Opmode")

public class BlueTeamAutonomie extends LinearOpMode{

    DcMotor front_left;
    DcMotor front_right;
    DcMotor back_left;
    DcMotor back_right;
    Servo put;
    ColorSensor sensorPut;

    public void movement(double backLeft, double frontLeft, double backRight, double frontRight){
        back_left.setPower(backLeft/2);
        front_left.setPower(frontLeft/2);
        back_right.setPower(backRight/2);
        front_right.setPower(frontRight/2);
    }

    @Override
    public void runOpMode() throws InterruptedException {
        front_left = hardwareMap.dcMotor.get("frontLeft");
        front_right = hardwareMap.dcMotor.get("frontRight");
        back_left = hardwareMap.dcMotor.get("backLeft");
        back_right = hardwareMap.dcMotor.get("backRight");
        put = hardwareMap.servo.get("put");
        sensorPut = hardwareMap.get(ColorSensor.class, "sensorPut");

        waitForStart();
        sensorPut.enableLed(true);
        put.setPosition(1);
        sleep(2000);
        //pushing red
        if(sensorPut.red()>sensorPut.blue()){
            movement(1,1,-1,-1);
            sleep(150);
            movement(-1,-1,1,1);
            sleep(150);
        }else if(sensorPut.red()<sensorPut.blue()){
            movement(-1,-1,1,1);
            sleep(150);
            movement(1,1,-1,-1);
            sleep(150);
        }
        movement(0,0,0,0);
        put.setPosition(0.5);
        sleep(2000);
        telemetry.addData("r b:", sensorPut.red()+";"+sensorPut.blue());
        telemetry.update();
        sensorPut.enableLed(false);
        sleep(5000);
    }
}