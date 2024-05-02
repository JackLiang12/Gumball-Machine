package edu.iu.habahram.GumballMachine.model;

public record TransitionRequest(String id, Integer count) {
    public TransitionRequest(String id) {
        this(id, null);
    }

}
