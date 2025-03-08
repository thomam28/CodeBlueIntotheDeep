package org.firstinspires.ftc.teamcode;

import com.qualcomm.hardware.dfrobot.HuskyLens;
import com.qualcomm.hardware.dfrobot.HuskyLens.Block;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.ColorSensor;

@TeleOp
public class CamerasAndSensors extends LinearOpMode {

    private HuskyLens huskyLens;
    private ColorSensor colorSensor;

    @Override
    public void runOpMode() {
        huskyLens = hardwareMap.get(HuskyLens.class, "huskylens");
        colorSensor = hardwareMap.get(ColorSensor.class, "colorsensor");

        huskyLens.selectAlgorithm(HuskyLens.Algorithm.COLOR_RECOGNITION);

        telemetry.addData("Status", "Initialized");
        telemetry.update();

        waitForStart();

        while (opModeIsActive()) {
            cameraTest();
        }
    }

    private void cameraTest() {
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

    private void colorSensorTest() {
        telemetry.addData("RGB", colorSensor.red() + ", "
                + colorSensor.green() + ", " + colorSensor.blue());
        if (getRedRange(colorSensor.red(), colorSensor.blue(), colorSensor.green())) {
            telemetry.addData("Red", "detected!");
        } else if (getBlueRange(colorSensor.red(), colorSensor.blue(), colorSensor.green())) {
            telemetry.addData("Blue", "detected!");
        } else if (getYellowRange(colorSensor.red(), colorSensor.blue(), colorSensor.green())) {
            telemetry.addData("Yellow", "detected!");
        }

        telemetry.update();
    }

    private boolean getRedRange(int r, int g, int b) {
        return r >= 200 && g <= 75 && b <= 75;
    }
    private boolean getYellowRange(int r, int g, int b) {
        return r >= 150 && g >= 150 && b <= 75;
    }
    private boolean getBlueRange(int r, int g, int b) {
        return r <= 75 && g <= 75 && b >= 200;
    }
}
