package edu.iu.habahram.GumballMachine.model;

public class SoldState implements IState{
    IGumballMachine gumballMachine;
    public SoldState(IGumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }
    @Override
    public TransitionResult insertQuarter() {
        gumballMachine.changeTheStateTo(GumballMachineState.HAS_QUARTER);
        String message = "Already Sold you a Gumball";
        boolean succeeded = false;
        int count = gumballMachine.getCount();
        return new TransitionResult(succeeded, message, gumballMachine.getTheStateName(), count);
    }
    @Override
    public TransitionResult ejectQuarter() {
        String message = "No Quarter to eject";
        boolean succeeded = false;
        return new TransitionResult(succeeded, message, gumballMachine.getTheStateName(), gumballMachine.getCount());
    }
    @Override
    public TransitionResult turnCrank() {
        String message = "You turned the crank, but no quarter";
        boolean succeeded = false;
        return new TransitionResult(succeeded, message, gumballMachine.getTheStateName(), gumballMachine.getCount());
    }
    @Override
    public TransitionResult dispense() {
        String message = "Already Sold";
        boolean succeeded = false;
        return new TransitionResult(succeeded, message, gumballMachine.getTheStateName(), gumballMachine.getCount());

    }
    @Override
    public String getTheName() {
        return GumballMachineState.NO_QUARTER.name();
    }
}
