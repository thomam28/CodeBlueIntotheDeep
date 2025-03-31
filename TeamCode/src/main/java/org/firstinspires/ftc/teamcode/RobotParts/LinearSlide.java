package org.firstinspires.ftc.teamcode.RobotParts;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import org.firstinspires.ftc.teamcode.Direction;
import org.firstinspires.ftc.teamcode.Interfaces.Directional;
import org.firstinspires.ftc.teamcode.Interfaces.Initializable;
import org.firstinspires.ftc.teamcode.Interfaces.Power;

public class LinearSlide implements Initializable, Directional {

    private static Direction currentDirection = Direction.STATIC;
    public static DcMotor LSlide, RSlide;
    final private String LSlide_Name, RSlide_Name;

    public LinearSlide(String LSlide_Name, String RSlide_Name) {
        this.LSlide_Name = LSlide_Name;
        this.RSlide_Name = RSlide_Name;
    }

    final public static Power moveSlides = () -> {
        switch (currentDirection) {
            case ASCEND:
                break;
            case DESCEND:
                break;
            default:
                break;
        }
    };

    @Override
    public void setDirection(Direction direction) {
        switch (direction) {
            case STATIC: case ASCEND: case DESCEND:
                currentDirection = direction;
                break;
            default:
                break;
        }
    }

    @Override
    public Direction getDirection() {
        return currentDirection;
    }

    @Override
    public void initialize(HardwareMap hardwareMap) throws InterruptedException {
        LSlide = hardwareMap.get(DcMotor.class, LSlide_Name);
        RSlide = hardwareMap.get(DcMotor.class, RSlide_Name);

        RSlide.setDirection(DcMotor.Direction.REVERSE);
    }
}
