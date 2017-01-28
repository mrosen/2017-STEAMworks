package org.usfirst.frc.team4915.steamworks.commands;

import org.usfirst.frc.team4915.steamworks.Logger;
import org.usfirst.frc.team4915.steamworks.subsystems.Launcher;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Joystick.AxisType;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class LauncherOnCommand extends Command 
{

	private final Joystick m_launchStick;
	private final Launcher m_launcher;
	private Logger m_logger;

	public LauncherOnCommand(Launcher launcher, Joystick launchStick) 
	{
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);

		m_launcher = launcher;
		m_launchStick = launchStick;
		m_logger = new Logger("Launcher", Logger.Level.DEBUG);
		requires(m_launcher);
	}

	// Called just before this Command runs the first time
	protected void initialize() 
	{
		m_logger.debug("LauncherOnCommand Initialized");
		m_launcher.setLauncher(true);
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() 
	{
		//rawZ is raw data from z axis on joystick. Range of rawZ: [-1,1]
		//double rawZ = m_launchStick.getAxis(AxisType.kZ);
		 
		//maps range of rawZ to units of setLauncherSpeed (RPM?)
		//double speed = Launcher.DEFAULT_SPEED + 0.25 * rawZ;
		double speed =  Launcher.DEFAULT_SPEED;
		m_launcher.setLauncherSpeed(speed);
		
		//m_logger.debug("rawZ = " + rawZ + ", speed = " + speed);
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() 
	{
		return false;
	}

	// Called once after isFinished returns true
	protected void end() 
	{

	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() 
	{
		m_logger.info("LauncherOnCommand.interrupted");
	}
}
