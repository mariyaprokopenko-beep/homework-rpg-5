package com.narxoz.rpg.facade;

import com.narxoz.rpg.decorator.AttackAction;
import com.narxoz.rpg.enemy.BossEnemy;
import com.narxoz.rpg.hero.HeroProfile;
import java.util.Random;

public class BattleService {
    private Random random = new Random(1L);
    private static final int MAX_ROUNDS = 20;

    public BattleService setRandomSeed(long seed) {
        this.random = new Random(seed);
        return this;
    }

    public AdventureResult battle(HeroProfile hero, BossEnemy boss, AttackAction action) {
        AdventureResult result = new AdventureResult();
        int round = 0;

        result.addLine("=== BATTLE START ===");
        result.addLine(hero.getName() + " vs " + boss.getName());

        while (hero.isAlive() && boss.isAlive() && round < MAX_ROUNDS) {
            round++;
            result.addLine("\n--- ROUND " + round + " ---");

            int heroDamage = action.getDamage();
            boss.takeDamage(heroDamage);
            result.addLine(hero.getName() + " attacks with " + action.getActionName() +
                    " dealing " + heroDamage + " damage");
            result.addLine(boss.getName() + " HP: " + boss.getHealth());

            if (!boss.isAlive()) {
                result.addLine(boss.getName() + " has been defeated!");
                break;
            }

            int bossDamage = boss.getAttackPower();
            hero.takeDamage(bossDamage);
            result.addLine(boss.getName() + " attacks dealing " + bossDamage + " damage");
            result.addLine(hero.getName() + " HP: " + hero.getHealth());
        }

        result.setRounds(round);

        if (!hero.isAlive() && !boss.isAlive()) {
            result.setWinner("Draw");
            result.addLine("\nThe battle ended in a draw!");
        } else if (!hero.isAlive()) {
            result.setWinner(boss.getName());
            result.addLine("\n" + boss.getName() + " wins!");
        } else if (!boss.isAlive()) {
            result.setWinner(hero.getName());
            result.addLine("\n" + hero.getName() + " wins!");
        } else {
            result.setWinner("Max rounds reached");
            result.addLine("\nBattle reached maximum rounds without a winner");
        }

        return result;
    }
}