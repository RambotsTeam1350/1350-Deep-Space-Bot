/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.subsystems.Elevator;

public class ElevatorCommands extends CommandBase {
  /**
   * Creates a new Elevator.
   */
  public ElevatorCommands() {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(Elevator.GetInstance());
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    
  }
  private static ElevatorCommands instance;
  public static ElevatorCommands GetInstance(){
    if (instance==null)
      instance = new ElevatorCommands();
    return instance;
  }
  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if(RobotContainer.GetInstance().GetElevatorUp()){
      Elevator.GetInstance().SetElevatorUp();
    }
    if(RobotContainer.GetInstance().GetElevatorDown()){
      Elevator.GetInstance().SetElevatorDown();
    }
    if(RobotContainer.GetInstance().GetElavatorUpReleased() || RobotContainer.GetInstance().GetElevatorDownReleased()){
      Elevator.GetInstance().stopElevator();
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
