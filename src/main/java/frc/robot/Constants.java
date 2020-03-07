/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;


/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants.  This class should not be used for any other purpose.  All constants should be
 * declared globally (i.e. public static).  Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
    //Controls
	public static final int LEFTJOYSTICKPORT = 0;
    public static final int RIGHTJOYSTICKPORT = 1;
    public static final int XBOX = 2;
    //Drivetrain
	public static final int LEFTMOTOR = 0;
    public static final int RIGHTMOTOR =1;
    public static final double AUTOTURNSPEED = .7;
    //Elevator
	public static final int ELEVATORMOTORPORT = 3;
	public static final int WENCHMOTORPORT = 2;
	public static final double ELEVATORSPEED = .5;
	public static final double WENCHSPEED = 1;
    //Intake
    public static final int INTAKESOL1 = 0;
    public static final int INTAKESOL2 = 1;
	public static final int INTAKEMOTORPORT = 5;
	public static final double INTAKEMOTORSPEED = .65;
    //Control pannel
    public static final int CONTROLSOLPORT1 = 4;
    public static final int CONTROLSOLPORT2 = 5;
    public static final int CONTROLMOTOR = 3;
    public static final int SPINCOUNTVALUE = 7;
    public static final double CONTROLMOTORSPEED = .7;
    //Storage
    public static final int STORAGESOL1 = 6;
    public static final int SOTRAGESOL2 = 7;
 	public static final int STORAGEMOTOR = 1;
    public static final double STORAGEMOTORSPEED = .55;
    //gearbox
	public static final int GEARBOXPORT1 = 2;
	public static final int GEARBOXPORT2 = 3;
	public static final int HIGHGEARBUTTON = 2;
    public static final int LOWGEARBUTTON = 3;
    //Shooter
	public static final int LEFTSHOOTER = 4;
	public static final int RIGHTSHOOTER = 2;
	public static final double LOWGEARSPEED = .2;
    public static final double HIGHGEARSPEED = 1;
    //Compressor
    public static final int COMPRESSORBUTTON = 1;
    public static final int AUTOAIMBUTTON = 2;
    //Auto
	public static final double PHASE2TIME = 1;
	public static final double PHASE3TIME = 2;
	public static final double PHASE4TIME = 8;
	public static final double PHASE5TIME = 10;
	public static final double AUTOREVERSESPEED = .5;

    //Limelight (not constants)
    public static double x;
    public static double y;
    public static double a1;
    //Gearbox variables
    public static boolean isHigh = false;




}

