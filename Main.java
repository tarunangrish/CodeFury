package com.hsbc.orderprocessingsystem.dao;

import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

import com.hsbc.orderprocessingsystem.connections.DBConnection;

public class Main {
 
	public static void main(String[] args) {
		Timer timer = new Timer();
		TimerTask tt = new TimerTask(){
			public void run(){
				Calendar cal = Calendar.getInstance(); //this is the method you should use, not the Date(), 
 
				int hour = cal.get(Calendar.HOUR_OF_DAY);//get the hour number of the day, from 0 to 23
 
				if(hour == 18){
					System.out.println("generate result");
					 
				}
				
				
			}
		};
		timer.schedule(tt,0, 1000*5);//	 and then run task every five seconds
	}
} 