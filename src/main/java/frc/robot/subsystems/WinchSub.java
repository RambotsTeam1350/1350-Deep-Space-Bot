/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class WinchSub extends SubsystemBase {
  /**
   * Creates a new WinchSub.
   */
  public WinchSub() {

  }
  private static WinchSub instance;
  public static WinchSub GetInstance(){
    if (instance==null)
      instance = new WinchSub();
    return instance;
  }
  private Victor wenchMotor = new Victor(Constants.WENCHMOTORPORT);
  public void SetWench(){
    Constants.isHigh = false; 
    wenchMotor.set(Constants.WENCHSPEED);
  }
  public void stopWinch(){
    //Constants.isHigh = true; 
    wenchMotor.set(0);
  }
  public void SetReverse(){
    wenchMotor.set(-Constants.WENCHSPEED);
  }
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
