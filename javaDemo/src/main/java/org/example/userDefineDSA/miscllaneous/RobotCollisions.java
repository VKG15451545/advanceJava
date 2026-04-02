package org.example.userDefineDSA.miscllaneous;

import java.util.*;

public class RobotCollisions {
    public List<Integer> solution(int[] healths, int[] positions, String directions){
        TreeMap<Integer,Robot> map = new TreeMap<>();
        int n = healths.length;
        for(int i=0;i<n;i++){
            map.put(positions[i],new Robot(healths[i],directions.charAt(i)));
        }
        Stack<Integer> s = new Stack<>();
        for(Map.Entry<Integer,Robot> robot : map.entrySet()){
            if(s.isEmpty() || robot.getValue().position == 1){
                s.push(robot.getKey());continue;
            }
            while (!s.isEmpty() && map.get(s.peek()).position == 1 && robot.getValue().health>0) {
                Robot top = map.get(s.peek());
                if(top.health < robot.getValue().health){
                    s.pop();
                    robot.getValue().health--;
                }else if(top.health > robot.getValue().health){
                    top.health--;
                    robot.getValue().health =0;
                }else{
                    s.pop();
                    robot.getValue().health =0;
                }
                if(robot.getValue().health > 0){
                    s.push(robot.getKey());
                }
            }

        }
        List<Integer> res = new ArrayList<>();
        while (!s.isEmpty()){
            res.add(map.get(s.pop()).health);
        }
        return res;
    }
    class  Robot {
        int health;
        int position;

        public Robot(int d, char ch) {
            this.health = d;
            this.position = ch == 'R' ? 1 : 0;
        }
    }
}
