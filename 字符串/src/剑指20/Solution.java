package 剑指20;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        String str = "123";
        System.out.println(new Solution().isNumber(str));
    }

    public boolean isNumber(String s) {
        // 这个MAP 当前状态, 转移字符, 能转移到的状态
        Map<State, Map<Action, State>> transfer = new HashMap<State, Map<Action, State>>();

        transfer.put(State.STATE_0, new HashMap<Action, State>() {{
            put(Action.CHAR_SIGN, State.STATE_1);
            put(Action.CHAR_POINT, State.STATE_4);
            put(Action.CHAR_NUMBER, State.STATE_2);
        }});

        transfer.put(State.STATE_1, new HashMap<Action, State>() {{
            put(Action.CHAR_POINT, State.STATE_4);
            put(Action.CHAR_NUMBER, State.STATE_2);
        }});

        transfer.put(State.STATE_2, new HashMap<Action, State>() {{
            put(Action.CHAR_POINT, State.STATE_3);
            put(Action.CHAR_EXP, State.STATE_5);
            put(Action.CHAR_NUMBER, State.STATE_2);
        }});

        transfer.put(State.STATE_3, new HashMap<Action, State>() {{
            put(Action.CHAR_EXP, State.STATE_5);
            put(Action.CHAR_NUMBER, State.STATE_3);
        }});


        transfer.put(State.STATE_4, new HashMap<Action, State>() {{
            // put(Action.CHAR_EXP, State.STATE_5);
            put(Action.CHAR_NUMBER, State.STATE_3);
        }});
        transfer.put(State.STATE_5, new HashMap<Action, State>() {{
            put(Action.CHAR_SIGN, State.STATE_6);
            put(Action.CHAR_NUMBER, State.STATE_7);
        }});

        transfer.put(State.STATE_6, new HashMap<Action, State>() {{
            put(Action.CHAR_NUMBER, State.STATE_7);
        }});

        transfer.put(State.STATE_7, new HashMap<Action, State>() {{
            put(Action.CHAR_NUMBER, State.STATE_7);
        }});


        s = s.trim();
        int length = s.length();
        State state = State.STATE_0;

        for (int i = 0; i < length; i++) {
            Action type = toCharType(s.charAt(i));
            if (!transfer.get(state).containsKey(type)) {
                return false;
            } else {
                state = transfer.get(state).get(type);
            }
        }
        return state == State.STATE_2 || state == State.STATE_3 || state == State.STATE_7;
    }

    public Action toCharType(char ch) {
        if (ch >= '0' && ch <= '9') {
            return Action.CHAR_NUMBER;
        } else if (ch == 'e' || ch == 'E') {
            return Action.CHAR_EXP;
        } else if (ch == '.') {
            return Action.CHAR_POINT;
        } else if (ch == '+' || ch == '-') {
            return Action.CHAR_SIGN;
        } else {
            return Action.CHAR_ILLEGAL;
        }
    }
    enum State {
        STATE_0,
        STATE_1,
        STATE_2,
        STATE_3,
        STATE_4,
        STATE_5,
        STATE_6,
        STATE_7
    }
    // 动作
    enum Action {
        CHAR_NUMBER,
        CHAR_SIGN,
        CHAR_EXP,
        CHAR_POINT,
        CHAR_ILLEGAL
    }
}
