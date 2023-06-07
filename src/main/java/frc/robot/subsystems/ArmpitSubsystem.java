package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ArmpitSubsystem extends SubsystemBase {
  private final WPI_TalonFX armpit1;


  public ArmpitSubsystem() {
    armpit1 = new WPI_TalonFX(5);
  }

  public void move(XboxController controller) {
    double speed = 0.0;

    // Check if the right trigger is pressed
    if (controller.getRawAxis(XboxController.Axis.kRightTrigger.value) > 0.1) {
        // Spin the motor in one direction
        speed = 0.5; // Adjust the speed value as needed
    }
    // Check if the left trigger is pressed
    else if (controller.getRawAxis(XboxController.Axis.kLeftTrigger.value) > 0.1) {
        // Spin the motor in the other direction
        speed = -0.5; // Adjust the speed value as needed
    }

    // Set the motor speed
    armpit1.set(ControlMode.PercentOutput, speed);
}

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
