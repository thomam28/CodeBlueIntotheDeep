package org.firstinspires.ftc.teamcode.TeleOp;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import org.firstinspires.ftc.teamcode.Movable;
import org.firstinspires.ftc.teamcode.RobotParts.Wheels;

@TeleOp
public class AnimosityAndMortification extends Movable {

    @Override
    public void runOpMode() throws InterruptedException {
        super.runOpMode();

        telemetry.addData("Status", "Initialized");
        telemetry.update();

        waitForStart();

        while (opModeIsActive()) {

            updatePhoneConsole();
        }
    }

    @Override
    public void updatePhoneConsole() {
        telemetry.update();
    }

    @Override
    protected void initializeAll() throws InterruptedException {
        wheels.initialize(hardwareMap);
        linearSlide.initialize(hardwareMap);
        claw.initialize(hardwareMap);
        camera.initialize(hardwareMap);
    }
}