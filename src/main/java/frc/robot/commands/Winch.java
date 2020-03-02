/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.subsystems.WinchSub;

public class Winch extends CommandBase {
  /**
   * Creates a new Winch.
   */
  public Winch() {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(WinchSub.GetInstance());
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {

  }
  private static Winch instance;
  public static Winch GetInstance(){
    if (instance==null)
      instance = new Winch();
    return instance;
  }
  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if(RobotContainer.GetInstance().GetWinchButton()){
      WinchSub.GetInstance().SetWench();
    }
    if(RobotContainer.GetInstance().GetWinchButtonReleased()){
      WinchSub.GetInstance().stopWinch();
    }
    // if(RobotContainer.GetInstance().GetReverseButton()){
    //   WinchSub.GetInstance().SetReverse();
    // }
    // if(RobotContainer.GetInstance().GetWinchButtonReleased()){
    //   WinchSub.GetInstance().stopWinch();
    // }
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
