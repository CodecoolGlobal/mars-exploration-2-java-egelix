package com.codecool.marsexploration.logic.phase;

import com.codecool.marsexploration.data.Context;

public class StepIncrement implements Phase{
    @Override
    public void perform(Context context) {
        int current = context.getStepNumber();
        int next = current + 1;
        context.setStepNumber(next);
    }
}
