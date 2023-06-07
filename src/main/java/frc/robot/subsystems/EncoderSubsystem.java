package frc.robot.subsystems;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class EncoderSubsystem extends SubsystemBase {
    private final Encoder encoder;

    public EncoderSubsystem(int channelA, int channelB) {
        // Create an instance of the Encoder class
        // Specify the channel numbers for the encoder's A and B signals
        encoder = new Encoder(channelA, channelB);

        // Set the distance per pulse of the encoder (optional)
        // Replace 0.0 with the appropriate distance per pulse value
        encoder.setDistancePerPulse(0.0);
    }

    public double getDistance() {
        // Get the distance traveled by the encoder
        return encoder.getDistance();
    }

    public int getRaw() {
        // Get the raw count of the encoder
        return encoder.getRaw();
    }

    public void reset() {
        // Reset the encoder count to zero
        encoder.reset();
    }

    @Override
    public void periodic() {
        // This method will be called once per scheduler run
        // You can perform periodic updates or checks here
    }
}
