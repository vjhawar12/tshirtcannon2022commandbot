package frc.robot;

import frc.robot.commands.DriveForDistance;
import frc.robot.subsystems.DriveSubsystem;
import edu.wpi.first.wpilibj2.command.Command;

public class RobotContainer {
  private final DriveSubsystem driveSubsystem = new DriveSubsystem(); 
  private final DriveForDistance driveForDistance = new DriveForDistance(driveSubsystem);

  public RobotContainer() {
    configureButtonBindings();
  }

  private void configureButtonBindings() {}

  public Command getAutonomousCommand() {
    return driveForDistance;
  }
}
