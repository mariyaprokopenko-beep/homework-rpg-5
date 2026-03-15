package com.narxoz.rpg.decorator;

public class FireRuneDecorator extends ActionDecorator {
    public FireRuneDecorator(AttackAction wrappedAction) {
        super(wrappedAction);
    }

    @Override
    public String getActionName() {
        return getWrappedAction().getActionName() + " + Fire Rune";
    }

    @Override
    public int getDamage() {
        return getWrappedAction().getDamage() + 8;
    }

    @Override
    public String getEffectSummary() {
        return getWrappedAction().getEffectSummary() + " + Burns enemy (8 bonus fire damage)";
    }
}