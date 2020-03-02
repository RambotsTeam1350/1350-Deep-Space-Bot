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

public class intakePistons extends SubsystemBase {
  /**
   * Creates a new intakePistons.
   */
  public intakePistons() {

  }
  private static intakePistons instance;
  public static intakePistons GetInstance(){
    if (instance==null)
      instance = new intakePistons();
    return instance;
  }
private DoubleSolenoid intakeSols = new DoubleSolenoid(Constants.INTAKESOL1, Constants.INTAKESOL2);
 
public void intakeOut(){
  intakeSols.set(Value.kForward);
  IntakeMotor.GetInstance().IntakeMotorOff();   
  StorageMotor.GetInstance().storageMotorOff();
  
  StorageSol.GetInstance().ShooterOut();
}
public void intakeOutAuto(){
  intakeSols.set(Value.kReverse);
  IntakeMotor.GetInstance().IntakeMotorOff();   
  try{
  Thread.sleep(1000);
  } catch(Exception ex){
    SmartDashboard.putString("ERROR", "Storage had trouble sleeping");
  }
  StorageMotor.GetInstance().storageMotorOff();
  
  StorageSol.GetInstance().ShooterOut();
}

public void intakeIn(){
  intakeSols.set(Value.kReverse);
  IntakeMotor.GetInstance().setIntakeMotor();
  StorageMotor.GetInstance().setStorageMotor();
}
@Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
