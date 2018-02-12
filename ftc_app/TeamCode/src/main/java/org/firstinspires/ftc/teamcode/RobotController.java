package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
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

    @Override
    public void init() {
        left_motor = hardwareMap.dcMotor.get("leftmotor");
        right_motor = hardwareMap.dcMotor.get("rightmotor");
        brat_motor = hardwareMap.dcMotor.get("bratmotor");
        right_servo = hardwareMap.servo.get("right_servo");
        left_servo = hardwareMap.servo.get("left_servo");
        //right_servo.setPosition(Servo.MAX_POSITION);
    }

    @Override
    public void loop() {
        left_motor.setPower(gamepad1.right_stick_y);
        right_motor.setPower(-gamepad1.left_stick_y);
        if(gamepad1.right_bumper){
            brat_motor.setPower(0.25);
        }else brat_motor.setPower(0);
        if(gamepad1.left_bumper){
            brat_motor.setPower(-0.25);
        }else brat_motor.setPower(0);
    }
}
