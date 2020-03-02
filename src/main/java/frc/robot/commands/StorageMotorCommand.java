/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.RobotController;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.subsystems.IntakeMotor;
import frc.robot.subsystems.ShooterMotor;
import frc.robot.subsystems.StorageMotor;

public class StorageMotorCommand extends CommandBase {
  /**
   * Creates a new StorageMotorCommand.
   */
  public StorageMotorCommand() {
    // Use addRequirements() here to declare subsystem dependencies.
  addRequirements(StorageMotor.GetInstance());
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }
  private static StorageMotorCommand instance;
  Timer timer = new Timer();
  public static StorageMotorCommand GetInstance(){
    if (instance==null)
      instance = new StorageMotorCommand();
    return instance;
  }
  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if (timer.get()>.2){
      timer.stop();
      timer.reset();
    }
    if (RobotContainer.GetInstance().getShooterAxis()>0 && timer.get()==0){
      timer.start();
      if(IntakeMotor.GetInstance().getIsOn()==false){
        //StorageMotor.GetInstance().storageMotorOff();
      } else {
        //StorageMotor.GetInstance().setStorageMotor();
      }
      if(RobotContainer.GetInstance().GetIntakeValue()>0){
        timer.start();
        if(ShooterMotor.GetInstance().getIsHigh()==false){
          StorageMotor.GetInstance().storageMotorOff();
        } else {
          StorageMotor.GetInstance().setStorageMotor();
        }
        
        // if(RobotContainer.GetInstance().GetTurntableButton()){
        //   StorageMotor.GetInstance().setStorageMotor();
        // }
        // if(RobotContainer.GetInstance().GetTurntableButtonReleased()){
        //   StorageMotor.GetInstance().storageMotorOff();
        // }

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
