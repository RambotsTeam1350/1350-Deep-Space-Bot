/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.ColorMatch;
import com.revrobotics.ColorMatchResult;
import com.revrobotics.ColorSensorV3;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.util.Color;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class ControlPannelMotor extends SubsystemBase {

  /**
   * Creates a new ControlPannelMotor.
   */
  public ControlPannelMotor() {

  }

  private int spinCount = 0;
  private boolean isBlue = false;
  private boolean isDone = false;
  private CANSparkMax controlMotor = new CANSparkMax(Constants.CONTROLMOTOR, MotorType.kBrushless);
  private static I2C.Port i2cPort = I2C.Port.kOnboard;
  private static ColorSensorV3 colorSensor = new ColorSensorV3(i2cPort);
  private static ColorMatch colorMatch = new ColorMatch();
  private final Color Blue = ColorMatch.makeColor(0.143, 0.427, 0.429);
  private final Color Green = ColorMatch.makeColor(0.197, 0.561, 0.240);
  private final Color Red = ColorMatch.makeColor(0.561, 0.232, 0.114);
  private final Color Yellow = ColorMatch.makeColor(0.361, 0.524, 0.113);

  private static ControlPannelMotor instance;
  public static ControlPannelMotor GetInstance(){
  if (instance == null)
    instance = new ControlPannelMotor();
  return instance;
}

  public void setUpColor() {
    colorMatch.addColorMatch(Red);
    colorMatch.addColorMatch(Green);
    colorMatch.addColorMatch(Blue);
    colorMatch.addColorMatch(Yellow);
  }

  public String getColor() {
    Color detectedColor = colorSensor.getColor();
    ColorMatchResult match = colorMatch.matchClosestColor(detectedColor);
  if (match.color == Blue) {
      return "Blue";
    } else if (match.color == Red) {
      return "Red";
    } else if (match.color == Green) {
      return "Green";
    } else if (match.color == Yellow) {
      return "Yellow";
    } else {
      return "Unknown";
    }
}
public  void spinThrice(){
  Constants.isHigh = false;
  setUpColor();
      controlMotor.set(Constants.CONTROLMOTORSPEED);
      if(getColor().equals("Blue") && isBlue==false){
        spinCount++;
        isBlue=true;
      } else if (!getColor().equals("Blue")) {
        isBlue = false;
      }
      if(spinCount>=Constants.SPINCOUNTVALUE){
        controlMotor.set(0);
      }
}
public void spinToColor(){
  Constants.isHigh = false;
  String gameData = DriverStation.getInstance().getGameSpecificMessage();  
    if(gameData.length() > 0)
    {
      switch (gameData.charAt(0))
      {
        case 'B' :
        if(getColor().equals("Red")){
          controlMotor.set(0);
          isDone = true;
        }
        if(isDone==false)
        controlMotor.set(Constants.CONTROLMOTORSPEED);
          break;
        case 'G' :
        if(getColor().equals("Yellow")){
        controlMotor.set(0);
        isDone = true;
        }
        if(isDone==false)
        controlMotor.set(Constants.CONTROLMOTORSPEED);
          break;
        case 'R' :
        if(getColor().equals("Blue")){
        controlMotor.set(0);
        isDone = true;
        }
        if(isDone==false)
        controlMotor.set(Constants.CONTROLMOTORSPEED);
          break;
        case 'Y' :
        if(getColor().equals("Green")){
        controlMotor.set(0);
        isDone = true;
        }
        if(isDone==false)
        controlMotor.set(Constants.CONTROLMOTORSPEED);
          break;
        default :
          SmartDashboard.putString("ERROR", "ERROR3467654 INVALID COLOR");
          break;
      }
    } 
  }  

public void resetSpinTrice(){
  //Constants.isHigh = true;
  isBlue=false;
  spinCount = 0; 
  controlMotor.set(0);
}
public void resetSpinToColor(){
  //Constants.isHigh = true;
  isDone = false;
  controlMotor.set(0);
}

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
