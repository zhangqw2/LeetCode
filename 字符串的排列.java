/**
*输入一个字符串，打印出该字符串中字符的所有排列。
*你可以以任意顺序返回这个字符串数组，但里面不能有重复元素
* 输入：s = "abc"
*输出：["abc","acb","bac","bca","cab","cba"]
*/
class Solution {
    public String[] permutation(String s) {
        String[] initArray = s.split("");
        Set<String> set = partionArray(initArray);
        return set.toArray(new String[set.size()]);
    }

    public  Set<String> partionArray(String[] initArray){
        List<String> list = Arrays.asList(initArray);

        List<List<String>> allSubList = getAllSublist(list);
        Set<String> set = new HashSet();
        for(List<String> sub: allSubList){
            set.add(getString(sub));
        }

        return set;
    }

/**
 * 获取所有二元子列表
 */
      public List<List<String>> getAllSublist(List<String> sourceList) {
        List<List<String>> resultList = new ArrayList();
        if (sourceList.size() == 1) {
            resultList.add(sourceList);
            return resultList;
        }
        if (sourceList.size() == 2) {
            List<String> temp = new ArrayList();
            temp.add(0, sourceList.get(1));
            temp.add(1, sourceList.get(0));
            resultList.add(sourceList);
            resultList.add(temp);
            return resultList;
        }

        List<String> subPreList = sourceList.subList(0, 2);
        List<String> temp = new ArrayList();
        temp.add(0, sourceList.get(1));
        temp.add(1, sourceList.get(0));
        resultList.add(subPreList);
        resultList.add(temp);

        List<String> subBackList = sourceList.subList(2, sourceList.size());

        for (String tag : subBackList) {
            resultList = getSubstring(tag,resultList);
        }
            return resultList;
        }
    /**
     * 获取字符串
     */
    public List<List<String>> getSubstring(String target, List<List<String>> initList){
        List<List<String>> result = new ArrayList<>();
       for(List<String> subList: initList){
           for(int i = 0; i <= subList.size(); i++){
               List<String> temp = new ArrayList();
               temp.addAll(subList);
               temp.add(i,target);
               result.add(temp);
           }
       }
        
        return result;
    }

    public String getString(List<String> list){
        StringBuilder sb = new StringBuilder();
        for(String item: list){
            sb.append(item);
        }
        return sb.toString();
    }
}
