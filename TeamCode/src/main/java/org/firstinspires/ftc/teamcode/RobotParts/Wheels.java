package org.firstinspires.ftc.teamcode.RobotParts;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import org.firstinspires.ftc.teamcode.Direction;
import org.firstinspires.ftc.teamcode.Interfaces.Directional;
import org.firstinspires.ftc.teamcode.Interfaces.Macro;
import org.firstinspires.ftc.teamcode.Interfaces.Power;
import org.firstinspires.ftc.teamcode.Interfaces.Initializable;

public class Wheels implements Initializable, Directional {

    private static Direction currentDirection = Direction.STATIC;
    public static DcMotor FLW, FRW, BLW, BRW;
    final private String FLW_Name, FRW_Name, BLW_Name, BRW_Name;

    public Wheels(String FLW_Name, String FRW_Name, String BLW_Name, String BRW_Name) {
        this.FLW_Name = FLW_Name;
        this.FRW_Name = FRW_Name;
        this.BLW_Name = BLW_Name;
        this.BRW_Name = BRW_Name;
    }

    // examples of Power and Macro interfaces
    final public static Power moveWheels = () -> {
        switch (currentDirection) {
            case FORWARD:
                break;
            case BACKWARD:
                break;
            case LEFT:
                break;
            case RIGHT:
                break;
            default:
                break;
        }
    };

    final public static Macro move90Deg = () -> {
        // insert code here
    };

    // setter
    @Override
    public void setDirection(Direction direction) {
        // since this is the class for Wheels, arm directions not needed, vice versa
        switch (direction) {
            case STATIC: case FORWARD: case BACKWARD: case LEFT: case RIGHT:
                currentDirection = direction;
                break;
            default:
                // do nothing
                break;
        }
    }

    // getter
    @Override
    public Direction getDirection() {
        return currentDirection;
    }

    @Override
    public void initialize(HardwareMap hardwareMap) throws InterruptedException {
        FLW = hardwareMap.get(DcMotor.class, FLW_Name);
        FRW = hardwareMap.get(DcMotor.class, FRW_Name);
        BLW = hardwareMap.get(DcMotor.class, BLW_Name);
        BRW = hardwareMap.get(DcMotor.class, BRW_Name);

        FLW.setDirection(DcMotor.Direction.FORWARD);
        BLW.setDirection(DcMotor.Direction.FORWARD);
        FRW.setDirection(DcMotor.Direction.REVERSE);
        BRW.setDirection(DcMotor.Direction.REVERSE);
    }
}
