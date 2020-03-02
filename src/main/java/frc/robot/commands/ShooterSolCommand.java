/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.subsystems.StorageSol;

public class ShooterSolCommand extends CommandBase {
  /**
   * Creates a new ShooterSolCommand.
   */
  public ShooterSolCommand() {
    // Use addRequirements() here to declare subsystem dependencies.
  addRequirements(StorageSol.GetInstance());
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    StorageSol.GetInstance().ShooterOut();
  }
  
  private static ShooterSolCommand instance;
  public static ShooterSolCommand GetInstance(){
    if (instance==null)
      instance = new ShooterSolCommand();
    return instance;
  }
Timer timer = new Timer();
boolean isOut = false; 
  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if (timer.get()>.2){
      timer.stop();
      timer.reset();
    }
    if(RobotContainer.GetInstance().getShooterAxis()>0 && timer.get()==0){
      timer.start();
      if(StorageSol.GetInstance().getIsOut()==false){
        StorageSol.GetInstance().ShooterOut();
        } else {
          StorageSol.GetInstance().ShooterIn();
        }
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
