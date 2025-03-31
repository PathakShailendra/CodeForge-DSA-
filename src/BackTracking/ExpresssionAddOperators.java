package BackTracking;

import java.util.ArrayList;
import java.util.List;

public class ExpresssionAddOperators {
    public List<String> addOperators(String num, int target) {
        List<String> result = new ArrayList<>();
        if (num == null || num.length() == 0) return result;
        backtrack(result, num, target, "", 0, 0, 0);
        return result;
    }

    private void backtrack(List<String> result, String num, int target, String path, int index, long eval, long prevNum) {
        if (index == num.length()) {
            if (eval == target) {
                result.add(path);
            }
            return;
        }

        for (int i = index; i < num.length(); i++) {
            if (i != index && num.charAt(index) == '0') break;

            String strNum = num.substring(index, i + 1);
            long currNum = Long.parseLong(strNum);

            if (index == 0) {
                backtrack(result, num, target, path + strNum, i + 1, currNum, currNum);
            } else {
                //addition
                backtrack(result, num, target, path + "+" + strNum, i + 1, eval + currNum, currNum);

                //subtraction
                backtrack(result, num, target, path + "-" + strNum, i + 1, eval - currNum, -currNum);

                //multiplication
                backtrack(result, num, target, path + "*" + strNum, i + 1, eval - prevNum + (prevNum * currNum), prevNum * currNum);
            }
        }
    }
}
