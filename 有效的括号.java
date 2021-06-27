/**
*给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
*有效字符串需满足：
*左括号必须用相同类型的右括号闭合。
*左括号必须以正确的顺序闭合。
*/

public boolean isValid(String s) {
        String[] arr = s.split("");
        Map<String,String> map = new HashMap<>();
        map.put("{","}");
        map.put("[","]");
        map.put("(",")");
        Stack<String> stack = new Stack();
     
        for(String f: arr){
            if(stack.size() > 0 && map.get(stack.peek()) != null && map.get(stack.peek()).equals(f)){
             stack.pop();
            }else{
                stack.push(f);
            }

        }
        return stack.size() > 0 ? false:true;
    }
