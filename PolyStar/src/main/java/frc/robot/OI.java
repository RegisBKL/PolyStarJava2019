/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

//import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.robot.commands.MecanumStopCommand;
import frc.robot.commands.SetServoAngleCommand;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
  //// CREATING BUTTONS
  // One type of button is a joystick button which is any button on a
  //// joystick.
  // You create one by telling it which joystick it's on and which button
  // number it is.
  private int DRIVER_PORT = 1;
  private XboxController stick ;
  private Button buttonA; 
  private Button buttonB; 
  private Button buttonX; 
  private Button buttonY; 
  public OI(){
  stick = new XboxController(DRIVER_PORT);
  buttonA = new JoystickButton(stick, 1);
  buttonB = new JoystickButton(stick, 2);
  buttonX = new JoystickButton(stick, 3);
  buttonY = new JoystickButton(stick, 4);

    //buttons commands
  buttonA.whenPressed(new MecanumStopCommand());
  buttonB.whenPressed(new SetServoAngleCommand(45));
  buttonX.whenPressed(new SetServoAngleCommand(0));
  buttonY.whenPressed(new SetServoAngleCommand(60));
  }
 
  public double getPiloteXaxis(){
    return stick.getRawAxis(4);
  }

  public double getPiloteYaxis(){
    return stick.getRawAxis(1);
  }

  public double getPiloteZaxis(){
    return stick.getRawAxis(0);
  }
  // There are a few additional built in buttons you can use. Additionally,
  // by subclassing Button you can create custom triggers and bind those to
  // commands the same as any other Button.

  //// TRIGGERING COMMANDS WITH BUTTONS
  // Once you have a button, it's trivial to bind it to a button in one of
  // three ways:

  // Start the command when the button is pressed and let it run the command
  // until it is finished as determined by it's isFinished method.
  // button.whenPressed(new ExampleCommand());

  // Run the command while the button is being held down and interrupt it once
  // the button is released.
  // button.whileHeld(new ExampleCommand());

  // Start the command when the button is released and let it run the command
  // until it is finished as determined by it's isFinished method.
  // button.whenReleased(new ExampleCommand());
}
