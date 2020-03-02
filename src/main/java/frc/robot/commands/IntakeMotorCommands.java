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
import frc.robot.subsystems.IntakeMotor;

public class IntakeMotorCommands extends CommandBase {
  /**
   * Creates a new IntakeMotorCommands.
   */
  public IntakeMotorCommands() {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(IntakeMotor.GetInstance());
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }
  private static IntakeMotorCommands instance;
  public static IntakeMotorCommands GetInstance(){
    if (instance==null)
      instance = new IntakeMotorCommands();
    return instance;
  }
  private Timer timer = new Timer();
  
  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if (timer.get()>.2){
      timer.stop();
      timer.reset();
    }
    //if this doesn't work try getting rid of the timer!!!
    if(RobotContainer.GetInstance().getCompressorButton() && timer.get()==0){
      timer.start();
      if(IntakeMotor.GetInstance().getIsOn()==false){
       IntakeMotor.GetInstance().setIntakeMotor();
      } else {
        IntakeMotor.GetInstance().IntakeMotorOff();
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
