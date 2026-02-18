package org.example.userDefineDSA.codingQuestions;

import java.util.Stack;

public class MinReversalToValidParanthesis {
    public int solution(String s){
        if(s.length()%2 != 0) return -1;
        Stack<Character> st = new Stack<Character>();
        for(Character ch : s.toCharArray()){
            if(ch=='{'){
                st.push('{');
            }else{
                if(!st.isEmpty() && st.peek()=='{'){
                    st.pop();
                }else{
                    st.push('}');
                }
            }
        }
        if(st.isEmpty()) return 0;
        int a =0;
        int b=0;
        while(!st.isEmpty()){
            if(st.pop()=='{'){
                a++;
            }else{
                b++;
            }
        }

        return (a+1)/2+(b+1)/2;
    }
}
