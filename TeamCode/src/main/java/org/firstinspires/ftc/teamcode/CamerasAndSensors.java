package org.firstinspires.ftc.teamcode;

import com.qualcomm.hardware.dfrobot.HuskyLens;
import com.qualcomm.hardware.dfrobot.HuskyLens.Block;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.ColorSensor;

import java.util.ArrayList;

@TeleOp
public class CamerasAndSensors extends LinearOpMode {

    private HuskyLens huskyLens;
    private ColorSensor colorSensor;
    private int redRGB[][] = {{134, 54, 84}, {150, 55, 90}, {195, 68, 111}, {171, 63, 102}, {163, 60, 96}};
    private int blueRGB[][] = {{39, 199, 83}, {41, 237, 91}, {48, 263, 102}, {40, 217, 88}, {41, 221, 89}};
    private int yellowRGB[][] = {{171, 72, 222}, {188, 74, 242}, {182, 75, 234}, {206, 79, 266}, {235, 86, 302}};
    private int blankRGB[][] = new int[5][3];
    private static int i;

    @Override
    public void runOpMode() {
        huskyLens = hardwareMap.get(HuskyLens.class, "huskylens");
        colorSensor = hardwareMap.get(ColorSensor.class, "colorsensor");
        huskyLens.selectAlgorithm(HuskyLens.Algorithm.COLOR_RECOGNITION);

        telemetry.addData("Status", "Initialized");
        telemetry.update();

        waitForStart();

        // should use actual numbers from the arrays, but too lazy to program :P
        while (opModeIsActive()) {
            colorDetection();
        }
    }

    private boolean inRange(int min, int max, int num) {
        return num <= max && num >= min;
    }

    private void faceDetection() {
        Block[] blocks = huskyLens.blocks();

        // Check if any colors are detected
        if (blocks.length > 0) {
            telemetry.addData("Detected Faces", blocks.length);

            // Loop through each detected color block
            for (Block block : blocks) {
                int faceID = block.id;
                switch (faceID) {
                    case 1:
                        break;
                    case 2:
                        break;
                    case 3:
                        break;
                }
                telemetry.addData("Face ID", faceID);
            }
        } else {
            telemetry.addData("Status", "No Faces Detected");
        }

        telemetry.update();
    }

    private void colorDetection() {
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

    private void trainColors() {
        for (i = 0; i <= 4; i++) {
            blankRGB[i] = new int[]{colorSensor.red(), colorSensor.blue(), colorSensor.green()};
            sleep(2000);
        }
    }

    private void listColors() {
        trainColors();
        while (opModeIsActive()) {
            for (int i = 0; i <= 4; i++) {
                telemetry.addData("RGB", blankRGB[i][0] + ", " + blankRGB[i][1] + ", " + blankRGB[i][2]);
            }
            telemetry.update();
        }
    }

}
