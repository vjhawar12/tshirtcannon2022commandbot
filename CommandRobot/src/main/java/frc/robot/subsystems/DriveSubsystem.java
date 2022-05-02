// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.interfaces.Gyro;
import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.motorcontrol.PWMTalonSRX;
import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import frc.robot.Constants; 
import edu.wpi.first.math.filter.MedianFilter;


public class DriveSubsystem extends SubsystemBase {
  private PWMTalonSRX backleftmotor; 
  private PWMTalonSRX backrightmotor; 
  private PWMTalonSRX frontleftmotor;
  private PWMTalonSRX frontrightmotor; 

  private MotorControllerGroup right; 
  private MotorControllerGroup left; 

  public DifferentialDrive drive; 

  private Encoder leftEncoder; 
  private Encoder rightEncoder; 

  private Gyro gyro; 


  public final MedianFilter mFilter = new MedianFilter(Constants.medianFilterSamples); 
  public final AnalogInput aInput = new AnalogInput(Constants.kUltrasonicPort); 

  public void initMotors() {
    right = new MotorControllerGroup(backrightmotor, frontrightmotor); 
    left = new MotorControllerGroup(backleftmotor, frontleftmotor); 
    drive = new DifferentialDrive(right, left); 
    right.setInverted(true); 
    left.setInverted(false);
  }

  public void initGyro() {
    leftEncoder = new Encoder(Constants.leftEncoderSourceA, Constants.leftEncoderSourceB); 
    rightEncoder = new Encoder(Constants.rightEncoderSourceA, Constants.rightEncoderSourceB); 
    leftEncoder.setDistancePerPulse(Constants.leftEncoderDistancePerPulse);
    rightEncoder.setDistancePerPulse(Constants.rightEncoderDistancePerPulse);
    gyro = new ADXRS450_Gyro(); 
  }

  public DriveSubsystem() {
    initMotors();
    initGyro();
  }

  public void drive(double fwdMove, double rot) {
    drive.arcadeDrive(fwdMove, rot);
  }

  public void stop() {
    drive.stopMotor();
  }

  public void resetEncoders() {
    leftEncoder.reset(); 
    rightEncoder.reset(); 
  }

  public double getEncoderDistance() {
    return (leftEncoder.getDistance() + rightEncoder.getDistance()) * 0.5; 
  }

  public void resetGyro() {
    gyro.reset(); 
  }

  public double getHeading() {
    return Math.IEEEremainder(gyro.getAngle(), 360) * (Constants.gyroReversed ? -1.0 : 1.0);
  }

  @Override
  public void periodic() {
  }

  @Override
  public void simulationPeriodic() {
  }
}
 