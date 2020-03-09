/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;


import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
// import frc.robot.commands.ExampleCommand;
// import frc.robot.subsystems.ExampleSubsystem;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

/**
 * This class is where the bulk of the robot should be declared.  Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls).  Instead, the structure of the robot
 * (including subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  // private final ExampleSubsystem m_exampleSubsystem = new ExampleSubsystem();

  // private final ExampleCommand m_autoCommand = new ExampleCommand(m_exampleSubsystem);




/**
   * The container for the robot.  Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();
  }

  /**
   * Use this method to define your button->command mappings.  Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a
   * {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {

    //Basically OI
  }
  Joystick leftJoystick = new Joystick(Constants.LEFTJOYSTICKPORT);
  Joystick rightJoystick = new Joystick(Constants.RIGHTJOYSTICKPORT);
  XboxController xBox = new XboxController(Constants.XBOX);

  JoystickButton highGearButton = new JoystickButton(leftJoystick, Constants.HIGHGEARBUTTON);
  JoystickButton lowGearButton = new JoystickButton(leftJoystick, Constants.LOWGEARBUTTON);
  JoystickButton compressorButton = new JoystickButton(leftJoystick, Constants.COMPRESSORBUTTON);
  JoystickButton autoAimButton = new JoystickButton(rightJoystick, Constants.AUTOAIMBUTTON);
  private static RobotContainer instance;
  public static RobotContainer GetInstance(){
    if (instance==null)
      instance = new RobotContainer();
    return instance;
  }
  public boolean GetReverseButton(){
    return xBox.getStartButtonPressed();
  }
  public boolean GetReverseButtonReleased(){
    return xBox.getStartButtonReleased();
  }
  public boolean GetTurntableButtonReleased(){
    return xBox.getStickButtonReleased(Hand.kRight);
  }
  public boolean getAutoAimButton(){
    return autoAimButton.get();
  }
  public boolean getCompressorButton(){
    return compressorButton.get();
  }
  public boolean getHighGearButton(){
    return highGearButton.get();
  }
  public boolean lowGearButton(){
    return lowGearButton.get();
  }
  public double getLeftJoystick(){
    //return leftJoystick.getRawAxis(1);
    return xBox.getX(Hand.kLeft);
  }
  public double getRightJoystick(){
    //return rightJoystick.getRawAxis(1);
    return xBox.getX(Hand.kRight);
  }
  public boolean GetElevatorUp(){
    return xBox.getBumperPressed(Hand.kRight);
  }
  public boolean GetElevatorDown(){
    return xBox.getBumperPressed(Hand.kLeft);
  }
  public boolean GetElavatorUpReleased(){
    return xBox.getBumperReleased(Hand.kRight);
  }
  public boolean GetElevatorDownReleased(){
    return xBox.getBumperReleased(Hand.kLeft);
  }
  public boolean GetWinchButton(){
    return xBox.getAButtonPressed();
  }
  public boolean GetWinchButtonReleased(){
    return xBox.getAButtonReleased();
  }
  public double GetIntakeValue() {
    return xBox.getTriggerAxis(Hand.kLeft);
  }
  public boolean getXButton(){
    return xBox.getXButtonPressed();
  }
  public int getControlValue(){
    return xBox.getPOV();
  }
  public boolean getStorageShooter(){
    return xBox.getXButtonPressed();
  }
  public boolean getStorageButtonReleased(){
    return xBox.getXButtonReleased();
  }
  public double getShooterAxis(){
    return xBox.getTriggerAxis(Hand.kRight);
  }
  public boolean getSpinToColorButton(){
    return xBox.getYButtonPressed();
  }
  public boolean getSpinToColorReleased(){
    return xBox.getYButtonReleased();
  }
  public boolean getSpinThriceButton(){
    return xBox.getBButtonPressed();
  }
  public boolean getSpinThriceButtonReleased(){
    return xBox.getBButtonReleased();
  }
  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  // public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    //return m_autoCommand;
  }
//}
