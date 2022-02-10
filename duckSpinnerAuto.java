package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.hardware.Blinker;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

@Autonomous(name = "auto", group = "Auto")

public class Auto extends LinearOpMode{
    private DcMotor backLeftMotor;
    private DcMotor backRightMotor; 
    private DcMotor frontLeftMotor;
    private DcMotor frontRightMotor;
    private DcMotor duckSpinner;
    static double BLUE_SPEED = 0.7;
    static double RED_SPEED = -0.7;
    static double DUCK_SPEED = 0.4;
    private ElapsedTime     runtime = new ElapsedTime();
    public void runOpMode() {
        backLeftMotor = hardwareMap.get(DcMotor.class, "bl");
        frontLeftMotor = hardwareMap.get(DcMotor.class, "fl");
        frontRightMotor = hardwareMap.get(DcMotor.class, "fr");
        backRightMotor = hardwareMap.get(DcMotor.class, "br");
        duckSpinner  = hardwareMap.get(DcMotor.class, "dusp");
        duckSpinner.setDirection(DcMotor.Direction.FORWARD);
        backLeftMotor.setDirection(DcMotor.Direction.FORWARD);
        frontLeftMotor.setDirection(DcMotor.Direction.REVERSE);
        backRightMotor.setDirection(DcMotor.Direction.FORWARD);
        frontRightMotor.setDirection(DcMotor.Direction.REVERSE);
        waitForStart();
        telemetry.addData("Path", "Running - " + 0.5);
        telemetry.update();
        while (opModeIsActive() &&runtime.seconds()<5){
            frontLeftMotor.setPower(BLUE_SPEED);
            backLeftMotor.setPower(BLUE_SPEED);
            frontRightMotor.setPower(RED_SPEED);
            backRightMotor.setPower(RED_SPEED);
            while (opModeIsActive() && runtime.seconds()>3 & runtime.seconds()<5){
                frontLeftMotor.setPower(RED_SPEED);
                backLeftMotor.setPower(BLUE_SPEED);
                frontRightMotor.setPower(RED_SPEED);
                backRightMotor.setPower(BLUE_SPEED);
                while (opModeIsActive() && runtime.seconds()>3.2 & runtime.seconds()<5.4){
                    frontLeftMotor.setPower(-0.07);
                    backLeftMotor.setPower(0.07);
                    frontRightMotor.setPower(-0.07);
                    backRightMotor.setPower(0.07);
                    duckSpinner.setPower(DUCK_SPEED);
                    
                        while (opModeIsActive() && runtime.seconds()>5.3 & runtime.seconds()<6.272){
                            frontLeftMotor.setPower(0.47);
                            backLeftMotor.setPower(-0.47);
                            frontRightMotor.setPower(0.47);
                            backRightMotor.setPower(-0.47);
                }
            }
        }
    }}}
        
