package org.firstinspires.ftc.teamcode.RobotParts;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import org.firstinspires.ftc.teamcode.Direction;
import org.firstinspires.ftc.teamcode.Interfaces.Directional;
import org.firstinspires.ftc.teamcode.Interfaces.Power;
import org.firstinspires.ftc.teamcode.Interfaces.Initializable;

public class Claws implements Initializable, Directional {

    private static Direction currentCondition = Direction.OPEN;
    public static Servo LServo, RServo;
    final private String LServo_Name, RServo_Name;

    public Claws(String LServo_Name, String RServo_Name) {
        this.LServo_Name = LServo_Name;
        this.RServo_Name = RServo_Name;
    }

    final private Power moveClaws = () -> {
        switch (currentCondition) {
            case OPEN:
                break;
            case CLOSE:
                break;
            default:
                break;
        }
    };

    @Override
    public void setDirection(Direction condition) {
        switch (condition) {
            case OPEN: case CLOSE:
                currentCondition = condition;
                break;
            default:
                break;
        }
    }

    @Override
    public Direction getDirection() {
        return currentCondition;
    }

    @Override
    public void initialize(HardwareMap hardwareMap) throws InterruptedException {
        LServo = hardwareMap.get(Servo.class, LServo_Name);
        RServo = hardwareMap.get(Servo.class, RServo_Name);

        RServo.setDirection(Servo.Direction.REVERSE);
    }
}
