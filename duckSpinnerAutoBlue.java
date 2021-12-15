package org.firstinspires.ftc.robotcontroller.external.samples;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.robot.Robot;
import com.qualcomm.robotcore.hardware.HardwareMap;
import java.util.Map;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;
 @Autonomous(name="duckSpinner", group="DuckSpinner")
public class DuckSpinnerBlue extends LinearOpMode {

    public DcMotor  duckSpinner   = null;
    private ElapsedTime     runtime = new ElapsedTime();


    static final double     FORWARD_SPEED = 0.5;

    @Override
    public void runOpMode() {
        duckSpinner  = hardwareMap.get(DcMotor.class, "dusp");
        duckSpinner.setDirection(DcMotor.Direction.FORWARD);
        duckSpinner.setPower(0);
        duckSpinner.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        waitForStart();
        duckSpinner.setPower(0.5);
        duckSpinner.setPower(FORWARD_SPEED);
        while (opModeIsActive() && (runtime.seconds() < 30.0)) {
            telemetry.update();
        }
         telemetry.addData("Path", "Complete");
        telemetry.update();
        sleep(1000);
    }
}
