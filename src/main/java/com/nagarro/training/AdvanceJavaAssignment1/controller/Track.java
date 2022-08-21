package com.nagarro.training.AdvanceJavaAssignment1.controller;

public class Track implements Runnable{
	
		@Override
		public void run() {
			// TODO Auto-generated method stub
			ModificationWatcher.modificationTrack();
		}
		
}
