package org.firstinspires.ftc.teamcode.Methods;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Inits {

    public DcMotor FLm;
    public DcMotor FRm;
    public DcMotor RLm;
    public DcMotor RRm;
    public DcMotor encX1;
    public DcMotor encX2;
    public DcMotor encY;

    double oldX1val, oldX2val, oldYval, Xpos, Ypos, heading;

    HardwareMap hwMap;

    public void initDrivetrain(LinearOpMode opMode) {
        hwMap = opMode.hardwareMap;

        FLm = hwMap.get(DcMotor.class, "FL");
        FRm = hwMap.get(DcMotor.class, "FR");
        RLm = hwMap.get(DcMotor.class, "RL");
        RRm = hwMap.get(DcMotor.class, "RR");

        FLm.setDirection(DcMotor.Direction.FORWARD);
        FRm.setDirection(DcMotor.Direction.FORWARD);
        RLm.setDirection(DcMotor.Direction.FORWARD);
        RRm.setDirection(DcMotor.Direction.FORWARD);

        FLm.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        FRm.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        RLm.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        RRm.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        FLm.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        FRm.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        RLm.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        RRm.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    }

    public void initOdo(LinearOpMode opMode) {
        /* (assuming X axis is forwards backwards) */
        encX1 = FLm;
        encX2 = FRm;
        encY = RLm;

        encX1.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        encX2.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        encY.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        oldX1val = encX1.getCurrentPosition();
        oldX2val = encX2.getCurrentPosition();
        oldYval = encY.getCurrentPosition();

        Xpos = 0;
        Ypos = 0;
        heading = 0;
    }
}
