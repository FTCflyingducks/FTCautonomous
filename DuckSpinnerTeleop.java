package org.firstinspires.ftc.robotcontroller.external.samples;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.robot.Robot;
import com.qualcomm.robotcore.hardware.HardwareMap;
import java.util.Map;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;
@TeleOp(name="duckSpinner", group="DuckSpinner")
public class DuckSpinnerTeleOp extends LinearOpMode {
    
    private DcMotor backLeftMotor;
    private DcMotor backRightMotor; 
    public void runOpMode() {
        backLeftMotor = hardwareMap.get(DcMotor.class, "bl");
        frontLeftMotor = hardwareMap.get(DcMotor.class, "fl");
        frontRightMotor = hardwareMap.get(DcMotor.class, "fr");
        backRightMotor = hardwareMap.get(DcMotor.class, "br");
        backLeftMotor.setDirection(DcMotor.Direction.REVERSE);
        frontLeftMotor.setDirection(DcMotor.Direction.REVERSE);
        backRightMotor.setDirection(DcMotor.Direction.FORWARD);
        frontRightMotor.setDirection(DcMotor.Direction.FORWARD);
        waitForStart();
    
        while (opModeIsActive()) {
    
            double px = gamepad1.left_stick_x;
            double py = -gamepad1.left_stick_y;
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

    public DcMotor  duckSpinner   = null;
    private ElapsedTime     runtime = new ElapsedTime();


    static final double     BLUE_SPEED = 0.5;
    static final double     RED_SPEED = -0.5; 

    @Override
    public void runOpMode() {
        duckSpinner  = hardwareMap.get(DcMotor.class, "dusp");
        duckSpinner.setDirection(DcMotor.Direction.REVERSE);
        duckSpinner.setPower(0);
        duckSpinner.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        waitForStart();
        duckSpinner.setPower(0.5);
        telemetry.addData("Path", "Running" + 0.5);
        telemetry.update();
        while (opModeIsActive()) {
            if (gamepad1.x) {
                duckSpinner.setPower(BLUE_SPEED);
                telemetry.addData("Path", "BLUE_SPEED");
                telemetry.update();
            } else if (gamepad1.a) {
                duckSpinner.setPower(RED_SPEED);
                telemetry.addData("Path", "RED_SPEED");
                telemetry.update();
            } else {
                duckSpinner.setPower(0);
            }
        }
        telemetry.addData("Path", "Complete");
        telemetry.update();
        sleep(1000);
    }
}
