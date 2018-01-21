package org.usfirst.frc.team4183.robot.subsystems;

import org.usfirst.frc.team4183.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Subsystem;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;


public class ElevatorSubSystem extends BitBucketsSubsystem {

	private final WPI_TalonSRX elevatorMotorA;
	
	private final WPI_TalonSRX elevatorMotorB;
	
	
	
	
	public ElevatorSubSystem()
	{
		elevatorMotorA = new WPI_TalonSRX(RobotMap.ELEVATOR_MOTOR_A_ID);
		elevatorMotorB = new WPI_TalonSRX(RobotMap.ELEVATOR_MOTOR_B_ID);	
		
		setAllMotorsZero();
	}
	
	public void disable()
	{
		setAllMotorsZero();
	}
	
	public int inchesToTicks(double inches)
	{
		return (int) (inches/RobotMap.INCH_EXTENSION_ROT);
	}
	
	public void goToPosition(int ticks)
	{
		elevatorMotorA.set(ControlMode.Position, ticks);
		if (elevatorMotorB.getControlMode() != ControlMode.Follower)
		{
			elevatorMotorB.set(ControlMode.Follower,RobotMap.ELEVATOR_MOTOR_A_ID);
		}
	}
	
	public void setAllMotorsZero()
	{
		elevatorMotorA.set(ControlMode.PercentOutput,0);
		elevatorMotorA.set(ControlMode.Follower,RobotMap.ELEVATOR_MOTOR_A_ID);
	}
	
	public void setSystemPower(double power)
	{
		elevatorMotorA.set(ControlMode.PercentOutput,power);
		if (elevatorMotorB.getControlMode() != ControlMode.Follower)
		{
			elevatorMotorB.set(ControlMode.Follower,RobotMap.ELEVATOR_MOTOR_A_ID);
		}
	}



	@Override
	public void diagnosticsCheck() {
		// TODO Auto-generated method stub
	}

	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void diagnosticsInit() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void diagnosticsFlagSet() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void periodic() {
		// TODO Auto-generated method stub
		
	}
	
	
}