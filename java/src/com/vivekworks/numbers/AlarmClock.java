/**
 * Purpose - A simple clock where it plays a sound after X number of minutes/seconds or at a particular time.
 * Author  - Vivek T S
 * Date    - 03/12/2018
 */
package com.vivekworks.numbers;

import javax.sound.sampled.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class AlarmClock {
    public void runAlarmClock(){
        System.out.println("Alarm Clock");
        System.out.println("1. Set an Alarm");
        System.out.println("2. Timer");
        System.out.print("Choose an option --> ");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String option = null,alarmTimer=null,date=null;
        try {
            option = reader.readLine();
            if(option != null && option.equalsIgnoreCase("1")) {
                System.out.print("Do you want to set the alarm on a different date (Y/N) --> ");
                if(reader.readLine().equalsIgnoreCase("Y")){
                    System.out.print("Enter the date in dd/mm/yyyy format--> ");
                    date = reader.readLine();
                }
            }
            System.out.print("Enter the alarm time/timer duration in hh24:mm:ss format --> ");
            alarmTimer = reader.readLine();
        }catch(Exception e){
            e.printStackTrace();
        }
        String[] alarmArray = alarmTimer.split(":");
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(new Date());
        long date1 = calendar.getTimeInMillis(),date2=0;
        if(date == null){
            calendar.set(calendar.get(calendar.YEAR),calendar.get(calendar.MONTH),calendar.get(calendar.DAY_OF_MONTH),Integer.parseInt(alarmArray[0]),Integer.parseInt(alarmArray[1]),Integer.parseInt(alarmArray[2]));
            date2=calendar.getTimeInMillis();
        } else {
            String[] dateArray = date.split("/");
            calendar.set(Integer.parseInt(dateArray[2]),Integer.parseInt(dateArray[1])-1,Integer.parseInt(dateArray[0]),Integer.parseInt(alarmArray[0]),Integer.parseInt(alarmArray[1]),Integer.parseInt(alarmArray[2]));
            date2=calendar.getTimeInMillis();
        }
        long duration = date2-date1;
        if(duration < 0) {
            System.out.println("Please enter a time/date in the future to set an alarm to");
            return;
        }
        runTimer(duration);
    }

    public void runTimer(long duration){
        try {
            Thread.sleep(duration);
        } catch (InterruptedException ie){
            ie.printStackTrace();
        }
        try {
            ringAlarm();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public void ringAlarm() throws UnsupportedAudioFileException, IOException, LineUnavailableException, InterruptedException {
        Path audioFilePath = Paths.get("");
        File alarmFile = new File(audioFilePath.toAbsolutePath().toString()+"\\file\\audio\\AlarmTone.wav");
        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(alarmFile.getAbsoluteFile());
        Clip clip = AudioSystem.getClip();
        clip.open(audioInputStream);
        clip.start();
        Thread.sleep(clip.getMicrosecondLength()/1000);
    }
}