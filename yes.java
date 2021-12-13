package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
    @Autonomous(name="DuckSpinner", group="Auto")
    public class DuckSpinner extends LinearOpMode {
        public DcMotor duckspinner;
        static final double FORWARD_SPEED = 0.2;
        public Autonomous mode;{
        duckspinner = hardwareMap.get(DcMotor.class, "dusp");
         if (red = 1){ 
             duckSpinner.setDirection(DcMotor.Direction.FORWARD);
             
         else;{
            duckSpinner.setDirection(DcMotor.Direction.FORWARD);
         }
        duckSpinner.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        duckSpinner.setPower(FORWARD_SPEED);
        while (opModeIsActive() && (runtime.seconds() < 1.0)){
            set.
    }
    telemetry.update();
    sleep(1000);
} 
}

