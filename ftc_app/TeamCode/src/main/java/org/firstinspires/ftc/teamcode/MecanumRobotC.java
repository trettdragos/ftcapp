package org.firstinspires.ftc.teamcode;

/**
 * Created by alex on 01.03.2018.
 */

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@TeleOp(name = "Mecanum Robot Controller", group = "Iterative Opmode")

public class MecanumRobotC extends OpMode {

    DcMotor front_left;
    DcMotor front_right;
    DcMotor back_left;
    DcMotor back_right;
    DcMotor puller_left;
    DcMotor puller_right;
    CRServo servo_setup;

    @Override
    public void init() {
        front_left = hardwareMap.dcMotor.get("frontLeft");
        front_right = hardwareMap.dcMotor.get("frontRight");
        back_left = hardwareMap.dcMotor.get("backLeft");
        back_right = hardwareMap.dcMotor.get("backRight");
        puller_left = hardwareMap.dcMotor.get("pullerLeft");
        puller_right = hardwareMap.dcMotor.get("pullerRight");
        servo_setup = hardwareMap.crservo.get("servos");
    }

    public void movement(double backLeft, double frontLeft, double backRight, double frontRight){
        back_left.setPower(backLeft/2);
        front_left.setPower(frontLeft/2);
        back_right.setPower(backRight/2);
        front_right.setPower(frontRight/2);
    }


    @Override
    public void loop() {
        if(gamepad1.dpad_up){
            movement(1,1,-1,-1);
        }
        else  if(gamepad1.dpad_down){
            movement(-1,-1,1,1);
        }
        else if(gamepad1.dpad_right){
            movement(-1,1,-1,1);;
        }
        else if(gamepad1.dpad_left){
            movement(1,-1,1,-1);
        }
        else if(gamepad1.right_bumper){
            movement(1,1,1,1);
        }
        else if(gamepad1.left_bumper){
            movement(-1,-1,-1,-1);
        }
        else{
            movement(0,0,0,0);
        }

        if (gamepad2.a) {
            puller_left.setPower(-1);
            puller_right.setPower(1);
        }
        else if (gamepad2.b) {
            puller_left.setPower(0);
            puller_right.setPower(0);
        }

        if (gamepad2.right_bumper){
            servo_setup.setPower(1);
        }
        else if (gamepad2.left_bumper){
            servo_setup.setPower(-1);
        }
        else
        {
            servo_setup.setPower(0);
        }

    }
}
