/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class StorageSol extends SubsystemBase {
  /**
   * Creates a new StorageSol.
   */
  public StorageSol() {

  }
  private DoubleSolenoid storageSol = new DoubleSolenoid(Constants.STORAGESOL1, Constants.SOTRAGESOL2);
  boolean isOut = false; 
  public static StorageSol instance;
  public static StorageSol GetInstance(){
    if (instance == null)
      instance = new StorageSol();
    return instance;
  }
  public void ShooterOut(){
    storageSol.set(Value.kForward);
    isOut = true;
    SmartDashboard.putString("Storage Sol", "Out");
  }
  public void ShooterIn(){
    storageSol.set(Value.kReverse);
    isOut = false; 
    SmartDashboard.putString("Storage Sol", "In");
  }
  public boolean getIsOut(){
    return isOut;
  }
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
