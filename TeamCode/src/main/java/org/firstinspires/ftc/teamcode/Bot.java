package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.Methods.Inits;
import org.firstinspires.ftc.teamcode.Methods.OdoMethods;

public class Bot {

    public static OdoMethods odo = new OdoMethods();
    public static Inits init = new Inits();

    public static void initialize(LinearOpMode opM) {
        init.initDrivetrain(opM);
        init.initOdo(opM);
    }
}
