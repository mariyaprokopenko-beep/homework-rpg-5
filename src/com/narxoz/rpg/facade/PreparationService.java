package com.narxoz.rpg.facade;

import com.narxoz.rpg.decorator.AttackAction;
import com.narxoz.rpg.enemy.BossEnemy;
import com.narxoz.rpg.hero.HeroProfile;

public class PreparationService {
    public String prepare(HeroProfile hero, BossEnemy boss, AttackAction action) {
        if (hero == null || boss == null || action == null) {
            return "Preparation failed: Invalid inputs";
        }

        StringBuilder summary = new StringBuilder();
        summary.append("Preparation complete:\n");
        summary.append("  Hero: ").append(hero.getName()).append(" [HP: ").append(hero.getHealth()).append("]\n");
        summary.append("  Boss: ").append(boss.getName()).append(" [HP: ").append(boss.getHealth()).append("]\n");
        summary.append("  Action: ").append(action.getActionName()).append(" [DMG: ").append(action.getDamage()).append("]\n");
        summary.append("  Effects: ").append(action.getEffectSummary());

        return summary.toString();
    }
}