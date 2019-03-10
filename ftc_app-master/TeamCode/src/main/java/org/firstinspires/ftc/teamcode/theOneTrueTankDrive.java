package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;

@TeleOp(name = "New Tank Drive")

public class theOneTrueTankDrive extends OpMode {
    private ElapsedTime runtime = new ElapsedTime();
    hardwareMap robot = new hardwareMap();

    @Override
    public void init(){
        robot.init(hardwareMap);
        runtime.reset();
    }

    @Override
    public void loop(){
        double leftPower;
        double rightPower;
        double armCW;
        double armCCW;
        double armP;

        robot.leftRight(gamepad1.dpad_left, gamepad1.dpad_right, gamepad1.start);
        leftPower = Range.clip(gamepad1.left_stick_y, -1.0, 1.0);
        rightPower = Range.clip(gamepad1.right_stick_y, -1.0, 1.0);

        robot.autobots(leftPower, rightPower, robot.mod);

        armCW = Range.clip(gamepad1.left_trigger, 0, 1.0);
        armCCW = Range.clip(gamepad1.right_trigger, 0, 1.0);
        armP = armCCW - armCW;

        robot.arm.setPower(armP);

        if(gamepad1.left_bumper){
            robot.hand.setPower(1.0);
        } else if(gamepad1.right_bumper){
            robot.hand.setPower(-1.0);
        } else{
            robot.hand.setPower(0);
        }

        if(gamepad1.dpad_up){
            robot.hook.setPower(1.0);
        } else if(gamepad1.dpad_down) {
            robot.hook.setPower(-1.0);
        } else{
            robot.hook.setPower(0);
        }



    }

}
