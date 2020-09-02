package cn.codexin.questions;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by xinGao 2020/9/2
 */

public class QSword0020_JudgeStringIsNumber {
    enum State {
        BEGIN,
        INT_SIGN,
        INT,
        POINT_WITH_LEFT_INT,
        POINT_WITHOUT_LEFT_INT,
        FRACTION,
        EXP,
        EXP_SIGN,
        EXP_INT,
        END;
    }

    enum CharType {
        SPACE,
        NUMBER,
        POINT,
        EXP,
        SIGN,
        ILLEGAL;
    }

    public CharType toCharType(char c) {
        if(c >= '0' && c <= '9') {
            return CharType.NUMBER;
        }
        if(c == 'e' || c == 'E') {
            return CharType.EXP;
        }
        if(c == '+' || c == '-') {
            return CharType.SIGN;
        }
        if(c == ' ') {
            return CharType.SPACE;
        }
        if(c == '.') {
            return CharType.POINT;
        }
        return CharType.ILLEGAL;
    }

    public boolean isNumber(String s) {
        Map<State, Map<CharType, State>> transfer = new HashMap<>();

        Map<CharType, State> initialMap = new HashMap<CharType, State>() {{
            put(CharType.SPACE, State.BEGIN);
            put(CharType.SIGN, State.INT_SIGN);
            put(CharType.NUMBER, State.INT);
            put(CharType.POINT, State.POINT_WITHOUT_LEFT_INT);
        }};
        transfer.put(State.BEGIN, initialMap);

        Map<CharType, State> intSignMap = new HashMap<CharType, State>() {{
            put(CharType.NUMBER, State.INT);
            put(CharType.POINT, State.POINT_WITHOUT_LEFT_INT);
        }};
        transfer.put(State.INT_SIGN, intSignMap);

        Map<CharType, State> intMap = new HashMap<CharType, State>() {{
            put(CharType.NUMBER, State.INT);
            put(CharType.POINT, State.POINT_WITH_LEFT_INT);
            put(CharType.EXP, State.EXP);
            put(CharType.SPACE, State.END);
        }};
        transfer.put(State.INT, intMap);

        Map<CharType, State> pointWithoutLeftIntMap = new HashMap<CharType, State>() {{
            put(CharType.NUMBER, State.FRACTION);
        }};
        transfer.put(State.POINT_WITHOUT_LEFT_INT, pointWithoutLeftIntMap);

        Map<CharType, State> pointWithLeftIntMap = new HashMap<CharType, State>() {{
            put(CharType.NUMBER, State.FRACTION);
            put(CharType.EXP, State.EXP);
            put(CharType.SPACE, State.END);
        }};
        transfer.put(State.POINT_WITH_LEFT_INT, pointWithLeftIntMap);

        Map<CharType, State> fractionMap = new HashMap<CharType, State>() {{
            put(CharType.NUMBER, State.FRACTION);
            put(CharType.EXP, State.EXP);
            put(CharType.SPACE, State.END);
        }};
        transfer.put(State.FRACTION, fractionMap);

        Map<CharType, State> expMap = new HashMap<CharType, State>() {{
            put(CharType.NUMBER, State.EXP_INT);
            put(CharType.SIGN, State.EXP_SIGN);
        }};
        transfer.put(State.EXP, expMap);

        Map<CharType, State> expSignMap = new HashMap<CharType, State>() {{
            put(CharType.NUMBER, State.EXP_INT);
        }};
        transfer.put(State.EXP_SIGN, expSignMap);

        Map<CharType, State> expIntMap = new HashMap<CharType, State>() {{
            put(CharType.NUMBER, State.EXP_INT);
            put(CharType.SPACE, State.END);
        }};
        transfer.put(State.EXP_INT, expIntMap);

        Map<CharType, State> endMap = new HashMap<CharType, State>() {{
            put(CharType.SPACE, State.END);
        }};
        transfer.put(State.END, endMap);
        int n = s.length();
        State state = State.BEGIN;
        for (int i = 0; i < n; i++) {
            CharType charType = toCharType(s.charAt(i));
            if(!transfer.get(state).containsKey(charType)) {
                return false;
            } else {
                state = transfer.get(state).get(charType);
            }
        }
        return state == State.END || state == State.INT || state == State.EXP_INT || state == State.FRACTION || state == State.POINT_WITH_LEFT_INT;
    }
}
