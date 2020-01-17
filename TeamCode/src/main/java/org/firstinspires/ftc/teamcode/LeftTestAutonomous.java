package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;


// Template created by Chun on 1/26/19 for 10023. Made by Team 13981 on 10/11/19


@Autonomous

public class LeftTestAutonomous extends BaseRobot {
    private int stage = 0;

    private int leftFront;



    @Override
    public void init() {
        super.init();
    }

    @Override
    public void start() {
        super.start();
    }

    @Override
    public void loop() {
        super.loop();
        switch (stage) {

                // Drive forward from the corner and stop
            case 0:
                if (auto_drive(1, 27)) {
                    reset_drive_encoders();
                    stage++;
                }
                    break;

                // Scan for color while mecanuming, assign encoder value to variable after seeing black
            case 1:
                if (checkBlackColor(colorBlock.red(), colorBlock.blue())) {
                    leftFront = leftFrontDriveMotor.getCurrentPosition();
                    reset_drive_encoders();
                    stage++;

                }
                else auto_mecanum(-0.5, 46);
                    break;

            case 2:
                // adjust the robot to the block
                if (auto_drive(0.5, 2)) {
                    reset_drive_encoders();
                    setArmClampMotor(1);
                    stage++;
                }
                    break;

            case 3:
                // adjust the robot off the block
                if (auto_drive(-0.5, 2)) {
                    reset_drive_encoders();
                    timer.reset();
                    stage++;
                }
                    break;

                // mecanum back to first block using the opposite of the variable
            case 4:
                    if (leftFrontDriveMotor.getCurrentPosition() >= -leftFront) {
                        reset_drive_encoders();
                        stage++;
                    }
                    else auto_mecanum(0.5, 46);
                    break;

            case 5:
                if (auto_drive(-1, 5)) {
                    reset_drive_encoders();
                    stage++;
                }
                    break;

            default:
                    break;
        }

    }
}
