package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.RobotParts.Camera;
import org.firstinspires.ftc.teamcode.RobotParts.Claws;
import org.firstinspires.ftc.teamcode.RobotParts.LinearSlide;
import org.firstinspires.ftc.teamcode.RobotParts.Wheels;

public abstract class Movable extends LinearOpMode {
    protected static final Wheels wheels = new Wheels("FLW", "FRW", "BLW", "BRW");
    protected static final LinearSlide linearSlide = new LinearSlide("LSlide", "RSlide");
    protected static final Claws claw = new Claws("LClaw", "RClaw");
    protected static final Camera camera = new Camera("huskylens");
    @Override
    public void runOpMode() throws InterruptedException {
        initializeAll();
        telemetry.addData("Status", "Initialized");
        telemetry.update();
    }

    protected abstract void updatePhoneConsole();
    protected abstract void initializeAll() throws InterruptedException;
}