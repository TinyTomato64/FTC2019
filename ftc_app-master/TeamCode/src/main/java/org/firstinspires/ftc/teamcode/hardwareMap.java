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
    public double mod = 0.75;


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

        frontRightDrive.setDirection(DcMotor.Direction.REVERSE);
        leftDrive.setDirection(DcMotor.Direction.REVERSE);
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
    public void leftRight(boolean L, boolean R, boolean S){
        if(L){
            this.mod += 0.1;
        }
        if(R){
            this.mod -= 0.1;
        }
        if(S){
            this.mod = 0.75;
        }
        this.mod = Math.min(1.0, this.mod);
        this.mod = Math.max(0.1, this.mod);
    }
    public void autobots(double leftPower, double rightPower, double mod){
        this.leftDrive.setPower(leftPower / mod);
        this.frontLeftDrive.setPower(leftPower / mod);
        this.rightDrive.setPower(rightPower / mod);
        this.frontRightDrive.setPower(rightPower / mod);
    }

  /*  public void pressButton(boolean A, boolean B, boolean X, boolean Y) {
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
    public void buttonPress(boolean A, boolean B, boolean X, boolean Y, boolean S){
        if (A){
            this.mod -= 0.1;
        }
        if (B){
            this.mod -= 0.5;
        }
        if(X){
            this.mod += 0.5;
        }
        if(Y){
            this.mod += 0.1;
        }
        if(S){
            this.mod = 1.0;
        }
        this.mod = Math.min(1.0, this.mod);
        this.mod = Math.max(0.1, this.mod);
    }


    public void decepticon(double leftPower, double rightPower, double mod){
        this.leftDrive.setPower(leftPower * mod);
        this.frontLeftDrive.setPower(leftPower * mod);
        this.rightDrive.setPower(rightPower * mod);
        this.frontRightDrive.setPower(rightPower * mod);
    }*/
}



