package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.util.ElapsedTime;

@Disabled
public class autonomousFunctions {

    //set time to move to crater from position
    double craterTime = 5;

    public boolean moveCrater(hardwareMap robot, boolean opModeIsActive, ElapsedTime runtime){
        while(opModeIsActive && runtime.seconds() < craterTime){
            robot.leftDrive.setPower(0);
            robot.frontLeftDrive.setPower(0);
            robot.frontRightDrive.setPower(0);
            robot.rightDrive.setPower(0);
            robot.arm.setPower(0.7);
        }
        return false;
    }

}
