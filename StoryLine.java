public class StoryLine {
    String who;
    int timetaken;

    //always pass the latter Member 2nd so we know he has the slower time
    public void addToStoryLine(Member obj1, Member obj2){
        if(obj2==null){
            timetaken += obj1.time;
            String str = "\n"+obj1.name+ " goes back with the torch(" + timetaken +")";
            who = who.concat(str);
        }
        else{
            timetaken += obj2.time;
            String str = "\n"+obj1.name+ " & " + obj2.name +" cross with the torch(" + timetaken +")";
            who = who.concat(str);
        }
    }




}
