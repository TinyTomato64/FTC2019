package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;

@TeleOp(name="Tank Drive", group="Drive")


public class TankDrive extends OpMode {

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

        leftPower = Range.clip(gamepad1.left_stick_y, -1.0, 1.0);
        rightPower = Range.clip(gamepad1.right_stick_y, -1.0, 1.0);
        robot.buttonPress(gamepad2.a, gamepad2.b, gamepad2.x, gamepad2.y, gamepad2.start);
        robot.decepticon(leftPower, rightPower, robot.mod);

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


        //public void stop(){}

    }


