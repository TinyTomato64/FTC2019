package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.util.ElapsedTime;

@Disabled
public class autonomousFunctions {

    //set time to move to crater from position
    double craterTime = 5;

    public boolean moveCrater(boolean opModeIsActive, ElapsedTime runtime){
        while(opModeIsActive && runtime.seconds() < craterTime){

        }
        return false;
    }

}
