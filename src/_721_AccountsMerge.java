import java.util.*;

public class _721_AccountsMerge {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        if (accounts == null || accounts.size() == 0) {
            return null;
        }
        boolean next;
        List<List<String>> result;
        do {
            next = false;
            HashMap<String, List<List<String>>> map = new HashMap<>();
            for (List<String> account : accounts) {
                String name = account.get(0);
                account.remove(0);
                account = new ArrayList<>(new HashSet<>(account));
                if (!map.containsKey(name)) {
                    List<List<String>> value = new ArrayList<>();
                    value.add(account);
                    map.put(name, value);
                } else {
                    List<List<String>> oldList = map.get(name);
                    boolean toAdd = true;
                    for (List<String> oldValue : oldList) {
                        int size = oldValue.size();
                        oldValue.removeAll(account);
                        if (size - oldValue.size() >= 1) {
                            oldValue.addAll(account);
                            toAdd = false;
                            next = true;
                            break;
                        }
                    }
                    if (toAdd) {
                        oldList.add(account);
                    }
                }
            }
            result = new ArrayList<>();
            Set<String> keys = map.keySet();
            for (String key : keys) {
                List<List<String>> value = map.get(key);
                for (List<String> strings : value) {
                    Collections.sort(strings);
                    strings.add(0, key);
                    result.add(strings);
                }
            }
            accounts = result;
        } while (next);
        return result;
    }
}
