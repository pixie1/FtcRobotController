package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.NormalizedColorSensor;
import com.qualcomm.robotcore.hardware.NormalizedRGBA;

@TeleOp(name="Color calibration", group = "test")
public class ColorSensorCalibration extends LinearOpMode {

    NormalizedColorSensor colorSensor;
    final int SCALE= 256;

    @Override
    public void runOpMode() throws InterruptedException {

        colorSensor = hardwareMap.get(NormalizedColorSensor.class, "colorSensor");

        waitForStart();

        while (opModeIsActive()){
            NormalizedRGBA rgba= colorSensor.getNormalizedColors();

            telemetry.addData("Red: ", (int)rgba.red *SCALE );
            telemetry.addData("Blue: ", (int)rgba.blue*SCALE);
            telemetry.addData("Green: ", (int)rgba.green*SCALE);
            telemetry.addData("Alpha: ", (int)rgba.alpha*SCALE);
            telemetry.update();
        }

    }
}
