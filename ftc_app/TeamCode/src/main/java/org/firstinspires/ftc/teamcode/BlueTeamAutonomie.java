package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

/**
 * Created by trett on 2/19/18.
 */
//@Autonomous(name="BlueTeamAuto CU CUB", group="Linear Opmode")

public class BlueTeamAutonomie extends LinearOpMode{

    DcMotor front_left;
    DcMotor front_right;
    DcMotor back_left;
    DcMotor back_right;
    Servo put;
    ColorSensor sensorPut;
    CRServo servo_setup;

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
        servo_setup = hardwareMap.crservo.get("servos");
        sensorPut = hardwareMap.get(ColorSensor.class, "sensorPut");

        waitForStart();
        sensorPut.enableLed(true);
        put.setPosition(1);
        sleep(2000);
        //pushing red
        if(sensorPut.red()>sensorPut.blue()){
            telemetry.addData("r b:", sensorPut.red()+";"+sensorPut.blue());
            telemetry.update();
            sensorPut.enableLed(false);
            movement(1,1,-1,-1);
            sleep(1000);
            movement(0,0,0,0);
            put.setPosition(0.4);
            sleep(500);
            movement(1,1,-1,-1);
            sleep(1500);
        }else if(sensorPut.red()<sensorPut.blue()){

            telemetry.addData("r b:", sensorPut.red()+";"+sensorPut.blue());
            telemetry.update();
            sensorPut.enableLed(false);
            movement(-1,-1,1,1);
            sleep(400);
            movement(0,0,0,0);
            put.setPosition(0.4);
            sleep(500);
            movement(1,1,-1,-1);
            sleep(3000);
        }else{
            telemetry.addData("sensor", "not working");
            telemetry.update();
        }
        movement(0,0,0,0);
        //spin 90 grade
        movement(1,1,1,1);
        sleep(1500);
        movement(0, 0, 0, 0);
        //basculeaza
        //mergi in fata
        movement(-0.75,-0.75,0.75,0.75);
        sleep(800);
        movement(0, 0, 0, 0);
        //try all directions
        /*movement(1,-1,1,-1);
        sleep(50);
        movement(-0.3,-0.3,0.3,0.3);
        sleep(600);
        movement(-0.3,-0.3,0.3,0.3);
        sleep(100);
        movement(-1,-1,1,1);
        sleep(600);*/
        servo_setup.setPower(1);
        sleep(500);
        servo_setup.setPower(0);
        servo_setup.setPower(-1);
        sleep(500);
        servo_setup.setPower(0);
        movement(1,1,-1,-1);
        sleep(300);
        movement(0, 0, 0, 0);
        sleep(1000);
    }
}
