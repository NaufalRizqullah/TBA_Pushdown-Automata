/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Scanner;

/**
 *
 * @author Spooky
 */
public class stack {

    Node head, tail;
    static String data;

    public stack(String data) {
        this.data = data;
        head = new Node(data);
    }

    public String peek() {
        return head.data;
    }

    public void getAll() {
        Node temp = head;
        System.out.print("STACK : ");
        while (temp!= null) {
            System.out.print(" [ " + temp.data + " ] ");
            temp = temp.next;
        }
        System.out.println();
    }

    public void push(String data) {
        Node temp = new Node(data);
        if(head!=null){        
            temp.next = head;
            head.prev = temp;
            head = temp;
            head.prev = null;
        }
        else{
            head=temp;
            tail=temp;
        }
    }
    public String pop() {
        String temp=head.data;
        if (head.next != null) {
            head = head.next;  
        }
        else {
            head=null;
        }
        return temp;
    }   
    public String head(){
        return head.data;
    }
    // public void searchPop(String huruf){
    //     Node temp=head;
    //     Node temp1=head;
    //     // Node temp2=head;
    //     while(temp!=null){
    //         if(temp==head){
    //             if(temp.data.equalsIgnoreCase(huruf)){
    //                 // temp=temp.next;
    //                 head=head.next;
    //                 temp.next=head;
    //                 head.prev=temp;
    //                 temp=null;
    //                 // Node temp1=temp.next.next;
    //                 // temp1.prev=temp;
    //                 // temp.next=temp1;
    //             }
    //             else{
    //                 temp=temp.next;
    //             }
    //         }
    //         else{
    //             if(temp.data.equalsIgnoreCase(huruf)){
    //                 temp1=temp.prev;
    //                 temp=temp.next;
    //                 temp1.next=temp;
    //                 temp.prev=temp1;
    //             }else{
    //                 temp=temp.next;
    //             }
    //         }
    //     }  
    // }
}