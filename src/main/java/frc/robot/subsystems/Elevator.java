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

public class Elevator extends SubsystemBase {
  /**
   * Creates a new Elevator.
   */
  public Elevator() {

  }
private static Elevator instance;
public static Elevator GetInstance(){
  if(instance==null)
    instance = new Elevator();
  return instance;
}

  private Victor elevatorMotor = new Victor(Constants.ELEVATORMOTORPORT); 
  

  public void SetElevatorUp(){
    Constants.isHigh = false;
    elevatorMotor.set(Constants.ELEVATORSPEED);
  }
  public void SetElevatorDown(){
    Constants.isHigh = false;
    elevatorMotor.set(-Constants.ELEVATORSPEED);
  }
  public void stopElevator(){
    //Constants.isHigh = true; 
    elevatorMotor.set(0);
  }
  

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
