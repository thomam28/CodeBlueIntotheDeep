package org.firstinspires.ftc.teamcode.pedroPathing;

import com.pedropathing.localization.Encoder;
import com.pedropathing.localization.constants.DriveEncoderConstants;
import com.pedropathing.localization.constants.ThreeWheelConstants;

public class LConstants {
    static {
        DriveEncoderConstants.forwardTicksToInches = 1;
        DriveEncoderConstants.strafeTicksToInches = 1;
        DriveEncoderConstants.turnTicksToInches = 1;

        // TODO: CHANGE WIDTH AND LENGTH!! 
        DriveEncoderConstants.robot_Width = 1;
        DriveEncoderConstants.robot_Length = 1;
        // TODO: CHANGE WIDTH AND LENGTH!!

        DriveEncoderConstants.leftFrontEncoderDirection = Encoder.REVERSE;
        DriveEncoderConstants.rightFrontEncoderDirection = Encoder.FORWARD;
        DriveEncoderConstants.leftRearEncoderDirection = Encoder.REVERSE;
        DriveEncoderConstants.rightRearEncoderDirection = Encoder.FORWARD;
    }
}




