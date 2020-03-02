/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class CompressorSub extends SubsystemBase {
  /**
   * Creates a new Compressor.
   */
  public CompressorSub() {

  }
  private static CompressorSub instance;
  public static CompressorSub GetInstance(){
  if (instance == null)
    instance = new CompressorSub();
  return instance;
}
  private Compressor compressor = new Compressor();

  public void compressorOn(){
    compressor.start();
  }
  public void compressorOff(){
    compressor.stop();
  }
  public boolean getCompressorStatus(){
    return compressor.getClosedLoopControl();
  }
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
