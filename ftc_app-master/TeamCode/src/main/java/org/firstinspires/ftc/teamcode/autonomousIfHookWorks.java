package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

@Autonomous (name = "Hook and Crater")

public class autonomousIfHookWorks extends LinearOpMode{
    private ElapsedTime runtime = new ElapsedTime();
    private hardwareMap robot = new hardwareMap();
    private autonomousFunctions functions = new autonomousFunctions();


    // Step Variables
    boolean runCrater = true;


    public void runOpMode() throws InterruptedException{
        robot.init(hardwareMap);
        waitForStart();
        runtime.reset();


        while(opModeIsActive() && runtime.seconds() < 3.9){
            robot.extend();
        }

        runtime.reset();

        while(opModeIsActive() && runtime.seconds() < 0.5){
            robot.autobots(0.5, 0.5, -1.0);
            robot.hook.setPower(0);
        }

        runtime.reset();

        while(opModeIsActive() && runtime.seconds() < 1.5){
            robot.autobots(0, 1.0, -1.0);
        }

        while(opModeIsActive() && runtime.seconds() < 3.9){
            robot.autobots(0, 0, -1.0);
            robot.retract();
        }

        runtime.reset();

        while(opModeIsActive() && runtime.seconds() < 3){
            robot.autobots(1.0, 1.0, -1.0);
            robot.hook.setPower(0);
        }

        runtime.reset();

        while(opModeIsActive() && runtime.seconds() < 1){
            robot.autobots(0, 0, -1.0);
            robot.arm.setPower(1.0);
        }

        runtime.reset();

        while(opModeIsActive() && runtime.seconds() < 1){
            robot.arm.setPower(0);
            robot.autobots(0.5, 0, -1.0);
        }

        runtime.reset();

        while(opModeIsActive() && runtime.seconds() < 3){
            robot.autobots(-1.0, -1.0, -1.0);
        }

        runtime.reset();

        while(opModeIsActive() && runtime.seconds() < 2){
            robot.autobots(0, 0, -1.0);
            robot.arm.setPower(1.0);
        }

        runtime.reset();

        while(opModeIsActive() && runtime.seconds() > 0){
            robot.arm.setPower(0);
        }

    }

}
