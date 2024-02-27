import java.util.*;

public class Solution {
    Map<String, Integer> ticketInfoMap;
    Map<String, Integer> pickedTicketMap;
    List<String> orderOfCheapestTicket;
    int answer = 0;

    public int solution(String[] tickets, int roll, String[][] shop, int money) {
        ticketInfoMap = new HashMap<>();
        pickedTicketMap = new HashMap<>();

        for (String ticket : tickets) {
            String[] ticketInfo = ticket.split(" ");
            ticketInfoMap.put(ticketInfo[0], Integer.parseInt(ticketInfo[1]));
            pickedTicketMap.put(ticketInfo[0], 0);
        }

        orderOfCheapestTicket = new ArrayList<>(ticketInfoMap.keySet());
        Collections.sort(orderOfCheapestTicket, (v1, v2) -> ticketInfoMap.get(v1).compareTo(ticketInfoMap.get(v2)));

        calculateGoldenTicket(shop, roll, money, 0);

        return answer;
    }

    public void calculateGoldenTicket(String[][] shop, int roll, int money, int depth) {
        if (depth == shop.length) {
            return;
        }

        String[] tickets = shop[depth];
        for (String pickedTicket : tickets) {
            pickedTicketMap.put(pickedTicket, pickedTicketMap.get(pickedTicket) + 1);
        }

        int moneyToPay = depth * roll;
        int goldenTicketCount = 0;
        boolean outOfBudget = false;

        for (String ticket : orderOfCheapestTicket) {
            int ticketCount = pickedTicketMap.get(ticket);

            while(ticketCount >= 3) {
                ticketCount -= 3;
                moneyToPay += ticketInfoMap.get(ticket) * 3;

                if (moneyToPay > money) {
                    outOfBudget = true;
                    break;
                }

                goldenTicketCount++;
            }

            if (outOfBudget) {
                break;
            }
        }

        answer = Math.max(answer, goldenTicketCount);

        calculateGoldenTicket(shop, roll, money, depth + 1);
    }
}
