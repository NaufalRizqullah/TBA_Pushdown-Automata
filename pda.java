/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;

import java.util.Scanner;

/**
 *
 * @author Spooky
 */
public class pda {

    static stack stacK;
    static int state;
    static String status;
    int counter_a = 0;
    int counter_b = 0;
    int counter_c = 0;
    static ArrayList<String> pushInput = new ArrayList<String>();

    public pda() {
        state = 0; //kasi nilai awal state = 0
        status = "Rejected!"; // dan nilai status = rejected

        //untuk q0 ke q1
    }

    void initialize() {
        state = 1;
        stacK = new stack("$"); //kenapa? karena dari state 0 ke 1 itu harus push $
        System.out.println("q0 ke q1 dengan input null dan push $");
        stacK.getAll();
    }

    //rumus pda nya a**n b**n c**n
    public void pushdown(String data) {
        if (state == 1 && data.equals("a")) {
            //q1 ke q2 akan berjalan ketika diberi input a
            // counter_a++;
            state = 2;
            stacK.push("a");
            System.out.println("q1 ke q2 dengan input a");
            stacK.getAll();
            pushInput.add("a");
        } else if (state == 2 && data.equals("a")) {
            // counter_a++;;
            state = 2;
            stacK.push("a");
            System.out.println("q2 ke q2 Kembali dengan input a");
            stacK.getAll();
            pushInput.add("a");
        } else if (state == 2 && data.equals("b")) {
            state = 3;
            stacK.pop();
            System.out.println("q2 ke q3 dengan input b");
            stacK.getAll();
            pushInput.add("b");
        }
        else if(state == 3 && data.equals("b")){
            state = 3;
            if(stacK.head().equalsIgnoreCase("$")){
                stacK.pop();
                stacK.push("$");
                state = 4;
            }else{
                stacK.pop();
            }
            System.out.println("q2 ke q3 dengan input b");
            stacK.getAll();
            pushInput.add("b");
        }
        else if(state==4 && data.equals("b")){
            state = 5;
            stacK.push("b");
            System.out.println("q4 ke q5 dengan input b");
            stacK.getAll();
            pushInput.add("b");
        }
        else if(state==5 && data.equals("b")){
            state = 5;
            stacK.push("b");
            System.out.println("q5 ke q5 dengan input b");
            stacK.getAll();
            pushInput.add("b");
        }
        else if(state==5 && data.equals("c")){
            state =6;
            stacK.pop();
            System.out.println("q5 ke q6 dengan input c");
            stacK.getAll();
            pushInput.add("c");
        }
        else if(state==6 && data.equals("c")){
            state =6;
            if(stacK.head().equalsIgnoreCase("$")){
                stacK.pop();
                state =7;
                status="Accepted";
            }
            else{
                stacK.pop();
            }
            System.out.println("q5 ke q6 dengan input c");
            stacK.getAll();
            pushInput.add("c");
        }
        else{
            System.out.println("Rejected");
        }
    
    }

    public void hasilPDA() {
        System.out.println();
        System.out.println(">>>>> PDA tersebut =  " + status + " <<<<<");
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String query;

        System.out.println("PUSHDOWN AUTOMATA");
        System.out.println("===================");
        System.out.println();
        pda p = new pda();

        p.initialize();

        while (p.state < 7) {
            System.out.print("Input: ");
            query = input.next();
            p.pushdown(query);
            System.out.println();
        }
        System.out.println("=============================");
        p.hasilPDA();
        System.out.println("Bahasan Yang diinput = " + p.pushInput);
    }

}
