package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.util.ElapsedTime;

public class hardwareMap {

    public DcMotor leftDrive = null;
    public DcMotor rightDrive = null;
    public DcMotor frontLeftDrive = null;
    public DcMotor frontRightDrive = null;
    public DcMotor arm = null;
    public DcMotor hand = null;
    public DcMotor hook = null;
    public double mod = 1.0;


    HardwareMap hwMap = null;
    private ElapsedTime time = new ElapsedTime();

    public hardwareMap() {
    }

    public void init(HardwareMap ahwMap) {
        hwMap = ahwMap;

        leftDrive = hwMap.get(DcMotor.class, "left_drive");
        rightDrive = hwMap.get(DcMotor.class, "right_drive");
        frontLeftDrive = hwMap.get(DcMotor.class, "front_left_drive");
        frontRightDrive = hwMap.get(DcMotor.class, "front_right_drive");
        arm = hwMap.get(DcMotor.class, "arm");
        hand = hwMap.get(DcMotor.class, "hand");
        hook = hwMap.get(DcMotor.class, "hook");

        rightDrive.setDirection(DcMotor.Direction.REVERSE);
        frontLeftDrive.setDirection(DcMotor.Direction.REVERSE);
        arm.setDirection(DcMotor.Direction.REVERSE);
        hook.setDirection(DcMotor.Direction.REVERSE);

        leftDrive.setPower(0);
        rightDrive.setPower(0);
        arm.setPower(0);
        hand.setPower(0);
        hook.setPower(0);
        frontLeftDrive.setPower(0);
        frontRightDrive.setPower(0);

        rightDrive.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
        leftDrive.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
        frontLeftDrive.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
        frontRightDrive.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
        arm.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        hook.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

    }

    public void extend() {
        this.hook.setPower(-1.0);
    }

    public void retract() {
        this.hook.setPower(1.0);
    }

    public void pressButton(boolean A, boolean B, boolean X, boolean Y) {
        if (A) {
            this.mod = 4.0;
        }
        if (B) {
            this.mod = 3.0;
        }
        if (X) {
            this.mod = 2.0;
        }
        if (Y) {
            this.mod = 1.0;
        }
    }
}



