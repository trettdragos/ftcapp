package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorController;
import com.qualcomm.robotcore.hardware.Servo;

/**
 * Created by trett on 2/6/18.
 */
@TeleOp(name="Robot Controller", group="Iterative Opmode")

public class RobotController extends OpMode {

    DcMotor left_motor;
    DcMotor right_motor;
    DcMotor brat_motor;
    Servo right_servo;
    Servo left_servo;
    CRServo rServo;
    CRServo lServo;
    Boolean gripping =false;

    @Override
    public void init() {
        left_motor = hardwareMap.dcMotor.get("leftmotor");
        right_motor = hardwareMap.dcMotor.get("rightmotor");
        brat_motor = hardwareMap.dcMotor.get("bratmotor");
        //right_servo = hardwareMap.servo.get("right_servo");
        //left_servo = hardwareMap.servo.get("left_servo");
        rServo = hardwareMap.crservo.get("rservo");
        lServo = hardwareMap.crservo.get("lservo");
        lServo.setPower(0);
        rServo.setPower(0);
        gripping =false;
    }

    @Override
    public void loop() {
        left_motor.setPower(-gamepad1.right_stick_y);
        right_motor.setPower(gamepad1.left_stick_y);
        telemetry.addData("rstyck y", gamepad1.right_stick_y);
        if(gamepad2.right_stick_y != 0){
            brat_motor.setPower(gamepad2.right_stick_y/4);
        }else{
            brat_motor.setPower(0.05);
        }
        telemetry.addData("brat", gamepad2.right_stick_y);
        if(gamepad2.a && !gripping) {
            lServo.setPower(0.5);
            rServo.setPower(-0.5);
        }
        else if (gamepad2.b && !gripping) {
            lServo.setPower(-0.5);
            rServo.setPower(0.5);
        }
        else if(gripping){
            lServo.setPower(0.1);
            rServo.setPower(-0.1);
        }else
        {
            lServo.setPower(0);
            rServo.setPower(0);
        }
        if(gamepad2.y){
            gripping = true;
        }else if(gamepad2.x){
            gripping = false;
        }
        telemetry.addData("gripping status", gripping);
        telemetry.update();
    }

    void sleep(int time){
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
