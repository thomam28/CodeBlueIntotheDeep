package org.firstinspires.ftc.teamcode;

import android.graphics.Color;

import com.qualcomm.hardware.dfrobot.HuskyLens;
import com.qualcomm.hardware.dfrobot.HuskyLens.Block;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp
public class CameraTest extends LinearOpMode {

    private HuskyLens huskyLens;

    @Override
    public void runOpMode() {
        huskyLens = hardwareMap.get(HuskyLens.class, "huskylens");
        huskyLens.selectAlgorithm(HuskyLens.Algorithm.COLOR_RECOGNITION);

        telemetry.addData("Status", "Initialized");
        telemetry.update();

        waitForStart();

        while (opModeIsActive()) {
            Block[] blocks = huskyLens.blocks();

            // Check if any colors are detected
            if (blocks.length > 0) {
                telemetry.addData("Detected Colors", blocks.length);

                // Loop through each detected color block
                for (Block block : blocks) {
                    /*
                     red ID = 1
                     blue ID = 2
                     yellow ID = 3
                    */
                    int colorID = block.id;

                    switch (colorID) {
                        case 1:
                            telemetry.addData("Red Detected!", "");
                            break;
                        case 2:
                            telemetry.addData("Blue Detected!", "");
                            break;
                        case 3:
                            telemetry.addData("Yellow Detected!", "");
                            break;
                    }
                    telemetry.addData("Color ID", colorID);
                }
            } else {
                telemetry.addData("Status", "No Colors Detected");
            }

            telemetry.update();
        }
    }
}
