package com.narxoz.rpg;

import com.narxoz.rpg.decorator.AttackAction;
import com.narxoz.rpg.decorator.BasicAttack;
import com.narxoz.rpg.decorator.CriticalFocusDecorator;
import com.narxoz.rpg.decorator.FireRuneDecorator;
import com.narxoz.rpg.decorator.PoisonCoatingDecorator;
import com.narxoz.rpg.enemy.BossEnemy;
import com.narxoz.rpg.facade.AdventureResult;
import com.narxoz.rpg.facade.DungeonFacade;
import com.narxoz.rpg.hero.HeroProfile;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Homework 5 Demo: Decorator + Facade ===\n");

        HeroProfile hero = new HeroProfile("Arthas", 150);
        BossEnemy boss = new BossEnemy("Lich King", 200, 25);

        AttackAction basic = new BasicAttack("Strike", 15);

        AttackAction fireAttack = new FireRuneDecorator(basic);
        AttackAction poisonAttack = new PoisonCoatingDecorator(basic);
        AttackAction criticalAttack = new CriticalFocusDecorator(basic);

        AttackAction enhanced = new CriticalFocusDecorator(
                new FireRuneDecorator(
                        new PoisonCoatingDecorator(basic)));

        System.out.println("--- DECORATOR PATTERN DEMONSTRATION ---");
        System.out.println("1. Base attack:");
        System.out.println("   Name: " + basic.getActionName());
        System.out.println("   Damage: " + basic.getDamage());
        System.out.println("   Effects: " + basic.getEffectSummary());

        System.out.println("\n2. Single decorators:");
        System.out.println("   " + fireAttack.getActionName() + " | Damage: " + fireAttack.getDamage());
        System.out.println("   " + poisonAttack.getActionName() + " | Damage: " + poisonAttack.getDamage());
        System.out.println("   " + criticalAttack.getActionName() + " | Damage: " + criticalAttack.getDamage());

        System.out.println("\n3. Multiple decorators stacked (Poison + Fire + Critical):");
        System.out.println("   Name: " + enhanced.getActionName());
        System.out.println("   Damage: " + enhanced.getDamage());
        System.out.println("   Effects: " + enhanced.getEffectSummary());

        System.out.println("\n--- FACADE PATTERN DEMONSTRATION ---");
        System.out.println("Running dungeon through simplified facade interface...\n");

        DungeonFacade facade = new DungeonFacade().setRandomSeed(42L);
        AdventureResult result = facade.runAdventure(hero, boss, enhanced);

        System.out.println("\n=== ADVENTURE RESULT ===");
        System.out.println("Winner: " + result.getWinner());
        System.out.println("Rounds: " + result.getRounds());
        System.out.println("Reward: " + result.getReward());
        System.out.println("\nComplete Log:");
        for (String line : result.getLog()) {
            System.out.println(line);
        }

        System.out.println("\n=== Demo Complete ===");
    }
}