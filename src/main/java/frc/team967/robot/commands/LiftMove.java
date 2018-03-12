package frc.team967.robot.commands;

import frc.team967.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class LiftMove extends Command {

    public LiftMove() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.kLiftSubsystem);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        double power = Robot.m_oi.getXbox1().getRawAxis(1);
        if (!Robot.kLiftSubsystem.IsBottom()){
            Robot.kLiftSubsystem.moveLift(power);
        }
    	else if (power > 0) {
            Robot.kLiftSubsystem.moveLift(0);
        }
        else if (power < 0) {
            Robot.kLiftSubsystem.moveLift(power);
        }
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
