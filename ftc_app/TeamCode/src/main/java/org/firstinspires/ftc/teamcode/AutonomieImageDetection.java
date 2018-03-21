package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.robotcore.external.ClassFactory;
import org.firstinspires.ftc.robotcore.external.matrices.OpenGLMatrix;
import org.firstinspires.ftc.robotcore.external.navigation.RelicRecoveryVuMark;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaLocalizer;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaTrackable;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaTrackables;

/**
 * Created by trett on 2/22/18.
 */

@Autonomous(name="Colomn Detection Camera", group ="Camera")

public class AutonomieImageDetection extends LinearOpMode{

    VuforiaLocalizer vuforia;

    @Override
    public void runOpMode() throws InterruptedException {
        int cameraMonitorViewId = hardwareMap.appContext.getResources().getIdentifier("cameraMonitorViewId", "id", hardwareMap.appContext.getPackageName());
        VuforiaLocalizer.Parameters parameters = new VuforiaLocalizer.Parameters(cameraMonitorViewId);
        parameters.vuforiaLicenseKey = "ATsHtk7/////AAAAmTzbpo/KRERhoF6Fhay/A1MzU0F1Q5Rz8nWvMtZ4rhoNByeb6beowSyrnIDhlnoclUB/lXA0m2aMSYxdAn3Ofi+3YWitGb1BlRSbVXUFJpD81FHpXpu9R04xmWYY26+227V6/AkFdaesv8HE+838MdBIeitKF4JI8e0Dl2I4uCZ9SrSE7O2OT+1ovHWn14srRPlFHB31jR2RAAQno37TWOS8nmRfbavRbXZ9pRFJ+kilycFGFTTYz1Ypn/8h2mxLrWjlKOwfNVGYjlnGzM6NKkXT0PxLHcD8hJdNAjWruDcDWXVIF4DWhP1D3NyWAbKgg/45jryngOQhFbHnM3VJwKHP+1eHaKdQXobdwfCRehtv";
        parameters.cameraDirection = VuforiaLocalizer.CameraDirection.FRONT;
        this.vuforia = ClassFactory.createVuforiaLocalizer(parameters);
        VuforiaTrackables relicTrackables = this.vuforia.loadTrackablesFromAsset("RelicVuMark");
        VuforiaTrackable relicTemplate = relicTrackables.get(0);
        relicTemplate.setName("relicVuMarkTemplate");
        waitForStart();
        relicTrackables.activate();
        boolean found = false;
        while (!found){
            RelicRecoveryVuMark vuMark = RelicRecoveryVuMark.from(relicTemplate);
            if (vuMark != RelicRecoveryVuMark.UNKNOWN) {
                telemetry.addData("VuMark", "%s visible", vuMark);
                telemetry.update();
                found = true;
            }
        }
        sleep(10000);
    }

    String format(OpenGLMatrix transformationMatrix) {
        return (transformationMatrix != null) ? transformationMatrix.formatAsTransform() : "null";
    }
}
