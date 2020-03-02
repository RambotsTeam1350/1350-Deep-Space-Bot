/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.subsystems.Drivetrain;

public class DrivetrainCommands extends CommandBase {
  /**
   * Creates a new Drivetrain.
   */
  public DrivetrainCommands() {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(Drivetrain.GetInstance());
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double leftStick = RobotContainer.GetInstance().getLeftJoystick();
    double rightStick = RobotContainer.GetInstance().getRightJoystick();
    Drivetrain.GetInstance().setLeftDrive(leftStick);
    Drivetrain.GetInstance().setRightDrive(rightStick);
    if (RobotContainer.GetInstance().getAutoAimButton()) {
      Drivetrain.GetInstance().autoAim();
    } else {
      NetworkTableInstance.getDefault().getTable("limelight").getEntry("ledMode").setNumber(3);
    }
  }

  private static DrivetrainCommands instance;
  public static DrivetrainCommands GetInstance(){
    if(instance==null)
      instance = new DrivetrainCommands();
    return instance;
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
