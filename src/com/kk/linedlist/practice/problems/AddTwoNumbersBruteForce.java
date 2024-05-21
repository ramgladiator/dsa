package com.kk.linkedlist;

public class AddTwoNumbersBruteForce {

    public static void main(String[] args) {

        LinkedList list = new LinkedList(2);
        list.next = new LinkedList(4);
        list.next.next = new LinkedList(3);

        LinkedList list2 = new LinkedList(5);
        list2.next = new LinkedList(6);
        list2.next.next = new LinkedList(4);

        LinkedList answer = addTwoNumbers(list,list2);
       //LinkedList newList =  reverse(list);
        while(answer != null){

            System.out.println(answer.val);
            answer = answer.next;
        }
    }

    public static LinkedList addTwoNumbers(LinkedList l1, LinkedList l2) {

         LinkedList lis1 = reverse(l1);
         LinkedList list2 = reverse(l2);
         Integer n = convertListToInteger(lis1);
         Integer m = convertListToInteger(list2);
       //  Integer reverse1 = reverseNumber(n,0);
        // Integer reverse2 = reverseNumber(m,0);
         Integer answer = n + m;

        return createdList(answer);
    }

    private static Integer convertListToInteger(LinkedList list){
        int returnInteger = 0;
        while(list != null){

            returnInteger = returnInteger *10 + list.val;
            list = list.next;
        }
        return  returnInteger;

    }

    private static LinkedList createdList(Integer number){

        int[] digitsArray = String.valueOf(number)
                .chars() // Convert the string to an IntStream of character codes
                .map(Character::getNumericValue) // Convert each character code to its numeric value
                .toArray(); //

        LinkedList list = new LinkedList(digitsArray[0]);
        list.next = new LinkedList(digitsArray[1]);
        list.next.next = new LinkedList(digitsArray[2]);

        return  reverse(list);
    }

    private static Integer reverseNumber(Integer n,int sum){

     if( n ==0){
         return sum;
     }

     int remainder = n%10;
     sum = sum * 10 +remainder;
     n = n/10;

     return  reverseNumber(n,sum);
    }

    private static LinkedList reverse(LinkedList list){

        LinkedList previous = null;
        LinkedList present = list;
        LinkedList next = present.next;

        while(present != null){
            present.next = previous;
            previous = present;
            present = next;
            if(next != null){
                next = next.next;
            }
            /*if(present != null)
              present = present.next;*/
        }

        return previous;
    }



    private static class LinkedList{

        int val;
        LinkedList next;

        public LinkedList(int val) {
            this.val = val;
        }

        public LinkedList(LinkedList next, int val) {
            this.next = next;
            this.val = val;
        }
    }



}
