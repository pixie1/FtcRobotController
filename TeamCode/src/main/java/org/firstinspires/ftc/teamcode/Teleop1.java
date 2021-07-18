package org.firstinspires.ftc.teamcode;


import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

public class Teleop1 extends LinearOpMode {

    Robot robot;

    @Override
    public void runOpMode() throws InterruptedException {

        initRobot();

        waitForStart();

        while (opModeIsActive()){



        }
    }

    protected void initRobot(){

        robot= new Robot(hardwareMap, telemetry, true);

    }
}
