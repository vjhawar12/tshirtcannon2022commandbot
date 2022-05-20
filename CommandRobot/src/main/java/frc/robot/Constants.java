// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.DigitalSource;

public final class Constants {
    public static final double rightEncoderDistancePerPulse = 1.0; 
    public static final double leftEncoderDistancePerPulse = 2.0; 
    public static DigitalSource leftEncoderSourceA; 
    public static DigitalSource rightEncoderSourceA; 
    public static DigitalSource leftEncoderSourceB; 
    public static DigitalSource rightEncoderSourceB;
    public static final boolean gyroReversed = false; 
    public static final double holdDistance = 12.0; 
    public static final double toInches = 0.125; 
    public static final double speedConstant = 0.05; 
    public static final int kLeftMotorPort = 0;
    public static final int kRightMotorPort = 1;
    public static final int kUltrasonicPort = 0;
    public static final int medianFilterSamples = 10;
   
    public static final int frontLeftMotorPort = 1; 
    public static final int frontRightMotorPort = 2; 
    public static final int backLeftMotorPort = 3; 
    public static final int backRightMotorPort = 4; 
    public static final int rightJoystickPort = 5;
    public static final int leftJoystickPort = 6;  
}


