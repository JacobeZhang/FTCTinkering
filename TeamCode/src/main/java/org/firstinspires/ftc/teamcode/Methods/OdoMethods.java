package org.firstinspires.ftc.teamcode.Methods;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

public class OdoMethods extends Inits {
    double X1val, X2val, Yval, deltaX1pos, deltaX2pos, deltaYpos, phi, deltaXcenter, deltaXhoriz, Lpower, Rpower, targetX, targetY, targetHeading, deltaX, deltaY;

    /* Tuning Values */
    double trackwidth = 10;
    double encYoffset = 10;
    double kP_error = 0.1;
    double kP_Heading = 0.1;

    public void updatePose() {
        X1val = encX1.getCurrentPosition();
        X2val = encX2.getCurrentPosition();
        Yval = encY.getCurrentPosition();

        /* delta as in "change in "*/
        deltaX1pos = X1val - oldX1val;
        deltaX2pos = X2val - oldX2val;
        deltaYpos = Yval - oldYval;

        phi = (deltaX1pos - deltaX2pos) / trackwidth;
        deltaXcenter = (deltaX2pos + deltaX1pos) / 2;
        deltaXhoriz = deltaYpos - encYoffset * phi;

        deltaX = deltaXcenter * Math.cos(heading) - deltaXhoriz * Math.sin(heading);
        deltaY = deltaXcenter * Math.sin(heading) + deltaXhoriz * Math.cos(heading);

        Xpos += deltaX;
        Ypos += deltaY;
        heading += phi;

        oldX1val = encX1.getCurrentPosition();
        oldX2val = encX2.getCurrentPosition();
        oldYval = encY.getCurrentPosition();
    }

    public void pointToPoint(double Xchange, double Ychange, double headingChange, LinearOpMode opM) {

        updatePose();
        targetX = Xchange + Xpos;
        targetY = Ychange + Ypos;
        targetHeading = headingChange + heading;

        double Xerror, Yerror, headingError, distToTarget, error;

        while (opM.opModeIsActive()) {
            updatePose();

            Xerror = targetX - Xpos;
            Yerror = targetY - Ypos;
            headingError = targetHeading - heading;

            distToTarget = Math.sqrt(Math.pow(Xerror, 2) + Math.pow(Yerror, 2));
            error = distToTarget * Math.cos(headingError);

            Lpower = (kP_error * error) + (kP_Heading * headingError);
            Rpower = (kP_error * error) - (kP_Heading * headingError);

            FLm.setPower(Lpower);
            FRm.setPower(Lpower);
            RLm.setPower(Rpower);
            RRm.setPower(Rpower);
        }
    }
}
