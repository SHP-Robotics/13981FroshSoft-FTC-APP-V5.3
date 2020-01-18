package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;


@Autonomous


public class RightLoadingZoneAutonomous extends BaseRobot {
    private int stage;
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

            case 0:
                    if (auto_mecanum(-0.4,7)){
                        reset_drive_encoders();
                        stage++;
                    }
                break;
            case 1 :
                    if (auto_drive(0.6, 33)) {
                        set_platformMoveLeft_servo(0);
                        set_platformMoveRight_servo(1);
                        reset_drive_encoders();
                        timer.reset();
                        stage++;
                    }

                break;

            case 2:
                if (timer.seconds() > 1) {
                    if (auto_drive(-0.6, 31)) {
                        set_platformMoveLeft_servo(1.8);
                        set_platformMoveRight_servo(0.2);
                        reset_drive_encoders();
                        timer.reset();
                        stage++;
                    }
                }
                break;

            case 3:
                if (timer.seconds() > 2) {
                    if (auto_mecanum(0.5, 60)) {
                        reset_drive_encoders();
                        stage++;
                    }
                }

                break;

        }
    }
}
