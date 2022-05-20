package frc.robot.commands;

import frc.robot.Constants;
import frc.robot.subsystems.DriveSubsystem;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class DriveForDistance extends CommandBase {
  private final DriveSubsystem driveSubsystem;
  private double distance; 

  public DriveForDistance(DriveSubsystem subsystem) {
    driveSubsystem = subsystem;
    addRequirements(subsystem);
    distance = Constants.holdDistance; 
  }

  public DriveForDistance(DriveSubsystem subsystem, double _distance) {
    driveSubsystem = subsystem;
    addRequirements(subsystem);
    distance = _distance; 
  }

  @Override
  public void initialize() {}

  @Override
  public void execute() {
    double currentDistance = driveSubsystem.mFilter.calculate(
      driveSubsystem.aInput.getValue()
    ) * Constants.toInches; 
    double currentSpeed = (distance - currentDistance) * Constants.speedConstant;
    driveSubsystem.drive(currentSpeed, 0);
  }

  @Override
  public void end(boolean interrupted) {}

  @Override
  public boolean isFinished() {
    return false;
  }
}
