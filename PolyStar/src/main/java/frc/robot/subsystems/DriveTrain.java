/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.RobotMap;
import frc.robot.commands.ArcadeDriveCommand;

/**
 * An example subsystem.  You can replace me with your own Subsystem.
 */
public class DriveTrain extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  private static SpeedController driveRightFront, driveLeftFront, driveRightBack, driveLeftBack; 
  private static SpeedControllerGroup left, right;
  private static DifferentialDrive drivetrain;
  

  public DriveTrain(){
    driveRightFront = new Talon(RobotMap.rightfrontMotor); 
    driveRightBack  = new Talon(RobotMap.rightbackMotor);
    right = new SpeedControllerGroup(driveRightFront, driveRightBack);
    //right.setInverted(false);

    driveLeftFront  = new Talon(RobotMap.leftfrontMotor);
    driveLeftBack   = new Talon(RobotMap.rightbackMotor);
    left = new SpeedControllerGroup(driveLeftFront, driveLeftBack);
    // left.setInverted(false);

    drivetrain = new DifferentialDrive(left, right);
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
     setDefaultCommand(new ArcadeDriveCommand());
  }

  public void arcadeDrive(double yaxis, double xaxis){
    drivetrain.arcadeDrive(yaxis, xaxis);
  }

  public void stop(){
    drivetrain.arcadeDrive(0, 0);
  }
}
