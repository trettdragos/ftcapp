package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

/**
 * Created by trett on 2/12/18.
 */
@TeleOp(name="MuieMIlena", group="Linear Opmode")

public class TelemetryTest extends LinearOpMode{
    @Override
    public void runOpMode() throws InterruptedException {
        waitForStart();
        while (opModeIsActive()){
            telemetry.addData("muie", "sticano");
            telemetry.update();
        }
    }
}
