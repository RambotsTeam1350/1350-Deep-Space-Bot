/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class IntakeMotor extends SubsystemBase {
  /**
   * Creates a new IntakeNew.
   */
  public IntakeMotor() {

 
  }
  private boolean isOn = false;
  private static IntakeMotor instance;
  public static IntakeMotor GetInstance(){
    if (instance==null)
      instance = new IntakeMotor();
    return instance;
  }
  private CANSparkMax intakeMotor = new CANSparkMax(Constants.INTAKEMOTORPORT, MotorType.kBrushless);
  public void setIntakeMotor(){
    Constants.isHigh = false;

    intakeMotor.set(Constants.INTAKEMOTORSPEED);
    isOn = true;
  }
  public void IntakeMotorOff(){
    //Constants.isHigh = true; 

    intakeMotor.set(0);
    isOn=false;
  }
  public boolean getIsOn(){
    return isOn;
  }
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
