/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Gearbox extends SubsystemBase {
  /**
   * Creates a new Gearbox.
   */
  public Gearbox() {

  }
  private static Gearbox instance;
  public static Gearbox GetInstance(){
    if (instance==null)
      instance = new Gearbox();
    return instance;
  }
private DoubleSolenoid gearBox = new DoubleSolenoid(Constants.GEARBOXPORT1, Constants.GEARBOXPORT2);

public void highGear(){
gearBox.set(Value.kForward);
Constants.isHigh = true;
}
public void lowGear(){
  gearBox.set(Value.kReverse);
  Constants.isHigh = false; 
}

public void switchGear(){
  //if automatically going to high gear switch kValues
  if(Constants.isHigh){
    gearBox.set(Value.kForward);
  } else {
    gearBox.set(Value.kReverse);
  }
}
@Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
