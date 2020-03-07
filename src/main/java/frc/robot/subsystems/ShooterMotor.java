/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.revrobotics.CANEncoder;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class ShooterMotor extends SubsystemBase {
  /**
   * Creates a new ShooterMotor.
   */
  public ShooterMotor() {

  }
  private static ShooterMotor instance;
  public static ShooterMotor GetInstance(){
    if (instance==null)
      instance = new ShooterMotor();
    return instance;
  }
  private CANSparkMax leftShooter = new CANSparkMax(Constants.LEFTSHOOTER, MotorType.kBrushless);
  private CANSparkMax rightShooter = new CANSparkMax(Constants.RIGHTSHOOTER, MotorType.kBrushless);
  public CANEncoder leftEncoder = leftShooter.getEncoder();
  public CANEncoder rightEncoder = rightShooter.getEncoder();
  private boolean isHigh = false;
  public void lowGear(){
    //Constants.isHigh = true; 
    leftShooter.set(-Constants.LOWGEARSPEED);
    rightShooter.set(Constants.LOWGEARSPEED);
    StorageMotor.GetInstance().storageMotorOff();
    StorageSol.GetInstance().ShooterOut();
    isHigh = false;
  }
  public void highGear(){
    Constants.isHigh = false;
    leftShooter.set(-Constants.HIGHGEARSPEED);
    rightShooter.set(Constants.HIGHGEARSPEED);
    try{
      Thread.sleep(750);
    } catch(Exception ex){
      SmartDashboard.putString("ERROR", "high gear had trouble sleeping");
    }
    StorageMotor.GetInstance().setStorageMotor();
    StorageSol.GetInstance().ShooterIn();
    isHigh = true;
    leftEncoder.getCountsPerRevolution();
  }
  public double findDistance(){
      return (98.25-20)/Math.tan(20+Constants.y);
  }
  public void reverse(){
    leftShooter.set(Constants.HIGHGEARSPEED);
    rightShooter.set(-Constants.HIGHGEARSPEED);
  }
  public boolean getIsHigh(){
    return isHigh;
  }
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
