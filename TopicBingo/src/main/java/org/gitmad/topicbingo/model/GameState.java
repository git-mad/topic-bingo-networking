package org.gitmad.topicbingo.model;

/**
 * Created by thedekel on 3/9/14.
 */
public class GameState {

    private Integer score;

    public Boolean getWonState() {
        return wonState;
    }

    private Boolean wonState;

    public GameState() {
        this.score = 0;
        this.wonState = false;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
        if (this.score == 5) {
            this.wonState = true;
        }
    }

}
