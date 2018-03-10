package frc.team967.robot.commands;

import frc.team967.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class BusterBrake extends Command {

    public String Position;

    public BusterBrake(String position) {
        requires(Robot.kLiftSubsystem);
        Position = position;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        if (Position == "enabled") {
            Robot.kLiftSubsystem.enableBrake();
        }
        else if (Position =="disabled"){
            Robot.kLiftSubsystem.removeBrake();
        }
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {

    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return true;
    }

    // Called once after isFinished returns true
    protected void end() {

    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {

    }
}