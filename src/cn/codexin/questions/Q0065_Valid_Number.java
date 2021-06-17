package cn.codexin.questions;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by xinGao 2021/6/17
 */

public class Q0065_Valid_Number {
    public boolean isNumber(String s) {
        Map<State, Map<CharType, State>> transfer = new HashMap<>();
        Map<CharType, State> initialMap = new HashMap<CharType, State>() {{
            put(CharType.CHAR_NUMBER, State.STATE_INTEGER);
            put(CharType.CHAR_SIGN, State.STATE_INT_SIGN);
            put(CharType.CHAR_POINT, State.STATE_POINT_WITHOUT_INT);
        }};
        transfer.put(State.STATE_INITIAL, initialMap);
        Map<CharType, State> intSignMap = new HashMap<CharType, State>(){{
           put(CharType.CHAR_NUMBER, State.STATE_INTEGER);
           put(CharType.CHAR_POINT, State.STATE_POINT_WITHOUT_INT);
        }};
        transfer.put(State.STATE_INT_SIGN, intSignMap);
        Map<CharType, State> intMap = new HashMap<CharType, State>(){{
            put(CharType.CHAR_NUMBER, State.STATE_INTEGER);
            put(CharType.CHAR_EXP, State.STATE_EXP);
            put(CharType.CHAR_POINT, State.STATE_POINT);
        }};
        transfer.put(State.STATE_INTEGER, intMap);
        Map<CharType, State> pointWithoutNumberMap = new HashMap<CharType, State>(){{
            put(CharType.CHAR_NUMBER, State.STATE_FRACTION);
        }};
        transfer.put(State.STATE_POINT_WITHOUT_INT, pointWithoutNumberMap);
        Map<CharType, State> pointMap = new HashMap<CharType, State>(){{
            put(CharType.CHAR_NUMBER, State.STATE_FRACTION);
            put(CharType.CHAR_EXP, State.STATE_EXP);
        }};
        transfer.put(State.STATE_POINT, pointMap);
        Map<CharType, State> fractionMap = new HashMap<CharType, State>(){{
            put(CharType.CHAR_NUMBER, State.STATE_FRACTION);
            put(CharType.CHAR_EXP, State.STATE_EXP);
        }};
        transfer.put(State.STATE_FRACTION, fractionMap);
        Map<CharType, State> expMap = new HashMap<CharType, State>(){{
            put(CharType.CHAR_SIGN, State.STATE_EXP_SIGN);
            put(CharType.CHAR_NUMBER, State.STATE_EXP_NUMBER);
        }};
        transfer.put(State.STATE_EXP, expMap);
        Map<CharType, State> expSignMap = new HashMap<CharType, State>(){{
            put(CharType.CHAR_NUMBER, State.STATE_EXP_NUMBER);
        }};
        transfer.put(State.STATE_EXP_SIGN, expSignMap);
        Map<CharType, State> expNumberMap = new HashMap<CharType, State>(){{
            put(CharType.CHAR_NUMBER, State.STATE_EXP_NUMBER);
        }};
        transfer.put(State.STATE_EXP_NUMBER, expNumberMap);
        State state = State.STATE_INITIAL;
        for (char c : s.toCharArray()) {
            if(!transfer.get(state).containsKey(toCharType(c))) {
                return false;
            } else {
                state = transfer.get(state).get(toCharType(c));
            }
        }
        return state == State.STATE_INTEGER || state == State.STATE_POINT || state == State.STATE_FRACTION || state == State.STATE_EXP_NUMBER;
    }
    public CharType toCharType(char ch) {
        if(ch >= '0' && ch <= '9') {
            return CharType.CHAR_NUMBER;
        }
        if(ch == '.') {
            return CharType.CHAR_POINT;
        }
        if(ch == '+' || ch == '-') {
            return CharType.CHAR_SIGN;
        }
        if(ch == 'e' || ch == 'E') {
            return CharType.CHAR_EXP;
        }
        return CharType.CHAR_ILLEGAL;
    }
    enum State{
        STATE_INITIAL,
        STATE_INT_SIGN,
        STATE_INTEGER,
        STATE_POINT,
        STATE_POINT_WITHOUT_INT,
        STATE_FRACTION,
        STATE_EXP,
        STATE_EXP_SIGN,
        STATE_EXP_NUMBER,
    }
    enum CharType{
        CHAR_NUMBER,
        CHAR_SIGN,
        CHAR_EXP,
        CHAR_POINT,
        CHAR_ILLEGAL
    }
}
