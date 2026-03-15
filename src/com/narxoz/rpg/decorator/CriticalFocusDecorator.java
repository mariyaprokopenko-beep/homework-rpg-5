package com.narxoz.rpg.decorator;

public class CriticalFocusDecorator extends ActionDecorator {
    public CriticalFocusDecorator(AttackAction wrappedAction) {
        super(wrappedAction);
    }

    @Override
    public String getActionName() {
        return getWrappedAction().getActionName() + " + Critical Focus";
    }

    @Override
    public int getDamage() {
        return (int)(getWrappedAction().getDamage() * 1.5);
    }

    @Override
    public String getEffectSummary() {
        return getWrappedAction().getEffectSummary() + " + 50% critical damage multiplier";
    }
}