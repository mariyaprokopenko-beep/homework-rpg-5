package com.narxoz.rpg.facade;

public class RewardService {
    public String determineReward(AdventureResult battleResult) {
        if (battleResult == null) {
            return "No reward - invalid battle result";
        }

        String winner = battleResult.getWinner();
        int rounds = battleResult.getRounds();

        if (winner.equals("Draw")) {
            return "Participation reward: 50 gold";
        } else if (winner.contains("Arthas")) {
            if (rounds < 5) {
                return "Epic victory! Reward: 500 gold + Legendary item";
            } else if (rounds < 10) {
                return "Victory! Reward: 300 gold + Rare item";
            } else {
                return "Hard-fought victory! Reward: 200 gold + Common item";
            }
        } else {
            return "Defeat reward: 50 gold";
        }
    }
}
