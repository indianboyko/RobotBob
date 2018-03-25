package frc.team967.robot.commands;

import frc.team967.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class LiftMove extends Command {

    double Power = 0;

//    public LiftMove(double power) {
//        // Use requires() here to declare subsystem dependencies
//        // eg. requires(chassis);
//    	requires(Robot.kLiftSubsystem);
//        Power = power;
//    }
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
        double Power = Robot.m_oi.getXbox1().getRawAxis(1);
        Robot.kLiftSubsystem.moveLift(-Power);
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
