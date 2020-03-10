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
import frc.robot.subsystems.StorageMotor;
import frc.robot.subsystems.StorageSol;
import frc.robot.subsystems.intakePistons;

public class intakeSolCommands extends CommandBase {
  /**
   * Creates a new intakeSolCommands.
   */
  public intakeSolCommands() {
    addRequirements(intakePistons.GetInstance());
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    intakePistons.GetInstance().intakeOut();
  }

  private static intakeSolCommands instance;
  public static intakeSolCommands GetInstance(){
    if (instance==null)
      instance = new intakeSolCommands();
    return instance;
  }
  // Called every time the scheduler runs while the command is scheduled.
 private boolean isOut=true;
 Timer timer = new Timer();
  @Override
  public void execute() {
    if (timer.get()>.2){
      timer.stop();
      timer.reset();
    }
    if(RobotContainer.GetInstance().getCompressorButton()>0 && timer.get()==0){
      if (isOut){
        intakePistons.GetInstance().intakeIn();
        IntakeMotor.GetInstance().IntakeMotorOff();
        StorageMotor.GetInstance().setStorageMotor();
        isOut=false;
        timer.start();
      } else {
        intakePistons.GetInstance().intakeOut();
        IntakeMotor.GetInstance().setIntakeMotor();
        StorageMotor.GetInstance().storageMotorOff();
        isOut=true;
        timer.start();
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
