package org.firstinspires.ftc.robotcontroller.external.samples;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.robot.Robot;
import com.qualcomm.robotcore.hardware.HardwareMap;
import java.util.Map;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;
@TeleOp(name="DuckSpinnerTeleOp", group="DuckSpinner")
public class DuckSpinnerTeleOp extends LinearOpMode {
    public DcMotor  duckSpinner   = null;
    private ElapsedTime     runtime = new ElapsedTime();
    static final double     BLUE_SPEED = 0.5;
    static final double     RED_SPEED = -0.5; 
    private DcMotor backLeftMotor;
    private DcMotor backRightMotor; 
    private DcMotor frontLeftMotor;
    private DcMotor frontRightMotor;
    private DcMotorEx lifter;
    public void runOpMode() {
        backLeftMotor = hardwareMap.get(DcMotor.class, "bl");
        frontLeftMotor = hardwareMap.get(DcMotor.class, "fl");
        frontRightMotor = hardwareMap.get(DcMotor.class, "fr");
        backRightMotor = hardwareMap.get(DcMotor.class, "br");
        lifter = hardwareMap.get(DcMotorEx.class,"lif" );
        backLeftMotor.setDirection(DcMotor.Direction.REVERSE);
        frontLeftMotor.setDirection(DcMotor.Direction.REVERSE);
        backRightMotor.setDirection(DcMotor.Direction.FORWARD);
        frontRightMotor.setDirection(DcMotor.Direction.FORWARD);
        lifter.setDirection(DcMotorEx.Direction.REVERSE);
        duckSpinner  = hardwareMap.get(DcMotor.class, "dusp");
        duckSpinner.setDirection(DcMotor.Direction.REVERSE);
        duckSpinner.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER); 
        
        waitForStart();
        telemetry.addData("Path", "Running" + 0.5);
        telemetry.update();
            while (opModeIsActive()) {
                double px = -gamepad1.left_stick_y;
                double py = -gamepad1.left_stick_x;
                double pa = (gamepad1.right_stick_x - gamepad1.right_stick_y);
                if (Math.abs(pa) < 0.05) pa = 0;
                double p1 = -px + py + pa;
                double p2 = px + py + pa;
                double p3 = -px + py - pa;
                double p4 = px + py - pa;
                double max = Math.max(1.0, Math.abs(p1));
                max = Math.max(max, Math.abs(p2));
                max = Math.max(max, Math.abs(p3));
                max = Math.max(max, Math.abs(p4));
                p1 /= max;
                p2 /= max;
                p3 /= max;
                p4 /= max;
                frontLeftMotor.setPower(p1/1.5);
                frontRightMotor.setPower(p2/1.5);
                backLeftMotor.setPower(p3/1.5);
                backRightMotor.setPower(p4/1.5);
                
                
                
                
                if (gamepad1.x) {
                    duckSpinner.setPower(BLUE_SPEED);
                } else if (gamepad1.a) {
                    duckSpinner.setPower(RED_SPEED);
                } else {
                    duckSpinner.setPower(0);
                }
                if (gamepad1.left_bumper){
                    
                    
                }
            }
            telemetry.addData("Path", "Complete");
            telemetry.update();
            sleep(1000);
        }
    }
