public class Data {
    public static boolean isPlay=true,isPause=false,isMenu=false,isEnd=false;

    public static int score = 0;

    public static int getScore(){return score;}
    public static void setScore(int a){score = a;}
    public static void increaseScore(Tile other){
        score += other.getHp()*10;
    }

    public static String getScoreString(){return Integer.toString(score);}

    public static boolean isPlay(){return isPlay;}
    public static boolean isPause(){return isPause;}
    public static boolean isMenu(){return isMenu;}
    public static boolean isEnd(){return isEnd;}

    public static void togglePause() {
        if (isPause) {
            isPause = false;
            isPlay = true;
        }else{
            isPause = true;
            isPlay = false;
        }
    }

    public static void toggleMenu(){
        if(isMenu){
            isMenu=false;
            isPause=false;
            isPlay=true;
        }else{
            isMenu=true;
            isPlay=false;
            isPause=false;
        }
    }

    public static void toggleEnd(){
        if(isEnd){
            isEnd=false;
            isMenu=true;
            isPlay=false;
        }else{
            isEnd=true;
            isPlay=false;
        }
    }

}
