package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import frc.robot.subsystems.ArmpitSubsystem;
import frc.robot.subsystems.DrivetrainSubsystem;

public class RobotContainer {
    private final DrivetrainSubsystem DTS;
    private final XboxController DTC;
    private final ArmpitSubsystem AP;

    public RobotContainer() {
        DTS = new DrivetrainSubsystem();
        DTC = new XboxController(0);
        AP = new ArmpitSubsystem();

        configureButtonBindings();
        configureDefaultCommands();
    }

    private void configureButtonBindings() {
        // Define button bindings and commands here
    }

    private void configureDefaultCommands() {
        // Set default commands here
    }

    public Command getAutonomousCommand() {
        // Create and return your autonomous command here
        return null;
    }

    public void teleopInit() {
        // Cancel any running commands and set the default commands for teleop
        CommandScheduler.getInstance().cancelAll();
        // Add any necessary default commands
    }

    public void teleopPeriodic() {
        DTS.driveWithXboxController();
        AP.move(DTC);
    }

    public void autonomousInit() {
        // Cancel any running commands and set the default commands for autonomous
        CommandScheduler.getInstance().cancelAll();
        Command autonomousCommand = getAutonomousCommand();
        if (autonomousCommand != null) {
            autonomousCommand.schedule();
        }
    }
}
