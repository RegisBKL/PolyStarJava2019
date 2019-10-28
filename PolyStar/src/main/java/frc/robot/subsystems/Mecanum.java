/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.SpeedController;
//import edu.wpi.first.wpilibj.Talon;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.MecanumDrive;
import frc.robot.RobotMap;
import frc.robot.commands.MecanumDriveCommand;

/**
 * An example subsystem.  You can replace me with your own Subsystem.
 */
public class Mecanum extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  private static SpeedController driveRightFront, driveLeftFront, driveRightBack, driveLeftBack; 
  
  private static MecanumDrive mecanumdrive;
  
  

  public Mecanum(){
    driveRightFront = new WPI_TalonSRX(RobotMap.rightfrontMotor); 
    driveRightBack  = new WPI_TalonSRX(RobotMap.rightbackMotor);
    
    //right.setInverted(false);

    driveLeftFront  = new WPI_TalonSRX(RobotMap.leftfrontMotor);
    driveLeftBack   = new WPI_TalonSRX(RobotMap.leftbackMotor);
    
    // left.setInverted(false);
    mecanumdrive = new MecanumDrive(driveLeftFront, driveLeftBack, driveRightFront, driveRightBack);
    
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
     setDefaultCommand(new MecanumDriveCommand());
  }

  public void driveCartesian(double yaxis, double xaxis, double zaxis){
    mecanumdrive.driveCartesian(yaxis, xaxis, zaxis);
  }

  public void stop(){
    mecanumdrive.driveCartesian(0, 0, 0); 
  }
}
