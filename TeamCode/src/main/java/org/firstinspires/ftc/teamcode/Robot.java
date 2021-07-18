package org.firstinspires.ftc.teamcode;

import com.qualcomm.hardware.bosch.BNO055IMU;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;

import java.util.Optional;

public class Robot {
    DcMotor motorLeft;
    DcMotor motorRight;
    Optional<DcMotor> hDriveMotor;
    Telemetry telemetry;
    BNO055IMU imu;

    public Robot (HardwareMap hardwareMap, Telemetry telemetry,  boolean isHdrive){
        motorLeft = hardwareMap.get(DcMotor.class,"motorLeft");
        motorRight = hardwareMap.get(DcMotor.class, "motorRight");
        motorLeft.setDirection(DcMotorSimple.Direction.REVERSE);
        motorRight.setDirection(DcMotorSimple.Direction.FORWARD);

        if (isHdrive){
            hDriveMotor = Optional.of(hardwareMap.get(DcMotor.class, "hDriveMotor"));
        } else{
            hDriveMotor= Optional.empty();
        }

        this.telemetry = telemetry;

        BNO055IMU.Parameters parameters = new BNO055IMU.Parameters();

        parameters.angleUnit           = BNO055IMU.AngleUnit.DEGREES;
        parameters.accelUnit           = BNO055IMU.AccelUnit.METERS_PERSEC_PERSEC;
        // parameters.calibrationDataFile = "AdafruitIMUCalibration.json"; // see the calibration sample opmode
        parameters.loggingEnabled      = true;
        parameters.loggingTag          = "IMU";
        parameters.accelerationIntegrationAlgorithm=null;//= new JustLoggingAccelerationIntegrator();

        imu = hardwareMap.get(BNO055IMU.class, "imu1");
        imu.initialize(parameters);


    }

    public Robot (HardwareMap hardwareMap, Telemetry telemetry){
        this(hardwareMap, telemetry, false);
    }

    public DcMotor getMotorLeft(){
        return  motorLeft;
    }

    public DcMotor getMotorRight(){
        return  motorRight;
    }

    public void teleopStraight(double power){
        motorRight.setPower(power);
        motorLeft.setPower(power);
        if (hDriveMotor.isPresent()){
            hDriveMotor.get().setPower(0);
        }
    }

    public void teleopLeft(double power){
        motorRight.setPower(0);
        motorLeft.setPower(0);
        if (hDriveMotor.isPresent()){
            hDriveMotor.get().setPower(power);
        }
    }

    public void teleopRight(double power){
        motorRight.setPower(0);
        motorLeft.setPower(0);
        if (hDriveMotor.isPresent()){
            hDriveMotor.get().setPower(-power);
        }
    }



}
