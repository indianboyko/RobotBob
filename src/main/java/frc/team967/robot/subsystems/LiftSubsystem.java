package frc.team967.robot.subsystems;

import frc.team967.robot.Robot;
import frc.team967.robot.RobotConstraints;
import frc.team967.robot.RobotMap;
import frc.team967.robot.commands.LiftMove;
import frc.team967.robot.commands.T_ArcadeDriveLookUp;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class LiftSubsystem extends Subsystem {

	private WPI_TalonSRX liftLead;
	private WPI_TalonSRX liftFollow;
	
	private DigitalInput limitSwitchTop;
	private DigitalInput limitSwitchBottom;
	
	private DoubleSolenoid liftShift;
	private DoubleSolenoid busterBrake;
	
//	private final double kP = RobotConstraints.LiftSubsystem_kP;
//	private final double kI = RobotConstraints.LiftSubsystem_kI;
//	private final double kD = RobotConstraints.LiftSubsystem_kD;
//	private final double kToleranceDegrees = RobotConstraints.LiftSubsystem_kTolerance;
	
    public LiftSubsystem(){
    	liftLead = new WPI_TalonSRX(RobotMap.liftLead);
    	liftFollow = new WPI_TalonSRX(RobotMap.liftFollow);
    	
    	liftLead.configSelectedFeedbackSensor(com.ctre.phoenix.motorcontrol.FeedbackDevice.QuadEncoder, 0, 0);
    	liftLead.setSensorPhase(false);
    	
    	liftFollow.follow(liftLead);
    	liftFollow.setInverted(true);

    	limitSwitchTop = new DigitalInput(RobotMap.limitSwitchTop);
    	limitSwitchBottom = new DigitalInput(RobotMap.limitSwitchBottom);
    	
    	liftShift = new DoubleSolenoid(RobotMap.pcm, RobotMap.liftHigh,RobotMap.liftLow);
    	busterBrake = new DoubleSolenoid(RobotMap.pcm, RobotMap.busterBrakeIn, RobotMap.busterBrakeOut);
    }
        
    public boolean IsTop()    { return limitSwitchTop.get();    }
    public boolean IsBottom() { return limitSwitchBottom.get(); }
    
    public double Position() {
    	if (limitSwitchBottom.get()) {
    		liftLead.getSensorCollection().setQuadraturePosition(0, 5);
            SmartDashboard.putBoolean("PositionInit", true);
    		return liftLead.getSensorCollection().getQuadraturePosition();
    	}
    	else {
            SmartDashboard.putBoolean("PositionInit", false);
    		return liftLead.getSensorCollection().getQuadraturePosition();
    	}
    }

    public void moveLift(double power) {
        if (!Robot.kLiftSubsystem.IsBottom()){
            liftLead.set(power);
        }
        else if (power > 0) {
            liftLead.set(0);
        }
        else if (power < 0) {
            liftLead.set(power);
        }
    }
    
    public void shiftLift(String position) {
    	if (position == "high") {
    		liftShift.set(DoubleSolenoid.Value.kForward);
    	} else if (position == "low") {
    		liftShift.set(DoubleSolenoid.Value.kReverse);
    	}
    }
    
    public void enableBrake() {
    	busterBrake.set(DoubleSolenoid.Value.kForward);
    }
    
    public void removeBrake() {
	   busterBrake.set(DoubleSolenoid.Value.kReverse);
   }
    
	public void initDefaultCommand() {
		setDefaultCommand(new LiftMove());
	}
    
    public void log() {
    	SmartDashboard.putNumber("Lift position", Position());
    	SmartDashboard.putNumber("Lift Velocity", liftLead.getSelectedSensorVelocity(0));
    	SmartDashboard.putNumber("LiftAmpsLead", liftLead.getOutputCurrent());
    	SmartDashboard.putNumber("LiftAmpsFollow", liftFollow.getOutputCurrent());
    	
    	SmartDashboard.putBoolean("limmit botom", IsBottom());

    	SmartDashboard.putNumber("LIFT Encoder", liftLead.getSensorCollection().getQuadraturePosition());
    }
}

