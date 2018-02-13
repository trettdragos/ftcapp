package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

/**
 * Created by trett on 2/12/18.
 */
@TeleOp(name="MuieMIlena", group="Linear Opmode")

public class TelemetryTest extends LinearOpMode{
    DcMotor left_motor;


    @Override
    public void runOpMode() throws InterruptedException {
        left_motor = hardwareMap.dcMotor.get("leftmotor");
        left_motor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        left_motor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        left_motor.setTargetPosition(1440);
        waitForStart();
        while(left_motor.isBusy() && opModeIsActive()) {
            telemetry.addData("status", left_motor.getCurrentPosition());
            telemetry.update();
        }
    }
}
