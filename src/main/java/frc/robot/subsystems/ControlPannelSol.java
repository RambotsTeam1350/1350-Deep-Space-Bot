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

public class ControlPannelSol extends SubsystemBase {
  /**
   * Creates a new ControlPannel.
   */
  public ControlPannelSol() {

  }
private DoubleSolenoid commandSol = new DoubleSolenoid(Constants.CONTROLSOLPORT1, Constants.CONTROLSOLPORT2);  
private static ControlPannelSol instance;
public static ControlPannelSol GetInstance(){
  if (instance == null)
    instance = new ControlPannelSol();
  return instance;
}
public void controlSolOut(){
  commandSol.set(Value.kForward);
  SmartDashboard.putString("Control Pannel position", "UP");
}
public void controlSolIn(){
  commandSol.set(Value.kReverse);
  SmartDashboard.putString("Control Pannel position", "UP");
}
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
