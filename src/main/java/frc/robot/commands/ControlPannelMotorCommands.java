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
import frc.robot.subsystems.ControlPannelMotor;

public class ControlPannelMotorCommands extends CommandBase {
  /**
   * Creates a new ControlPannelMotorCommands.
   */
  public ControlPannelMotorCommands() {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(ControlPannelMotor.GetInstance());
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    ControlPannelMotor.GetInstance().setUpColor();
  }
  private static ControlPannelMotorCommands instance;
  public static ControlPannelMotorCommands GetInstance(){
    if (instance == null)
      instance = new ControlPannelMotorCommands();
    return instance;
  }
Timer timer = new Timer();
private boolean activated = false;
  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    SmartDashboard.putString("Color", ControlPannelMotor.GetInstance().getColor());
    if(RobotContainer.GetInstance().getSpinThriceButton() && activated == false){
      activated = true;
      ControlPannelMotor.GetInstance().spinThrice();
    }
    if(RobotContainer.GetInstance().getSpinThriceButtonReleased()){
      activated = false;
      ControlPannelMotor.GetInstance().resetSpinTrice();
    }
    if(RobotContainer.GetInstance().getSpinToColorButton()){
      activated = true;
      ControlPannelMotor.GetInstance().spinToColor();
    }
    if(RobotContainer.GetInstance().getSpinToColorReleased()){
      activated = false; 
      ControlPannelMotor.GetInstance().resetSpinToColor();
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
