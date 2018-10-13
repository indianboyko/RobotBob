package frc.team967.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	
	public static final int pcm = 1;
	
	// Drive Subsystem
	public static final int driveLeftLead = 7;
	public static final int driveLeftFollow = 8;
	public static final int driveLeftFollowTwo = 11;
	public static final int driveRightLead = 4;
	public static final int driveRightFollow = 3;
	public static final int driveRightFollowTwo = 12;
//
//	public static final int driveLeftLead = 3;
//	public static final int driveLeftFollow = 4;
//	public static final int driveLeftFollowTwo = 5;
//	public static final int driveRightLead = 6;
//	public static final int driveRightFollow = 7;
//	public static final int driveRightFollowTwo = 8;

	// Lift Subsystem
	public static final int liftLead = 6;
	public static final int liftFollow = 5;

	public static final int limitSwitchTop = 1;
	public static final int limitSwitchBottom = 0;
	
	public static final int liftHigh = 5;
	public static final int liftLow = 2;
	
	public static final int busterBrakeIn = 1;
	public static final int busterBrakeOut = 6;
	
	//Intake
	public static final int rightIntake = 2;
	public static final int leftIntake = 1;

	public static final int armOpen = 0;
	public static final int armClosed = 7;
	
	//Wrist
	public static final int wrist = 0;
	
}
