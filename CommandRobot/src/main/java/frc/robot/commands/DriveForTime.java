package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveSubsystem;
import edu.wpi.first.wpilibj.Timer; 

public class DriveForTime extends CommandBase {
    private final DriveSubsystem driveSubsystem = new DriveSubsystem();
    private Timer timer; 

    public DriveForTime(DriveSubsystem driveSubsystem) {
        timer = new Timer(); 
    }
    
    @Override
    public void initialize() {
        timer.reset(); 
    }
  
    @Override
    public void execute() {
        if (timer.get() < 5.0) {
            driveSubsystem.drive(1, 0);
        } else {
            driveSubsystem.stop();
        }
    }
  
    @Override
    public void end(boolean interrupted) {}
  
    @Override
    public boolean isFinished() {
        return timer.get() < 5.0? true : false;
    }
}
 