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
import frc.robot.subsystems.CompressorSub;

public class CompressorCommands extends CommandBase {
  /**
   * Creates a new CompressorCommands.
   */
  public CompressorCommands() {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(CompressorSub.GetInstance());
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    //CompressorSub.GetInstance().compressorOff();
  }
  private static CompressorCommands instance;
  public static CompressorCommands GetInstance(){
    if (instance == null)
      instance = new CompressorCommands();
    return instance;
  }
Timer timer = new Timer();
  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if (timer.get()>.2){
      timer.stop();
      timer.reset();
    }
    if(RobotContainer.GetInstance().GetIntakeValue()>0 && timer.get()==0){
      timer.start();
      if(CompressorSub.GetInstance().getCompressorStatus()){
       CompressorSub.GetInstance().compressorOff();
      } else {
        CompressorSub.GetInstance().compressorOn();
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
