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
import frc.robot.subsystems.ShooterMotor;

public class ShooterMotorCommands extends CommandBase {
  /**
   * Creates a new ShooterMotorCommands.
   */
  public ShooterMotorCommands() {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(ShooterMotor.GetInstance());
  }
  private static ShooterMotorCommands instance;
  public static ShooterMotorCommands GetInstance(){
    if (instance==null)
      instance = new ShooterMotorCommands();
    return instance;
  }
  // Called when the command is initially scheduled.
  @Override
  public void initialize() {

  }
Timer timer = new Timer();
  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if (timer.get()>.2){
      timer.stop();
      timer.reset();
    }
    SmartDashboard.putNumber("Distance (inches)", ShooterMotor.GetInstance().findDistance());
    if(RobotContainer.GetInstance().getShooterAxis()>0 &&timer.get()==0){
      timer.start();
      if(ShooterMotor.GetInstance().getIsHigh()==false){
        ShooterMotor.GetInstance().highGear();
        
      } else {
        ShooterMotor.GetInstance().lowGear();
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
