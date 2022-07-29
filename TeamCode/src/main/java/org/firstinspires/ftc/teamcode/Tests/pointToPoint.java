package org.firstinspires.ftc.teamcode.Tests;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.Bot;

@Autonomous
public class pointToPoint extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {

        Bot bot = new Bot();
        bot.initialize(this);

        waitForStart();

        bot.odo.pointToPoint(1000,1000,25, this);
    }
}
