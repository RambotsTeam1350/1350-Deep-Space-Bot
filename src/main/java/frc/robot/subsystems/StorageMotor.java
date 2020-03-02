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

public class StorageMotor extends SubsystemBase {
  /**
   * Creates a new StorageMotor.
   */
  public StorageMotor() {

  }
  private boolean isOn = false;
  private static StorageMotor instance;
  public static StorageMotor GetInstance(){
    if (instance==null)
      instance = new StorageMotor();
    return instance;
  }
  private CANSparkMax storageMotor = new CANSparkMax(Constants.STORAGEMOTOR, MotorType.kBrushless);

  public void setStorageMotor(){
    storageMotor.set(Constants.STORAGEMOTORSPEED);
    isOn = true;
  }
  public void storageMotorOff(){
    storageMotor.set(0);
    isOn = false;
  }
  public boolean getIsOn(){
    return isOn;
  }
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
