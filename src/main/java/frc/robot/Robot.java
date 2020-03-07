/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import frc.robot.commands.CompressorCommands;
import frc.robot.commands.ControlPannelMotorCommands;
import frc.robot.commands.ControlPannelSolCommands;
import frc.robot.commands.DrivetrainCommands;
import frc.robot.commands.ElevatorCommands;
import frc.robot.commands.GearboxCommands;
import frc.robot.commands.IntakeMotorCommands;
import frc.robot.commands.ShooterMotorCommands;
import frc.robot.commands.ShooterSolCommand;
import frc.robot.commands.StorageMotorCommand;
import frc.robot.commands.Winch;
import frc.robot.commands.intakeSolCommands;
import frc.robot.subsystems.CompressorSub;
import frc.robot.subsystems.ControlPannelMotor;
import frc.robot.subsystems.ControlPannelSol;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Elevator;
import frc.robot.subsystems.Gearbox;
import frc.robot.subsystems.IntakeMotor;
import frc.robot.subsystems.ShooterMotor;
import frc.robot.subsystems.StorageMotor;
import frc.robot.subsystems.StorageSol;
import frc.robot.subsystems.WinchSub;
import frc.robot.subsystems.intakePistons;


/**
 * The VM is configured to automatically run this class, and to call the functions corresponding to
 * each mode, as described in the TimedRobot documentation. If you change the name of this class or
 * the package after creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
  private Command m_autonomousCommand;
  private Timer autoTimer = new Timer();
  private RobotContainer m_robotContainer;
//LIMELOGHT 20 degrees 20 ft
  /**
   * This function is run when the robot is first started up and should be used for any
   * initialization code.
   */
  @Override
  public void robotInit() {
    // Instantiate our RobotContainer.  This will perform all our button bindings, and put our
    // autonomous chooser on the dashboard.
    NetworkTableInstance.getDefault().getTable("limelight").getEntry("ledMode").setNumber(0);
    m_robotContainer = new RobotContainer();
    Drivetrain.GetInstance().setDefaultCommand(DrivetrainCommands.GetInstance());
    Elevator.GetInstance().setDefaultCommand(ElevatorCommands.GetInstance());
    WinchSub.GetInstance().setDefaultCommand(Winch.GetInstance());
    intakePistons.GetInstance().setDefaultCommand(intakeSolCommands.GetInstance());
    IntakeMotor.GetInstance().setDefaultCommand(IntakeMotorCommands.GetInstance());
    ControlPannelSol.GetInstance().setDefaultCommand(ControlPannelSolCommands.GetInstance());
    StorageSol.GetInstance().setDefaultCommand(ShooterSolCommand.GetInstance());
    Gearbox.GetInstance().setDefaultCommand(GearboxCommands.GetInstance());
    StorageMotor.GetInstance().setDefaultCommand(StorageMotorCommand.GetInstance());
    ShooterMotor.GetInstance().setDefaultCommand(ShooterMotorCommands.GetInstance());
    ControlPannelMotor.GetInstance().setDefaultCommand(ControlPannelMotorCommands.GetInstance());
    CompressorSub.GetInstance().setDefaultCommand(CompressorCommands.GetInstance());

  }

  /**
   * This function is called every robot packet, no matter the mode. Use this for items like
   * diagnostics that you want ran during disabled, autonomous, teleoperated and test.
   *
   * <p>This runs after the mode specific periodic functions, but before
   * LiveWindow and SmartDashboard integrated updating.
   */
  NetworkTable table = NetworkTableInstance.getDefault().getTable("limelight");
  @Override
  public void robotPeriodic() {
    // Runs the Scheduler.  This is responsible for polling buttons, adding newly-scheduled
    // commands, running already-scheduled commands, removing finished or interrupted commands,
    // and running subsystem periodic() methods.  This must be called from the robot's periodic
    // block in order for anything in the Command-based framework to work.
    NetworkTableEntry tx = table.getEntry("tx");
    NetworkTableEntry ty = table.getEntry("ty");
    NetworkTableEntry ta = table.getEntry("ta");
    NetworkTableEntry tv = table.getEntry("tv");
    Constants.x = tx.getDouble(0.0);
    Constants.y = ty.getDouble(0.0);
    Constants.a1 = tv.getDouble(0.0);
    SmartDashboard.putNumber("a1", Constants.a1);
    SmartDashboard.putString("Color", ControlPannelMotor.GetInstance().getColor());
    SmartDashboard.putBoolean("Compressor", CompressorSub.GetInstance().getCompressorStatus());
    CommandScheduler.getInstance().run();
    SmartDashboard.putBoolean("stick", RobotContainer.GetInstance().GetTurntableButtonReleased());
    SmartDashboard.putNumber("Distance", ShooterMotor.GetInstance().findDistance());
    SmartDashboard.putNumber("Left RPM", ShooterMotor.GetInstance().leftEncoder.getVelocity());
    SmartDashboard.putNumber("Right RPM", ShooterMotor.GetInstance().rightEncoder.getVelocity());
  }

  /**
   * This function is called once each time the robot enters Disabled mode.
   */
  @Override
  public void disabledInit() {
    NetworkTableInstance.getDefault().getTable("limelight").getEntry("ledMode").setNumber(0);
    autoTimer.stop();
    autoTimer.reset();
    WinchSub.GetInstance().stopWinch();
    Drivetrain.GetInstance().setLeftDrive(0);
    Drivetrain.GetInstance().setRightDrive(0);
    StorageMotor.GetInstance().storageMotorOff();
    IntakeMotor.GetInstance().IntakeMotorOff();
  }

  @Override
  public void disabledPeriodic() {
    NetworkTableInstance.getDefault().getTable("limelight").getEntry("ledMode").setNumber(0);
  }

  /**
   * This autonomous runs the autonomous command selected by your {@link RobotContainer} class.
   */
  @Override
  public void autonomousInit() {
    //m_autonomousCommand = m_robotContainer.getAutonomousCommand();

    // schedule the autonomous command (example)
    ControlPannelSol.GetInstance().controlSolIn();
    ShooterMotor.GetInstance().lowGear();
    StorageMotor.GetInstance().storageMotorOff();
    IntakeMotor.GetInstance().IntakeMotorOff();
    NetworkTableInstance.getDefault().getTable("limelight").getEntry("ledMode").setNumber(0);
    ShooterMotor.GetInstance().lowGear();
    CompressorSub.GetInstance().compressorOn();
    StorageMotor.GetInstance().storageMotorOff();
    autoTimer.start();
    if (m_autonomousCommand != null) {
      m_autonomousCommand.schedule();
    }
  }

  /**
   * This function is called periodically during autonomous.
   */
  @Override
  public void autonomousPeriodic() {
    // if(autoTimer.get()<6){
    //   Drivetrain.GetInstance().setLeftDrive(.4);
    //   intakePistons.GetInstance().intakeIn();
    // } else if (autoTimer.get()>=6 && autoTimer.get()<12){
    //   intakePistons.GetInstance().intakeOutAuto();
    //   Drivetrain.GetInstance().setLeftDrive(Constants.AUTOREVERSESPEED);
    //   Drivetrain.GetInstance().setRightDrive(Constants.AUTOREVERSESPEED);
    // } else if (autoTimer.get()>=12){
    //   Drivetrain.GetInstance().setLeftDrive(0);
    //   Drivetrain.GetInstance().setRightDrive(0);
    //   ShooterMotor.GetInstance().lowGear();
    //   StorageMotor.GetInstance().storageMotorOff();
    //   // autoTimer.stop();
    //   // autoTimer.reset();
    // } 
    
  
      if(autoTimer.get()<Constants.PHASE2TIME){
        Drivetrain.GetInstance().spinToTarget();
        intakePistons.GetInstance().intakeIn();
      } else if (autoTimer.get()>=Constants.PHASE2TIME && autoTimer.get()<Constants.PHASE3TIME){
        Drivetrain.GetInstance().autoAim();
        intakePistons.GetInstance().intakeOutAuto();
      } else if (autoTimer.get()>=Constants.PHASE3TIME && autoTimer.get()<Constants.PHASE4TIME){
          ShooterMotor.GetInstance().highGear();
          if(StorageSol.GetInstance().getIsOut()==false)
            StorageSol.GetInstance().ShooterIn();
          StorageMotor.GetInstance().setStorageMotor();
      } else if (autoTimer.get()>=Constants.PHASE4TIME && autoTimer.get()<Constants.PHASE5TIME){
        NetworkTableInstance.getDefault().getTable("limelight").getEntry("ledMode").setNumber(3);
        ShooterMotor.GetInstance().lowGear();
        if(StorageSol.GetInstance().getIsOut())
          StorageSol.GetInstance().ShooterOut();
        StorageMotor.GetInstance().storageMotorOff();
        Drivetrain.GetInstance().setLeftDrive(Constants.AUTOREVERSESPEED);
        Drivetrain.GetInstance().setRightDrive(-Constants.AUTOREVERSESPEED);
      } else if (autoTimer.get()>=Constants.PHASE5TIME){
        Drivetrain.GetInstance().setLeftDrive(0);
        Drivetrain.GetInstance().setRightDrive(0);
        ShooterMotor.GetInstance().lowGear();
        StorageMotor.GetInstance().storageMotorOff();
        // autoTimer.stop();
        // autoTimer.reset();
      } 
   }

  @Override
  public void teleopInit() {
    // This makes sure that the autonomous stops running when
    // teleop starts running. If you want the autonomous to
    // continue until interrupted by another command, remove
    // this line or comment it out.
    NetworkTableInstance.getDefault().getTable("limelight").getEntry("ledMode").setNumber(0);
    autoTimer.reset();
    autoTimer.stop();

    if (m_autonomousCommand != null) {
      m_autonomousCommand.cancel();
    }
  }

  /**
   * This function is called periodically during operator control.
   */
  @Override
  public void teleopPeriodic() {
  }

  @Override
  public void testInit() {
    // Cancels all running commands at the start of test mode.
    CommandScheduler.getInstance().cancelAll();
  }

  /**
   * This function is called periodically during test mode.
   */
  @Override
  public void testPeriodic() {
  }
}