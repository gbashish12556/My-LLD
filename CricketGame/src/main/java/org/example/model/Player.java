package org.example.model;

public class Player {



    private PlayerStatus playerStatus;

    private Integer fours = 0;

    private Integer sixes = 0;


    private Integer threes = 0;

    private Integer ones = 0  ;

    private Integer twos = 0;

    private Player dismissedBy = null;

    private String name;

    private Integer playerNo;

    private Integer score = 0;

    public Integer getBallsFace() {
        return ballsFace;
    }

    private Integer ballsFace = 0;

    Player(Integer playerNo, String name){

        this.playerNo = playerNo;
        this.name = name;
        this.playerStatus = PlayerStatus.YET_TO_PLAY;

    }
    public void setPlayerStatus(PlayerStatus playerStatus) {
        this.playerStatus = playerStatus;
    }

    public Integer getPlayerNo() {
        return playerNo;
    }


    public String getName() {
        return name;
    }

    public Integer getScore() {
        return score;
    }

    public PlayerStatus getPlayerStatus() {
        return playerStatus;
    }

    public Integer getFours() {
        return fours;
    }

    public Integer getSixes() {
        return sixes;
    }

    public Integer getThrees() {
        return threes;
    }

    public Integer getOnes() {
        return ones;
    }

    public Integer getTwos() {
        return twos;
    }

    public Player getDismissedBy() {
        return dismissedBy;
    }



    public void additionalRun(Integer integer){
        score += integer;

    }
    public void increaseScore(Integer integer){

        switch (integer){

            case 6:
                sixes++;
                break;
            case 4:
                fours++;
                break;
            case 3:
                threes++;
                break;
            case 2:
                twos++;
                break;
            case 1:
                ones++;
                break;

        }

        score += integer;
        ballsFace++;


    }

    void playerDismissed(Player player){

        playerStatus   = PlayerStatus.OUT;
        dismissedBy = player;

    }
}
