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
         if button(gamepad.x) 
             duckSpinner.setDirection(DcMotor.Direction.FORWARD);
         if button(gamepad.y)
            duckSpinner.setDirection(DcMotor.Direction.FORWARD);
        duckSpinner.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        duckSpinner.setPower(FORWARD_SPEED);
        while (opModeIsActive() && (runtime.seconds() < 1.0)){
            if button(gamepad.x) 
             duckSpinner.setspeed(DcMotor.speed.FORWARD_SPEED);
         if button(gamepad.y)
            duckSpinner.setspeed -(DcMotor.speed.FORWARD_SPEED);
    }
    telemetry.update();
    sleep(1000);
} 
}

