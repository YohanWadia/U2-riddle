import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class U2 {

    public static void main(String[] args) {

        Member obj0 = new Member(1,"Bono");
        Member obj1 = new Member(2,"Edge");
        Member obj2 = new Member(5,"Adam");
        Member obj3 = new Member(10,"Larry");
        StoryLine story = new StoryLine();






        for(int i=0; i<3; i++){
            for(int j=i+1; j<4; j++){
                Member[] arrTop = {obj0,obj1,obj2,obj3};
                Member[] arrBottom = new Member[4];
                story.timetaken=0; story.who="";
                U2.status(arrBottom,arrTop,"#1 ===============",j);

                arrBottom[i] = arrTop[i];
                arrBottom[j] = arrTop[j];
                story.addToStoryLine(arrTop[i],arrBottom[j]);
                arrTop[i] = null;
                arrTop[j] = null;
                U2.status(arrBottom,arrTop,"#1 -x-x-x-x-x-x-x- ",j);
                Member[] statefor2Top = Arrays.copyOf(arrTop,4);
                Member[] statefor2Bot = Arrays.copyOf(arrBottom,4);
                String statefor2who = story.who;
                int statefor2time = story.timetaken;

                for(int k=0; k<4; k++){
                    arrTop = Arrays.copyOf(statefor2Top,4);
                    arrBottom = Arrays.copyOf(statefor2Bot,4);
                    story.who = statefor2who;
                    story.timetaken = statefor2time;
                    U2.status(arrBottom,arrTop,"#2 ===============",k);

                    if(arrBottom[k]==null){continue;}
                    arrTop[k] = arrBottom[k];
                    story.addToStoryLine(arrBottom[k],null);
                    arrBottom[k] = null;
                    U2.status(arrBottom,arrTop,"#2 -x-x-x-x-x-x-x- ", k);
                    Member[] statefor3Top = Arrays.copyOf(arrTop,4);
                    Member[] statefor3Bot = Arrays.copyOf(arrBottom,4);
                    String statefor3who = story.who;
                    int statefor3time = story.timetaken;

                    for(int l=0; l<3; l++) {
                        arrTop = Arrays.copyOf(statefor3Top,4);
                        arrBottom = Arrays.copyOf(statefor3Bot,4);
                        if(arrTop[l]==null){continue;}
                        for (int m = l + 1; m < 4; m++) {
                            arrTop = Arrays.copyOf(statefor3Top,4);
                            arrBottom = Arrays.copyOf(statefor3Bot,4);
                            story.who = statefor3who;
                            story.timetaken = statefor3time;
                            //System.out.printf("%d,%d",l,m);
                            U2.status(arrBottom,arrTop,"#3 ===============",m);


                            if(arrTop[m]==null){continue;}
                            arrBottom[l] = arrTop[l];
                            arrBottom[m] = arrTop[m];
                            story.addToStoryLine(arrTop[l],arrBottom[m]);
                            arrTop[l] = null;
                            arrTop[m] = null;
                            U2.status(arrBottom, arrTop, "#3 -x-x-x-x-x-x-x- ",m);
                            Member[] statefor4Top = Arrays.copyOf(arrTop,4);
                            Member[] statefor4Bot = Arrays.copyOf(arrBottom,4);
                            String statefor4who = story.who;
                            int statefor4time = story.timetaken;

                            for(int n=0; n<4; n++) {
                                arrTop = Arrays.copyOf(statefor4Top,4);
                                arrBottom = Arrays.copyOf(statefor4Bot,4);
                                story.who = statefor4who;
                                story.timetaken = statefor4time;
                                U2.status(arrBottom,arrTop,"#4 ===============",n);

                                if(arrBottom[n]==null){continue;}
                                arrTop[n] = arrBottom[n];
                                story.addToStoryLine(arrBottom[n],null);
                                arrBottom[n] = null;
                                U2.status(arrBottom, arrTop, "#4 -x-x-x-x-x-x-x- ",n);
                                List<Member> last = new ArrayList<>();
                                for(int o=0; o<4; o++) {
                                    if(arrTop[o]==null){continue;}
                                    arrBottom[o] = arrTop[o];
                                    arrTop[o] = null;
                                    System.out.println("#5 Moving "+arrBottom[o].name+" to bottom @" + o);
                                    last.add(arrBottom[o]);

                                    //xxxxxxxxxxxxxxxxxxxxxxxthe ending
                                    if(last.size()==2) {
                                        U2.status(arrBottom, arrTop, "#5 -x-x-x-x-x-x-x- ",o);
                                        story.addToStoryLine(last.get(0),last.get(1));
                                        System.out.println(story.who +" => " + story.timetaken);
                                        System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
                                        break;
                                    }
                                }//o
                            }//n
                        }//m
                    }//l

                }//k
            }//j
        }//i





    }

    private static void status(Member[] arrBottom, Member[] arrTop, String position,int loopCnt) {
        if(position.charAt(position.length()-1)=='='){
            System.out.println(position);
        }

        String str="";
        for (Member obj : arrTop){
            str = (obj==null)? str.concat("-|") : str.concat(obj.name+"|");
        }
        System.out.println(str);

        str="";
        for (Member obj : arrBottom){
            str = (obj==null)? str.concat("-|") : str.concat(obj.name+"|");
        }
        System.out.println(str);

        if(position.charAt(position.length()-1)=='='){
            System.out.println("--------------- " + loopCnt);
        }
        else {
            System.out.println(position);
            System.out.println();
        }
    }

}
