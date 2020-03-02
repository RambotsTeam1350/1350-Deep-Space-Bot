/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.subsystems.ControlPannelSol;

public class ControlPannelSolCommands extends CommandBase {
  /**
   * Creates a new ControlPannelSolCommands.
   */
  public ControlPannelSolCommands() {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(ControlPannelSol.GetInstance());
  }
  private static ControlPannelSolCommands instance;
  public static ControlPannelSolCommands GetInstance(){
    if (instance == null)
      instance = new ControlPannelSolCommands();
    return instance;
  }
  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    ControlPannelSol.GetInstance().controlSolOut();
  }
Timer timer = new Timer();
boolean isOut = true;
  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if (timer.get()>.2){
      timer.stop();
      timer.reset();
    }
    if(RobotContainer.GetInstance().getStorageShooter() && timer.get()==0){
      timer.start();
      if(isOut){
        ControlPannelSol.GetInstance().controlSolIn();
        isOut = false;
      } else {
        ControlPannelSol.GetInstance().controlSolOut();
        isOut= true;
      }
    }
    SmartDashboard.putBoolean("isOut control", isOut);
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
