package org.firstinspires.ftc.teamcode.RobotParts;

import com.qualcomm.hardware.dfrobot.HuskyLens;
import com.qualcomm.robotcore.hardware.HardwareMap;
import org.firstinspires.ftc.teamcode.Interfaces.Initializable;
import org.firstinspires.ftc.teamcode.Interfaces.Macro;
import org.firstinspires.ftc.teamcode.Interfaces.Power;

public class Camera implements Initializable {

    public static HuskyLens huskyLens;
    final private String cameraName;

    public Camera(String cameraName) {
        this.cameraName = cameraName;
    }

    // change access modifier if necessary
    final private static Macro foo = () -> {};

    final public static Power detectColors = () -> {
        HuskyLens.Block[] blocks = huskyLens.blocks();

        // Loop through each detected color block
        for (HuskyLens.Block block : blocks) {
            int colorID = block.id;
            switch (colorID) {
                case 1:
                    // example of how macro can be used with camera
                    foo.runMacro();
                    break;
                case 2:
                    break;
                case 3:
                    break;
            }
        }
    };

    @Override
    public void initialize(HardwareMap hardwareMap) throws InterruptedException {
        huskyLens = hardwareMap.get(HuskyLens.class, cameraName);

        // default alg is color sensing, associated method is detectColors.activate()
        // feel free to change alg and write their own methods, color detection is just the most common
        huskyLens.selectAlgorithm(HuskyLens.Algorithm.COLOR_RECOGNITION);
    }
}
