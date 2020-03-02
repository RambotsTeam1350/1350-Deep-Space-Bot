/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Drivetrain extends SubsystemBase {
  /**
   * Creates a new Drivetrain.
   */

  public Drivetrain() {

  }

  private Victor rightMotor = new Victor(Constants.LEFTMOTOR);
  private Victor leftMotor = new Victor(Constants.RIGHTMOTOR);

  public void setLeftDrive(double speed) {
    leftMotor.set(-speed);
  }

  public void setRightDrive(double speed) {
    rightMotor.set(speed);
  }

  public void autoAim() {
    double scaleConstant = -0.01;
    double minValue = 0.10;
    double motorValue = 0;
    boolean isBad = false;
    NetworkTableInstance.getDefault().getTable("limelight").getEntry("ledMode").setNumber(0);
    if(Constants.x<=.5 && Constants.x>=-.5){
      leftMotor.set(0);
      rightMotor.set(0);
      isBad = true;
    }
    if(Constants.x>=.5 && isBad==false){
      motorValue = scaleConstant*Constants.x-minValue;
      leftMotor.set(-motorValue);
    }
    if(Constants.x<=-.5 && isBad ==false){
      motorValue = scaleConstant*Constants.x+minValue;
      rightMotor.set(motorValue);
    }
  }
  public void spinToTarget(){
    if(Constants.x==0){
      leftMotor.set(Constants.AUTOTURNSPEED);
      rightMotor.set(Constants.AUTOTURNSPEED);
    }
  }

  private static Drivetrain instance;
  public static Drivetrain GetInstance(){
    if (instance == null)
      instance = new Drivetrain();
    return instance;
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
