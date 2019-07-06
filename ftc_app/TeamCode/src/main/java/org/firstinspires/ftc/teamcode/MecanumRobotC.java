package org.firstinspires.ftc.teamcode;

/**
 * Created by trett on 01.03.2018.
 */

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp(name = "Mecanum Robot Controller", group = "Iterative Opmode")

public class MecanumRobotC extends OpMode {

    DcMotor front_left;
    DcMotor front_right;
    DcMotor back_left;
    DcMotor back_right;
    DcMotor puller_left;
    DcMotor puller_right;
    CRServo servo_setup;
    //Servo put;
    CRServo level;
    //double pozitiePut=0.4;

    @Override
    public void init() {
        front_left = hardwareMap.dcMotor.get("frontLeft");
        front_right = hardwareMap.dcMotor.get("frontRight");
        back_left = hardwareMap.dcMotor.get("backLeft");
        back_right = hardwareMap.dcMotor.get("backRight");
        puller_left = hardwareMap.dcMotor.get("pullerLeft");
        puller_right = hardwareMap.dcMotor.get("pullerRight");
        servo_setup = hardwareMap.crservo.get("servos");
        //put = hardwareMap.servo.get("put");
        level = hardwareMap.crservo.get("level");
    }

    public void movement(double backLeft, double frontLeft, double backRight, double frontRight, double div){
        back_left.setPower(backLeft/div);
        front_left.setPower(frontLeft/div);
        back_right.setPower(backRight/div);
        front_right.setPower(frontRight/div);
    }


    @Override
    public void loop() {
        if(gamepad1.dpad_up){
            movement(1,1,-1,-1, 1);
        }
        else  if(gamepad1.dpad_down){
            movement(-1,-1,1,1, 1);
        }
        else if(gamepad1.dpad_right){
            movement(-1,1,-1,1, 2.5);
        }
        else if(gamepad1.dpad_left){
            movement(1,-1,1,-1, 2.5);
        }
        else if(gamepad1.right_bumper){
            movement(1,1,1,1, 1.5);
        }
        else if(gamepad1.left_bumper){
            movement(-1,-1,-1,-1, 1.5);
        }
        else{
            movement(0,0,0,0, 1.0);
        }
        /*if (gamepad1.x)
            pozitiePut = 0;
        if(gamepad1.y)
            pozitiePut = 0.4;
        */
        if (gamepad2.a) {
            puller_left.setPower(-1);
            puller_right.setPower(1);
        }
        else if (gamepad2.b) {
            puller_left.setPower(1);
            puller_right.setPower(-1);
        }
        else{
            puller_left.setPower(0);
            puller_right.setPower(0);
        }

        if (gamepad2.right_bumper){
            servo_setup.setPower(1);
            level.setPower(0);
        }
        else if (gamepad2.left_bumper){
            servo_setup.setPower(-1);
            level.setPower(0);
        }
        else if (gamepad2.x)
        {
            level.setPower(1);
            servo_setup.setPower(0);
        }
        else if (gamepad2.y)
        {
            level.setPower(-0.9);
            servo_setup.setPower(0);
        }
        else
        {
            level.setPower(0);
            servo_setup.setPower(0);
        }

        //put.setPosition(pozitiePut);
    }
}