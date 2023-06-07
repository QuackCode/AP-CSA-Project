package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DrivetrainSubsystem extends SubsystemBase {
    private final WPI_TalonFX leftMotor1;
    private final WPI_TalonFX leftMotor2;
    private final WPI_TalonFX rightMotor1;
    private final WPI_TalonFX rightMotor2;
    private final DifferentialDrive drive;  

    private final XboxController driverController;

    public DrivetrainSubsystem() {
        // Initialize the Falcon motor controllers for the left and right sides
        // Replace the port numbers with the appropriate CAN IDs
        leftMotor1 = new WPI_TalonFX(1);
        leftMotor2 = new WPI_TalonFX(2);
        rightMotor1 = new WPI_TalonFX(3);
        rightMotor2 = new WPI_TalonFX(4);

        // Invert the right motors if necessary
        rightMotor1.setInverted(true);
        rightMotor2.setInverted(true);

        // Create the DifferentialDrive object with the left and right motor controllers
        drive = new DifferentialDrive(leftMotor1, rightMotor1);

        // Initialize the XboxController
        // Replace "0" with the appropriate port number
        driverController = new XboxController(0);

        // Set the follower mode for the second motors on each side
        leftMotor2.follow(leftMotor1);
        rightMotor2.follow(rightMotor1);
    }

    public void driveWithXboxController() {
        // Get the joystick values from the controller
        double forward = -driverController.getRawAxis(1); // Negative sign to invert the forward direction
        double rotation = driverController.getRawAxis(4);

        // Pass the joystick values to the drivetrain for arcade drive
        drive.arcadeDrive(forward, rotation);
    }

    public void stop() {
        // Stop the drivetrain
        drive.stopMotor();
    }
}
