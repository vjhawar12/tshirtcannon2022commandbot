package frc.robot;

import frc.robot.commands.DriveForDistance;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.commands.DriveForTime;
import edu.wpi.first.wpilibj2.command.Command;

public class RobotContainer {
  private final DriveSubsystem driveSubsystem = new DriveSubsystem(); 
  @SuppressWarnings({"unused"})
  private final DriveForDistance driveForDistance = new DriveForDistance(driveSubsystem);
  private final DriveForTime driveForTime = new DriveForTime(driveSubsystem); 

  public RobotContainer() {
    configureButtonBindings();
  }

  private void configureButtonBindings() {}

  public Command getAutonomousCommand() {
    return driveForTime;
  }

}
