package org.firstinspires.ftc.teamcode.Interfaces;

import com.qualcomm.robotcore.hardware.HardwareMap;

@FunctionalInterface
public interface Initializable {
    void initialize(HardwareMap hardwareMap) throws InterruptedException;
}
