package scoring;

public class GameResults {
    
    private long runningTime_; // In milliseconds
    private boolean isWin_; 
    
    public GameResults(long runningTime, boolean isWin) {
        this.runningTime_ = runningTime;
        this.isWin_ = isWin;
    }
    
    public long getRunningTime() {
        return runningTime_;
    }
    
    public boolean isWin() {
        return isWin_;
    }
    
    public String toString() {
        return (this.isWin_ ? "Won" : "Lost") + " in " + this.runningTime_ + " milliseconds."; // TODO localize
    }

}
