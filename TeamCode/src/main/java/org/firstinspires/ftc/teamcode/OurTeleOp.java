package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.Range;

import org.firstinspires.ftc.robotcore.external.Const;

/*
Created by Chun on 1/26/19 for 10023. Edited by Team 13981 on 10/14/19.
*/

@TeleOp

public class OurTeleOp extends BaseRobot {

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

        tankanum_drive(gamepad1.right_stick_y, gamepad1.left_stick_y, gamepad1.right_stick_x);


        //lower or raise first rack and pinion
        if (gamepad1.dpad_up || gamepad1.b) {
            setArmLiftMotor(-1);
        } else if (gamepad1.dpad_down || gamepad1.a) {
            setArmLiftMotor(1);
        } else {
            setArmLiftMotor(0);
        }

        // second rack and pinion
        if (gamepad1.x) {
            setArmLiftMotor2(1);
        } else if (gamepad1.y) {
            setArmLiftMotor2(-1);
        } else {
            setArmLiftMotor2(0);
        }

        //Servo Motors for platform
        if (gamepad1.dpad_left) {
            set_platformMoveRight_servo(0);
            set_platformMoveLeft_servo(1);
        }
        else if (gamepad1.dpad_right) {
            set_platformMoveRight_servo(1);
            set_platformMoveLeft_servo(0);
        }


        //Clamp Motor
        if (gamepad1.left_bumper) {
            setArmClampMotor(-1);
        } else if (gamepad1.right_bumper) {
            setArmClampMotor(1);
        } else {
            setArmClampMotor(0);
        }
    }
}