package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;

@TeleOp(name="Tank Drive 2", group="Drive")

public class tankDriveTwo extends OpMode {

    private ElapsedTime runtime = new ElapsedTime();
    hardwareMap robot = new hardwareMap();

    @Override
    public void init() {
        robot.init(hardwareMap);

        runtime.reset();
    }

    @Override
    public void loop() {
        double leftPower;
        double rightPower;
        double armPowerClockWise;
        double armPowerCounterClockwise;
        double armPower;

        robot.pressButton(gamepad2.a, gamepad2.b, gamepad2.x, gamepad2.y);
        leftPower = Range.clip(-gamepad1.left_stick_y, -1.0, 1.0);
        rightPower = Range.clip(-gamepad1.right_stick_y, -1.0, 1.0);

        robot.leftDrive.setPower(leftPower / robot.mod);
        robot.rightDrive.setPower(rightPower / robot.mod);
        robot.frontLeftDrive.setPower(leftPower / robot.mod);
        robot.frontRightDrive.setPower(rightPower / robot.mod);

        armPowerClockWise = Range.clip(gamepad1.left_trigger,0.0, 1.0);
        armPowerCounterClockwise = Range.clip(gamepad1.right_trigger, 0.0, 1.0);
        armPower = Range.clip(armPowerClockWise - armPowerCounterClockwise, -1.0, 1.0);

        robot.arm.setPower(armPower);

        if (gamepad1.left_bumper) {
            robot.hand.setPower(-1.0);
        }
        else if (gamepad1.right_bumper) {
            robot.hand.setPower(1.0);
        } else {
            robot.hand.setPower(0);
        }

        if (gamepad1.dpad_up) {
            robot.hook.setPower(1.0);
        }
        else if (gamepad1.dpad_down) {
            robot.hook.setPower(-1.0);
        } else {
            robot.hook.setPower(0);
        }

    }

    }

    //public void stop(){}




