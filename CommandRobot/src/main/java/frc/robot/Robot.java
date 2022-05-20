package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
<<<<<<< HEAD
import edu.wpi.first.wpilibj.Joystick; 
=======
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.motorcontrol.PWMTalonSRX;
import frc.robot.*;

>>>>>>> 935453517278f373f962bfebbb5fb4c9dbf99534

public class Robot extends TimedRobot {
  private Command autoCommand;
  private RobotContainer m_robotContainer;
  private Joystick joystick; 

  public DifferentialDrive differentialDrive;
  public Joystick rightJoystick, lefJoystick;

  private PWMTalonSRX frontTalonLeft = new PWMTalonSRX(Constants.frontLeftMotorPort); 
  private PWMTalonSRX frontTalonRight = new PWMTalonSRX(Constants.frontRightMotorPort); 
  private PWMTalonSRX backTalonRight = new PWMTalonSRX(Constants.backRightMotorPort); 
  private PWMTalonSRX backTalonLeft = new PWMTalonSRX(Constants.backLeftMotorPort); 

  @Override
  public void robotInit() {
    m_robotContainer = new RobotContainer();
    differentialDrive = new DifferentialDrive(Constants.leftMotor, Constants.rightMotor);
  }

  @Override
  public void robotPeriodic() {
    CommandScheduler.getInstance().run();
  }

  @Override
  public void disabledInit() {}

  @Override
  public void disabledPeriodic() {}

  @Override
  public void autonomousInit() {
    autoCommand = m_robotContainer.getAutonomousCommand();
    if (autoCommand != null) {
      autoCommand.schedule();
    }
  }

  @Override
  public void autonomousPeriodic() {}

  @Override
  public void teleopInit() {
    if (autoCommand != null) {
      autoCommand.cancel();
    }
  }

  @Override
  public void teleopPeriodic() {
    
  }

}
