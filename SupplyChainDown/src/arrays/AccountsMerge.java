package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given a list accounts, each element accounts[i] is a list of strings,
 * where the first element accounts[i][0] is a name, and the rest of the elements are emails representing emails of the account.
 *
 * Now, we would like to merge these accounts.
 * Two accounts definitely belong to the same person if there is some email that is common to both accounts.
 * Note that even if two accounts have the same name, they may belong to different people as people could have the same name.
 * A person can have any number of accounts initially, but all of their accounts definitely have the same name.
 *
 * After merging the accounts, return the accounts in the following format: the first element of each account is the name,
 * and the rest of the elements are emails in sorted order. The accounts themselves can be returned in any order.
 *
 * Example 1:
 *
 * Input:
 * accounts = [["John", "johnsmith@mail.com", "john00@mail.com"],
 *              ["John", "johnnybravo@mail.com"],
 *              ["John", "johnsmith@mail.com", "john_newyork@mail.com"],
 *              ["Mary", "mary@mail.com"]]
 * Output: [["John", 'john00@mail.com', 'john_newyork@mail.com', 'johnsmith@mail.com'],  ["John", "johnnybravo@mail.com"], ["Mary", "mary@mail.com"]]
 * Explanation:
 * The first and third John's are the same person as they have the common email "johnsmith@mail.com".
 * The second John and Mary are different people as none of their email addresses are used by other accounts.
 * We could return these lists in any order, for example the answer [['Mary', 'mary@mail.com'], ['John', 'johnnybravo@mail.com'],
 * ['John', 'john00@mail.com', 'john_newyork@mail.com', 'johnsmith@mail.com']] would still be accepted.
 * Note:
 *
 * The length of accounts will be in the range [1, 1000].
 * The length of accounts[i] will be in the range [1, 10].
 * The length of accounts[i][j] will be in the range [1, 30].
 */
public class AccountsMerge {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, Integer> emailMap = new HashMap<>();
        Map<Integer, String> nameMap = new HashMap<>();
        List<List<String>> result = new ArrayList<>();
        for(List<String> account: accounts) {
            String name = account.get(0);
            boolean newEmail = true;
            int userIndex = -1;
            for(int i=1; i<account.size(); i++) {
                String email = account.get(i);
                if(emailMap.containsKey(email)) {
                    newEmail = false;
                    userIndex = emailMap.get(email);
                }
            }
            if(newEmail) {
                userIndex = nameMap.size();
                nameMap.put(userIndex, name);
            }
            for(int i=1; i<account.size(); i++) {
                String email = account.get(i);
                emailMap.put(email, userIndex);
            }
        }
        for(Map.Entry<Integer, String> entry: nameMap.entrySet()) {
            List<String> account = new ArrayList<>();
            account.add(entry.getValue());
            result.add(account);
        }
        for(Map.Entry<String, Integer> entry: emailMap.entrySet()) {
            result.get(entry.getValue()).add(entry.getKey());
        }
        for(List<String> resultEntry: result) {
            resultEntry.sort(String::compareTo);
        }
        return result;
    }

    public static void main(String[] args) {
        AccountsMerge instance = new AccountsMerge();
        List<List<String>> accounts = new ArrayList<>();
        accounts.add(Arrays.asList("David","David0@m.co","David1@m.co"));
        accounts.add(Arrays.asList("David","David3@m.co","David4@m.co"));
        accounts.add(Arrays.asList("David","David4@m.co","David5@m.co"));
        accounts.add(Arrays.asList("David","David2@m.co","David3@m.co"));
        accounts.add(Arrays.asList("David","David1@m.co","David2@m.co"));
        List<List<String>> result = instance.accountsMerge(accounts);
    }
}
